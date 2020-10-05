package com.DragonVaults.DragonSlayer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PlayerVaultCommand implements CommandExecutor {

    Main plugin;

    public PlayerVaultCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {

        }



        return true;
    }
}
