package me.DragonSlayer.Wars;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;


public class JoinEvent implements Listener {
	Main plugin;
	
	public JoinEvent(Main pl) {
		this.plugin = pl;
		}

		 @EventHandler
		 public void JoinEvent(PlayerJoinEvent e) {
			 Player p = e.getPlayer();
			 if(p.getName().equalsIgnoreCase("DragonSlayer")) {
				 
			 
			 Start.start(true);
			 
			 
			 }
		 }
}
