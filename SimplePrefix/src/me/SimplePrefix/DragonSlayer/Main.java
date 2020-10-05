//Copyright © Zachary Walensa 2017


package me.SimplePrefix.DragonSlayer;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;

import java.util.List;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin implements Listener {
	
    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;


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
	 //Vault
	 if (!setupEconomy() ) {
         log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
         getServer().getPluginManager().disablePlugin(this);
         return;
     }
     setupPermissions();
     setupChat();
  plugin = this;
started = true;

  getLogger().info("|----------------------------------------|");

  //Events

  //pm.registerEvents(new InventoryClick(this), this);

  //pm.registerEvents(new PlayerLogin(this), this);

	//Commands

getCommand("setdonor").setExecutor(new setDonorCommand(this));
getCommand("sdr").setExecutor(new reloadConfigCommand(this));
plugin.getConfig().options().copyDefaults(true);
plugin.saveConfig();
  
 }

 public void onDisable() {
	 log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
  getLogger().info("|-----------------------------------------|");

  }

 public static Main getInstance() {
  return plugin;
 }
 
 //Vault Methods
 private boolean setupEconomy() {
     if (getServer().getPluginManager().getPlugin("Vault") == null) {
         return false;
     }
     RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
     if (rsp == null) {
         return false;
     }
     econ = rsp.getProvider();
     return econ != null;
 }
 
 private boolean setupChat() {
     RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
     chat = rsp.getProvider();
     return chat != null;
 }
 
 private boolean setupPermissions() {
     RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
     perms = rsp.getProvider();
     return perms != null;
 }
 public static Economy getEcononomy() {
     return econ;
 }
 
 public static Permission getPermissions() {
     return perms;
 }
 
 public static Chat getChat() {
     return chat;
 }
 
 private Plugin loadPlugin(String pluginName) {
	    Plugin plugin = getServer().getPluginManager().getPlugin(pluginName);
	    if (plugin == null) {
	        return null;
	    }
	    return plugin;
	}
 
}