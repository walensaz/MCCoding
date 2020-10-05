package me.dragon.antiabuse.events;

import me.dragon.antiabuse.Main;
import me.dragon.antiabuse.MyLogger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropEvent implements Listener {

    Main plugin;

    public DropEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        if(Main.getStaff().containsKey(e.getPlayer().getName())) {
            MyLogger.logDropEvent(e.getPlayer(), e.getItemDrop().getItemStack().getType());
        }
    }
}
