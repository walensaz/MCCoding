package me.dragon.antiabuse.events;

import me.dragon.antiabuse.Main;
import me.dragon.antiabuse.MyLogger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakEvent implements Listener {

    Main plugin;

    public BreakEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if(Main.getStaff().containsKey(e.getPlayer().getName())) {
            MyLogger.logBlockEvent(e.getPlayer(), false, e.getBlock().getType());
        }
    }

}
