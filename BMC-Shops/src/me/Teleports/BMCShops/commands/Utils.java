package me.Teleports.BMCShops.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;

import me.Teleports.BMCShops.Main;

public class Utils {
	
	Main plugin;
	
	public Utils(Main plugin) {
		this.plugin = plugin;
	}
	
	
	protected static List<Material> getNearbyBlocks(Location location, int radius) {
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
	

}
