package me.dragon.Generators.Events;

import me.dragon.Generators.Main.Generator;
import me.dragon.Generators.Main.Main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class onBreak implements Listener {

    Main plugin;

    public onBreak(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onBreak(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.ENDER_PORTAL_FRAME) {
            if (e.isCancelled()) {
                return;
            }
            Generator.remove(plugin,e.getBlock().getLocation(),e.getPlayer());
        }
    }

}
