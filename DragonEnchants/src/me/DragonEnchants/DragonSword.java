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


public class DragonSword implements Listener{
	Main plugin;
	
	
	public boolean lore(Player p, String con) {
		if(p.getItemInHand().getItemMeta().getLore().contains(con)) {
			return true;
			
			
		} else {
			return false;
		}
	}
	
	
	public DragonSword(Main pl) {
		this.plugin = pl;
		}
	

		 @EventHandler
		 public void Fight(EntityDamageByEntityEvent e) {
	            if(e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
	            	Player p = (Player) e.getDamager();
	            	Player pl = (Player) e.getEntity();
	            	PotionEffect effect = new PotionEffect(PotionEffectType.POISON, 20, 1);
	            	PotionEffect effect2 = new PotionEffect(PotionEffectType.WITHER, 20, 1);
	            	PotionEffect effect3 = new PotionEffect(PotionEffectType.BLINDNESS, 20, 2);
	            	PotionEffect effect4 = new PotionEffect(PotionEffectType.HEAL, 20, 6);
	            	PotionEffect effect5 = new PotionEffect(PotionEffectType.HARM, 1, 1);
	            	PotionEffect effect6 = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 40, 1);
	            	PotionEffect effect7 = new PotionEffect(PotionEffectType.REGENERATION, 100, 4);
	            	
	            	if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "A Dragon's Claw")) {
	            		Random rand = new Random();
	            		int n = rand.nextInt(100) + 1;
	            		if(n <= 50) {
	            			effect.apply(pl);
	            			pl.addPotionEffect(effect);
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