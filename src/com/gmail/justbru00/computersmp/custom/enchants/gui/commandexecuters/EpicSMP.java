package com.gmail.justbru00.computersmp.custom.enchants.gui.commandexecuters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.gmail.justbru00.computersmp.custom.enchants.gui.main.Main;

public class EpicSMP implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command,	String label, String[] args) {
		if (command.getName().equalsIgnoreCase("epicsmp")) {
			if (sender.hasPermission("epicsmp.epicsmp")) {				
				if (args.length == 1) {
					if(args[0].equalsIgnoreCase("version")) {
						sender.sendMessage(Main.Prefix + Main.color("&fVersion Message Here."));
						return true;
					}
					if(args[0].equalsIgnoreCase("help")) {
						sender.sendMessage(Main.Prefix + Main.color("&fHelp Message Here."));
						return true;
					}else {
						sender.sendMessage(Main.Prefix + Main.color("&4Please put help or version after /epicsmp"));
						return true;
					}
					
				} else {
				sender.sendMessage(Main.Prefix + Main.color("&4Please put help or version after /epicsmp"));
				return true;
				}
			} else {
				sender.sendMessage(Main.Prefix + Main.color("&4You don't have permission."));
				return true;
			}
		}
		return false;
	}

}
