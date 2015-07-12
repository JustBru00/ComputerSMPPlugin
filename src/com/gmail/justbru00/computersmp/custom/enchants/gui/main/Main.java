package com.gmail.justbru00.computersmp.custom.enchants.gui.main;

import java.util.ArrayList;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.justbru00.computersmp.custom.enchants.gui.guis.CommandPurchaseGUI;
import com.gmail.justbru00.computersmp.custom.enchants.gui.listener.GUIWatcher;

public class Main extends JavaPlugin {

	public String Prefix = color("&8[&bEpic&fSMP&8] &f");
	public FileConfiguration config = getConfig();	
	public ConsoleCommandSender console = Bukkit.getConsoleSender();
	public static Economy econ = null;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,	String label, String[] args) {

		if (command.getName().equalsIgnoreCase("epicsmp")) {
			if (sender.hasPermission("epicsmp.epicsmp")) {				
				if (args.length == 1) {
					if(args[0].equalsIgnoreCase("version")) {
						sender.sendMessage(Prefix + color("&fVersion Message Here."));
						return true;
					}
					if(args[0].equalsIgnoreCase("help")) {
						sender.sendMessage(Prefix + color("&fHelp Message Here."));
						return true;
					}else {
						sender.sendMessage(Prefix + color("&4Please put help or version after /epicsmp"));
						return true;
					}
					
				} else {
				sender.sendMessage(Prefix + color("&4Please put help or version after /epicsmp"));
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
				sender.sendMessage(Prefix + color("&4SILLY JustBru00 :D"));
				return true;
			}
		}
		if (command.getName().equalsIgnoreCase("withdraw")) {
			if (sender instanceof Player) {
				if (args.length == 1) {
					Player player = (Player) sender;	
					double withdrawAmount = 0;
					try {
					    withdrawAmount = Double.parseDouble(args[0]);
					} catch(Exception e){
						sender.sendMessage(Prefix + color("&cPlease put a number."));
						return true;
					}
					EconomyResponse r = econ.withdrawPlayer(player, withdrawAmount);
		            if(r.transactionSuccess()) {
		                player.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
		                PlayerInventory pi = player.getInventory();
		                pi.addItem(createPaperItem(color("&4&l$" + args[0]), color("&7Right Click in the air to deposit this."), color("&8[&bComputerSMP&8]")));
		                
		                return true;		                
		            } else {
		                player.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));	
		                return true;
		            }			
				} else {
					sender.sendMessage(Prefix + color("&cToo Many or Too Little Args. Please only type one number after /withdraw. Eg: /withdraw 50"));
				}
			} else {
				sender.sendMessage(Prefix + color("&4Why JustBru00. Just Why.....  sender NOT instanceof Player"));
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
