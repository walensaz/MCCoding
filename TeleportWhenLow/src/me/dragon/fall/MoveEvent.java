package me.dragon.fall;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {


    @EventHandler
    public void onFall(PlayerMoveEvent e) {
        if(e.getPlayer().getLocation().getBlockY() < -5) {
            e.getPlayer().teleport(e.getFrom());
        }
    }

}
