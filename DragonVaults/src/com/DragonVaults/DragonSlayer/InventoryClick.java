package com.DragonVaults.DragonSlayer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {
	Main plugin;
	
	public InventoryClick(Main pl) {
		this.plugin = pl;
		}
	
@EventHandler(priority=EventPriority.MONITOR)
public void InventoryClick(InventoryCloseEvent e) {
    if (e.getInventory().getTitle().contains("Vault") && Main.commandplayers.contains(e.getPlayer().getName())) {
    	ItemStack[] inv = e.getInventory().getContents();
    	Main.commandplayers.remove(e.getPlayer().getName());
    	String number = e.getInventory().getName();
    	String[] parts = number.split(" ");
    	plugin.getConfig().set("vaults." + e.getPlayer().getUniqueId() + "." + parts[1], inv);
    	plugin.saveConfig();
    }
}
}
    	
    	
    	