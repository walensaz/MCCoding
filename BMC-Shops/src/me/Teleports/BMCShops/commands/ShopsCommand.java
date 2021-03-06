package me.Teleports.BMCShops.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import me.Teleports.BMCShops.Main;
import net.md_5.bungee.api.ChatColor;

public class ShopsCommand implements CommandExecutor {

	Main plugin;
	private Inventory inv;
	private List<String> advertList;

	public ShopsCommand(Main pl) {
		this.plugin = pl;
	}
	
	public void intialize() {
		inv = Bukkit.createInventory(null, 54, plugin.prefix + ChatColor.RED + "Shops");
		advertList = plugin.getConfig().getStringList("advertisement-players");
	}

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		if (l.equalsIgnoreCase("pshops")) {
			if (s.hasPermission("BMC.shop")) {
				intialize();
				Player p = (Player) s;
				if (advertList == null) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.prefix + plugin.getConfig().getString("advert-not-bought")));
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.prefix + plugin.getConfig().getString("shop-advertise")));
				} else {
					for (int i = 0; i < advertList.size(); i++) {
						UUID uuid = UUID.fromString(advertList.get(i));
						Player person = Bukkit.getPlayer(uuid);
						if (person != null) {
							ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
							SkullMeta skullm = (SkullMeta) skull.getItemMeta();
							skullm.setOwner(person.getName());
							skullm.setDisplayName(ChatColor.translateAlternateColorCodes('&', ChatColor.AQUA + person.getName() + "'s " + ChatColor.GOLD + "Shop"));
							List<String> list3 = plugin.getConfig().getStringList("playershops." + person.getUniqueId() + ".lore");

							if (list3 != null) {
								skullm.setLore(list3);

							} else {
								list3 = new ArrayList<String>();
								list3.add(ChatColor.translateAlternateColorCodes('&',
										ChatColor.AQUA + "Come to my shop! I've got much product!"));
								skullm.setLore(list3);
							}
							
							skull.setItemMeta(skullm);
							inv.addItem(skull);

						} else {
							OfflinePlayer operson = Bukkit.getOfflinePlayer(uuid);
							ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
							SkullMeta skullm = (SkullMeta) skull.getItemMeta();
							skullm.setOwner(operson.getName());
							skullm.setDisplayName(ChatColor.translateAlternateColorCodes('&',
									ChatColor.AQUA + operson.getName() + "'s " + ChatColor.GOLD + "Shop"));
							List<String> list3 = plugin.getConfig()
									.getStringList("playershops." + operson.getUniqueId() + ".lore");

							if (list3 != null) {
								skullm.setLore(list3);

							} else {
								list3 = new ArrayList<String>();
								list3.add(ChatColor.translateAlternateColorCodes('&',
										ChatColor.AQUA + "Come to my shop! I've got much product!"));
								skullm.setLore(list3);
							}

							skull.setItemMeta(skullm);
							inv.addItem(skull);

						}

					}
					ItemStack myitem = new ItemStack(Material.DIAMOND);
					ItemMeta itemm = myitem.getItemMeta();
					itemm.setDisplayName(ChatColor.AQUA + "Made by Teleports");
					myitem.setItemMeta(itemm);
					inv.setItem(49, myitem);
					ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
					inv.setItem(45, glass);
					inv.setItem(46, glass);
					inv.setItem(47, glass);
					inv.setItem(48, glass);
					inv.setItem(50, glass);
					inv.setItem(51, glass);
					inv.setItem(52, glass);
					inv.setItem(53, glass);
					p.openInventory(inv);

				}
			}
		}

		return true;
	}

}
