package me.DragonSlayer.BMCShops;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class BMCShopCommand implements CommandExecutor {
	
	Main plugin;
	
	public BMCShopCommand(Main pl) {
		this.plugin = pl;
	}

	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
			if(l.equalsIgnoreCase("bmcshops")) {
				Player p = (Player) s;
				p.sendMessage((ChatColor.GREEN + "--------" + plugin.prefix + ChatColor.GREEN + "--------").replaceAll(" ", ""));			
				p.sendMessage(ChatColor.GOLD + "/setps - sets your shop!");
				p.sendMessage(ChatColor.GOLD + "/ps <player> - Teleports you to players shop if player has a shop!");
				p.sendMessage(ChatColor.GOLD + "/pshops - opens shop advertisements.  Click to teleport to that person's shop!");
				p.sendMessage(ChatColor.GOLD + "/ps advertise - allows you to buy an advertisement, costs money, no warning message!");
				p.sendMessage(ChatColor.GOLD + "/ps advertise lore <lore> - adds a line <lore> to your shop!  Cannot include color codes!");
				p.sendMessage(ChatColor.GOLD + "/ps advertise lore delete - deletes all lines of lore!");
				p.sendMessage(ChatColor.GOLD + "[ADMIN] /psreset - Deletes all advertisements!");
				p.sendMessage((ChatColor.GREEN + "--------" + plugin.prefix + ChatColor.GREEN + "--------").replaceAll(" ", ""));	
				
			}

		return true;
	}

}
