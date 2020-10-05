/*package VoidClass.Main;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack ;

public class InventoryClick implements Listener {
	Main plugin;
	
	public InventoryClick(Main pl) {
		this.plugin = pl;
		}
	
@EventHandler(priority=EventPriority.MONITOR)
public void InventoryClick(InventoryClickEvent e) {
    if (e.getInventory().getTitle().equals("Choose Your Side")) {
    	
    	
    	Player p = (Player)e.getWhoClicked();
    	ItemStack[] pinv = p.getInventory().getContents();
    	ItemStack cl = e.getCurrentItem();
    	
    	ClickType c = e.getClick();
		  String Conq = ChatColor.GOLD + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Conqueror" + ChatColor.YELLOW + " Side";
			 String yield = ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Yielder" + ChatColor.YELLOW + " Side";
			 String hab = ChatColor.WHITE + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Habitant" + ChatColor.YELLOW + " Side";
    	
    	if(cl.getItemMeta().getDisplayName().equalsIgnoreCase(Conq)) {
    		
    		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
    		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
    		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
    		plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
    		plugin.saveConfig();
    		p.setMaxHealth(24);
    		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN + " to fight on!");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set Explorer");
    		e.setCancelled(true);
    		p.closeInventory();
    		p.getInventory().setContents(pinv);
    		
if(p.hasPermission("zeus.class")) {
        		
	plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
	plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
	plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
	plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
	plugin.saveConfig();
	p.setMaxHealth(24);
	p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN + " to fight on!");
	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set explorer6");
	e.setCancelled(true);
	p.closeInventory();
	p.getInventory().setContents(pinv);
        		
        		} else if(p.hasPermission("poseideon.class")) {
        			plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
        			plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
        			plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
        			plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
        			plugin.saveConfig();
        			p.setMaxHealth(24);
        			p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN + " to fight on!");
        			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set explorer5");
        			e.setCancelled(true);
        			p.closeInventory();
        			p.getInventory().setContents(pinv);
        		
        			
        			
        			
        		} else if(p.hasPermission("hades.class")) {
        			plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
        			plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
        			plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
        			plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
        			plugin.saveConfig();
        			p.setMaxHealth(24);
        			p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN + " to fight on!");
        			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set explorer4");
        			e.setCancelled(true);
        			p.closeInventory();
        			p.getInventory().setContents(pinv);
        			
        		} else if(p.hasPermission("ares.class")) {
        			plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
        			plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
        			plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
        			plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
        			plugin.saveConfig();
        			p.setMaxHealth(24);
        			p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN + " to fight on!");
        			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set explorer3");
        			e.setCancelled(true);
        			p.closeInventory();
        			p.getInventory().setContents(pinv);
        			
        	} else if(p.hasPermission("hermes.class")) {
        		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
        		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
        		plugin.saveConfig();
        		p.setMaxHealth(24);
        		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN + " to fight on!");
        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set explorer2");
        		e.setCancelled(true);
        		p.closeInventory();
        		p.getInventory().setContents(pinv);
        		
        		
        	} else if(p.hasPermission("helper.class")) {
        		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
        		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
        		plugin.saveConfig();
        		p.setMaxHealth(24);
        		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN + " to fight on!");
        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set explorer7");
        		e.setCancelled(true);
        		p.closeInventory();
        		p.getInventory().setContents(pinv);
        		
        		
        	} else if(p.hasPermission("mod.class")) {
        		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
        		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
        		plugin.saveConfig();
        		p.setMaxHealth(24);
        		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN + " to fight on!");
        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set explorer8");
        		e.setCancelled(true);
        		p.closeInventory();
        		p.getInventory().setContents(pinv);
        		
        	} else if(p.hasPermission("admin.class")) {
        		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
        		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
        		plugin.saveConfig();
        		p.setMaxHealth(24);
        		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN + " to fight on!");
        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set explorer9");
        		e.setCancelled(true);
        		p.closeInventory();
        		p.getInventory().setContents(pinv);
        		
        		
        	} else if(p.hasPermission("owner.class")) {
        		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
        		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
        		plugin.saveConfig();
        		p.setMaxHealth(24);
        		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN + " to fight on!");
        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set explorer10");
        		e.setCancelled(true);
        		p.closeInventory();
        		p.getInventory().setContents(pinv);
        		
        	} else if(p.hasPermission("developer.class")) {
        		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
        		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
        		plugin.saveConfig();
        		p.setMaxHealth(24);
        		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN + " to fight on!");
        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set explorer11");
        		e.setCancelled(true);
        		p.closeInventory();
        		p.getInventory().setContents(pinv);
        		
        		
        	} else if(p.hasPermission("builder.class")) {
        		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
        		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
        		plugin.saveConfig();
        		p.setMaxHealth(24);
        		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN + " to fight on!");
        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set explorer12");
        		e.setCancelled(true);
        		p.closeInventory();
        		p.getInventory().setContents(pinv);
        		
        	} else {
        		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
        		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
        		plugin.saveConfig();
        		p.setMaxHealth(24);
        		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN + " to fight on!");
        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set explorer");
        		e.setCancelled(true);
        		p.closeInventory();
        		p.getInventory().setContents(pinv);
        		
        	}
    		
    		
    	} else if(cl.getItemMeta().getDisplayName().equalsIgnoreCase(yield)) {
    		
    		
    		if(p.hasPermission("zeus.class")) {
        		
        		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
        		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
        		plugin.saveConfig();
        		
        		p.setMaxHealth(18);
        		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN + " to fight on!");
        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set voidler6");
        		e.setCancelled(true);
        		p.closeInventory();
        		p.getInventory().setContents(pinv);
        		
        		} else if(p.hasPermission("poseideon.class")) {
            		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
            		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
            		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
            		plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
            		plugin.saveConfig();
            		
            		p.setMaxHealth(18);
            		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN + " to fight on!");
            		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set voidler5");
            		e.setCancelled(true);
            		p.closeInventory();
            		p.getInventory().setContents(pinv);
        		
        			
        			
        			
        		} else if(p.hasPermission("hades.class")) {
            		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
            		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
            		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
            		plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
            		plugin.saveConfig();
            		
            		p.setMaxHealth(18);
            		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN + " to fight on!");
            		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set voidler4");
            		e.setCancelled(true);
            		p.closeInventory();
            		p.getInventory().setContents(pinv);
        			
        		} else if(p.hasPermission("ares.class")) {
            		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
            		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
            		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
            		plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
            		plugin.saveConfig();
            		
            		p.setMaxHealth(18);
            		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN + " to fight on!");
            		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set voidler3");
            		e.setCancelled(true);
            		p.closeInventory();
            		p.getInventory().setContents(pinv);
        			
        	} else if(p.hasPermission("hermes.class")) {
        		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
        		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
        		plugin.saveConfig();
        		
        		p.setMaxHealth(18);
        		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN + " to fight on!");
        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set voidler2");
        		e.setCancelled(true);
        		p.closeInventory();
        		p.getInventory().setContents(pinv);
        		
        	} else if(p.hasPermission("helper.class")) {
        		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
        		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
        		plugin.saveConfig();
        		
        		p.setMaxHealth(18);
        		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN + " to fight on!");
        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set voidler7");
        		e.setCancelled(true);
        		p.closeInventory();
        		p.getInventory().setContents(pinv);
        		
        	} else if(p.hasPermission("mod.class")) {
        		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
        		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
        		plugin.saveConfig();
        		
        		p.setMaxHealth(18);
        		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN + " to fight on!");
        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set voidler8");
        		e.setCancelled(true);
        		p.closeInventory();
        		p.getInventory().setContents(pinv);
        		
        	} else if(p.hasPermission("admin.class")) {
        		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
        		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
        		plugin.saveConfig();
        		
        		p.setMaxHealth(18);
        		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN + " to fight on!");
        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set voidler9");
        		e.setCancelled(true);
        		p.closeInventory();
        		p.getInventory().setContents(pinv);
        		
        	} else if(p.hasPermission("owner.class")) {
        		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
        		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
        		plugin.saveConfig();
        		
        		p.setMaxHealth(18);
        		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN + " to fight on!");
        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set voidler10");
        		e.setCancelled(true);
        		p.closeInventory();
        		p.getInventory().setContents(pinv);
        		
        	} else if(p.hasPermission("developer.class")) {
        		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
        		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
        		plugin.saveConfig();
        		
        		p.setMaxHealth(18);
        		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN + " to fight on!");
        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set voidler11");
        		e.setCancelled(true);
        		p.closeInventory();
        		p.getInventory().setContents(pinv);
        		
        	} else if(p.hasPermission("builder.class")) {
        		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
        		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
        		plugin.saveConfig();
        		
        		p.setMaxHealth(18);
        		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN + " to fight on!");
        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set voidler12");
        		e.setCancelled(true);
        		p.closeInventory();
        		p.getInventory().setContents(pinv);
        		
        	} else {
        		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
        		plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
        		plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
        		plugin.saveConfig();
        		
        		p.setMaxHealth(18);
        		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN + " to fight on!");
        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set voidler");
        		e.setCancelled(true);
        		p.closeInventory();
        		p.getInventory().setContents(pinv);
        		
        	}
    		
    	} else if(cl.getItemMeta().getDisplayName().equalsIgnoreCase(hab)) {
    		if(p.hasPermission("zeus.class")) {
    		
    		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
    		plugin.saveConfig();
    		
    		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE + "Habitant " + ChatColor.YELLOW + "Side!");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set habitant6");
    		e.setCancelled(true);
    		p.closeInventory();
    		p.getInventory().setContents(pinv);
    		} else if(p.hasPermission("poseideon.class")) {
        		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
        		plugin.saveConfig();
        		
        		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE + "Habitant " + ChatColor.YELLOW + "Side!");
        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set habitant5");
        		e.setCancelled(true);
        		p.closeInventory();
        		p.getInventory().setContents(pinv);
    		
    			
    			
    			
    		} else if(p.hasPermission("hades.class")) {
        		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
        		plugin.saveConfig();
        		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE + "Habitant " + ChatColor.YELLOW + "Side!");        		
        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set habitant4");
        		e.setCancelled(true);
        		p.closeInventory();
        		p.getInventory().setContents(pinv);
    			
    		} else if(p.hasPermission("ares.class")) {
        		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
        		plugin.saveConfig();
        		
        		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE + "Habitant " + ChatColor.YELLOW + "Side!");
        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set habitant3");
        		e.setCancelled(true);
        		p.closeInventory();
        		p.getInventory().setContents(pinv);
    			
    	} else if(p.hasPermission("hermes.class")) {
    		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
    		plugin.saveConfig();
    		
    		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE + "Habitant " + ChatColor.YELLOW + "Side!");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set habitant2");
    		e.setCancelled(true);
    		p.closeInventory();
    		p.getInventory().setContents(pinv);
    		
    		
    		
    	} else if(p.hasPermission("helper.class")) {
    		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
    		plugin.saveConfig();
    		
    		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE + "Habitant " + ChatColor.YELLOW + "Side!");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set habitant7");
    		e.setCancelled(true);
    		p.closeInventory();
    		p.getInventory().setContents(pinv);
    		
    		
    		
    	} else if(p.hasPermission("mod.class")) {
    		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
    		plugin.saveConfig();
    		
    		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE + "Habitant " + ChatColor.YELLOW + "Side!");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set habitant8");
    		e.setCancelled(true);
    		p.closeInventory();
    		p.getInventory().setContents(pinv);
    		
    		
    	} else if(p.hasPermission("admin.class")) {
    		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
    		plugin.saveConfig();
    		
    		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE + "Habitant " + ChatColor.YELLOW + "Side!");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set habitant9");
    		e.setCancelled(true);
    		p.closeInventory();
    		p.getInventory().setContents(pinv);
    		
    		
    	} else if(p.hasPermission("owner.class")) {
    		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
    		plugin.saveConfig();
    		
    		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE + "Habitant " + ChatColor.YELLOW + "Side!");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set habitant10");
    		e.setCancelled(true);
    		p.closeInventory();
    		p.getInventory().setContents(pinv);
    		
    	} else if(p.hasPermission("developer.class")) {
    		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
    		plugin.saveConfig();
    		
    		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE + "Habitant " + ChatColor.YELLOW + "Side!");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set habitant11");
    		e.setCancelled(true);
    		p.closeInventory();
    		p.getInventory().setContents(pinv);
    		
    		
    	} else if(p.hasPermission("builder.class")) {
    		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
    		plugin.saveConfig();
    		
    		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE + "Habitant " + ChatColor.YELLOW + "Side!");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set habitant12");
    		e.setCancelled(true);
    		p.closeInventory();
    		p.getInventory().setContents(pinv);
    		
    	} else {
    		plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
    		plugin.saveConfig();
    		
    		p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE + "Habitant " + ChatColor.YELLOW + "Side!");
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Pex user " + p.getName() + " group set habitant");
    		e.setCancelled(true);
    		p.closeInventory();
    		p.getInventory().setContents(pinv);
    		
    	}
    		
    	}
    	
    }
}
}
    	*/
    	
    	