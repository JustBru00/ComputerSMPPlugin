package com.gmail.justbru00.computersmp.custom.enchants.gui.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.gmail.justbru00.computersmp.custom.enchants.gui.main.Main;

public class GUIWatcher implements Listener{

	@EventHandler
	public void InventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().contains(ChatColor.RED + "Money")) {
			e.setCancelled(true);

			if (e.getCurrentItem() == null) {
				return;
			}
			
			// Start Click Checks
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.color("&b/tpa"))) {
				
			}
			
		}		
}
	
}
