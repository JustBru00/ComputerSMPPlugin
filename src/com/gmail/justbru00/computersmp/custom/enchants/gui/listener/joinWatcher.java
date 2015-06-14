package com.gmail.justbru00.computersmp.custom.enchants.gui.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.gmail.justbru00.computersmp.custom.enchants.gui.main.Main;

public class joinWatcher implements Listener{

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
	 if (e.getPlayer().getName() == "JustBru00") {
		 e.setJoinMessage(Main.color("&eJustBru00 (The Developer of CommandPurchaseGUI) has joined the game."));		 
	 }
	}
	
	
}
