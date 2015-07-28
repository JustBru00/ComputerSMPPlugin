package com.gmail.justbru00.computersmp.custom.enchants.gui.commandexecuters;

import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import com.gmail.justbru00.computersmp.custom.enchants.gui.main.Main;

public class Withdraw implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command,	String label, String[] args) {
		if (command.getName().equalsIgnoreCase("withdraw")) {
			if (sender instanceof Player) {
				if (args.length == 1) {
					Player player = (Player) sender;	
					double withdrawAmount = 0;
					try {
					    withdrawAmount = Double.parseDouble(args[0]);
					} catch(Exception e){
						sender.sendMessage(Main.Prefix + Main.color("&cPlease put a number."));
						return true;
					}
					EconomyResponse r = Main.econ.withdrawPlayer(player, withdrawAmount);
		            if(r.transactionSuccess()) {
		                player.sendMessage(String.format(Main.Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
		                PlayerInventory pi = player.getInventory();
		                pi.addItem(Main.createPaperItem(Main.color("&4&l$" + args[0]), Main.color("&7Right Click in the air to deposit this."), Main.color("&8[&bComputerSMP&8]")));
		                
		                return true;		                
		            } else {
		                player.sendMessage(String.format(Main.Prefix + Main.color("&4An error occured: %s"), r.errorMessage));	
		                return true;
		            }			
				} else {
					sender.sendMessage(Main.Prefix + Main.color("&cToo Many or Too Little Args. Please only type one number after /withdraw. Eg: /withdraw 50"));
				}
			} else {
				sender.sendMessage(Main.Prefix + Main.color("&4Why JustBru00. Just Why.....  sender NOT instanceof Player"));
				return true;
			}
		}
		return false;
	}

}
