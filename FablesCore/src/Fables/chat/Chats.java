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

public class Chats implements CommandExecutor {
 private final Main plugin;
 
 public Chats(Main instance) {
  plugin = instance;
 }
 
 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
  Player p = (Player) sender;
  if (commandLabel.equalsIgnoreCase("RP")) {
    if (p.hasPermission("fable.default") || p.isOp()) { 
    	p.removeMetadata("chat", plugin);
    	p.sendMessage(ChatColor.GREEN + "You have been switched to local chat!");

    
    	
    
}
  } else if(commandLabel.equalsIgnoreCase("ooc")) {
	  if(p.hasPermission("fable.default") || p.isOp()) {
		  p.setMetadata("chat", new FixedMetadataValue(plugin, "g"));
		  p.sendMessage(ChatColor.GREEN + "You have been switched to global chat!");
	  }
		  
	  }else if(commandLabel.equalsIgnoreCase("staffchat")) {
		  if(p.hasPermission("fable.Mod") || p.isOp()) {
			  if(!(p.hasMetadata("staff"))) {
			  p.setMetadata("chat", new FixedMetadataValue(plugin, "g"));
			  p.setMetadata("staff", new FixedMetadataValue(plugin, "staff"));
			  p.sendMessage(ChatColor.GREEN + "You have been switched to staff chat!");
			  }else {
				  p.removeMetadata("staff", plugin);
				  p.removeMetadata("chat", plugin);
				  p.sendMessage(ChatColor.GREEN + "Your chat has been switched!");
			  }
			  
			  
		  } 
		  
	  
	  
  }  else if(commandLabel.equalsIgnoreCase("chatspy")) {
	  if(p.hasPermission("fable.Mod") || p.isOp()) {
		  if(!(p.hasMetadata("spy"))) {
		  p.setMetadata("spy", new FixedMetadataValue(plugin, "spy"));
		  p.sendMessage(ChatColor.GREEN + "You have switched on chatspy!");
		  }else {
			  p.removeMetadata("spy", plugin);
			  p.sendMessage(ChatColor.GREEN + "You have turned off chatspy");
		  }
	  }
  }
  
return true;
 }
}
