package Fables.chat;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import Fables.core.Main;


public class ChatChannel implements Listener {
Main plugin;

	public ChatChannel(Main pl) {
		this.plugin = pl;
	}
	

@EventHandler
public void onPlayerChat(AsyncPlayerChatEvent e) {
	Player pla = e.getPlayer();
	if(!(pla.hasMetadata("chat"))) {
		
	Location pl = e.getPlayer().getLocation();
	String bold = ChatColor.BOLD + "";
	double xmin = pl.getX() - 20;
	double zmin = pl.getZ() - 20;
	double xmax = pl.getX() + 20;
	double zmax = pl.getZ() + 20;
	String name1 = "";
	String name = "";
	String test = "";
	test += "'";
	ChatColor italize1 = ChatColor.ITALIC;
	String italize = ChatColor.GRAY + "" + ChatColor.ITALIC;
	String msg = e.getMessage();
	String msg1 = msg.replace("*", "");
	if(!(e.getMessage().startsWith("*"))) {
		italize = ChatColor.WHITE + "";
		msg1 = msg;

	}
	if(plugin.getConfig().getString("names." + pla.getName()) != null) {
		name1 = plugin.getConfig().getString("names." + pla.getName());
		name = name1.replaceAll("-", " ");
	} else {
		name = pla.getName();
		
	}
        for (Player p : Bukkit.getOnlinePlayers()) {
        	Location p1 = p.getPlayer().getLocation();

                   if(p1.getX() < xmax && p1.getX() > xmin && p1.getZ() < zmax && p1.getZ() > zmin) {
                	   e.setCancelled(true);
                	   if(pla.hasPermission("admin.prefix")) {
                		   p.getPlayer().sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Admin" + ChatColor.DARK_GRAY + "] " + name + ChatColor.WHITE + " : " + italize + msg1);
                        
                	   }
                	   else if(pla.hasPermission("tech.prefix")) {
                		   p.getPlayer().sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "Tech" + ChatColor.DARK_GRAY + "] " + name + ChatColor.WHITE + " : " + italize + msg1);
                   
                		   
                		   
                	   }else if(pla.hasPermission("lore.prefix"))	{
                		   p.getPlayer().sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_GREEN + "Lore" + ChatColor.DARK_GRAY + "] " + name + ChatColor.WHITE + " : " + italize + msg1);
                		   
                	   }else if(pla.hasPermission("construction.prefix"))	{
                		   p.getPlayer().sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW + "Construction" + ChatColor.DARK_GRAY + "] " + name + ChatColor.WHITE + " : " + italize + msg1);   
                	   
                   }else {
                	   p.getPlayer().sendMessage(ChatColor.GRAY + name + ChatColor.WHITE + " : " + italize + msg1);
                   }
                }else if(p.hasMetadata("spy")) {
                   p.sendMessage(ChatColor.WHITE + pla.getName() + ChatColor.RED + " : " + ChatColor.AQUA + e.getMessage());
                }
        }
                }else if(pla.hasMetadata("staff")) {
                	e.setCancelled(true);
                	for(Player p : Bukkit.getOnlinePlayers()) {
                		if(p.hasPermission("Fables.Mod")) {
                	p.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "StaffChat" + ChatColor.GRAY + "] " + pla.getName() + ChatColor.LIGHT_PURPLE + " " + e.getMessage());
                	}
                	}
                }
                	
                
        }
        }

