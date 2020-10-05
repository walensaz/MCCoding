package me.dragonslayer.core.commands;

import me.dragonslayer.core.Main;
import me.dragonslayer.core.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandClan implements CommandExecutor {

    private Main plugin;

    public CommandClan(Main plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof ConsoleCommandSender)) {
            Player player = (Player) sender;
            player.sendMessage(Utils.color("&b-------&lClans&b-------\n" +
                    "&b/clan create <name> - Creates a command with the specified name.\n" +
                    "&b/clan invite <username> - Invites a player with the username.\n" +
                    "&b/clan promote <username> - Promotes user in your clan.\n" +
                    "&b/clan stats [clan] - Shows you the stats of your clan.\n" +
                    "&b/clan info [clan] - Shows you info about specified clan\n"));
            if(args.length > 0) {




            }
        }
        return true;
    }


}
