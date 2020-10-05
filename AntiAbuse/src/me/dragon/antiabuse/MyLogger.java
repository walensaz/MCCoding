package me.dragon.antiabuse;

import com.sk89q.worldedit.bukkit.selections.Selection;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyLogger {




    public static void logCommand(String username, String command) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String date = dateFormat.format(cal.getTime());
        Main.getStaff().get(username).println("*COMMAND* [" + date + "] " + username + " issued command " + command);
        Main.getStaff().get(username).flush();
    }

    public static void logWorldEditCommand(Player p, String command) {
        String username = p.getName();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String date = dateFormat.format(cal.getTime());
        Main.getStaff().get(username).println("*WORLDEDIT* " + "[" + date + "] " + username + " issued command " + command + " at coords X:"
                + p.getLocation().getBlockX() + ", Y:" + p.getLocation().getBlockY() + ", Z:" + p.getLocation().getBlockZ());
        Main.getStaff().get(username).flush();
    }

    public static void logWorldEdit(Player p, String command, Selection s) {
        String username = p.getName();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String date = dateFormat.format(cal.getTime());
        Main.getStaff().get(username).println("*WORLDEDIT* " + "[" + date + "] " + username + " issued command " + command + " at coords X:"
                + p.getLocation().getBlockX() + ", Y:" + p.getLocation().getBlockY() + ", Z:" + p.getLocation().getBlockZ() + "" +
                "    EXTRA: EDITTING CUBOID MAX:" + s.getMaximumPoint() + ", MIN:" + s.getMinimumPoint());
        Main.getStaff().get(username).flush();
    }

    public static void logBlockEvent(Player p, boolean place, Material material) {
        String username = p.getName();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String date = dateFormat.format(cal.getTime());
        if(place) {
            Main.getStaff().get(username).println("*BlockEvent* " + "[" + date + "] " + username + " placed " + material.name() + " at coords X:"
                    + p.getLocation().getBlockX() + ", Y:" + p.getLocation().getBlockY() + ", Z:" + p.getLocation().getBlockZ());
        } else {
            Main.getStaff().get(username).println("*BlockEvent* " + "[" + date + "] " + username + " broke " + material.name() + " at coords X:"
                    + p.getLocation().getBlockX() + ", Y:" + p.getLocation().getBlockY() + ", Z:" + p.getLocation().getBlockZ());
        }
        Main.getStaff().get(username).flush();
    }

    public static void logDropEvent(Player p, Material item) {
        String username = p.getName();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String date = dateFormat.format(cal.getTime());
        Main.getStaff().get(username).println("*DropEvent* " + "[" + date + "] " + username + " dropped item " + item.name() + " at coords X:"
                + p.getLocation().getBlockX() + ", Y:" + p.getLocation().getBlockY() + ", Z:" + p.getLocation().getBlockZ() +
                "    Players around: " + playersAround(p));
        Main.getStaff().get(username).flush();
    }

    private static String playersAround(Player p) {
        String str = "";
        for(Player pl : Bukkit.getOnlinePlayers()) {
            if(pl.getLocation().distance(p.getLocation()) <= 10) {
                str += pl.getName();
            }
        }
        return str;
    }

    public static void logInventoryMove(Player p, Material item, Player otherplayer) {
        String username = p.getName();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String date = dateFormat.format(cal.getTime());
        if(item != Material.AIR) {
            Main.getStaff().get(username).println("*Inventory Move* " + "[" + date + "] " + username + " moved inventory item " + item.name() + " of player " + otherplayer.getName());
            Main.getStaff().get(username).flush();
        }
    }
}
