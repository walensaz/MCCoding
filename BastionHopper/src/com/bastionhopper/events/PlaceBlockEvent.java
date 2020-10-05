package com.bastionhopper.events;

import com.bastionhopper.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.Arrays;

public class PlaceBlockEvent implements Listener {

    Main plugin;

    public PlaceBlockEvent(Main plugin) {
        this.plugin = plugin;
    }

    public static String CC(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (e.getBlockPlaced().getType() == Material.HOPPER || e.getBlockPlaced().getType() == Material.HOPPER_MINECART) {
            int maxhoppers = plugin.getConfig().getInt("max-hoppers-per-chunk");
            if (Arrays.stream(e.getBlockPlaced().getChunk().getTileEntities()).filter(block -> (block.getType() == Material.HOPPER)).count() >= maxhoppers) {
                e.getPlayer().sendMessage(CC(plugin.getConfig().getString("max-hopper-message")).replace("{AMOUNT}", String.valueOf(maxhoppers)));
                e.setCancelled(true);
            }
        }
    }


}
