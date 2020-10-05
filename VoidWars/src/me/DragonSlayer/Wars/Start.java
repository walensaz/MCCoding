package me.DragonSlayer.Wars;

import net.minecraft.server.v1_8_R3.ItemStack;
import net.minecraft.server.v1_8_R3.MerchantRecipe;
import net.minecraft.server.v1_8_R3.MerchantRecipeList;

import org.bukkit.Bukkit;

public class Start {

	
	public static void start(Boolean a) {
		if(a) {
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "iron");
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "gold");
			
		}
	}
	public static MerchantRecipeList addItems(MerchantRecipeList list,ItemStack item, ItemStack item2, ItemStack item3) {
		list.add(new MerchantRecipe(item, item2, item3));
		return list;
	}
}

