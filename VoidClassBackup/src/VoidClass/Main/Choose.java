/*package VoidClass.Main;

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



public class Choose implements CommandExecutor{
	
	 private final Main plugin;
	 
	 private String replaceColors(String message) {
			return message.replaceAll("(?i)&([a-f0-9])", "\u00A7$1");
		}
	 
	 public Choose(Main instance) {
	  plugin = instance;
	 }
	 
	 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	  Player p = (Player) sender;
	  if (commandLabel.equalsIgnoreCase("Choose")) {
		  if(plugin.getConfig().getString("players." + p.getUniqueId() + ".class") == "H"  || p.hasPermission("class.choose")) {
			  String Conq = ChatColor.GOLD + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Conqueror" + ChatColor.YELLOW + " Side";
				 String yield = ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Yielder" + ChatColor.YELLOW + " Side";
				 String hab = ChatColor.WHITE + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Habitant" + ChatColor.YELLOW + " Side";
				 String S1 = replaceColors("&6The heroes of the dimensions, winners");
				 String S1r = replaceColors("&6of the conquest. They have conquered");
				 String S2 = replaceColors("&6All the dimensions. Will it be another win?");
				 String S3 = replaceColors("&a+2 hearts");
				 String S4 = replaceColors("&c-8% damage");
     			 String S5 = replaceColors("&aYour hearts increase by &c.5 &aevery 12 hours you play");
				 String space = "";
				 String S6 = replaceColors("&5The Yielders are the failures in the dimensions.");
				 String S6r = replaceColors("&5This species hate the Conquerors and their fame and might");
				 String S7 = replaceColors("&5They are the most aggressive species in all the dimensions. ");
				 String S8 = replaceColors("&5They must stop the Conquerors, is it their time now?");
				 String S9 = replaceColors("&a+10% damage");
				 String S10 = replaceColors("&c-1 hearts");
				 String S11 = replaceColors("&aYour damage increases by &e.05% &aevery 12 hours you play");
					 
				 Inventory inv = Bukkit.createInventory(null, 27, "Choose Your Side");
				 ItemStack sword = new ItemStack(Material.DIAMOND_CHESTPLATE);
				 ItemStack bone = new ItemStack(Material.BONE);
				 ItemMeta swordm = sword.getItemMeta();
				 swordm.setDisplayName(Conq);
				ArrayList<String> sl = new ArrayList<String>();
				
				 sl.add(S1);
				 sl.add(S1r);
				 sl.add(S2);
				 sl.add(space);
				 sl.add(S3);
				 sl.add(S4);
				 sl.add(space);
				 sl.add(S5); 
				 swordm.setLore(sl);
				 sword.setItemMeta(swordm);
				 ItemMeta bonem = bone.getItemMeta();
				 bonem.setDisplayName(yield);
				 ArrayList<String> nl = new ArrayList<String>();
				 nl.add(S6);
				 nl.add(S6r);
				 nl.add(S7);
				 nl.add(S8);
				 nl.add(space);
				 nl.add(S9);
				 nl.add(S10);
				 
				 nl.add(space);
				 nl.add(S11);
				 bonem.setLore(nl);
				 bone.setItemMeta(bonem);
				 ItemStack apple = new ItemStack(Material.APPLE);
				 ItemMeta applem = apple.getItemMeta();
				 applem.setDisplayName(hab);
				 ArrayList<String> al = new ArrayList<String>();
				 al.add(ChatColor.GRAY + "Habitant gets no boosts");
				 al.add(ChatColor.GRAY + "It is neutral and gets nothing special");
				 al.add(ChatColor.GRAY + "You may change using /choose with this class");
				 al.add("");
				 al.add(ChatColor.GRAY + "You also do not gain time with this class.");
				 applem.setLore(al);
				 apple.setItemMeta(applem);
				inv.setItem(10, sword);
				inv.setItem(16, bone);
				inv.setItem(13, apple);
				 
				
				 p.sendMessage(ChatColor.RED + "Choose a class, place your cursor over each class for more information.");
				 
				        	 p.openInventory(inv);
				        		 
				     
					
				 }else{
					 p.sendMessage(ChatColor.RED + "You have already chosen a side to fight on!");
				 }
		  
	  }return true;
	  }


}*/
