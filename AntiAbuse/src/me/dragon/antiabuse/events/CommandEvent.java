package me.dragon.antiabuse.events;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.Selection;
import me.dragon.antiabuse.Main;
import me.dragon.antiabuse.MyLogger;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandEvent implements Listener {
    Main plugin;

    public CommandEvent(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        if(Main.getStaff().containsKey(e.getPlayer().getName())) {
            if(e.getMessage().contains("//") || e.getMessage().contains("/undo") || e.getMessage().contains("/redo")) {
                WorldEditPlugin worldEdit = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
                Selection selection = worldEdit.getSelection(e.getPlayer());
                if(selection !=  null) {
                    MyLogger.logWorldEdit(e.getPlayer(), e.getMessage(), selection);
                } else {
                    MyLogger.logWorldEditCommand(egetPlayer(), e.getMessage());
                }
                return;
            }
            MyLogger.logCommand(e.getPlayer().getName(), e.getMessage());
        }
    }

}
