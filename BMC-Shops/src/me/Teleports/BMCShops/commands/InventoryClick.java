package me.Teleports.BMCShops.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.Teleports.BMCShops.Main;

public class InventoryClick implements Listener {

	Main plugin;

	public InventoryClick(Main pl) {
		this.plugin = pl;
	}

	public boolean isLocked(Player p) {
		Boolean bool = false;
		if (plugin.getConfig().getBoolean("playershops." + p.getUniqueId() + ".locked") == true) {
			bool = true;
		}
		return bool;
	}

	public boolean isLockedo(OfflinePlayer p) {
		Boolean bool = false;
		if (plugin.getConfig().getBoolean("playershops." + p.getUniqueId() + ".locked") == true) {
			bool = true;
		}
		return bool;
	}

	public static List<Material> getNearbyBlocks(Location location, int radius) {
		List<Material> blocks = new ArrayList<Material>();
		for (int x = location.getBlockX() - radius; x <= location.getBlockX() + radius; x++) {
			for (int y = location.getBlockY() - radius; y <= location.getBlockY() + radius; y++) {
				for (int z = location.getBlockZ() - radius; z <= location.getBlockZ() + radius; z++) {
					blocks.add(location.getWorld().getBlockAt(x, y, z).getType());
				}
			}
		}
		return blocks;
	}

	public boolean checkDangersLocation(Player p, Location loc, int radius) {
		boolean bool = true;

		List<Material> blocks = getNearbyBlocks(loc, radius);
		if (blocks.contains(Material.LAVA) || blocks.contains(Material.STATIONARY_LAVA)) {
			p.sendMessage(plugin.prefix + ChatColor.RED + "Shop set within 2 blocks of lava!");
		} else if (loc.getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.AIR)) {
			p.sendMessage(plugin.prefix + ChatColor.RED + "No block under destination!");
		} else {
			bool = false;
		}
		return bool;

	}

	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent e) {
		if (e.getInventory().getName().equalsIgnoreCase(plugin.prefix + ChatColor.RED + "Shops")) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType().equals(Material.SKULL_ITEM)) {

				Player p = (Player) e.getWhoClicked();
				ItemStack i = e.getCurrentItem();
				SkullMeta skullm = (SkullMeta) i.getItemMeta();

				Player pl = Bukkit.getPlayer(skullm.getOwner());
				if (pl != null) {

					double x = plugin.getConfig().getDouble("playershops." + pl.getUniqueId() + ".location.x");
					double y = plugin.getConfig().getDouble("playershops." + pl.getUniqueId() + ".location.y");
					double z = plugin.getConfig().getDouble("playershops." + pl.getUniqueId() + ".location.z");
					String w = plugin.getConfig().getString("playershops." + pl.getUniqueId() + ".location.world");
					float yaw = (float) plugin.getConfig()
							.getDouble("playershops." + pl.getUniqueId() + ".location.yaw");
					float pitch = (float) plugin.getConfig()
							.getDouble("playershops." + pl.getUniqueId() + ".location.pitch");

					Location loc = new Location(Bukkit.getServer().getWorld(w), x, y, z, yaw, pitch);
					if (checkDangersLocation(p, loc, 2) == false) {
						if (!(isLocked(pl))) {
							p.sendMessage(
									plugin.prefix + ChatColor.GREEN + "Teleporting to " + pl.getName() + "'s Shop.");
							p.teleport(loc);
						} else {
							p.sendMessage(plugin.prefix + ChatColor.RED + "Shop is locked!");
						}
					} else {
						p.sendMessage(plugin.prefix + ChatColor.RED + "Unsafe shop, contact shop owner!");
					}

				} else {
					OfflinePlayer pl2 = Bukkit.getOfflinePlayer(skullm.getOwner());
					double x = plugin.getConfig().getDouble("playershops." + pl2.getUniqueId() + ".location.x");
					double y = plugin.getConfig().getDouble("playershops." + pl2.getUniqueId() + ".location.y");
					double z = plugin.getConfig().getDouble("playershops." + pl2.getUniqueId() + ".location.z");
					String w = plugin.getConfig().getString("playershops." + pl2.getUniqueId() + ".location.world");
					float yaw = (float) plugin.getConfig()
							.getDouble("playershops." + pl2.getUniqueId() + ".location.yaw");
					float pitch = (float) plugin.getConfig()
							.getDouble("playershops." + pl2.getUniqueId() + ".location.pitch");

					Location loc = new Location(Bukkit.getServer().getWorld(w), x, y, z, yaw, pitch);
					if (checkDangersLocation(p, loc, 2) == false) {
						if (!(isLockedo(pl2))) {
							p.sendMessage(
									plugin.prefix + ChatColor.GREEN + "Teleporting to " + pl2.getName() + "'s Shop.");
							p.teleport(loc);
						} else {
							p.sendMessage(plugin.prefix + ChatColor.RED + "Shop is locked!");
						}
					} else {
						p.sendMessage(plugin.prefix + ChatColor.RED + "Unsafe shop, contact shop owner!");
					}

				}
			}

		}

	}

}
