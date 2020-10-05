package com.bastionhopper;

import com.bastionhopper.events.PistonPushEvent;
import com.bastionhopper.events.PlaceBlockEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        this.saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new PlaceBlockEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new PistonPushEvent(this), this);
    }

    public void onDisable() {
        Bukkit.getLogger().info("DISABLED BASTION HOPPERS");
    }


}
