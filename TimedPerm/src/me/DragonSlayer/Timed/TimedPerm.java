package me.DragonSlayer.Timed;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TimedPerm implements CommandExecutor {

    Main plugin;

    public TimedPerm(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("timedperm")) {
            if (sender.hasPermission("timedperm.admin")) {
                if(args.length == 3) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eTimedPerms > &eAdded " + args[1] + " to " + args[0] + " for " + args[2] + " seconds!"));
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " timed add " + args[1] + " " + args[2]);
                } else {
                    sender.sendMessage(ChatColor.YELLOW + "TimedPerms > " + ChatColor.RED + "Use /timedperm <user> <perm> <time in seconds>");
                }
            } else {
                sender.sendMessage(ChatColor.YELLOW + "TimedPerms > " +ChatColor.RED + "NO PERMISSION");
            }
        }
        return true;
    }
}
