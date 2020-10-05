package me.dragon.antiabuse.events;

import me.dragon.antiabuse.Main;
import me.dragon.antiabuse.MyLogger;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.PlayerInventory;

public class InventoryMoveEvent implements Listener {

    Main plugin;

    public InventoryMoveEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void inventoryMoveEvent(InventoryClickEvent e) {
        if(Main.getStaff().containsKey(e.getWhoClicked().getName())) {
            if (e.getInventory().getType().equals(InventoryType.PLAYER)) {
                PlayerInventory inventory = (PlayerInventory) e.getInventory();
                if(inventory.getHolder().getName().equalsIgnoreCase(e.getWhoClicked().getName())) {
                    return;
                } else {
                    MyLogger.logInventoryMove((Player)e.getWhoClicked(), e.getCurrentItem().getType(), (Player) inventory.getHolder());
                }
            } else {
                e.getWhoClicked().sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&c&lStaffDuty -> &bYou can't take items from chests."));
                e.setCancelled(true);
            }
        }
    }


}
