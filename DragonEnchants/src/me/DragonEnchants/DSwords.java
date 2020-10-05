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



public class DSwords implements CommandExecutor{
	
	 private final Main plugin;
	 

	 
	 public DSwords(Main instance) {
	  plugin = instance;
	 }
	 
	 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	  Player p = (Player) sender;
	  if (commandLabel.equalsIgnoreCase("DSword")) {
		  if(p.hasPermission("DEnchant.Sword")) {
	  
		 if(args.length == 1) {
			 if(args[0].equalsIgnoreCase("DragonSlayer")) {
				 ItemStack DagSword = new ItemStack(Material.DIAMOND_SWORD);
				 ItemMeta dag = DagSword.getItemMeta();
				 dag.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "A DragonSlayer's Sword");
				 ArrayList<String> nl = new ArrayList<String>();
				 nl.add(ChatColor.RED + "An Ancient sword wielded by those who hunted Dragons!");
				 dag.setLore(nl);
				  	
				 DagSword.setItemMeta(dag);
				 p.getInventory().addItem(DagSword);
				 
			 } else if(args[0].equalsIgnoreCase("Dragon")) {
				 
				 
				 ItemStack DagSword = new ItemStack(Material.DIAMOND_SWORD);
				 ItemMeta dag = DagSword.getItemMeta();
				 dag.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "A DragonSlayer's Sword");
				 ArrayList<String> nl = new ArrayList<String>();
				 nl.add(ChatColor.RED + "An Ancient sword wielded by those who hunted Dragons!");
				 dag.setLore(nl);
				  	
				 DagSword.setItemMeta(dag);
				 p.getInventory().addItem(DagSword);
			 }
		  
	  }
	  }
	  }return true;
	 } 
}





