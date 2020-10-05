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
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BreakEvent implements Listener {

    Main plugin;

    public BreakEvent(Main plugin) {
        this.plugin = plugin;
    }

    private void addItem(Player p) {
        ItemStack item = new ItemStack(Material.DISPENSER);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("autominername")));
        ArrayList<String> list = (ArrayList<String>) plugin.getConfig().getList("autominerlore");
        for(int i = 0; i < list.size(); i++) {
            list.set(i, ChatColor.translateAlternateColorCodes('&', list.get(i)));
        }
        itemMeta.setLore(list);
        item.setItemMeta(itemMeta);
        p.getInventory().addItem(item);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onBreak(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.DISPENSER) {
            if (e.isCancelled()) {
                return;
            }
            if (plugin.getDispensers().contains(new LocationData(e.getBlock().getLocation()).convertToString())) {
                plugin.getDispensers().remove(new LocationData(e.getBlock().getLocation()).convertToString());
                InventoryHolder dispenser = ((InventoryHolder) e.getBlock().getState());
                dispenser.getInventory().clear();
                e.setCancelled(true);
                e.getBlock().setType(Material.AIR);
                addItem(e.getPlayer());
            }
        }
    }
}