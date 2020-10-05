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


public class DragonRiderSword implements Listener{
	Main plugin;
	
	
	public boolean lore(Player p, String con) {
		if(p.getItemInHand().getItemMeta().getLore().contains(con)) {
			return true;
			
			
		} else {
			return false;
		}
	}
	
	
	public DragonRiderSword(Main pl) {
		this.plugin = pl;
		}
	

		 @EventHandler
		 public void Fight(EntityDamageByEntityEvent e) {
	            if(e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
	            	Player p = (Player) e.getDamager();
	            	Player pl = (Player) e.getEntity();
	            	PotionEffect effect = new PotionEffect(PotionEffectType.POISON, 20, 2);
	            	PotionEffect effect2 = new PotionEffect(PotionEffectType.WITHER, 20, 3);
	            	PotionEffect effect3 = new PotionEffect(PotionEffectType.SLOW, 20, 3);
	            	PotionEffect effect4 = new PotionEffect(PotionEffectType.HEAL, 10, 3);
	            	PotionEffect effect5 = new PotionEffect(PotionEffectType.HARM, 1, 3);
	            	PotionEffect effect6 = new PotionEffect(PotionEffectType.SPEED, 60, 3);
	            	PotionEffect effect7 = new PotionEffect(PotionEffectType.REGENERATION, 40, 3);
	            	
	            	if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "A DragonRider's Sword")) {
	            		Random rand = new Random();
	            		int  n = rand.nextInt(100) + 1;
	            		if(n <= 50) {
	            			effect.apply(pl);
	            			effect2.apply(pl);
	            			effect3.apply(pl);
	            			effect4.apply(p);
	            			effect5.apply(pl);
	            			
	            			
	            		} else if(n >=74 && n <= 79) {
	            			p.setHealth(20);
	            			effect6.apply(p);
	            			effect7.apply(p);
	            		}

	            }
		 }
}
}