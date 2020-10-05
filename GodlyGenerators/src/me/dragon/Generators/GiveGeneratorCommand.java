package me.dragon.Generators;

import me.dragon.Generators.Main.Generator;
import me.dragon.Generators.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveGeneratorCommand implements CommandExecutor {

    Main plugin;

    public GiveGeneratorCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("godlygens.admin")) {
            if(args.length == 1) {
                Player player;
                if((player = Bukkit.getPlayer(args[0])) != null) {
                    Generator.giveGenerator(plugin, player);
                    player.sendMessage(Utils.GenMessage(Main.prefix + " &aYou received 1 generator!"));
                    sender.sendMessage(Utils.GenMessage(Main.prefix + " &aYou gave " + args[0] + " 1 Generators!"));
                } else {
                    sender.sendMessage(Utils.GenMessage(Main.prefix + " &cPlayer is not online"));
                }
            } else if(args.length == 2) {
                Player player;
                if((player = Bukkit.getPlayer(args[0])) != null) {
                    for(int i = 0; i < Integer.valueOf(args[1]); i++) {
                        Generator.giveGenerator(plugin, player);
                    }
                    player.sendMessage(Utils.GenMessage(Main.prefix + " &aYou received " + args[1] + " generators!"));
                    sender.sendMessage(Utils.GenMessage(Main.prefix + " &aYou gave " + args[0] + " " + args[1] + " Generators!"));
                } else {
                    sender.sendMessage(Utils.GenMessage(Main.prefix + " &cPlayer is not online"));
                }
            } else {
                sender.sendMessage(Utils.GenMessage(Main.prefix + " &cUse: /Generator <player> Optional: <amount>"));
            }
        }
        return true;
    }
}
