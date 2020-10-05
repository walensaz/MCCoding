package me.dragon.antiabuse.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GUIS {

    private static Inventory KitStarter(Inventory inventory) {

        return inventory;
    }


    public static void showKitStarter(Player p) {
        Inventory inventory = Bukkit.createInventory(null, 9, ChatColor.RED + "Kit Starter");
        inventory = KitStarter(inventory);
        p.openInventory(inventory);

    }


}
