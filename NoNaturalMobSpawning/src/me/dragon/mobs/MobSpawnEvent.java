package me.dragon.mobs;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class MobSpawnEvent implements Listener {


    @EventHandler
    public void onSpawn(CreatureSpawnEvent e) {
        if(e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL) {
            e.getEntity().remove();
        }
    }
}
