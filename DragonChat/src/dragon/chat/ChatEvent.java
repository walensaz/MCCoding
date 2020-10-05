package dragon.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;

public class ChatEvent implements Listener {

    Main plugin;

    public ChatEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        String eventmessage = e.getMessage();
        if(eventmessage.toLowerCase().contains("discord")) {
            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("discord")));
        }
        if(eventmessage.toLowerCase().contains("website")) {
            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("website")));
        }
        if (!e.getPlayer().hasPermission("dragonchat")) {
            String regex = eventmessage.replaceAll("[a-zA-Z0-9]", "x").replace(',', '.');
            String[] ips = {"xxx", "xxxx", "xxxxx", "xxxxxx", "xxxxxxx", "xxxxxxxx", "xxxxxxxxx", "xxxxxxxxxxxx", "xxxxxxxxxxx", "xxxxxxxxxxxx"};
            String[] stylesf = {"xxxx.", "xxx.", "xx."};
            String[] stylesb = {".xxx", ".xx", ".xxxx"};
            boolean isAdvertising = false;
            if (regex.contains("xxx.xx.xx.xxx") || regex.contains("xxx.xx.xx.xxx:xxxxx")) {
                isAdvertising = true;
            }
            for (String ip : ips) {
                for (String styleb : stylesb) {
                    for (String stylef : stylesf) {
                        String check = stylef + ip + styleb;
                        if (regex.contains(check)) {
                            isAdvertising = true;
                        }
                    }
                    String check = ip + styleb;
                    if (regex.contains(check)) {
                        isAdvertising = true;
                    }
                }
            }
            if(Main.cooldown.containsKey(e.getPlayer())) {
                if(Main.cooldown.get(e.getPlayer()) > System.currentTimeMillis()) {
                    long seconds = (Main.cooldown.get(e.getPlayer()) - System.currentTimeMillis()) / 1000;
                    e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',
                            plugin.getConfig().getString("waitchatmessage").replace("{SECONDS}", String.valueOf(seconds))
                                    .replace("{PREFIX}", "&c&lDRAGONCHAT")));
                    e.setCancelled(true);
                    return;
                }
                Main.cooldown.remove(e.getPlayer());
            }
            if (isAdvertising) {
                for (Player op : Bukkit.getOnlinePlayers()) {
                    if (op.hasPermission("dragonchat.admin")) {
                        plugin.getLogger().info("" + ChatColor.GREEN + e.getPlayer().getName() + " might be trying to advertise.");
                        plugin.getLogger().info("" + ChatColor.RED + ChatColor.BOLD + "DRAGONCHAT " + ChatColor.GREEN + e.getPlayer().getName() + " - " + e.getMessage());
                        op.sendMessage("" + ChatColor.GREEN + e.getPlayer().getName() + " might be trying to advertise.");
                        op.sendMessage("" + ChatColor.RED + ChatColor.BOLD + "DRAGONCHAT " + ChatColor.GREEN + e.getPlayer().getName() + " - " + e.getMessage());
                    }
                }
                e.getPlayer().sendMessage("" + ChatColor.RED + "DO NOT ADVETISE!");
                e.setCancelled(true);
                return;
            }
            Main.cooldown.put(e.getPlayer(), System.currentTimeMillis() + plugin.getConfig().getInt("seconds") * 1000);
        }
        String newmessage = eventmessage.replace("[bal]", ChatColor.translateAlternateColorCodes('&', plugin.getEconomy().format(plugin.getEconomy().getBalance(e.getPlayer()))));
        e.setMessage(newmessage);
    }


}
