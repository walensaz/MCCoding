package me.bmcsimple.Teleports;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class HelloCommand implements CommandExecutor {
	//Constructor
	Main plugin;
	public HelloCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {  //Args is what comes after the command /hello teleports
		if(s instanceof Player) { //Checks if sender is a player not console
			Player p = (Player) s; //Player being assigned to a different variable
			
			if(args.length == 1) { //Args length
				Player target = Bukkit.getPlayer(args[0]); 
				if(target != null) {   //Null basically means nothing
					target.sendMessage(ChatColor.RED + p.getName() + " Has said hello!");
					p.sendMessage(ChatColor.RED + target.getName() + "Has received your hello!");
					
				} else {
					p.sendMessage(ChatColor.RED + "This player is not online!");
				}
				
				
			} else if(p.hasPermission("bmc.hello")) { //Checks permissions
				p.sendMessage(ChatColor.RED + "Hello!");  //Sends message
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Hello!"));
				
				
			} else {
				p.sendMessage(ChatColor.RED + "No permission my friend!");
			}
		}
		
		
		
		return true;
	}
	
	
	
	
	
	
	

}
