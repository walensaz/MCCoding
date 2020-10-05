package me.dragon.antiabuse.events;

import me.dragon.antiabuse.Main;
import me.dragon.antiabuse.MyLogger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceEvent implements Listener {

    Main plugin;

    public PlaceEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if(Main.getStaff().containsKey(e.getPlayer().getName())) {
            MyLogger.logBlockEvent(e.getPlayer(), true, e.getBlockPlaced().getType());
        }
    }
}
