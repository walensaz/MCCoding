package me.org.Bastion.Packs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;


public class Backpacks implements CommandExecutor {


    Main plugin;


    public Backpacks(Main pl) {
        this.plugin = pl;

    }

    public void openOfflineAdmin(OfflinePlayer target, Player p, int rows) {
        Inventory inv = Bukkit.createInventory(p, rows * 9, ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("admin-inventory-name")).replaceAll("%PLAYER%", target.getName()));
        List<ItemStack> a = new ArrayList<ItemStack>();
        a = (List<ItemStack>) plugin.getConfig().get("backpacks.players." + target.getUniqueId() + ".backpack");

        if (a != null) {
            for (int i = 0; i < a.size(); i++) {
                inv.addItem(a.get(i));
            }

            plugin.getConfig().set("backpacks.players." + target.getUniqueId() + ".slots", rows);
            plugin.saveConfig();
            p.openInventory(inv);
        } else {
            p.openInventory(inv);


        }


    }

    public void openAdmin(Player target, Player p, int rows) {
        Inventory inv = Bukkit.createInventory(p, rows * 9, ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("admin-inventory-name")).replaceAll("%PLAYER%", target.getName()));
        List<ItemStack> a = new ArrayList<ItemStack>();
        a = (List<ItemStack>) plugin.getConfig().get("backpacks.players." + target.getUniqueId() + ".backpack");

        if (a != null) {
            for (int i = 0; i < a.size(); i++) {
                inv.addItem(a.get(i));
            }

            plugin.getConfig().set("backpacks.players." + target.getUniqueId() + ".slots", rows);
            plugin.saveConfig();
            p.openInventory(inv);
        } else {
            p.openInventory(inv);


        }


    }

    public void openBackpack(Player p, int rows) {
        Inventory inv = Bukkit.createInventory(p, rows * 9, ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("inventory-name")));
        List<ItemStack> a = new ArrayList<ItemStack>();
        a = (List<ItemStack>) plugin.getConfig().get("backpacks.players." + p.getUniqueId() + ".backpack");

        if (a != null) {
            for (int i = 0; i < a.size(); i++) {
                inv.setItem(i, a.get(i));
            }

            plugin.getConfig().set("backpacks.players." + p.getUniqueId() + ".slots", rows);
            plugin.saveConfig();
            p.openInventory(inv);
        } else {
            p.openInventory(inv);


        }


    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args) {
        if (cmdlabel.equalsIgnoreCase("backpack") || cmdlabel.equalsIgnoreCase("bp")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("BMC.use")) {
                    if (args.length == 0) {
                        if (p.hasPermission("BMC.rows.6") || p.isOp()) {
                            openBackpack(p, 6);


                        } else if (p.hasPermission("BMC.rows.5")) {
                            openBackpack(p, 5);

                        } else if (p.hasPermission("BMC.rows.4")) {
                            openBackpack(p, 4);

                        } else if (p.hasPermission("BMC.rows.3")) {
                            openBackpack(p, 3);


                        } else if (p.hasPermission("BMC.rows.2")) {
                            openBackpack(p, 2);

                        } else if (p.hasPermission("BMC.rows.1")) {
                            openBackpack(p, 1);

                        } else {
                            openBackpack(p, 1);

                        }


                    } else if (args.length == 1) {
                        if (p.hasPermission("BMC.admin") || p.isOp()) {
                            Player target = (Player) Bukkit.getPlayer(args[0]);
                            if (target != null) {
                                if (plugin.getConfig().get("backpacks.players." + target.getUniqueId() + ".backpack") != null) {
                                    openAdmin(target, p, plugin.getConfig().getInt("backpacks.players." + target.getUniqueId() + ".slots"));

                                } else {
                                    p.sendMessage(ChatColor.RED + "Player has never had a backpack.");
                                }

                            } else if (plugin.getConfig().get("backpacks.players." + Bukkit.getOfflinePlayer(args[0]).getUniqueId() + ".backpack") != null) {
                                OfflinePlayer pl = Bukkit.getOfflinePlayer(args[0]);
                                openOfflineAdmin(pl, p, plugin.getConfig().getInt("backpacks.players." + pl.getUniqueId() + ".slots"));
                            } else {
                                p.sendMessage(ChatColor.RED + "Player doesn't exist");
                            }

                        }

                    }
                    //args length

                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("nopermission")));
                }
                //permission


            } else {
                sender.sendMessage("Players only!");
            }
        }
        return true;
    }


}
