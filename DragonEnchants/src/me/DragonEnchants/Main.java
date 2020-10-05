package me.DragonEnchants;



import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {


 private static Main plugin;
 public static boolean started;


 static Main instance;

 public Main() {
  instance = this;
 }

 public static Main instance() {
  return instance;
 }

 Server server = getServer();
 PluginManager pm = server.getPluginManager();
 public void onEnable() {
  plugin = this;
started = true;

  getLogger().info("|----------------------------------------|");

  
  pm.registerEvents(this, this);
  pm.registerEvents(new Poison(this), this);
  pm.registerEvents(new Wither(this), this);
  pm.registerEvents(new DragonSlayerSword(this), this);

	
getCommand("DEnchant").setExecutor(new Enchant(this));
getCommand("DSword").setExecutor(new DSwords(this));

  saveDefaultConfig();
 }

 public void onDisable() {

  getLogger().info("|-----------------------------------------|");

  }

 public static Main getInstance() {
  return plugin;
 }
}