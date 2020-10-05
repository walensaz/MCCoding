package me.DragonEnchants;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import java.util.Random;


public class Poison implements Listener{
	Main plugin;
	
	
	public boolean lore(Player p, String con) {
		if(p.getItemInHand().getItemMeta().getLore().contains(con)) {
			return true;
			
			
		} else {
			return false;
		}
	}
	
	
	public Poison(Main pl) {
		this.plugin = pl;
		}
	

		 @EventHandler
		 public void Fight(EntityDamageByEntityEvent e) {
	            if(e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
	            	Player p = (Player) e.getDamager();
	            	Player pl = (Player) e.getEntity();
	            	PotionEffect effect = new PotionEffect(PotionEffectType.POISON, 4, 1);
	            	PotionEffect effect2 = new PotionEffect(PotionEffectType.POISON, 4, 2);
	            	if(lore(p, ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Poison I")) {
	            		Random rand = new Random();
	            		int  n = rand.nextInt(100) + 1;
	            		if(n >= 15) {
	            			effect.apply(pl);
	            			
	            		}
	            		
	            		
	            	} else if(lore(p, ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Poison II")) {
	            		Random rand = new Random();
	            		int  n = rand.nextInt(100) + 1;
	            		if(n >= 30) {
	            			effect.apply(pl);
	            		
	            		
	            		
	            	}
	            	
	            	
			 } else if(lore(p, ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Poison III")) {
         		Random rand = new Random();
         		int  n = rand.nextInt(100) + 1;
         		if(n >= 50) {
         			effect2.apply(pl);
				 
				 
			 }
				 
			  
		 }
	            }
		 }
}
