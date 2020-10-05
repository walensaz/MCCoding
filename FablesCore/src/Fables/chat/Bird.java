package Fables.chat;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import Fables.core.Main;

public class Bird implements CommandExecutor {
 private final Main plugin;
 
 public Bird(Main instance) {
  plugin = instance;
 }
 
 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
  Player p = (Player) sender;
  if (commandLabel.equalsIgnoreCase("bird")) {
    if (p.hasPermission("fable.default") || p.isOp()) { 
    	if(args.length > 1) {
    		final Player pl = Bukkit.getPlayer(args[0]);
    		final Player pla = p;
    		String msg = "";
    		String name = "";
    		pla.sendMessage(ChatColor.GREEN + "Message sent!");
    		if(plugin.getConfig().getString("names." + p.getName()) != null) {
    			name = plugin.getConfig().getString("names." + p.getName());
    			name.replaceAll("-", " ");
    		} else {
    			name = p.getName();
    			
    		}
    		
    		for(int i = 1; i < args.length; i++) {
    			msg += args[i];
    		}
    		final String ms = msg;
    		final String nam = name;
    		 BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
    	        scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
    	            @Override
    	            public void run() {
    	            	pla.sendMessage(ChatColor.GREEN + "Bird has delievered its message!");
    	                pl.sendMessage(ChatColor.AQUA + "[Bird] " + ChatColor.DARK_GRAY + "" + nam + ChatColor.WHITE + " : " + ChatColor.GRAY + ms);
    	            }
    	        }, 12000L);
    		
    	}
	  }
  }
return true;
 }
}
