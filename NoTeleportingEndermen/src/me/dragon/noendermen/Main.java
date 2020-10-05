package me.dragon.noendermen;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new Teleportevent(), this);

    }


}
