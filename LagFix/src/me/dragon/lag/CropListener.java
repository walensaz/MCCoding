package me.dragon.lag;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Hopper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.world.StructureGrowEvent;

public class CropListener implements Listener {

    @EventHandler
    public void HopperListener(BlockGrowEvent e) {
        if(e.getNewState().getType() == Material.CACTUS) {
            e.getBlock().setType(Material.AIR);
            for(Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage("CACTUS");
            }
        }
    }
}
