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
	Main main = new Main();
	ConsoleCommandSender console = main.getServer().getConsoleSender();
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
