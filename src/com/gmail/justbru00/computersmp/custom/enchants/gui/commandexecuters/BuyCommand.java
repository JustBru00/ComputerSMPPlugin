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

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.gmail.justbru00.computersmp.custom.enchants.gui.guis.CommandPurchaseGUI;
import com.gmail.justbru00.computersmp.custom.enchants.gui.main.Main;

public class BuyCommand implements CommandExecutor{
	
	ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
	@Override
	public boolean onCommand(CommandSender sender, Command command,	String label, String[] args) {

		if (command.getName().equalsIgnoreCase("buycommand")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				
				// Special Case To add permission for tp to location
				if (player.hasPermission("essentials.tp") && !player.hasPermission("essentials.tp.others")) {
					Bukkit.dispatchCommand(console, "manuaddp " + player.getName() + " essentials.tp.others");
					Bukkit.dispatchCommand(console, "manuaddp " + player.getName() + " essentials.tppos");
					player.sendMessage(Main.Prefix + "I fixed your /tp permissions.");
				}
				
				// Fixes /day permission
				if (player.hasPermission("essentials.day") && !player.hasPermission("essentials.time")) {
					Bukkit.dispatchCommand(console, "manuaddp " + player.getName() + " essentials.time");
					Bukkit.dispatchCommand(console, "manuaddp " + player.getName() + " essentials.time.set");
					player.sendMessage(Main.Prefix + "I fixed your /day permissions.");
				}
				
				// Fix /weather
				if (player.hasPermission("essentials.weather")) {
					player.sendMessage(Main.Prefix + "Sorry There is no fix for /weather at this time.");
				}
				
				// Fix for back on death
				if (player.hasPermission("essentials.back") && !player.hasPermission("essentials.back.ondeath")) {
					Bukkit.dispatchCommand(console, "manuaddp " + player.getName() + " essentials.back.ondeath");
					player.sendMessage(Main.Prefix + "I fixed your /back permissions. /back will now work on death.");
				}
				
				if (player.hasPermission("essentials.repair") && !player.hasPermission("essentials.repair.all")) {
					Bukkit.dispatchCommand(console, "manuaddp " + player.getName() + " essentials.repair.all");
					Bukkit.dispatchCommand(console, "manuaddp " + player.getName() + " essentials.repair.armor");
					Bukkit.dispatchCommand(console, "manuaddp " + player.getName() + " essentials.repair.enchanted");
					player.sendMessage(Main.Prefix + "I fixed your /repair permissions.");
				}
				
				double money = 100;
				money = Main.econ.getBalance(player);
				if (money <= 99999) {
					player.openInventory(CommandPurchaseGUI.commandPurchaseGUI(player, money));
					return true;
				} else {
					player.openInventory(CommandPurchaseGUI.commandPurchaseGUI(player, 99999));
					return true;
				}
				
			} else {
				sender.sendMessage(Main.Prefix + Main.color("&4SILLY JustBru00 :D"));
				return true;
			}
		}		
		
		return false;
	}
}
