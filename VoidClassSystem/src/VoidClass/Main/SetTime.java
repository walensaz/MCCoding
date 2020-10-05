package VoidClass.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class SetTime implements CommandExecutor {

    private final Main plugin;

    private String replaceColors(String message) {
        return message.replaceAll("(?i)&([a-f0-9])", "\u00A7$1");
    }

    public SetTime(Main instance) {
        plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;
        if (commandLabel.equalsIgnoreCase("settime")) {
            if (p.hasPermission("class.settime")) {
                if (args.length == 4) {
                    Player pl = Bukkit.getPlayer(args[0]);

                    int num = Integer.valueOf(args[1]);
                    plugin.getConfig().set("players." + pl.getUniqueId() + ".time", num);
                    plugin.saveConfig();
                    int thenum = num / 43200;
                    int dnum = thenum * 43200;
                    int wnum = num - dnum;
                    plugin.getConfig().set("players." + pl.getUniqueId() + ".wtime", wnum);
                    plugin.saveConfig();
                    if (args[2].equalsIgnoreCase("C")) {
                        plugin.getConfig().set("players." + pl.getUniqueId() + ".hearts", Integer.valueOf(args[3]));
                        plugin.saveConfig();
                        pl.setMaxHealth(20 + Integer.valueOf(args[3]));


                    } else if (args[2].equalsIgnoreCase("Y")) {
                        plugin.getConfig().set("players." + pl.getUniqueId() + ".damage", Double.valueOf(args[3]));
                        plugin.saveConfig();


                    }


                } else {
                    p.sendMessage(ChatColor.RED + "Let DragonSlayer set time of players.");
                    p.sendMessage(ChatColor.RED + "This is not a common occurance i will only do this in special cases.");
                    p.sendMessage(ChatColor.RED + "/settime <player> <time in seconds> <class> <ratio>");
                    p.sendMessage(ChatColor.RED + "Class must be either    C    or    Y");
                    p.sendMessage(ChatColor.RED + "ratio must be the number that they should be set to based on time (Damage, etc)");
                    p.sendMessage(ChatColor.RED + "Y Ratio must be 1.x and not over 1.35");
                    p.sendMessage(ChatColor.RED + "C Ratio must be 4 - 10");
                }

            } else {
                p.sendMessage(ChatColor.RED + "No Perms");
            }

        }
        return true;

    }
}
