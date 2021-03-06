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
package com.gmail.justbru00.computersmp.custom.enchants.gui.main;

import java.util.ArrayList;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.justbru00.computersmp.custom.enchants.gui.commandexecuters.BuyCommand;
import com.gmail.justbru00.computersmp.custom.enchants.gui.commandexecuters.EpicSMP;
import com.gmail.justbru00.computersmp.custom.enchants.gui.commandexecuters.Withdraw;
import com.gmail.justbru00.computersmp.custom.enchants.gui.listener.GUIWatcher;

public class Main extends JavaPlugin {

	public static String Prefix = color("&8[&bEpic&fSMP&8] &f");
	public FileConfiguration config = getConfig();	
	public ConsoleCommandSender console = Bukkit.getConsoleSender();
	public static Economy econ = null;
	
	
	public static String color(String uncoloredstring) {
		String colored = uncoloredstring.replace('_', ' ');
		colored = ChatColor.translateAlternateColorCodes('&', colored);
		return colored;
	}
	
	public String getString(String location){
		return color(config.getString(location));
	}
	
	public static ItemStack createPaperItem(String displayname, String lore, String lore2) {
		ItemStack newitem = new ItemStack(Material.PAPER, 1);
		ItemMeta im = newitem.getItemMeta();
		im.setDisplayName(color(displayname));
		ArrayList<String> reallore = new ArrayList<String>();
		reallore.add(color(lore));
		reallore.add(color(lore2));
		im.setLore(reallore);
		newitem.setItemMeta(im);		
		return newitem;
	}
	
	@Override
	public void onDisable() {
		console.sendMessage(Prefix + "DISABLED!");
	}

	@Override
	public void onEnable() {
        if (!setupEconomy() ) {
            console.sendMessage(color(String.format("%s &cDisabled due to Vault NOT FOUND!", Prefix)));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
		getServer().getPluginManager().registerEvents(new GUIWatcher(), this);
		
		getCommand("withdraw").setExecutor(new Withdraw());
		getCommand("epicsmp").setExecutor(new EpicSMP());
		getCommand("buycommand").setExecutor(new BuyCommand());
		
		console.sendMessage(Prefix + "ENABLED!");

	}

	private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
	
}
