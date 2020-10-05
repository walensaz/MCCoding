package VoidClass.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Time implements CommandExecutor {

    private final Main plugin;

    public Time(Main instance) {
        plugin = instance;
    }

    private static String onTime(long time) {
        int days;
        int hours;
        int minutes;
        String alltime = ChatColor.GREEN + "";
        if (time >= 86400) {
            days = (int) (time / 86400);
            time = time - 86400 * days;
            alltime += ChatColor.GREEN + String.valueOf(days) + " Days, ";


        }
        if (time >= 3600) {
            hours = (int) (time / 3600);
            time = time - 3600 * hours;
            alltime += ChatColor.GREEN + String.valueOf(hours) + " Hours, ";

        }
        if (time >= 60) {
            minutes = (int) (time / 60);
            time = time - 60 * minutes;
            alltime += ChatColor.GREEN + String.valueOf(minutes) + " Minutes, ";

        }
        alltime += ChatColor.GREEN + String.valueOf(time + " Seconds");
        return alltime;


    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;
        if (commandLabel.equalsIgnoreCase("time")) {
            if (args.length == 0) {
                if (plugin.getConfig().get("players." + p.getUniqueId() + ".time") != null) {
                    long time = plugin.getConfig().getLong("players." + p.getUniqueId() + ".time");
                    String alltime = ChatColor.DARK_GREEN + "You have been playing for: ";

                    int remainder;
                    int days;
                    int hours;
                    int minutes;
                    if (time >= 86400) {
                        days = (int) (time / 86400);
                        time = time - 86400 * days;
                        alltime += ChatColor.GREEN + String.valueOf(days) + " Days, ";


                    }
                    if (time >= 3600) {
                        hours = (int) (time / 3600);
                        time = time - 3600 * hours;
                        alltime += ChatColor.GREEN + String.valueOf(hours) + " Hours, ";

                    }
                    if (time >= 60) {
                        minutes = (int) (time / 60);
                        time = time - 60 * minutes;
                        alltime += ChatColor.GREEN + String.valueOf(minutes) + " Minutes, ";

                    }
                    alltime += ChatColor.GREEN + String.valueOf(time + " Seconds");
                    p.sendMessage(alltime);
                    p.sendMessage(ChatColor.GREEN + "You gain damage/health every 12 hours that you play.");
                }
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("top")) {
                    p.sendMessage(ChatColor.GOLD + "#1: " + plugin.getConfig().getString("time.top.1.player") + " has " + onTime(plugin.getConfig().getLong("time.top.1.time")));
                    p.sendMessage(ChatColor.GOLD + "#2: " + plugin.getConfig().getString("time.top.2.player") + " has " + onTime(plugin.getConfig().getLong("time.top.2.time")));
                    p.sendMessage(ChatColor.GOLD + "#3: " + plugin.getConfig().getString("time.top.3.player") + " has " + onTime(plugin.getConfig().getLong("time.top.3.time")));
                    p.sendMessage(ChatColor.GOLD + "#4: " + plugin.getConfig().getString("time.top.4.player") + " has " + onTime(plugin.getConfig().getLong("time.top.4.time")));
                    p.sendMessage(ChatColor.GOLD + "#5: " + plugin.getConfig().getString("time.top.5.player") + " has " + onTime(plugin.getConfig().getLong("time.top.5.time")));
                    p.sendMessage(ChatColor.GOLD + "#6: " + plugin.getConfig().getString("time.top.6.player") + " has " + onTime(plugin.getConfig().getLong("time.top.6.time")));
                    p.sendMessage(ChatColor.GOLD + "#7: " + plugin.getConfig().getString("time.top.7.player") + " has " + onTime(plugin.getConfig().getLong("time.top.7.time")));
                    p.sendMessage(ChatColor.GOLD + "#8: " + plugin.getConfig().getString("time.top.8.player") + " has " + onTime(plugin.getConfig().getLong("time.top.8.time")));
                    p.sendMessage(ChatColor.GOLD + "#9: " + plugin.getConfig().getString("time.top.9.player") + " has " + onTime(plugin.getConfig().getLong("time.top.9.time")));
                    p.sendMessage(ChatColor.GOLD + "#10: " + plugin.getConfig().getString("time.top.10.player") + " has " + onTime(plugin.getConfig().getLong("time.top.10.time")));


                }

            }
        }
        return true;
    }


}
