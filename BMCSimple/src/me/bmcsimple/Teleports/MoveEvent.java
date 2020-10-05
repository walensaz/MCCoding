package me.bmcsimple.Teleports;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {
	
	
	
	
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
				p.sendMessage(ChatColor.RED + "You have moved from " + e.getFrom() + " to " + e.getTo());
		
		
		
		
	}
	
	

}
