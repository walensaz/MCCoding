package com.bastionhopper.events;


import com.bastionhopper.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PistonPushEvent implements Listener {

    Main plugin;

    public PistonPushEvent(Main plugin) {
        this.plugin = plugin;
    }

    private final List<Material> materials = Arrays.asList(Material.BAMBOO, Material.SUGAR_CANE, Material.CACTUS);

    private ArrayList<Material> getTypes(List<Block> blocks) {
        ArrayList<Material> bs = new ArrayList<>();
        for(Block b: blocks) {
            bs.add(b.getType());
        }
        return bs;
    }

    private Location createLocation(String world, int x, int y, int z) {
        return new Location(Bukkit.getWorld(world), x, y, z);
    }

    private boolean checkForFarms(List<Block> blocks) {
        for(Block b: blocks) {
            if(b.getType() == Material.SAND || b.getType() == Material.RED_SAND || b.getType() == Material.DIRT || b.getType() == Material.GRASS_BLOCK) {
                Location loc = b.getLocation();
                loc.setY(loc.getBlockY() + 1);
                if(materials.contains(loc.getBlock().getType())) {
                    b.breakNaturally();
                    return true;
                }
            }
        }
        return false;
    }

    @EventHandler
    public void onPistonPush(BlockPistonExtendEvent e) {
        ArrayList<Material> mats;
        if((mats = getTypes(e.getBlocks())).contains(Material.SAND) || mats.contains(Material.DIRT) || mats.contains(Material.GRASS) && e.getBlocks().size() >= 2) {
            if(checkForFarms(e.getBlocks())) {
                e.setCancelled(true);
                Location loc = e.getBlock().getLocation();
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (p.hasPermission("farming.notify") || p.isOp()) {
                        p.sendMessage(ChatColor.RED + "NOTICE -- Farm at " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ());
                    }
                }
            }
        }
    }

}
