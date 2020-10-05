package me.dragon.test.Events;

import me.dragon.test.Main.Main;
import me.dragon.test.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryClose implements Listener {

    Main plugin;

    public InventoryClose(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        if(e.getInventory().getName().equalsIgnoreCase(Utils.GenMessage("&bUpgrade Menu!"))
                || e.getInventory().getName().equalsIgnoreCase(Utils.GenMessage("&aAccept GUI"))) {
            Main.ingui.remove((Player)e.getPlayer());
        }
    }
}
