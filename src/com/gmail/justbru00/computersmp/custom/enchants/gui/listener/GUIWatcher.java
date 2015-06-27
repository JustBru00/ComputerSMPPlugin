package com.gmail.justbru00.computersmp.custom.enchants.gui.listener;

import java.util.ArrayList;

import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.justbru00.computersmp.custom.enchants.gui.main.Main;

public class GUIWatcher implements Listener{
	
	ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
	String Prefix = Main.color("&8[&bComputer&fSMP&8] &f");
	
	@EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        final Player player = e.getPlayer();
        
        ArrayList<String> testlore = new ArrayList<String>();
    	testlore.add(Main.color("&7Right Click in the air to deposit this."));
    	testlore.add(Main.color("&8[&bComputerSMP&8]"));
    	
    	
    	if (e.getAction() != Action.RIGHT_CLICK_AIR) return;
    	
    	
        if (player.getItemInHand().getItemMeta().getLore().equals(testlore)) {
            if(e.getAction() == Action.RIGHT_CLICK_AIR){
                if(player.getItemInHand().getType() == Material.PAPER){       	
                		double depositamount = 0.0;
                		String plainMoney = player.getItemInHand().getItemMeta().getDisplayName().replace(Main.color("&4&l$"), " ");
                		ChatColor.stripColor(plainMoney);
                		depositamount = Double.parseDouble(plainMoney);
                		EconomyResponse r = Main.econ.depositPlayer(player, depositamount);
    		            if(r.transactionSuccess()) {
    		                player.sendMessage(String.format(Prefix + "Deposited %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance))); 
    		                ItemStack inHand = player.getItemInHand();
    		              int amountInHand = inHand.getAmount();
    		              if (amountInHand == 1) {
    		            	  player.setItemInHand(new ItemStack(Material.AIR));
    		              } else {
    		              inHand.setAmount(--amountInHand);
    		              }
    		            } else {
    		            	player.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));    		             
    		            }			
                	}
                }  
            }  
    }
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
	 if (e.getPlayer().getName().equalsIgnoreCase("JustBru00")) {
		 Bukkit.broadcastMessage(Main.color("&eJustBru00 (The Developer of &8[&bComputer&fSMP&8]&e) has joined the game."));		 
	 }
	}	


	@EventHandler
	public void InventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();		
		

		if (e.getInventory().getTitle().contains(ChatColor.RED + "Money")) {
			
			
			if (e.getCurrentItem() == null || e.getCurrentItem() == new ItemStack(Material.AIR)) {
				return;
			}		
			e.setCancelled(true);	
			
			// Start Click Checks
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/tpa"))) {
				EconomyResponse r = Main.econ.withdrawPlayer(p, 2000);
	            if(r.transactionSuccess()) {
	                p.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.tpa");
	                p.closeInventory();
	            } else {
	                p.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));
	                p.closeInventory();
	            }     			
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/tp"))) {
				EconomyResponse r = Main.econ.withdrawPlayer(p, 3500);
	            if(r.transactionSuccess()) {
	                p.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.tp");
	                p.closeInventory();
	            } else {
	                p.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));
	                p.closeInventory();
	            }     			
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/tpahere"))) {
				EconomyResponse r = Main.econ.withdrawPlayer(p, 2100);
	            if(r.transactionSuccess()) {
	                p.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.tpahere");
	                p.closeInventory();
	            } else {
	                p.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));
	                p.closeInventory();
	            }     			
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/tpall"))) {
				EconomyResponse r = Main.econ.withdrawPlayer(p, 4500);
	            if(r.transactionSuccess()) {
	                p.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.tpall");
	                p.closeInventory();
	            } else {
	                p.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));
	                p.closeInventory();
	            }     			
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/msg"))) {
				EconomyResponse r = Main.econ.withdrawPlayer(p, 500);
	            if(r.transactionSuccess()) {
	                p.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.msg");
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.msg.color");
	                p.closeInventory();
	            } else {
	                p.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));
	                p.closeInventory();
	            }     			
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/repair"))) {
				EconomyResponse r = Main.econ.withdrawPlayer(p, 7500);
	            if(r.transactionSuccess()) {
	                p.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.repair");
	                p.closeInventory();
	            } else {
	                p.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));
	                p.closeInventory();
	            }     			
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/back"))) {
				EconomyResponse r = Main.econ.withdrawPlayer(p, 7000);
	            if(r.transactionSuccess()) {
	                p.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.back");
	                p.closeInventory();
	            } else {
	                p.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));
	                p.closeInventory();
	            }     			
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/broadcast"))) {
				EconomyResponse r = Main.econ.withdrawPlayer(p, 1500);
	            if(r.transactionSuccess()) {
	                p.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.broadcast");
	                p.closeInventory();
	            } else {
	                p.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));
	                p.closeInventory();
	            }     			
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/clearinventory"))) {
				EconomyResponse r = Main.econ.withdrawPlayer(p, 1500);
	            if(r.transactionSuccess()) {
	                p.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.clearinventory");
	                p.closeInventory();
	            } else {
	                p.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));
	                p.closeInventory();
	            }     			
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/workbench"))) {
				EconomyResponse r = Main.econ.withdrawPlayer(p, 5000);
	            if(r.transactionSuccess()) {
	                p.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.workbench");
	                p.closeInventory();
	            } else {
	                p.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));
	                p.closeInventory();
	            }     			
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/day"))) {
				EconomyResponse r = Main.econ.withdrawPlayer(p, 3000);
	            if(r.transactionSuccess()) {
	                p.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.day");
	                p.closeInventory();
	            } else {
	                p.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));
	                p.closeInventory();
	            }     			
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/night"))) {
				EconomyResponse r = Main.econ.withdrawPlayer(p, 3000);
	            if(r.transactionSuccess()) {
	                p.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.night");
	                p.closeInventory();
	            } else {
	                p.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));
	                p.closeInventory();
	            }     			
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/weather"))) {
				EconomyResponse r = Main.econ.withdrawPlayer(p, 3500);
	            if(r.transactionSuccess()) {
	                p.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.weather");
	                p.closeInventory();
	            } else {
	                p.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));
	                p.closeInventory();
	            }     			
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/feed"))) {
				EconomyResponse r = Main.econ.withdrawPlayer(p, 7500);
	            if(r.transactionSuccess()) {
	                p.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.feed");
	                p.closeInventory();
	            } else {
	                p.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));
	                p.closeInventory();
	            }     			
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/enderchest"))) {
				EconomyResponse r = Main.econ.withdrawPlayer(p, 2000);
	            if(r.transactionSuccess()) {
	                p.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.enderchest");
	                p.closeInventory();
	            } else {
	                p.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));
	                p.closeInventory();
	            }     			
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/fly"))) {
				EconomyResponse r = Main.econ.withdrawPlayer(p, 8000);
	            if(r.transactionSuccess()) {
	                p.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.fly");
	                p.closeInventory();
	            } else {
	                p.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));
	                p.closeInventory();
	            }     			
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/hat"))) {
				EconomyResponse r = Main.econ.withdrawPlayer(p, 2000);
	            if(r.transactionSuccess()) {
	                p.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.hat");
	                p.closeInventory();
	            } else {
	                p.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));
	                p.closeInventory();
	            }     			
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/invsee"))) {
				EconomyResponse r = Main.econ.withdrawPlayer(p, 4000);
	            if(r.transactionSuccess()) {
	                p.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.invsee");
	                p.closeInventory();
	            } else {
	                p.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));
	                p.closeInventory();
	            }     			
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/heal"))) {
				EconomyResponse r = Main.econ.withdrawPlayer(p, 6500);
	            if(r.transactionSuccess()) {
	                p.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.heal");
	                p.closeInventory();
	            } else {
	                p.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));
	                p.closeInventory();
	            }     			
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/lightning"))) {
				EconomyResponse r = Main.econ.withdrawPlayer(p, 4500);
	            if(r.transactionSuccess()) {
	                p.sendMessage(String.format(Prefix + "Withdrew %s and now you have %s", Main.econ.format(r.amount), Main.econ.format(r.balance)));
	                Bukkit.dispatchCommand(console, "manuaddp " + p.getName() + " essentials.lightning");
	                p.closeInventory();
	            } else {
	                p.sendMessage(String.format(Prefix + Main.color("&4An error occured: %s"), r.errorMessage));
	                p.closeInventory();
	            }     			
			}
			
			
		}		
}
	
}
