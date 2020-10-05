package me.DragonSlayer.Anti;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import net.md_5.bungee.api.ChatColor;

public class OnCommand implements Listener {
	
	Main plugin;
	
	public OnCommand(Main pl) {
		this.plugin = pl;
	}
	
	@EventHandler
	public void CommandEvent(PlayerCommandPreprocessEvent e) {
		if(e.getMessage().startsWith("/fly") && !(e.getPlayer().hasPermission("BMC.fly.Admin"))) {
			if(plugin.getConfig().getList("worlds.disable").contains(e.getPlayer().getWorld().getName())) {
				e.setCancelled(true);
				e.getPlayer().sendMessage(ChatColor.RED + "You cannot use /fly in this world!");
				e.getPlayer().setFlying(false);
				
			}
		}
		
		
		
	}
	

}
