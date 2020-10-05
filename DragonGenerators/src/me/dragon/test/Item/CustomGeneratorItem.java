package me.dragon.test.Item;

import me.dragon.test.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class CustomGeneratorItem extends ItemStack {

    private int level;

    public CustomGeneratorItem(int level) throws IllegalArgumentException {
        super(Material.ENDER_PORTAL_FRAME);
        Utils.addTag(this, "level", String.valueOf(level));
    }
}
