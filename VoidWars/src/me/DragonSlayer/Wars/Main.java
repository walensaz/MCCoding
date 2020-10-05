package me.DragonSlayer.Wars;



import org.bukkit.Server;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {


 private static Main plugin;


 static Main instance;

 public Main() {
  instance = this;
 }

 public static Main instance() {
  return instance;
 }

 Server server = getServer();
 PluginManager pm = server.getPluginManager();
 //public static String prefix = ChatColor.DARK_RED + "Dark" + ChatColor.DARK_PURPLE + "PvP" + ChatColor.GOLD + ">> ";
 public void onEnable() {

  plugin = this;


  getLogger().info("|----------------------------------------|");

  
  pm.registerEvents(this, this);
	pm.registerEvents(new JoinEvent(this), this);
	pm.registerEvents(new Villager(this), this);
	pm.registerEvents(new Inventory(this), this);
	
getCommand("Iron").setExecutor(new Iron (this));
getCommand("stopingots").setExecutor(new Iron(this));
//getCommand("gold").setExecutor(new Gold (this));
//getCommand("ticket").setExecutor(new Ticket (this));

  saveDefaultConfig();
 }

 public void onDisable() {

  getLogger().info("|-----------------------------------------|");

  }

 public static Main getInstance() {
  return plugin;
 }
}