package me.dragon.noendermen;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTeleportEvent;

public class Teleportevent implements Listener {


    @EventHandler
    public void onTeleport(EntityTeleportEvent e) {
        if(e.getEntityType() == EntityType.ENDERMAN) {
            e.setCancelled(true);
        }
    }

}
