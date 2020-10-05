package me.dragon.generators.Events;

import me.dragon.generators.Main.Main;
import me.dragon.generators.Utils;
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
        if(e.getInventory().getName().equalsIgnoreCase(Utils.color("&bUpgrade Menu!"))
                || e.getInventory().getName().equalsIgnoreCase(Utils.color("&aAccept GUI"))) {
            Main.ingui.remove((Player)e.getPlayer());
        }
    }
}
