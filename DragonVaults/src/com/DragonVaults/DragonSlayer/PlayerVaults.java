package com.DragonVaults.DragonSlayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class PlayerVaults {
    Main plugin;


    public static void openVault(Player p, String number, Main plugin) {
        if (plugin.getConfig().get("vaults." + p.getUniqueId() + "." + number) != null) {
            ItemStack[] items = (ItemStack[]) plugin.getConfig().get("vaults." + p.getUniqueId() + "." + number);
            Inventory inventory = Bukkit.createInventory(p, 54, ChatColor.RED + "Vault " + number);
            Main.commandplayers.add(p.getName());
            inventory.setContents(items);
            p.openInventory(inventory);
        }
    }

    public static void openVaults(Player p, Main plugin) {
        if (plugin.getConfig().get("vaults." + p.getUniqueId() + ".1") != null) {
            ItemStack item = new ItemStack(Material.STONE);
            Inventory inv = Bukkit.createInventory(null, 27, "Playervaults");
            for (int i = 1; i < 10; i++) {
                if (plugin.getConfig().get("vaults." + p.getUniqueId() + "." + String.valueOf(i)) != null) {
                    if (plugin.getConfig().get("vaults." + p.getUniqueId() + "." + String.valueOf(i) + ".item") == null) {
                        ItemMeta itemm = item.getItemMeta();
                        itemm.setDisplayName(ChatColor.RED + "Playervault " + String.valueOf(i));
                        item.setItemMeta(itemm);
                        inv.setItem(9 + i, item);
                    }
                }
            }
        }
    }
}


