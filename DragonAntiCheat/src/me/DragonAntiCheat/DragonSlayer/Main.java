package me.DragonAntiCheat.DragonSlayer;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {
	
	public static Main plugin;
	
	PluginManager pm = getServer().getPluginManager();
	
	public void onEnable() {
		plugin = this;
		pm.registerEvents(new DamageEvent(), this);
		
		
		
		
	}
	
	public void onDisable() {
		
		
	}

}
