package Fables.core;

//import me.DragonSlayer.Main.BlockPlace;
import java.sql.Connection;
import java.sql.SQLException;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import Fables.chat.Bird;
import Fables.chat.ChatChannel;
import Fables.chat.Chats;
import Fables.chat.FastBird;
import Fables.chat.Name;
import Fables.chat.Scoreboard;

import java.util.logging.Logger;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	

	private static Economy econ = null;
	private static Permission perms = null;
	private static Chat chat = null;
 private static Main plugin;


 static Main instance;

 public Main() {
  instance = this;
 }

 public static Main instance() {
  return instance;
 }

 PluginManager pm = Bukkit.getServer().getPluginManager();
 public void onEnable() {

	 
	 
	 
	 
	 
  plugin = this;
  Scoreboard.registerHealthBar();
  getLogger().info("|Fables-Core ENABLED|");

   
 pm.registerEvents(this, this);	
 pm.registerEvents(new ChatChannel(this), this);
	
getCommand("l").setExecutor(new Chats (this));  
getCommand("g").setExecutor(new Chats (this)); 
getCommand("local").setExecutor(new Chats (this)); 
getCommand("global").setExecutor(new Chats (this)); 
getCommand("chatspy").setExecutor(new Chats (this)); 
getCommand("name").setExecutor(new Name (this)); 
getCommand("bird").setExecutor(new Bird (this)); 
getCommand("fastbird").setExecutor(new FastBird (this));
getCommand("staffchat").setExecutor(new Chats (this));

  saveDefaultConfig();
  
  if (!setupEconomy() ) {
	    getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
	    getServer().getPluginManager().disablePlugin(this);
	    return;
	}
	setupPermissions();
	setupChat();
 }

 public void onDisable() {

  getLogger().info("|Fables-Core DISABLED|");
  getLogger().info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));

  }

 public static Main getInstance() {
  return plugin;
 }



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
}