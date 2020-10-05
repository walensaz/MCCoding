package com.dragon;

import com.dragon.events.PistonPushEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    Main plugin;

    public void onEnable() {
        this.plugin = this;
        Bukkit.getPluginManager().registerEvents(new PistonPushEvent(this), this);
    }


    public void onDisable() {}


}
