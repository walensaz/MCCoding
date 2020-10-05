package me.DragonSlayer.Timed;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    private static Main plugin;

    private static final Logger log = Logger.getLogger("Minecraft");


    PluginManager pm = Bukkit.getPluginManager();

    public void onEnable() {
        plugin = this;
        getCommand("timedperm").setExecutor(new TimedPerm(this));

    }

    public void onDisable() {
        log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
        getLogger().info("|-----------------------------------------|");

    }




}
