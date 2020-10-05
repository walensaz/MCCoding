package VoidClass.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class SetHealth implements CommandExecutor {

    private final Main plugin;

    private String replaceColors(String message) {
        return message.replaceAll("(?i)&([a-f0-9])", "\u00A7$1");
    }

    public SetHealth(Main instance) {
        plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;
        if (commandLabel.equalsIgnoreCase("setHealth")) {
            if (p.hasPermission("class.sethealth")) {
                if (args.length == 2) {
                    Player pl = Bukkit.getPlayer(args[0]);
                    Integer health = Integer.getInteger(args[1]);
                    pl.setMaxHealth(health);


                } else {
                    p.sendMessage(ChatColor.RED + "/sethealth <player> <int>");
                }

            } else {
                p.sendMessage(ChatColor.RED + "No Perms");
            }

        }
        return true;

    }
}
