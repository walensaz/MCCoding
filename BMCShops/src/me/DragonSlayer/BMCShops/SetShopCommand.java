package me.DragonSlayer.BMCShops;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import net.md_5.bungee.api.ChatColor;

public class SetShopCommand implements CommandExecutor {

	Main plugin;

	public SetShopCommand(Main pl) {
		this.plugin = pl;
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

	public boolean checkDangers(Player p, int radius) {
		boolean bool = true;
		Location loc = p.getLocation();
		List<Material> blocks = getNearbyBlocks(loc, radius);
		if (blocks.contains(Material.LAVA) || blocks.contains(Material.STATIONARY_LAVA)) {
			p.sendMessage(plugin.prefix + ChatColor.RED + "Don't set your shop within " + radius + " blocks of lava!");
		} else if (loc.getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.AIR)) {
			p.sendMessage(plugin.prefix + ChatColor.RED + "You must have a block under you!");
		} else {
			bool = false;
		}
		return bool;

	}

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		if (l.equalsIgnoreCase("setps")) {
			if (s.hasPermission("BMC.setshop")) {
				Player p = (Player) s;
				if (checkDangers(p, 3) == false) {
					if (!(plugin.setshop.containsKey(p))) {
						p.sendMessage(plugin.prefix + ChatColor.RED + "Type /setps again to confirm!");
						plugin.setshop.put(p, true);
						BukkitScheduler schedule = Bukkit.getScheduler();
						schedule.scheduleSyncDelayedTask(plugin, new Runnable() {
							public void run() {
								if (plugin.setshop.containsKey(p)) {
									plugin.setshop.remove(p);
								}
							}
						}, 1000L);

					} else {
						plugin.setshop.remove(p);
						p.sendMessage(plugin.prefix + ChatColor.GREEN + "You set your shop location!");
						plugin.getConfig().set("playershops." + p.getUniqueId() + ".location.x",
								p.getLocation().getX());
						plugin.getConfig().set("playershops." + p.getUniqueId() + ".location.y",
								p.getLocation().getY());
						plugin.getConfig().set("playershops." + p.getUniqueId() + ".location.z",
								p.getLocation().getZ());
						plugin.getConfig().set("playershops." + p.getUniqueId() + ".location.yaw",
								p.getLocation().getYaw());
						plugin.getConfig().set("playershops." + p.getUniqueId() + ".location.pitch",
								p.getLocation().getPitch());
						plugin.getConfig().set("playershops." + p.getUniqueId() + ".location.world",
								p.getLocation().getWorld().getName());
						plugin.getConfig().set("playershops." + p.getUniqueId() + ".locked", false);
						plugin.getConfig().set("playershops." + p.getUniqueId() + ".uuid", p.getUniqueId().toString());
						plugin.saveConfig();
					}
				}
			} else {
				s.sendMessage(plugin.prefix + ChatColor.RED + "No Perms!");
			}

		}

		return true;
	}

}
