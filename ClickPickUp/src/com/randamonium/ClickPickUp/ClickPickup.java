package com.randamonium.ClickPickUp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class ClickPickup extends JavaPlugin implements Listener {

@EventHandler
 public void onPlayerPickup(PlayerPickupItemEvent event) {
     
	event.setCancelled(true);
}

@EventHandler
 public void onPlayerInteract(PlayerInteractEvent event) {
 EquipmentSlot es = event.getHand(); //Get the hand of the event and set it to 'e'.
 	if (es.equals(EquipmentSlot.HAND)) { //If the event is fired by HAND (main hand)
 		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
 			double radius = getConfig().getDouble("radius");
 			Block b = event.getPlayer().getTargetBlock((Set<Material>) null, 50);
 			Location loc = event.getPlayer().getTargetBlock((Set<Material>) null, 50).getLocation();
 			
 				for (int i = 0; i < nearbyEntities(b.getLocation(), radius).size(); i++) {
 					Entity e = nearbyEntities(b.getLocation(), radius).get(i);
 					double locX = e.getLocation().getX();
 					double locZ = e.getLocation().getZ();
 					double locY = e.getLocation().getY();
 					if(loc.getBlockZ() + .9999 >= locZ && loc.getBlockZ() <= locZ) {
 	 					if(loc.getBlockX() + .9999 >= locX && loc.getBlockX() <= locX) {
 	 	 					if(250 >= locY && 0 <= locY) {
 	 					
 						if (e instanceof Item) {
 							event.getPlayer().getInventory().addItem(((Item) e).getItemStack());
 							e.remove();
 						}
 	 	 					}
 						}
 					}
 				}
 			}   
 		}
	}

 public static List<Entity> nearbyEntities(Location location, double radius) {
 List<Entity> entities = new ArrayList<Entity>();

 for (Entity entity : location.getWorld().getEntities()) {
 if (entity.getWorld() != location.getWorld()) {
continue;
 } else if (entity instanceof Player && ((Player) entity).getGameMode().equals(GameMode.SPECTATOR)) {
continue; //Don't want spectators
 } else if (entity.getLocation().distanceSquared(location) <= radius * radius) {
 entities.add(entity);
}
}

 return entities;
 }
  
 

 public void onEnable() {
 Bukkit.getServer().getPluginManager().registerEvents(this, this);
 getConfig().options().copyDefaults(true);
 saveConfig();
 }

}