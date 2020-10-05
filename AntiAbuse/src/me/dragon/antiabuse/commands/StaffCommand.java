package me.dragon.antiabuse.commands;

import me.dragon.antiabuse.Main;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StaffCommand implements CommandExecutor {

    Main plugin;

    public StaffCommand(Main plugin) {
        this.plugin = plugin;
    }


    private String m(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    private void msgOps(boolean bool, Player player, String rank) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.hasPermission("antiabuse.see")) {
                if (bool) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&c&lStaff Duty -> &b" + player.getName() + " &4is now on duty with rank &c" + rank + "&4!"));
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&c&lStaff Duty -> &b" + player.getName() + " &4is now off duty with rank &c" + rank + "&4!"));
                }
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("antiabuse.onduty")) {
            Player p = (Player) sender;
            String rank;
            File data = new File(plugin.getDataFolder() + "/staff/", p.getName() + ".txt");
            if ((rank = plugin.getConfig().getString("players." + p.getUniqueId() + ".rank")) != null) {
                if (!Main.getPermissions().playerInGroup(p, rank)) {
                    Main.getPermissions().playerAddGroup(null, p, rank);
                    p.sendMessage(m("&c&lStaff Duty -> &b" + "You are now on duty!  Everything you do will be logged!"));
                    msgOps(true, p, rank);
                    try {
                        Main.getStaff().put(p.getName(), new PrintWriter(new BufferedWriter(new FileWriter(data, true))));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    plugin.getConfig().set("players."+p.getUniqueId() + ".world", p.getLocation().getWorld().getName());
                    plugin.getConfig().set("players."+p.getUniqueId() + ".x", p.getLocation().getX());
                    plugin.getConfig().set("players."+p.getUniqueId() + ".y", p.getLocation().getY());
                    plugin.getConfig().set("players."+p.getUniqueId() + ".z", p.getLocation().getZ());
                    plugin.saveConfig();
                    ItemStack[] items = p.getInventory().getContents();
                    List<ItemStack> item = new ArrayList<ItemStack>();
                    for (int i = 0; i < items.length; i++) {
                        if (items[i] instanceof ItemStack) {
                            item.add(items[i]);
                        } else {
                            ItemStack air = new ItemStack(Material.AIR);
                            item.add(air);
                        }
                    }
                    plugin.getConfig().set("players."+p.getUniqueId() + ".inventory", item);
                    plugin.saveConfig();
                    p.getInventory().clear();
                } else {
                    p.getInventory().clear();
                    List<ItemStack> a = new ArrayList<>();
                    a = (List<ItemStack>) plugin.getConfig().get("players." + p.getUniqueId() + ".inventory");
                    if(a != null) {
                        for (int i = 0; i < a.size(); i++) {
                            p.getInventory().setItem(i, a.get(i));
                        }
                    }
                    p.teleport(new Location(Bukkit.getWorld(plugin.getConfig().getString("players."+p.getUniqueId() + ".world")),
                            plugin.getConfig().getDouble("players."+p.getUniqueId() + ".x"),
                            plugin.getConfig().getDouble("players."+p.getUniqueId() + ".y"),
                            plugin.getConfig().getDouble("players."+p.getUniqueId() + ".z")));
                    p.setGameMode(GameMode.SURVIVAL);
                    Main.getPermissions().playerRemoveGroup(null, p, rank);
                    p.sendMessage(m("&c&lStaff Duty -> &b" + "You are now off duty!  Only some things will be logged!"));
                    msgOps(false, p, rank);
                    Main.getStaff().remove(p.getName());
                }
            } else {
                p.sendMessage(m("&cYou have not been set to a rank."));
            }
        } else {
            sender.sendMessage(m("You are not staff!"));
        }
        return true;
    }
}
