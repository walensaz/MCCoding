package me.dragon.test.Events;

import me.dragon.test.Main.Generator;
import me.dragon.test.Main.Main;
import me.dragon.test.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class InventoryClickEvent implements Listener {

    Main plugin;

    public InventoryClickEvent(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void clickEvent(org.bukkit.event.inventory.InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if(e.getClickedInventory().getName().equalsIgnoreCase(Utils.GenMessage("&bUpgrade Menu!"))) {
            Generator generator = Main.ingui.get(player);
            e.setCancelled(true);
            if(e.getCurrentItem().getType() == Material.NETHER_STAR) {
                if(Main.getEconomy().getBalance(player) >= plugin.getConfig().getInt("level" + (generator.getLevel() + 1))) {
                    Main.openAcceptGUI("&bSpend " + plugin.getConfig().getInt("level" + (generator.getLevel() + 1)) + " to upgrade?", (Player) e.getWhoClicked());
                } else {
                    Main.ingui.remove(player);
                    player.closeInventory();
                    player.sendMessage(Utils.GenMessage(Main.prefix + " &cNot enough money!"));
                }
            } else if(e.getCurrentItem().getType() == Material.WOOD_PICKAXE) {
                Main.openAcceptGUI("&cBreak this generator and lose all its levels?", player);
            }
        } else if(e.getClickedInventory().getName().equalsIgnoreCase(Utils.GenMessage("&aAccept GUI"))) {
            Generator generator = Main.ingui.get(player);
            e.setCancelled(true);
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Utils.GenMessage("&aAccept!"))
                    && e.getInventory().getItem(4).getItemMeta().getDisplayName().contains("Spend")) {
                if (Main.getEconomy().getBalance(player) >= plugin.getConfig().getInt("level" + (generator.getLevel() +1))) {
                    Main.getEconomy().withdrawPlayer(player, plugin.getConfig().getInt("level" + (generator.getLevel() + 1)));
                    Main.ingui.get(player).upgrade(plugin, player);
                    Main.ingui.remove(player);
                    player.closeInventory();
                } else {
                    Main.ingui.remove(player);
                    e.getWhoClicked().closeInventory();
                    player.sendMessage(Utils.GenMessage(Main.prefix + " &cNot enough money!"));
                }
            } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Utils.GenMessage("&aAccept!"))
                    && e.getInventory().getItem(4).getItemMeta().getDisplayName().contains("Break")) {
                Main.ingui.remove(player);
                player.closeInventory();
                BlockBreakEvent breakEvent = new BlockBreakEvent(generator.getLocation().getBlock(), player);
                Bukkit.getServer().getPluginManager().callEvent(breakEvent);
                if(!breakEvent.isCancelled()) {
                    Generator.remove(plugin, generator.getLocation(), player);
                    player.sendMessage(Utils.GenMessage(Main.prefix + " &aBroke successfully!"));
                    return;
                }
                player.sendMessage(Utils.GenMessage(Main.prefix + " &cCan't break block here!"));
            } else {
                Main.ingui.remove(player);
                e.getWhoClicked().closeInventory();
                player.sendMessage(Utils.GenMessage(Main.prefix + " &cYou denied!"));
            }
        }
    }

}
