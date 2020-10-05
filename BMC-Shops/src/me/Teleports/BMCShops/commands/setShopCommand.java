package me.Teleports.BMCShops.commands;

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

import me.Teleports.BMCShops.Main;
import net.md_5.bungee.api.ChatColor;

public class setShopCommand implements CommandExecutor {

	Main plugin;
	private int price;

	public setShopCommand(Main pl) {
		this.plugin = pl;
		this.price = pl.getConfig().getInt("setshop-price");
	}
	
	protected boolean checkDangers(Player p, int radius) {
		boolean bool = true;
		Location loc = p.getLocation();
		List<Material> blocks = Utils.getNearbyBlocks(loc, radius);
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
				if (this.checkDangers(p, 3) == false) {
					if (!(plugin.setshop.containsKey(p)) && Main.getEconomy().bankBalance(p.getName()).amount >= price) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.prefix + plugin.getConfig().getString("set-shop-confirm").replace("[price]", String.valueOf(price))));
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
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.prefix + plugin.getConfig().getString("set-shop")));
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
						plugin.getConfig().set("playershops." + p.getUniqueId() + ".time", System.currentTimeMillis());
					
						plugin.saveConfig();
					}
				}
			} else {
				s.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.prefix + plugin.getConfig().getString("no-perms")));
			}

		}

		return true;
	}

	
	
	
	
}





