package me.dragon.outposts;

import com.wasteofplastic.askyblock.ASkyBlockAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyblockOutposts extends JavaPlugin {


    SkyblockOutposts plugin;
    ASkyBlockAPI aSkyBlockAPI;



    public void onEnable() {
        aSkyBlockAPI = (ASkyBlockAPI) Bukkit.getPluginManager().getPlugin("ASkyBlock");
        this.plugin = this;



    }


    public ASkyBlockAPI getaSkyBlockAPI() {
        return aSkyBlockAPI;
    }
}
