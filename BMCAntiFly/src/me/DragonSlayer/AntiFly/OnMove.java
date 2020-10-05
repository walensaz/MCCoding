package me.DragonSlayer.AntiFly;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

public class OnMove implements Listener {
	
	Main plugin;
	
	public void MOps(Player p, double violation) {
		for(Player pl: Bukkit.getOnlinePlayers()) {
			if(pl.hasPermission("BMC.fly.notify") || pl.isOp()) {
				pl.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0[&4BMCALERTS&0] " + p.getName() + " &cMight be fly hacking! VL " + violation));
			}
			
		}
		Bukkit.getServer().getLogger().log(Level.SEVERE, "[BMCALERTS] " + p.getName() + " Might be fly hacking! VL " + violation);
		
	}
	
	
	
	
	
	
	public OnMove(Main pl) {
		
		this.plugin = pl;
		
	}
	@EventHandler
	public void MoveEvent(PlayerMoveEvent e) {
		Location loc = e.getPlayer().getLocation();
		boolean worldfly = plugin.getConfig().getBoolean("worlds." + loc.getWorld());
		Block block = loc.getBlock();
		int blockint = loc.getBlockY() - 1;
		loc.setY(blockint);
		Block block2 = loc.getBlock().getRelative(BlockFace.DOWN);
		boolean ladder = false;
		for(BlockFace b: BlockFace.values()) {
			if(block.getRelative(b).getType().equals(Material.LADDER)) {
				ladder = true;
			}
			
		}
		Player p = e.getPlayer();
		Location loc2 = e.getPlayer().getLocation();
		
		if(e.getPlayer().hasPermission("BMC.fly") || e.getPlayer().isOp()) {
			return;
		} else if(worldfly == true) {
			return;
			
		} else if(ladder) {
			plugin.times.remove(e.getPlayer());
			plugin.playerymax.remove(e.getPlayer());
			plugin.playerymin.remove(e.getPlayer());
			return;

		} else {
			if(e.getPlayer().getActivePotionEffects().contains(PotionEffectType.JUMP)) {
				
			} else if(block2.getType().equals(Material.AIR)) {
				if((!(plugin.times.containsKey(e.getPlayer())) || plugin.times.get(e.getPlayer()) <= 15)) {
					
					if(!(plugin.times.containsKey(e.getPlayer()))) {
						
						plugin.times.put(e.getPlayer(), 1);
						plugin.playerymin.put(e.getPlayer(), loc2.getY());
						plugin.playerymax.put(e.getPlayer(), loc2.getY());
						
					} else if(plugin.playerymax.get(e.getPlayer()) < loc2.getY()) {
						
						int times = plugin.times.get(e.getPlayer());
						plugin.times.replace(e.getPlayer(), times + 1);
						plugin.playerymax.replace(e.getPlayer(), loc2.getY());	
						
						
					} else {
						int times = plugin.times.get(e.getPlayer());
						plugin.times.replace(e.getPlayer(), times + 1);
						
					}
				}else {
					
					double num1 = plugin.playerymin.get(e.getPlayer());
					double num2 = plugin.playerymax.get(e.getPlayer());
					double totalblock = num2-num1;
					p.sendMessage("Checked " + totalblock);
				if(totalblock > 4.2) {
				
				MOps(e.getPlayer(), totalblock);
				plugin.times.remove(e.getPlayer());
				plugin.playerymax.remove(e.getPlayer());
				plugin.playerymin.remove(e.getPlayer());
				e.setCancelled(true);
				
				
			} else {
				
				plugin.times.remove(e.getPlayer());
				plugin.playerymax.remove(e.getPlayer());
				plugin.playerymin.remove(e.getPlayer());
				
			}
				
				}
				
			}
			
			
			
			
		}
		
		
	}

}
