package me.dragon.antiabuse.commands;

import me.dragon.antiabuse.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class aSetRankCommand implements CommandExecutor {

    Main plugin;

    public aSetRankCommand(Main plugin) {
        this.plugin = plugin;
    }


    private String m(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    private void msgOps(boolean bool, Player player, String rank) {
        for(Player p : Bukkit.getOnlinePlayers()) {
            if(p.hasPermission("antiabuse.see")) {
                if(bool) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&c&lStaff Duty -> &b" + player.getName() + " &4is now on duty with rank &c" + rank + "&4!"));
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&c&lStaff Duty -> &b" + player.getName() + " &4is now off duty with rank &c" + rank + "&4!"));
                }
            }
        }
    }

    private String success(String username, String rank) {
        return ChatColor.translateAlternateColorCodes('&', "&c&lStaff Duty -> &bYou have set " + username + " to " + rank);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("antiabuse.setrank")) {
            Player p = (Player) sender;
            if(args.length == 2) {
                OfflinePlayer target;
                if(args[1] != null) {
                    if ((target = Bukkit.getPlayer(args[0])) != null) {
                        plugin.getConfig().set("players." + target.getUniqueId() + ".rank", args[1]);
                        plugin.saveConfig();
                        Main.getPermissions().playerAdd(null, target, "antiabuse.onduty");
                        Main.getPermissions().playerAdd(null, target, "staff.staffchat");
                        Main.getPermissions().playerAdd(null, target, "staff.report");
                        Main.getPermissions().playerAdd(null, target, "litebans.kick");
                        Main.getPermissions().playerAdd(null, target, "litebans.warn");
                        Main.getPermissions().playerAdd(null, target, "litebans.mute");
                        Main.getPermissions().playerAdd(null, target, "litebans.ban");
                        sender.sendMessage(success(target.getName(), args[1]));
                        ((Player) target).sendMessage(ChatColor.GREEN + "You have been promoted!");
                    } else {
                        target = Bukkit.getOfflinePlayer(args[0]);
                        plugin.getConfig().set("players." + target.getUniqueId() + ".rank", args[1]);
                        Main.getPermissions().playerAdd(null, target, "antiabuse.onduty");
                        Main.getPermissions().playerAdd(null, target, "staff.staffchat");
                        Main.getPermissions().playerAdd(null, target, "staff.report");
                        Main.getPermissions().playerAdd(null, target, "litebans.kick");
                        Main.getPermissions().playerAdd(null, target, "litebans.warn");
                        Main.getPermissions().playerAdd(null, target, "litebans.mute");
                        Main.getPermissions().playerAdd(null, target, "litebans.ban");
                        plugin.saveConfig();
                        Main.getPermissions().playerAdd(null, target, "antiabuse.onduty");
                        sender.sendMessage(success(target.getName(), args[1]));
                    }
                } else {
                    if ((target = Bukkit.getPlayer(args[0])) != null) {
                        Main.getPermissions().playerRemoveGroup(null, target, plugin.getConfig().getString("players." + target.getUniqueId() + ".rank"));
                        plugin.getConfig().set("players." + target.getUniqueId() + ".rank", null);
                        Main.getPermissions().playerRemove(null, target, "antiabuse.onduty");
                        Main.getPermissions().playerRemove(null, target, "staff.staffchat");
                        Main.getPermissions().playerRemove(null, target, "staff.report");
                        Main.getPermissions().playerRemove(null, target, "litebans.kick");
                        Main.getPermissions().playerRemove(null, target, "litebans.warn");
                        Main.getPermissions().playerRemove(null, target, "litebans.mute");
                        Main.getPermissions().playerRemove(null, target, "litebans.ban");
                        plugin.saveConfig();
                        Main.getPermissions().playerRemove(null,(Player)target, "antiabuse.onduty");
                        sender.sendMessage(success(target.getName(), "Member"));
                    } else {
                        target = Bukkit.getOfflinePlayer(args[0]);
                        Main.getPermissions().playerRemoveGroup(null, target, plugin.getConfig().getString("players." + target.getUniqueId() + ".rank"));
                        plugin.getConfig().set("players." + target.getUniqueId() + ".rank", null);
                        Main.getPermissions().playerRemove(null, target, "antiabuse.onduty");
                        Main.getPermissions().playerRemove(null, target, "staff.staffchat");
                        Main.getPermissions().playerRemove(null, target, "staff.report");
                        Main.getPermissions().playerRemove(null, target, "litebans.kick");
                        Main.getPermissions().playerRemove(null, target, "litebans.warn");
                        Main.getPermissions().playerRemove(null, target, "litebans.mute");
                        Main.getPermissions().playerRemove(null, target, "litebans.ban");
                        plugin.saveConfig();
                        Main.getPermissions().playerRemove(null, target, "antiabuse.onduty");
                        sender.sendMessage(success(target.getName(), "Member"));
                        ((Player) target).sendMessage(ChatColor.GREEN + "You have been demoted!");
                    }
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Use: /asetrank <player> <rank>");
            }
        }
        return true;
    }
}
