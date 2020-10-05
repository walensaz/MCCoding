package me.bmcsimple.Teleports;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	Main plugin;
	
	PluginManager pm = Bukkit.getServer().getPluginManager();
	
	public void onEnable() {
		plugin = this;
		
		
		this.getCommand("hello").setExecutor(new HelloCommand(this)); //Registering the command for the plugin
		
		
		pm.registerEvents(new MoveEvent(), this);
	}
	
	
	public void onDisable() {
		
		
		
		
	}
	

}
