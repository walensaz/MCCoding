package me.DragonSlayer.Anti;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	Main plugin;
	PluginManager pm = Bukkit.getServer().getPluginManager();
	
	public void onEnable() {
		plugin = this;
		
		this.getCommand("bmcaddworld").setExecutor(new CommandAddWorld(this));
		this.getCommand("bmcremoveworld").setExecutor(new CommandAddWorld(this));
		
		pm.registerEvents(new OnCommand(this), this);
		pm.registerEvents(new TeleportEvent(this), this);
		
	}
	
	
	public void onDisable() {
		
		
		
	}

}
