
/**
 * Plugin made for CryptoMC/Words by DragonSlayer
 * All Rights reserved
 * Inquired contact Zach#2129 on discord
 **/
package me.DragonSlayer.AutoMiner;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class onClick implements Listener {

    Main plugin;

    public onClick(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        if ((e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && ((!e.getPlayer().isSneaking()) || (e.getPlayer().getItemInHand() == null) || (e.getPlayer().getItemInHand().getType().equals(Material.AIR)))) {
            LocationData l = new LocationData(e.getClickedBlock().getLocation());
            if (plugin.getDispensers().contains(l.convertToString())) {
                e.setCancelled(true);
            }
        }
    }


}
