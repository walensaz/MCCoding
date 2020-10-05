package me.dragon.nofly;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {


    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (e.getPlayer().isFlying()) {
            if (e.getPlayer().hasPermission("nofly.nofly")) {
                return;
            }
            if (e.getPlayer().getLocation().getX() < -95) {
                if (e.getPlayer().getLocation().getX() > -127) {
                    if (e.getPlayer().getLocation().getZ() > 75) {
                        if (e.getPlayer().getLocation().getZ() < 101) {
                            e.getPlayer().setFlying(false);
                            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',
                                    "&b&lGodly&f&lMC &cYou may not fly near the koth!"));

                        }
                    }
                }
            }
        }
    }
}
