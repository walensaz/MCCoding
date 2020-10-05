package me.DragonSlayer.AntiFly;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {
	Main plugin;
	
	public MoveEvent(Main pl) {
		this.plugin = pl;
		
	}
	
	
	@EventHandler
	public void onMoveEvent(PlayerMoveEvent e) {
		
		
		
	}
	
	
}
