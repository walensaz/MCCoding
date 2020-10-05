package me.DragonSlayer.BMCShops;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class BMCResetAdvertCommand implements CommandExecutor {

	Main plugin;

	public BMCResetAdvertCommand(Main pl) {
		this.plugin = pl;
	}

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		if (l.equalsIgnoreCase("psreset")) {
			if (s.hasPermission("BMC.shop.admin")) {
				List<String> list2 = plugin.getConfig().getStringList("advertisement-players");
				if (list2 != null) {

					list2.clear();
					plugin.getConfig().set("advertisement-players", list2);
					plugin.saveConfig();
					s.sendMessage(ChatColor.RED + "RESET!");
				} else {
					s.sendMessage(ChatColor.RED + "ERROR: NO LIST TO BE CLEARED! CONTACT DEVELOPER");
				}

			}
		}

		return true;
	}

}
