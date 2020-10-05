package me.Teleports.BMCShops.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.Teleports.BMCShops.Main;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;

public class ShopCommand implements CommandExecutor {

	Main plugin;
	List<String> list;
	List<String> list2;

	public ShopCommand(Main pl) {
		this.plugin = pl;
	}

	private boolean isLocked(Player p) {
		Boolean bool = false;
		if (plugin.getConfig().getBoolean("playershops." + p.getUniqueId() + ".locked") == true) {
			bool = true;
		}
		return bool;

	}

	private boolean isLockedo(OfflinePlayer p) {
		Boolean bool = false;
		if (plugin.getConfig().getBoolean("playershops." + p.getUniqueId() + ".locked") == true) {
			bool = true;
		}
		return bool;
	}

	public boolean checkDangersLocation(Player p, Location loc, int radius) {
		boolean bool = true;

		List<Material> blocks = Utils.getNearbyBlocks(loc, radius);
		if (blocks.contains(Material.LAVA) || blocks.contains(Material.STATIONARY_LAVA)) {
			p.sendMessage(plugin.prefix + ChatColor.RED + "Shop set within 2 blocks of lava!");
		} else if (loc.getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.AIR)) {
			p.sendMessage(plugin.prefix + ChatColor.RED + "No block under destination!");
		} else {
			bool = false;
		}
		return bool;

	}

	public boolean checkDangers(Player p, int radius) {
		boolean bool = true;
		Location loc = p.getLocation();
		List<Material> blocks = Utils.getNearbyBlocks(loc, radius);
		if (blocks.contains(Material.LAVA) || blocks.contains(Material.STATIONARY_LAVA)) {
			p.sendMessage(plugin.prefix + ChatColor.RED + "Don't set your shop within 3 blocks of lava!");
		} else if (loc.getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.AIR)) {
			p.sendMessage(plugin.prefix + ChatColor.RED + "You must have a block under you!");
		} else {
			bool = false;
		}
		return bool;

	}
	
	private void intialize() {
		list = plugin.getConfig().getStringList("advertisement-players");
		list2 = new ArrayList<String>();
		
		
	}

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		if (l.equalsIgnoreCase("ps")) {
			if (s.hasPermission("BMC.shop")) {
				Player p = (Player) s;
				intialize();
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("advertise") && plugin.getConfig()
							.get("playershops." + p.getUniqueId() + ".uuid", p.getUniqueId().toString()) != null) {
						if (Main.getEconomy().bankBalance(p.getName()).amount >= plugin.getConfig()
								.getDouble("advertisement-price")) {

							if (list != null) {
								if (list.contains(p.getUniqueId().toString())) {
									p.sendMessage(plugin.prefix + ChatColor.RED + "Already bought an advertisement!");

								} else if (!(list.size() <= 45)) {
									p.sendMessage(plugin.prefix + ChatColor.RED + "List is full!");

								} else {
									Main.getEconomy().bankWithdraw(p.getName(),
											plugin.getConfig().getDouble("advertisement-price"));
									list.add(p.getUniqueId().toString());
									plugin.getConfig().set("advertisement-players", list);
									plugin.saveConfig();
									p.sendMessage(plugin.prefix + ChatColor.GREEN + "$"
											+ plugin.getConfig().getDouble("setshop-price")
											+ " has been taken from your account");
									p.sendMessage(
											plugin.prefix + ChatColor.GREEN + "Advertisement posted successfully!");
									p.sendMessage(plugin.prefix + ChatColor.GREEN
											+ "Make sure to add your lore using /shop advertise lore <loreline>");
									s.sendMessage(plugin.prefix + ChatColor.GREEN + "For more help use /bmcshops!");
								}

							} else if (list == null) {
								list2.add(p.getUniqueId().toString());
								Main.getEconomy().bankWithdraw(p.getName(),
										plugin.getConfig().getDouble("advertisement-price"));
								plugin.getConfig().set("advertisement-players", list2);
								plugin.saveConfig();
								p.sendMessage(plugin.prefix + ChatColor.GREEN + "$"
										+ plugin.getConfig().getDouble("setshop-price")
										+ " has been taken from your account");
								p.sendMessage(plugin.prefix + ChatColor.GREEN + "Advertisement posted successfully!");
								p.sendMessage(plugin.prefix + ChatColor.GREEN
										+ "Make sure to add your lore using /shop advertise lore <loreline>");
								s.sendMessage(plugin.prefix + ChatColor.GREEN + "For more help use /bmcshops!");

							}

						} else {
							p.sendMessage(plugin.prefix + ChatColor.RED + "Not enough money!");
						}

					} else if (args[0].equalsIgnoreCase("lock")) {
						if (plugin.getConfig().getBoolean("playershops." + p.getUniqueId() + ".locked") == false) {
							plugin.getConfig().set("playershops." + p.getUniqueId() + ".locked", true);
							plugin.saveConfig();
							p.sendMessage(
									plugin.prefix + ChatColor.GREEN + "Shop has been locked, use /ps lock to unlock!");
						} else {
							plugin.getConfig().set("playershops." + p.getUniqueId() + ".locked", false);
							plugin.saveConfig();
							p.sendMessage(
									plugin.prefix + ChatColor.GREEN + "Shop has been unlocked, use /ps lock to lock!");
						}

					} else {
						Player pl = Bukkit.getPlayer(args[0]);
						if (pl != null) {
							if (plugin.getConfig().getConfigurationSection("playershops").getKeys(false)
									.contains(pl.getUniqueId().toString())) {

								double x = plugin.getConfig()
										.getDouble("playershops." + pl.getUniqueId() + ".location.x");
								double y = plugin.getConfig()
										.getDouble("playershops." + pl.getUniqueId() + ".location.y");
								double z = plugin.getConfig()
										.getDouble("playershops." + pl.getUniqueId() + ".location.z");
								String w = plugin.getConfig()
										.getString("playershops." + pl.getUniqueId() + ".location.world");
								float yaw = (float) plugin.getConfig()
										.getDouble("playershops." + pl.getUniqueId() + ".location.yaw");
								float pitch = (float) plugin.getConfig()
										.getDouble("playershops." + pl.getUniqueId() + ".location.pitch");

								Location loc = new Location(Bukkit.getServer().getWorld(w), x, y, z, yaw, pitch);
								if (checkDangersLocation(p, loc, 2) == false) {
									if (!(isLocked(pl))) {
										s.sendMessage(plugin.prefix + ChatColor.GREEN + "Teleporting to " + args[0]
												+ "'s Shop.");
										p.teleport(loc);
									} else {
										p.sendMessage(plugin.prefix + ChatColor.RED + "Shop is locked!");
									}
								} else {
									p.sendMessage(plugin.prefix + ChatColor.RED + "Unsafe shop, contact shop owner!");
								}
							} else {
								p.sendMessage(plugin.prefix + ChatColor.RED + "This player does not have a shop!");
							}
						} else {
							OfflinePlayer pl1 = Bukkit.getOfflinePlayer(args[0]);

							if (plugin.getConfig().getConfigurationSection("playershops").getKeys(false)
									.contains(pl1.getUniqueId().toString())) {

								double x = plugin.getConfig()
										.getDouble("playershops." + pl1.getUniqueId() + ".location.x");
								double y = plugin.getConfig()
										.getDouble("playershops." + pl1.getUniqueId() + ".location.y");
								double z = plugin.getConfig()
										.getDouble("playershops." + pl1.getUniqueId() + ".location.z");
								String w = plugin.getConfig()
										.getString("playershops." + pl1.getUniqueId() + ".location.world");
								float yaw = (float) plugin.getConfig()
										.getDouble("playershops." + pl1.getUniqueId() + ".location.yaw");
								float pitch = (float) plugin.getConfig()
										.getDouble("playershops." + pl1.getUniqueId() + ".location.pitch");

								Location loc = new Location(Bukkit.getServer().getWorld(w), x, y, z, yaw, pitch);
								if (checkDangersLocation(p, loc, 2) == false) {
									if (!(isLockedo(pl1))) {
										s.sendMessage(plugin.prefix + ChatColor.GREEN + "Teleporting to " + args[0]
												+ "'s Shop.");
										p.teleport(loc);
									} else {
										p.sendMessage(plugin.prefix + ChatColor.RED + "Shop is locked!");
									}
								} else {
									p.sendMessage(plugin.prefix + ChatColor.RED + "Unsafe shop, contact shop owner!");
								}
							} else {
								p.sendMessage(plugin.prefix + ChatColor.RED + "This player does not have a shop!");
							}

						}
					}
				} else if (args.length >= 3) {
					if (args[0].equalsIgnoreCase("advertise")) {
						if (args[1].equalsIgnoreCase("lore") && !(args[2].equalsIgnoreCase("delete"))) {
							String lore1 = "";
							for (int i = 2; i < args.length; i++) {
								lore1 += args[i] += " ";
							}
							List<String> lore = plugin.getConfig()
									.getStringList("playershops." + p.getUniqueId() + ".lore");
							if (lore != null && lore.size() < 3) {
								lore.add(lore1);
								plugin.getConfig().set("playershops." + p.getUniqueId() + ".lore", lore);
								plugin.saveConfig();
								p.sendMessage(plugin.prefix + ChatColor.GREEN + "Added lore line!");
							} else if (lore == null) {
								List<String> newlore = new ArrayList<String>();
								newlore.add(lore1);
								plugin.getConfig().set("playershops." + p.getUniqueId() + ".lore", newlore);
								plugin.saveConfig();
								p.sendMessage(plugin.prefix + ChatColor.GREEN + "Added lore line!");
							} else {
								p.sendMessage(plugin.prefix + ChatColor.RED + "You are only allowed 3 lines!");
							}
						} else if (args[1].equalsIgnoreCase("lore") && args[2].equalsIgnoreCase("delete")) {
							plugin.getConfig().set("playershops." + p.getUniqueId() + ".lore", null);
							plugin.saveConfig();
							p.sendMessage(plugin.prefix + ChatColor.RED + "Lore deleted!");
						}

					}

				} else {
					p.sendMessage((ChatColor.GREEN + "--------" + plugin.prefix + ChatColor.GREEN + "--------")
							.replaceAll(" ", ""));
					p.sendMessage(ChatColor.GOLD + "/setps - sets your shop");
					p.sendMessage(
							ChatColor.GOLD + "/ps <player> - Teleports you to players shop if player has a shop!");
					p.sendMessage(ChatColor.GOLD
							+ "/pshops - opens shop advertisements.  Click to teleport to that person's shop!");
					p.sendMessage(ChatColor.GOLD
							+ "/ps advertise - allows you to buy an advertisement, costs money, no warning message!");
					p.sendMessage(ChatColor.GOLD
							+ "/ps advertise lore <lore> - adds a line <lore> to your shop!  Cannot include color codes!");
					p.sendMessage(ChatColor.GOLD + "/ps advertise lore delete - deletes all lines of lore!");
					p.sendMessage(ChatColor.GOLD + "[ADMIN] /psreset - Deletes all advertisements!");
					p.sendMessage((ChatColor.GREEN + "--------" + plugin.prefix + ChatColor.GREEN + "--------")
							.replaceAll(" ", ""));
				}
			} else {
				s.sendMessage(plugin.prefix + ChatColor.RED + "No Perms!");
				s.sendMessage(plugin.prefix + ChatColor.RED + "Looking for help? type /bmcshops.");
			}
		}

		return true;
	}

}
