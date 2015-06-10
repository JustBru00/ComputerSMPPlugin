package com.gmail.justbru00.computersmp.custom.enchants.gui.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public String Prefix = color("&8[&bEpic&fCustomEnchantsGUI&8]");
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,	String label, String[] args) {

		if (command.getName().equalsIgnoreCase("customenchantsgui")) {
			if (args.length == 1) {
				
			} else {
				sender.sendMessage(Prefix + color("&4Please put help or version after /customenchantsgui"));
			}
		}
		
		return false;
	}

	public static String color(String uncoloredstring) {
		String colored = uncoloredstring.replace('_', ' ');
		colored = ChatColor.translateAlternateColorCodes('&', colored);
		return colored;
	}
	
	@Override
	public void onDisable() {

	}

	@Override
	public void onEnable() {

	}

}
