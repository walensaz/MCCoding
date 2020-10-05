package me.DragonSlayer.Anti;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class CommandAddWorld implements CommandExecutor {

	Main plugin;
	
	public CommandAddWorld(Main pl) {
		this.plugin = pl;
	}
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args) {
		if(cmdlabel.equalsIgnoreCase("bmcaddworld")) {
			if(args.length == 1) {
				if(sender.hasPermission("BMC.world.admin") || sender.isOp()) {
					List<String> list = (List<String>) plugin.getConfig().getList("worlds.disable");
					if(list == null) {
						List<String> newlist = new ArrayList<String>();
						newlist.add(args[0]);
						plugin.getConfig().set("worlds.disable", newlist);
						plugin.saveConfig();
						sender.sendMessage(ChatColor.RED + "World added!");
						
						
					} else {
						list.add(args[0]);
						plugin.getConfig().set("worlds.disable", list);
						plugin.saveConfig();
						sender.sendMessage(ChatColor.RED + "World added!");
						
						
					}
					
				} else {
					sender.sendMessage(ChatColor.RED + "No permission!");
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Usage: /bmcaddworld <worldname>");
			}
		} else if(cmdlabel.equalsIgnoreCase("bmcremoveworld")) {
			if(args.length == 1) {
				if(sender.hasPermission("BMC.world.admin") || sender.isOp()) {
					List<String> list = (List<String>) plugin.getConfig().getList("worlds.disable");
					if(list == null) {
						sender.sendMessage(ChatColor.RED + "No disabled worlds exist");
						
						
						
					} else {
						if(list.contains(args[0])) {
							list.remove(args[0]);
							plugin.getConfig().set("worlds.disable", list);
							plugin.saveConfig();
							sender.sendMessage("World removed");
						} else {
							sender.sendMessage(ChatColor.RED + "World has not been disabled");
						}
						
					}
						
					} else {
						sender.sendMessage(ChatColor.RED + "No permission!");
					}
					
				} else {
					sender.sendMessage(ChatColor.RED + "Usage: /bmcremoveworld <worldname>");
				}
			
		}
		return true;
	}
	
	
	

}
