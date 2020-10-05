package me.DragonSlayer.Wars;



import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Iron implements CommandExecutor {
 private final Main plugin;
 private static Main plugin2;
 
 public Iron(Main instance) {
  plugin = instance;
  plugin2 = instance;
 }
 public static Boolean ironnum;
 public static void spawnIron(final String world3, final Location loc, final ItemStack item1) {
	 BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
     scheduler.scheduleSyncRepeatingTask(plugin2, new Runnable() {
         @Override
         public void run() {
        	 Bukkit.getServer().getWorld(world3).dropItem(loc, item1);
        		 
        	 
         }
     }, 25L, 25L);
	 
	 
 }
 
 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
  Player p = (Player) sender;
  if (commandLabel.equalsIgnoreCase("iron")) {
    if (p.isOp()) { 
    	
    	World world = p.getWorld();
    	ItemStack item = new ItemStack(Material.IRON_INGOT);
    	String world2 = p.getWorld().getName();
    	World world3 = Bukkit.getServer().getWorld("eggwars");
    	Location loc1 = new Location(world3,100.00, 100.00, 100.00);
    	Location l = p.getLocation();
    	l.setX(100.000);
    	l.setY(100.000);
    	l.setZ(100.000);
    	Bukkit.getServer().getWorld(world2).dropItem(loc1, item);
    	spawnIron(world2, loc1, item);
    	
    	//new Functions(100, 100, 100, new ItemStack(Material.IRON_INGOT), 1.25, world, world2);
    	}
	  } else if(commandLabel.equalsIgnoreCase("stopingots")) {
		  Bukkit.getScheduler().cancelTasks(plugin2);
		  p.sendMessage("worked?");
	  }
  
return true;
 }
}
