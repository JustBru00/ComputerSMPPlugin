package com.gmail.justbru00.computersmp.custom.enchants.gui.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public String Prefix = color("&8[&bEpic&fCustomEnchantsGUI&8]");
	public FileConfiguration config = getConfig();	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,	String label, String[] args) {

		if (command.getName().equalsIgnoreCase("customenchantsgui")) {
			if (sender.hasPermission("customenchantsgui.customenchantsgui")) {				
				if (args.length == 1) {
					if(args[0].equalsIgnoreCase("version")) {
						sender.sendMessage(Prefix + color("&fVersion Message Here."));
					}
					if(args[0].equalsIgnoreCase("help")) {
						sender.sendMessage(Prefix + color("&fHelp Message Here."));
					}else {
						sender.sendMessage(Prefix + color("&4Please put help or version after /customenchantsgui"));
					}
					
				} else {
				sender.sendMessage(Prefix + color("&4Please put help or version after /customenchantsgui"));
				}
			} else {
				sender.sendMessage(Prefix + color("&4You don't have permission."));
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
	
	@Override
	public void onDisable() {

	}

	@Override
	public void onEnable() {

	}

}
