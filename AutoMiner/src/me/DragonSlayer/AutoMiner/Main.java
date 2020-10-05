/**
 * Plugin made for CryptoMC/WORDS by DragonSlayer
 * All Rights reserved
 * Inquired contact Zach#2129 on discord
 **/

package me.DragonSlayer.AutoMiner;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends JavaPlugin {

    Main plugin;

    FileConfiguration data;

    ArrayList<String> dispensers;

    Server server = Bukkit.getServer();
    PluginManager pm = server.getPluginManager();

    public void onEnable() {
        this.getLogger().info("AUTOMINE ENABLED!");
        this.data = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "data.yml"));
        dispensers = ((ArrayList<String>) this.data.get("miners") != null) ? (ArrayList<String>) this.data.get("miners") : new ArrayList<>();
        saveDefaultConfig();
        plugin = this;
        pm.registerEvents(new onClick(this), this);
        pm.registerEvents(new PlaceEvent(this), this);
        pm.registerEvents(new BreakEvent(this), this);
        pm.registerEvents(new DispenserEvent(this), this);
        getCommand("am").setExecutor(new AMCommand(this));
    }

    public void onDisable() {
        if (dispensers.size() > 0) {
            try {
                data.set("miners", dispensers);
                data.save(new File(getDataFolder(), "data.yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<String> getDispensers() {
        return dispensers;
    }

}
