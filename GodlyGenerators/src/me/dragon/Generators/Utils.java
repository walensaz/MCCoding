package me.dragon.Generators;

import me.dragon.Generators.Main.Main;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Utils {


    public static String GenMessage(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> getList(Main plugin, String path) {
        ArrayList<String> list = new ArrayList<>();
        for(String string : plugin.getConfig().getStringList(path)) {
            list.add(Utils.GenMessage(string));
        }
        return list;
    }

}
