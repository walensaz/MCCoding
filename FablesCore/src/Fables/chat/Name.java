package Fables.chat;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import Fables.core.Main;

public class Name implements CommandExecutor {
 private final Main plugin;
 
 public Name(Main instance) {
  plugin = instance;
 }
 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
  Player p = (Player) sender;
  if (commandLabel.equalsIgnoreCase("name")) {
    if (p.hasPermission("fable.name") || p.isOp()) { 
    	if(args.length == 1) {

    			if(args[0].length() < 35) {
    				if(!(args[0].contains("&"))) {
    		String name = args[0];
    		plugin.getConfig().set("names." + p.getName(), name);
    		p.sendMessage(ChatColor.GREEN + "You name has been set to " + name);
    	
    				}else {
    					p.sendMessage(ChatColor.RED + "You cannot use colors in your name!");
    				}
    			}else {
    				p.sendMessage(ChatColor.RED + "Your name must be shorter than 35 characters!");
    			
    		} 
    	}else if(args.length == 2) {
    		if(p.hasPermission("Fable.mod")) {
    		Player p2 = Bukkit.getPlayer(args[1]);
    		if(p2 != null) {
    			plugin.getConfig().set("names." + p2.getName(), args[0]);
    		
    		} else {
    			if(p.hasPermission("Fable.mod")) {
    				p.sendMessage(ChatColor.RED + "Usage: /Name <Name>  NOTE: You can use a '-' to put a space in your name OR /Name <Name> <Player>!");
    			} else {
    			p.sendMessage(ChatColor.RED + "Usage: /Name <Name>  NOTE: You can use a '-' to put a space in your name!");
    			}
    		}
    		}else {
    			p.sendMessage(ChatColor.RED + "Usage: /Name <Name>  NOTE: You can use a '-' to put a space in your name!");
    		}
    	}
    	
    	else {
    		p.sendMessage(ChatColor.RED + "Usage: /Name <Name>  NOTE: You can use a '-' to put a space in your name!");
    	}
    	}	
    	}
    	

return true;
 }
}
