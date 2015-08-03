/**
 *     EpicSMP Plugin
    Copyright (C) 2015  Justin A. Brubaker

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.


	Contact me at justbru00@gmail.com
 */
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
