/**
 * Plugin made for CryptoMC/words by DragonSlayer
 * All Rights reserved
 * Inquired contact Zach#2129 on discord
**/
package me.DragonSlayer.AutoMiner;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class PlaceEvent implements Listener {

    Main plugin;

    public PlaceEvent(Main plugin) {
        this.plugin = plugin;
    }

    public void messageAll(String message) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(ChatColor.RED + message);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (e.getPlayer().getItemInHand().getData().getItemType() == Material.DISPENSER) {
            if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',
                    plugin.getConfig().getString("autominername")))) {
                plugin.getDispensers().add(new LocationData(e.getBlockPlaced().getLocation()).convertToString());
                InventoryHolder dispenser = ((InventoryHolder) e.getBlockPlaced().getState());
                dispenser.getInventory().addItem(new ItemStack(Material.WOOD));
            }
        }
    }
}
