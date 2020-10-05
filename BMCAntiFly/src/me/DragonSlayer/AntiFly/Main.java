package me.DragonSlayer.AntiFly;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	
	Main plugin;
	
	PluginManager pm = Bukkit.getServer().getPluginManager();
	public HashMap<Player, Double> playerymin;
	public HashMap<Player, Double> playerymax;
	public HashMap<Player, Integer> times;
	
	
	public void onEnable() {
		plugin = this;
		saveDefaultConfig();
		
		playerymin = new HashMap<Player, Double>();
		playerymax = new HashMap<Player, Double>();
		times = new HashMap<Player, Integer>();
		
		pm.registerEvents(new OnMove(this), this);
		
		
		
	}
	
	
	public void onDisable() {
		
		
		
		
		
	}
	
	
}
