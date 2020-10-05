package me.org.Bastion.Packs;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	
	
	Main plugin;
	
	PluginManager pm = Bukkit.getServer().getPluginManager();
	
	
	public void onEnable() {
		plugin = this;
		saveDefaultConfig();
		
		//Events
		pm.registerEvents(new InventoryClose(this), plugin);
		
		//Commands
		this.getCommand("backpack").setExecutor(new Backpacks(this));
		this.getCommand("bp").setExecutor(new Backpacks(this));
	}
	
	public void onDisable() {
		
		
		
		
	}
	
	
}
