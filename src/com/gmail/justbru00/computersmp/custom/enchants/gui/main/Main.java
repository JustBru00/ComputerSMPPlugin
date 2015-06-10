package com.gmail.justbru00.computersmp.custom.enchants.gui.main;

import java.util.ArrayList;

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
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.justbru00.computersmp.custom.enchants.gui.guis.CommandPurchaseGUI;

public class Main extends JavaPlugin {

	public String Prefix = color("&8[&bEpic&fCustomEnchantsGUI&8] &f");
	public FileConfiguration config = getConfig();	
	public ConsoleCommandSender console = Bukkit.getConsoleSender();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,	String label, String[] args) {

		if (command.getName().equalsIgnoreCase("customenchantsgui")) {
			if (sender.hasPermission("customenchantsgui.customenchantsgui")) {				
				if (args.length == 1) {
					if(args[0].equalsIgnoreCase("version")) {
						sender.sendMessage(Prefix + color("&fVersion Message Here."));
						return true;
					}
					if(args[0].equalsIgnoreCase("help")) {
						sender.sendMessage(Prefix + color("&fHelp Message Here."));
						return true;
					}else {
						sender.sendMessage(Prefix + color("&4Please put help or version after /customenchantsgui"));
						return true;
					}
					
				} else {
				sender.sendMessage(Prefix + color("&4Please put help or version after /customenchantsgui"));
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
				int money = 100;
				
				if (money < 99999) {
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
		console.sendMessage(Prefix + "ENABLED!");

	}

}
