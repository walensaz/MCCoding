package me.dragonslayer.core;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static String prefix;

    public Main plugin;

    public void onEnable() {
        prefix = plugin.getConfig().getString("prefix");
        Bukkit.getLogger().info("|---------------------|");
        Bukkit.getLogger().info("|[DragonClans] Enabled|");
        Bukkit.getLogger().info("|---------------------|");




    }

    public void onDisable() {
        Bukkit.getLogger().info("|---------------------|");
        Bukkit.getLogger().info("|[DragonClans] Disabled|");
        Bukkit.getLogger().info("|---------------------|");




    }


}
