package me.org.Bastion.Packs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClose implements Listener {

	public void saveBackpack(Object p, Inventory o) {
		if (p instanceof OfflinePlayer) {
			ItemStack[] items = o.getContents();
			List<ItemStack> item = new ArrayList<ItemStack>();

			for (int i = 0; i < items.length; i++) {

				if (items[i] instanceof ItemStack) {

					item.add(items[i]);
				} else {

					ItemStack air = new ItemStack(Material.AIR);
					item.add(air);
				}
			}
			plugin.getConfig().set("backpacks.players." + ((OfflinePlayer) p).getUniqueId() + ".backpack", item);
			plugin.saveConfig();
		} else if (p instanceof Player) {
			ItemStack[] items = o.getContents();
			List<ItemStack> item = new ArrayList<ItemStack>();

			for (int i = 0; i < items.length; i++) {

				if (items[i] instanceof ItemStack) {

					item.add(items[i]);
				} else {

					ItemStack air = new ItemStack(Material.AIR);
					item.add(air);
				}
			}

			plugin.getConfig().set("backpacks.players." + ((Player) p).getUniqueId() + ".backpack", item);
			plugin.saveConfig();
		}

	}

	Main plugin;

	public InventoryClose(Main pl) {
		this.plugin = pl;

	}

	@EventHandler
	public void InventoryCloseEvent(InventoryCloseEvent e) {
		if (e.getInventory().getName().equalsIgnoreCase(
				ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("inventory-name")))) {
			saveBackpack((Player) e.getPlayer(), e.getInventory());
		} else if (e.getInventory().getName().contains(
				ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("inventory-name")))) {
			String str = e.getInventory().getName();
			String[] s = str.split("'");
			e.getPlayer().sendMessage(s[0]);
			String name = ChatColor.stripColor(s[0]);
			Player p = Bukkit.getPlayer(name);
			if (p != null) {
				saveBackpack(p, e.getInventory());
			} else {
				OfflinePlayer pl = Bukkit.getOfflinePlayer(name);
				saveBackpack(pl, e.getInventory());
			}

		}
	}

}
