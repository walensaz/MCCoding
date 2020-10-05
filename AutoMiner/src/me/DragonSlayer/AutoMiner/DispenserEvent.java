/**
 * Plugin made for CryptoMC by DragonSlayer
 * All Rights reserved
 * Inquired contact Zach#2129 on discord
 **/
package me.DragonSlayer.AutoMiner;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.block.Hopper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.DirectionalContainer;
import org.bukkit.material.Dispenser;
import org.bukkit.material.Lever;
import org.bukkit.util.Vector;

import java.util.Collection;

public class DispenserEvent implements Listener {

    Main plugin;

    public DispenserEvent(Main plugin) {
        this.plugin = plugin;
    }

    public void messageAll(String message) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(ChatColor.RED + message);
        }
    }

    @EventHandler
    public void DispenseEvent(BlockDispenseEvent e) {
        final Block disp = e.getBlock();
        if (!disp.getType().equals(Material.DISPENSER)) {
            return;
        }
        LocationData l = new LocationData(disp.getLocation());
        if (plugin.getDispensers().contains(l.convertToString())) {
            e.setCancelled(true);
            DirectionalContainer d = (Dispenser) disp.getState().getData();
            Block b = disp.getRelative(d.getFacing());
            Block chest = disp.getRelative(d.getFacing().getOppositeFace());
            Collection<ItemStack> drops = b.getDrops();
            if ((chest.getType().equals(Material.CHEST)) || (chest.getType().equals(Material.TRAPPED_CHEST))) {
                b.setType(Material.AIR);
                Chest chest1 = (Chest) chest.getState();
                if (drops.size() > 0) {
                    for (ItemStack item : drops) {
                        chest1.getInventory().addItem(item);
                    }
                }
            } else if ((chest.getType().equals(Material.HOPPER))) {
                b.setType(Material.AIR);
                Hopper hopper = (Hopper) chest.getState();
                if (drops.size() > 0) {
                    for (ItemStack item : drops) {
                        hopper.getInventory().addItem(item);
                    }
                }

            } else {
                b.breakNaturally();
            }
        }
    }

}
