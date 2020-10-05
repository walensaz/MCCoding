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



public class reloadConfigCommand implements CommandExecutor{
	
	 private final Main plugin;
	 
	 public reloadConfigCommand(Main instance) {
	  plugin = instance;
	 }
	 
	 
	 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		 if(commandLabel.equalsIgnoreCase("sdr")) {
			 if(sender.isOp() ||sender.hasPermission("SimplePrefix.reload")) {
				 plugin.reloadConfig();
			 }
	  }return true;
	  }

	 
}
