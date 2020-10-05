package me.dragon.test.Events;

import me.dragon.test.Main.Generator;
import me.dragon.test.Main.Main;
import me.dragon.test.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryType;

import java.util.logging.Level;

public class onPlace implements Listener {

    Main plugin;

    public onPlace(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if(e.isCancelled()) {
            return;
        }
        if (e.getPlayer().getItemInHand().getData().getItemType() == Material.ENDER_PORTAL_FRAME) {
            if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Utils.GenMessage(plugin.getConfig().getString("genname")))) {
                Generator.add(plugin, e.getBlock().getLocation(), 1);
                e.getPlayer().sendMessage(Utils.GenMessage(Main.prefix + plugin.getConfig().getString("placesuccessmessage")));
                if(plugin.getConfig().getBoolean("logbreakingandplacing")) {
                    plugin.getLogger().log(Level.INFO, "GENERATOR: Generator placed at " + e.getBlock().getLocation().toString() + " by " + e.getPlayer().getName());
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        if (pl.isOp()) {
                            pl.sendMessage(Utils.GenMessage(Main.prefix + " &aGENERATOR: Generator placed at " + e.getBlock().getLocation().toString() + " by " + e.getPlayer().getName()));
                        }
                    }
                }
                Bukkit.createInventory(null, InventoryType.CREATIVE, "stuff");
            }
        }
    }
}
