package com.gmail.justbru00.computersmp.custom.enchants.gui.main;

import java.util.ArrayList;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.justbru00.computersmp.custom.enchants.gui.guis.CommandPurchaseGUI;
import com.gmail.justbru00.computersmp.custom.enchants.gui.listener.GUIWatcher;

public class Main extends JavaPlugin {

	public String Prefix = color("&8[&bCommandPurchaseGUI&8] &f");
	public FileConfiguration config = getConfig();	
	public ConsoleCommandSender console = Bukkit.getConsoleSender();
	public static Economy econ = null;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,	String label, String[] args) {

		if (command.getName().equalsIgnoreCase("commandpurchasegui")) {
			if (sender.hasPermission("commandpurchasegui.commandpurchasegui")) {				
				if (args.length == 1) {
					if(args[0].equalsIgnoreCase("version")) {
						sender.sendMessage(Prefix + color("&fVersion Message Here."));
						return true;
					}
					if(args[0].equalsIgnoreCase("help")) {
						sender.sendMessage(Prefix + color("&fHelp Message Here."));
						return true;
					}else {
						sender.sendMessage(Prefix + color("&4Please put help or version after /commandpurchasegui"));
						return true;
					}
					
				} else {
				sender.sendMessage(Prefix + color("&4Please put help or version after /commandpurchasegui"));
				return true;
				}
			} else {
				sender.sendMessage(Prefix + color("&4You don't have permission."));
				return true;
			}
		}
		if (command.getName().equalsIgnoreCase("buycommand")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				double money = 100;
				money = econ.getBalance(player);
				if (money <= 99999) {
					player.openInventory(CommandPurchaseGUI.commandPurchaseGUI(player, money));
					return true;
				} else {
					player.openInventory(CommandPurchaseGUI.commandPurchaseGUI(player, 99999));
					return true;
				}
				
			} else {
				sender.sendMessage(Prefix + color("&4SILLY COMPUTERDUDE :D"));
				return true;
			}
		}
		
		return false;
	}

	public static String color(String uncoloredstring) {
		String colored = uncoloredstring.replace('_', ' ');
		colored = ChatColor.translateAlternateColorCodes('&', colored);
		return colored;
	}
	
	public String getString(String location){
		return color(config.getString(location));
	}
	
	public static ItemStack createPaperItem(String displayname, String lore, String lore2) {
		ItemStack newitem = new ItemStack(Material.PAPER, 1);
		ItemMeta im = newitem.getItemMeta();
		im.setDisplayName(color(displayname));
		ArrayList<String> reallore = new ArrayList<String>();
		reallore.add(color(lore));
		reallore.add(color(lore2));
		im.setLore(reallore);
		newitem.setItemMeta(im);		
		return newitem;
	}
	
	@Override
	public void onDisable() {
		console.sendMessage(Prefix + "DISABLED!");
	}

	@Override
	public void onEnable() {
        if (!setupEconomy() ) {
            console.sendMessage(color(String.format("%s &cDisabled due to Vault NOT FOUND!", Prefix)));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
		getServer().getPluginManager().registerEvents(new GUIWatcher(), this);
		console.sendMessage(Prefix + "ENABLED!");

	}

	private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
}
