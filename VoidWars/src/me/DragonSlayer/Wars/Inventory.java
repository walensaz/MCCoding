package me.DragonSlayer.Wars;

import me.DragonSlayer.Wars.Villager;
import net.minecraft.server.v1_8_R3.Block;
import net.minecraft.server.v1_8_R3.ContainerMerchant;
import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.IMerchant;
import net.minecraft.server.v1_8_R3.Item;
import net.minecraft.server.v1_8_R3.MerchantRecipe;
import net.minecraft.server.v1_8_R3.MerchantRecipeList;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack ;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.MerchantInventory;

public class Inventory implements Listener {
	Main plugin;
	
	
	public static ItemStack Item(org.bukkit.Material a, String lore) {
		ItemStack item = new ItemStack(a);
		ItemMeta me = item.getItemMeta();
		List<String> list = me.getLore();
		list.add(lore);
		me.setLore(list);
		item.setItemMeta(me);
		
		return item;
		
	}
	
	public static ItemStack EItem(org.bukkit.Material a, String lore, Enchantment enchant, int level) {
		ItemStack item = new ItemStack(a);
		ItemMeta me = item.getItemMeta();
		List<String> list = me.getLore();
		list.add(lore);
		me.setLore(list);
		item.setItemMeta(me);
		item.addEnchantment(enchant, level);
		return item;
		
	}
	public Inventory(Main pl) {
		this.plugin = pl;
		}
	
@EventHandler(priority=EventPriority.MONITOR)
void onInventoryClick(InventoryClickEvent e) {
    if (e.getInventory().getTitle().equals("Shop")) {
    	
    	
    	Player p = (Player)e.getWhoClicked();
    	//CraftPlayer cp = (CraftPlayer) p;
    	//EntityPlayer ep = cp.getHandle();
    	ItemStack[] pinv = p.getInventory().getContents();
    	ItemStack cl = e.getCurrentItem();
    	
    	ClickType c = e.getClick();
    	if(c.equals(ClickType.LEFT)) {
    	if(cl.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Shop")) {
    	//Do Something	
    		org.bukkit.inventory.Inventory inv = Bukkit.createInventory(null, 27, "Weapons");
    		inv.setItem(10, Item(Material.WOOD_SWORD, ChatColor.DARK_PURPLE + "Buy a Wood Sword for 10 iron!"));
    		inv.setItem(11, Item(Material.STONE_SWORD, ChatColor.DARK_PURPLE + "Buy a Stone Sword for 30 iron!"));
    		inv.setItem(12, Item(Material.IRON_SWORD, ChatColor.DARK_PURPLE + "Buy a Iron Sword for 16 gold!"));
    		inv.setItem(13, Item(Material.DIAMOND_SWORD, ChatColor.DARK_PURPLE + "Buy a Diamond Sword for 5 diamond!"));
    		inv.setItem(13, Item(Material.BOW, ChatColor.DARK_PURPLE + "Buy a Bow for 5 diamond!"));
    		inv.setItem(13, EItem(Material.BOW, ChatColor.DARK_PURPLE + "Buy a Punch Bow for 12 diamond!", Enchantment.ARROW_KNOCKBACK, 1));
    		p.openInventory(inv);
    		//pla.openTrade(merchant);
    		
    	
    	} else if(cl.getItemMeta().getDisplayName().equalsIgnoreCase("Shop")) {
    		//Do Something
    		
    		org.bukkit.inventory.Inventory inv = Bukkit.createInventory(null, InventoryType.MERCHANT, "Food");
    		inv.setItem(10, Item(Material.COOKED_BEEF, ChatColor.DARK_PURPLE + "Buy 1 Steak for 5 iron!"));
    		inv.setItem(11, Item(Material.CARROT, ChatColor.DARK_PURPLE + "Buy 1 Carrot for 2 iron!"));
    		inv.setItem(13, Item(Material.CAKE, ChatColor.DARK_PURPLE + "Buy a Cake for 25 Iron!"));
    		inv.setItem(12, Item(Material.GOLDEN_APPLE, ChatColor.DARK_PURPLE + "Buy 1 Golden Apple for 10 gold!"));
    		
    		p.openInventory(inv);
    		
    		
    		
    	} else if(cl.getItemMeta().getDisplayName().equalsIgnoreCase("Armor")) {
    		//Do Something
    		org.bukkit.inventory.Inventory inv = Bukkit.createInventory(null, InventoryType.MERCHANT, "Weapons");
    		
    	}else if(cl.getItemMeta().getDisplayName().equalsIgnoreCase("misc.")) {
    		//Do SOmething
    		org.bukkit.inventory.Inventory inv = Bukkit.createInventory(null, InventoryType.MERCHANT, "Weapons");
    		
    	}else if(cl.getItemMeta().getDisplayName().equalsIgnoreCase("Blocks")) {
    		//Do Something
    		org.bukkit.inventory.Inventory inv = Bukkit.createInventory(null, InventoryType.MERCHANT, "Weapons");
    		
    	}
} else {
	p.sendMessage(ChatColor.RED + "Left click only, Being worked on!");
	e.setCancelled(true);
	p.getInventory().setContents(pinv);
}
}else if(e.getInventory().getName().equalsIgnoreCase("Shop")) {
	
	
	
	
	
}
}
}

