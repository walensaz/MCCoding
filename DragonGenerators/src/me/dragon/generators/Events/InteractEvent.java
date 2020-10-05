package me.dragon.generators.Events;

import me.dragon.generators.Main.Generator;
import me.dragon.generators.Main.Main;
import me.dragon.generators.Utils;
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
                        e.getPlayer().sendMessage(Utils.color(Main.prefix + " &cPlayer already in this generator!"));
                    }
                    e.setCancelled(true);
                    Main.ingui.put(e.getPlayer(), generator);
                    generator.openupgradegui(plugin, e.getPlayer());
                }
            }
        }
    }
}
