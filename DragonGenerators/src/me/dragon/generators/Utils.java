package me.dragon.generators;

import me.dragon.generators.Main.Main;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Utils {


    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> getList(Main plugin, String path) {
        ArrayList<String> list = new ArrayList<>();
        for(String string : plugin.getConfig().getStringList(path)) {
            list.add(Utils.color(string));
        }
        return list;
    }

}
