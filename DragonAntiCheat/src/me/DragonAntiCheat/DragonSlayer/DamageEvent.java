package me.DragonAntiCheat.DragonSlayer;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.NPC;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class DamageEvent implements Listener{
	Main plugin;
	

	PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles();


	@EventHandler
	public void Damage(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			Player damager = (Player) e.getDamager();
			Player damaged = (Player) e.getEntity();
			Float yaw = damager.getLocation().getYaw();
			Float yaw2 = damaged.getLocation().getYaw();
			damager.sendMessage(ChatColor.RED + String.valueOf(yaw));
			damaged.sendMessage(ChatColor.RED + String.valueOf(yaw));
			damager.sendMessage(ChatColor.RED + String.valueOf(yaw2));
			damaged.sendMessage(ChatColor.RED + String.valueOf(yaw2));
			 CraftPlayer p = (CraftPlayer) damaged;
			 
			 ((CraftPlayer) p).getHandle ().playerConnection.sendPacket ();
			
				
			 
		}
	}

}
