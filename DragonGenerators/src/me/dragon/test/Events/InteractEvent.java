package me.dragon.test.Events;

import me.dragon.test.Main.Generator;
import me.dragon.test.Main.Main;
import me.dragon.test.Utils;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractEvent implements Listener {

    Main plugin;

    public InteractEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void interact(PlayerInteractEvent e) {
        if(e.isCancelled()) {
            return;
        }
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(e.getPlayer().isSneaking()) {
                return;
            }
            if(e.getClickedBlock().getType() == Material.ENDER_PORTAL_FRAME) {
                Generator generator = null;
                if((generator = Generator.getGeneratorAt(plugin,e.getClickedBlock().getLocation())) != null) {
                    if(Main.ingui.containsValue(generator)) {
                        e.setCancelled(true);
                        e.getPlayer().sendMessage(Utils.GenMessage(Main.prefix + " &cPlayer already in this generator!"));
                    }
                    e.setCancelled(true);
                    Main.ingui.put(e.getPlayer(), generator);
                    generator.openupgradegui(plugin, e.getPlayer());
                }
            }
        }
    }
}
