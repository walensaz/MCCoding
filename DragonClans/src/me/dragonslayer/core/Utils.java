package me.dragonslayer.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Utils {

    /*public static void msgOps(String message) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.hasPermission(Permission.mod_perm)) {
                p.sendMessage(message);
            }
        }
    }*/

    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message).replace("{PREFIX}", Main.prefix);
    }


}
