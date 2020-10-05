package me.DragonSlayer.Anti;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.scheduler.BukkitScheduler;

import net.md_5.bungee.api.ChatColor;

public class TeleportEvent implements Listener {

	Main plugin;
	
	public TeleportEvent(Main pl) {
		this.plugin = pl;
	}
	
	@EventHandler
	public void onTeleport(PlayerTeleportEvent e) {
		if(e.getPlayer().hasPermission("BMC.fly.admin")) {
			return;
		} else if(e.getCause().equals(TeleportCause.ENDER_PEARL)) {
			return;
			
		} else {
			BukkitScheduler schedule = Bukkit.getScheduler();
			schedule.scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					
					
				
			List<String> list = (List<String>) plugin.getConfig().getList("worlds.disable");
			if(list == null) {
				return;
			} else if(list.contains(e.getPlayer().getWorld().getName()) && e.getPlayer().getAllowFlight() == true) {
				e.getPlayer().setFlying(false);
				e.getPlayer().setAllowFlight(false);
				e.getPlayer().sendMessage(ChatColor.RED + "Flying disabled in this world!");
				
			} else if(e.getPlayer().hasPermission("essentials.fly") && (!(list.contains(e.getPlayer().getWorld().getName())))){
				e.getPlayer().setAllowFlight(true);
				e.getPlayer().sendMessage(ChatColor.GREEN + "Fly enabled!");
				return;
			} else {
				return;
			}
				}
			}, 5L);
		}
		
		
		
	}
	
	
	
}
