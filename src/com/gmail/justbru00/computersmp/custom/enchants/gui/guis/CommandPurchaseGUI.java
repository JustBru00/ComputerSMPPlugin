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
package com.gmail.justbru00.computersmp.custom.enchants.gui.guis;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.gmail.justbru00.computersmp.custom.enchants.gui.main.Main;

public class CommandPurchaseGUI {

	public static Inventory commandPurchaseGUI(Player player, double money) {
		if (player.isOp()) {
		    Inventory inv = Bukkit.createInventory(null, 54, Main.color("&bYou are OP."));
		    inv.setItem(22, Main.createPaperItem("&4You are OP", "Why do you need to buy commands?", "Just Why?"));
		    return inv;
		} else {
			Inventory inv = Bukkit.createInventory(null, 54, Main.color("&cMoney $" + money + "."));
		
		
		if (!player.hasPermission("essentials.tpa")) {
			inv.addItem(Main.createPaperItem("&b/tpa", "Left Click to purchase.", "&fCost: 2000"));
		}
		if (!player.hasPermission("essentials.tp")) {
			inv.addItem(Main.createPaperItem("&b/tp", "Left Click to purchase.", "&fCost: 3500"));
		}
		if (!player.hasPermission("essentials.tpahere")) {
			inv.addItem(Main.createPaperItem("&b/tpahere", "Left Click to purchase.", "&fCost: 2100"));
		}
		if (!player.hasPermission("essentials.tpall")) {
			inv.addItem(Main.createPaperItem("&b/tpall", "Left Click to purchase.", "&fCost: 4500"));
		}
		if (!player.hasPermission("essentials.msg")) {
			inv.addItem(Main.createPaperItem("&b/msg", "Left Click to purchase.", "&fCost: 500"));
		}
		if (!player.hasPermission("essentials.repair")) {
			inv.addItem(Main.createPaperItem("&b/repair", "Left Click to purchase.", "&fCost: 7500"));
		}
		if (!player.hasPermission("essentials.back")) {
			inv.addItem(Main.createPaperItem("&b/back", "Left Click to purchase.", "&fCost: 7000"));
		}
		if (!player.hasPermission("essentials.broadcast")) {
			inv.addItem(Main.createPaperItem("&b/broadcast", "Left Click to purchase.", "&fCost: 1500"));
		}
		if (!player.hasPermission("essentials.clearinventory")) {
			inv.addItem(Main.createPaperItem("&b/clearinventory", "Left Click to purchase.", "&fCost: 1500"));
		}
		if (!player.hasPermission("essentials.workbench")) {
			inv.addItem(Main.createPaperItem("&b/workbench", "Left Click to purchase.", "&fCost: 5000"));
		}
		if (!player.hasPermission("essentials.day")) {
			inv.addItem(Main.createPaperItem("&b/day", "Left Click to purchase.", "&fCost: 3000"));
		}
		if (!player.hasPermission("essentials.night")) {
			inv.addItem(Main.createPaperItem("&b/night", "Left Click to purchase.", "&fCost: 3000"));
		}
		if (!player.hasPermission("essentials.weather")) {
			inv.addItem(Main.createPaperItem("&b/weather", "Left Click to purchase.", "&fCost: 3500"));
		}
		if (!player.hasPermission("essentials.feed")) {
			inv.addItem(Main.createPaperItem("&b/feed", "Left Click to purchase.", "&fCost: 7500"));
		}
		if (!player.hasPermission("essentials.enderchest")) {
			inv.addItem(Main.createPaperItem("&b/enderchest", "Left Click to purchase.", "&fCost: 2000"));
		}
		if (!player.hasPermission("essentials.fly")) {
			inv.addItem(Main.createPaperItem("&b/fly", "Left Click to purchase.", "&fCost: 8000"));
		}
		if (!player.hasPermission("essentials.hat")) {
			inv.addItem(Main.createPaperItem("&b/hat", "Left Click to purchase.", "&fCost: 2000"));
		}
		if (!player.hasPermission("essentials.invsee")) {
			inv.addItem(Main.createPaperItem("&b/invsee", "Left Click to purchase.", "&fCost: 4000"));
		}
		if (!player.hasPermission("essentials.heal")) {
			inv.addItem(Main.createPaperItem("&b/heal", "Left Click to purchase.", "&fCost: 6500"));
		}
		if (!player.hasPermission("essentials.lightning")) {
			inv.addItem(Main.createPaperItem("&b/lightning", "Left Click to purchase.", "&fCost: 4500"));
		}
		
		
		
		
		return inv;
		}
	}
	
}
