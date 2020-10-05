package me.DragonSlayer.Wars;

import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.EntityVillager;
import net.minecraft.server.v1_8_R3.MerchantRecipeList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class Villager implements Listener {
	Main plugin;
	
	public Villager(Main pl) {
		this.plugin = pl;
		
		}

		 @EventHandler
		 public void Villager(PlayerInteractEntityEvent e) {
			 if(e.getRightClicked().getType().equals(EntityType.VILLAGER)) {
				 Entity Village = e.getRightClicked();
				 if(Village.getCustomName().equalsIgnoreCase("Shop")) {
					 Player p = e.getPlayer();
					 Inventory inv = Bukkit.createInventory(null, 9, "VoidShop");
					 ItemStack Swords = new ItemStack(Material.DIAMOND_SWORD);
					 ItemStack Food = new ItemStack(Material.APPLE);
					 ItemStack Armor = new ItemStack(Material.DIAMOND_CHESTPLATE);
					 ItemStack misc = new ItemStack(Material.TNT);
					 ItemStack Blocks = new ItemStack(Material.OBSIDIAN);
					 ItemMeta sdata = Swords.getItemMeta();
					 sdata.setDisplayName(ChatColor.GRAY + "Weapons");
					 ItemMeta fdata = Food.getItemMeta();
					 fdata.setDisplayName(ChatColor.GRAY + "Food");
					 ItemMeta adata = Armor.getItemMeta();
					 adata.setDisplayName(ChatColor.GRAY + "Armor");
					 ItemMeta mdata = misc.getItemMeta();
					 mdata.setDisplayName(ChatColor.GRAY + "Misc.");
					 ItemMeta bdata = Blocks.getItemMeta();
					 bdata.setDisplayName(ChatColor.GRAY + "Blocks");
					 Blocks.setItemMeta(bdata);
					 Swords.setItemMeta(sdata);
					 Food.setItemMeta(fdata);
					 Armor.setItemMeta(adata);
					 misc.setItemMeta(mdata);
					 inv.setItem(2, Blocks);
					 inv.setItem(3, Swords);
					 inv.setItem(4, Armor);
					 inv.setItem(5, Food);
					 inv.setItem(6, misc);
					 p.openInventory(inv);

					 
					 
				 }
				 
				
				 
				 
				 
			 }
			 
			 
			 
		 }
		 

		 
		 
}