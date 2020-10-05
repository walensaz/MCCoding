package me.dragon.antiabuse.events;

import me.dragon.antiabuse.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {

    Main plugin;

    public LeaveEvent(Main plugin) {
        this.plugin = plugin;
    }

    private String m(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    private void msgOps(Player player, String rank) {
        for(Player p : Bukkit.getOnlinePlayers()) {
            if(p.hasPermission("antiabuse.see")) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&c&lStaff Duty -> &b" + player.getName() + " &4is now on duty&4!"));
            }
        }
    }


    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        if(Main.getStaff().containsKey(e.getPlayer().getName())) {
            String rank = plugin.getConfig().getString("players."+e.getPlayer().getUniqueId() +".rank");
            Main.getStaff().remove(e.getPlayer().getName());
            Main.getPermissions().playerRemoveGroup(null, e.getPlayer(), rank);
            e.getPlayer().teleport(new Location(Bukkit.getWorld(plugin.getConfig().getString("players."+e.getPlayer().getUniqueId() + ".world")),
                    plugin.getConfig().getDouble("players."+e.getPlayer().getUniqueId() + ".x"),
                    plugin.getConfig().getDouble("players."+e.getPlayer().getUniqueId() + ".y"),
                    plugin.getConfig().getDouble("players."+e.getPlayer().getUniqueId() + ".z")));
            e.getPlayer().setGameMode(GameMode.SURVIVAL);
            msgOps(e.getPlayer(), rank);
        }
    }

}
