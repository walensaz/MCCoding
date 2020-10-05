package me.SimplePrefix.DragonSlayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;



public class setDonorCommand implements CommandExecutor{
	
	 private final Main plugin;
	 
	 public setDonorCommand(Main instance) {
	  plugin = instance;
	 }
	 
	 
	 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		 if(commandLabel.equalsIgnoreCase("setDonor")) {
			 if(args.length == 2 && sender.hasPermission("SimplePrefix.setDonor")) {
				 String pname = Bukkit.getPlayerExact(args[0]).getName();
		  if(args[1].equals("0")){
			  plugin.getConfig().set(pname, false);
			  plugin.saveConfig();
			  
			  String prefix = Main.getChat().getGroupPrefix(Bukkit.getPlayer(args[0]).getWorld(), Main.getPermissions().getPrimaryGroup(Bukkit.getPlayer(args[0])).toString());
			  Main.getChat().setPlayerPrefix(Bukkit.getPlayer(args[0]), prefix);
			  sender.sendMessage(ChatColor.RED + "Prefix Removed!");
			  
		  } else if(args[1].length() > 2) {
					 plugin.getConfig().set(pname, true);
					 plugin.saveConfig();
					 String prefix = Main.getChat().getPlayerPrefix(Bukkit.getPlayer(args[0]));
					 Main.getChat().setPlayerPrefix(Bukkit.getPlayer(args[0]), args[1] + prefix);
					 sender.sendMessage(args[1] + ChatColor.RED + " has been successfully added!");
		  }
				 
			 } else {
				 sender.sendMessage(ChatColor.RED + "no perms or not enough args");
			 }
			 
	  }return true;
	  }

	 
}
