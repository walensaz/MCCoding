package me.DragonEnchants;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;



public class Enchant implements CommandExecutor{
	
	 private final Main plugin;
	 
	 public String integer(int num) {
		 if(num == 1) {
			 return "I";
		 } else if (num == 2) {
			 return "II";
		 } else {
			 return "III";
		 }
	 }
	 
	 
	 public Enchant(Main instance) {
	  plugin = instance;
	 }
	 
	 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	  Player p = (Player) sender;
	  if (commandLabel.equalsIgnoreCase("DEnchant")) {
		  if(p.hasPermission("DEnchant.Enchant")) {
	  
		 if(args.length == 2) {
			 if(args[0].equalsIgnoreCase("Poison")) {
				 String pois = ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Poison ";
			 String num = integer(Integer.valueOf(args[1]));
			 ArrayList<String> nl = new ArrayList<String>();
			 
			 nl.add(pois + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + num);
			 p.getItemInHand().getItemMeta().setLore(nl);
			
			 
			 
		 }
		  
	  }
	  }
	  }return true;
	 } 
}





