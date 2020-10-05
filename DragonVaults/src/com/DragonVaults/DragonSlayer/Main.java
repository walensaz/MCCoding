//Copyright © Zachary Walensa 2017


package com.DragonVaults.DragonSlayer;



import org.bukkit.Server;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;



public class Main extends JavaPlugin implements Listener {


 private static Main plugin;
 public static boolean started;
 public static List<String> commandplayers;


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
  //pm.registerEvents(new onJoin(this), this);
  //pm.registerEvents(new InventoryClick(this), this);
  //pm.registerEvents(new Fight(this), this);
  //pm.registerEvents(new Abilities(this), this);
  //pm.registerEvents(new PlayerLogin(this), this);

	
//getCommand("time").setExecutor(new Time (this)); 
//getCommand("Choose").setExecutor(new ChooseCommand (this)); 
//getCommand("Settime").setExecutor(new SetTime (this)); 
//getCommand("clearchat").setExecutor(new CommandClearChat(this));

  saveDefaultConfig();
 }

 public void onDisable() {

  getLogger().info("|-----------------------------------------|");

  }

 public static Main getInstance() {
  return plugin;
 }
}