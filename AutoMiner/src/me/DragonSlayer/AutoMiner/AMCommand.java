/**
 * Plugin made for CryptoMC/words by DragonSlayer
 * All Rights reserved
 * Inquires contact Zach#2129 on discord
 **/

package me.DragonSlayer.AutoMiner;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class AMCommand implements CommandExecutor {

    Main plugin;

    public AMCommand(Main plugin) {
        this.plugin = plugin;
    }

    public String m(String s) {
        return ChatColor.translateAlternateColorCodes('&', "&6&lCrypto&e&lMC " + s);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("am")) {
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("about")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCrypto&e&lMC&e - Plugin made for CryptoMC/Words by DragonSlayer"));
                }
            }
            if (sender.hasPermission("autominer.admin")) {
                if (args.length == 3) {
                    if(args[0].equalsIgnoreCase("give")) {
                        ItemStack item = new ItemStack(Material.DISPENSER);
                        ItemMeta itemMeta = item.getItemMeta();
                        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',
                                plugin.getConfig().getString("autominername")));
                        ArrayList<String> list = (ArrayList) plugin.getConfig().getList("autominerlore");
                        for(int i = 0; i < list.size(); i++) {
                            list.set(i, ChatColor.translateAlternateColorCodes('&', list.get(i)));
                        }
                        itemMeta.setLore(list);
                        item.setItemMeta(itemMeta);
                        Player p;
                        if (Integer.valueOf(args[2]) != 1) {
                            if ((p = Bukkit.getPlayer(args[1])) != null) {
                                for (int i = 0; i < Integer.valueOf(args[2]); i++) {
                                    p.getInventory().addItem(item);
                                }
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCrypto&e&lMC &eYou have received " + args[2] + " autominer(s)!"));
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCrypto&e&lMC &eYou gave " + args[1] + " " + args[2] + " autominer(s)!"));
                            } else {
                                sender.sendMessage(m("&cPlayer not found!"));
                            }
                        } else {
                            if ((p = Bukkit.getPlayer(args[1])) != null) {
                                p.getInventory().addItem(item);
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCrypto&e&lMC &eYou have received 1 autominer(s)!"));
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCrypto&e&lMC &eYou gave 1 autominer(s)!"));
                            } else {
                                sender.sendMessage(m("&cPlayer not found!"));
                            }
                        }
                    } else {
                        sender.sendMessage(m("&cUse /AM give <Player> optional: <amount>"));
                    }
                } else {
                    sender.sendMessage(m("&cUse /AM give <Player> optional: <amount>"));
                }
            } else {
                sender.sendMessage(ChatColor.RED + "No Permissions");
            }
        }
        return true;
    }
}
