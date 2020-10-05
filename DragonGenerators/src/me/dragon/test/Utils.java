package me.dragon.test;

import me.dragon.test.Main.Main;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {


    public static String GenMessage(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> getList(Main plugin, String path) {
        ArrayList<String> list = new ArrayList<>();
        for(String string : plugin.getConfig().getStringList(path)) {
            list.add(Utils.GenMessage(string));
        }
        return list;
    }



    public static ItemStack addTag(ItemStack item, String identifier, String value) {
        net.minecraft.server.v1_8_R3.ItemStack itemNms = CraftItemStack.asNMSCopy(item);
        if(itemNms.hasTag()) {
            itemNms.getTag().setString(identifier, value);
        } else {
            itemNms.setTag(new NBTTagCompound());
            itemNms.getTag().setString(identifier, value);
        }
        return CraftItemStack.asBukkitCopy(itemNms);
    }

    public static Set<String> getTags(ItemStack item) {
        net.minecraft.server.v1_8_R3.ItemStack itemNms = CraftItemStack.asNMSCopy(item);
        if(itemNms.hasTag())
            return itemNms.getTag().c();
        else
            return new HashSet<>();
    }

    public static String getTag(ItemStack item, String identifier) {
        net.minecraft.server.v1_8_R3.ItemStack itemNms = CraftItemStack.asNMSCopy(item);
        if(getTags(item).contains(identifier)) {
            return itemNms.getTag().getString(identifier);
        }
        return "";
    }

    public static ItemStack resetTags(ItemStack item) {
        net.minecraft.server.v1_8_R3.ItemStack itemNms = CraftItemStack.asNMSCopy(item);
        itemNms.setTag(new NBTTagCompound());
        return CraftItemStack.asBukkitCopy(itemNms);
    }

}
