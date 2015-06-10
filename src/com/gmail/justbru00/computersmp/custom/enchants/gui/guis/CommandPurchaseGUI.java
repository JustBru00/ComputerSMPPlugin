package com.gmail.justbru00.computersmp.custom.enchants.gui.guis;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.gmail.justbru00.computersmp.custom.enchants.gui.main.Main;

public class CommandPurchaseGUI {

	public static Inventory commandPurchaseGUI(Player player, int money) {
		Inventory inv = Bukkit.createInventory(null, 54, Main.color("&cMoney $" + money + "."));
		
		if (!player.hasPermission("essentials.tpa")) {
			inv.addItem(Main.createPaperItem("&b/tpa", "Left Click to purchase.", "&fCost: ?"));
		}
		if (!player.hasPermission("essentials.tp")) {
			inv.addItem(Main.createPaperItem("&b/tp", "Left Click to purchase.", "&fCost: ?"));
		}
		if (!player.hasPermission("essentials.tpahere")) {
			inv.addItem(Main.createPaperItem("&b/tphere", "Left Click to purchase.", "&fCost: ?"));
		}
		if (!player.hasPermission("essentials.tpall")) {
			inv.addItem(Main.createPaperItem("&b/tpall", "Left Click to purchase.", "&fCost: ?"));
		}
		if (!player.hasPermission("essentials.msg")) {
			inv.addItem(Main.createPaperItem("&b/msg", "Left Click to purchase.", "&fCost: ?"));
		}
		if (!player.hasPermission("essentials.repair")) {
			inv.addItem(Main.createPaperItem("&b/repair", "Left Click to purchase.", "&fCost: ?"));
		}
		if (!player.hasPermission("essentials.back")) {
			inv.addItem(Main.createPaperItem("&b/back", "Left Click to purchase.", "&fCost: ?"));
		}
		if (!player.hasPermission("essentials.broadcast")) {
			inv.addItem(Main.createPaperItem("&b/broadcast", "Left Click to purchase.", "&fCost: ?"));
		}
		if (!player.hasPermission("essentials.clearinventory")) {
			inv.addItem(Main.createPaperItem("&b/clearinventory", "Left Click to purchase.", "&fCost: ?"));
		}
		if (!player.hasPermission("essentials.workbench")) {
			inv.addItem(Main.createPaperItem("&b/workbench", "Left Click to purchase.", "&fCost: ?"));
		}
		if (!player.hasPermission("essentials.day")) {
			inv.addItem(Main.createPaperItem("&b/day", "Left Click to purchase.", "&fCost: ?"));
		}
		if (!player.hasPermission("essentials.night")) {
			inv.addItem(Main.createPaperItem("&b/night", "Left Click to purchase.", "&fCost: ?"));
		}
		if (!player.hasPermission("essentials.weather")) {
			inv.addItem(Main.createPaperItem("&b/weather", "Left Click to purchase.", "&fCost: ?"));
		}
		if (!player.hasPermission("essentials.feed")) {
			inv.addItem(Main.createPaperItem("&b/feed", "Left Click to purchase.", "&fCost: ?"));
		}
		if (!player.hasPermission("essentials.enderchest")) {
			inv.addItem(Main.createPaperItem("&b/enderchest", "Left Click to purchase.", "&fCost: ?"));
		}
		if (!player.hasPermission("essentials.fly")) {
			inv.addItem(Main.createPaperItem("&b/fly", "Left Click to purchase.", "&fCost: ?"));
		}
		if (!player.hasPermission("essentials.hat")) {
			inv.addItem(Main.createPaperItem("&b/hat", "Left Click to purchase.", "&fCost: ?"));
		}
		if (!player.hasPermission("essentials.invsee")) {
			inv.addItem(Main.createPaperItem("&b/invsee", "Left Click to purchase.", "&fCost: ?"));
		}
		if (!player.hasPermission("essentials.heal")) {
			inv.addItem(Main.createPaperItem("&b/heal", "Left Click to purchase.", "&fCost: ?"));
		}
		if (!player.hasPermission("essentials.lightning")) {
			inv.addItem(Main.createPaperItem("&b/lightning", "Left Click to purchase.", "&fCost: ?"));
		}
		
		
		
		return inv;
	}
	
}
