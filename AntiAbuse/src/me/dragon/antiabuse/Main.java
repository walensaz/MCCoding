package me.dragon.antiabuse;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Logger;

import me.dragon.antiabuse.commands.StaffCommand;
import me.dragon.antiabuse.commands.aSetRankCommand;
import me.dragon.antiabuse.events.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;


public class Main extends JavaPlugin {

    public static HashMap<String, PrintWriter> staff;

    public static ArrayList<Player> inChests;

    public Main plugin;
    public String prefix;
    public String version;

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;


    PluginManager pm = Bukkit.getPluginManager();

    public void onEnable() {
        if (!setupEconomy()) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        setupPermissions();
        setupChat();
        staff = new HashMap<>();
        this.saveDefaultConfig();
        plugin = this;
        File userfiles = new File(getDataFolder() + "/staff/");
        if (!userfiles.exists()) {
            userfiles.mkdirs();
        }

        pm.registerEvents(new BreakEvent(this), this);
        pm.registerEvents(new PlaceEvent(this), this);
        pm.registerEvents(new DropEvent(this), this);
        pm.registerEvents(new InventoryMoveEvent(this), this);
        pm.registerEvents(new CommandEvent(this), this);
        pm.registerEvents(new LeaveEvent(this), this);

        getCommand("asetrank").setExecutor(new aSetRankCommand(this));
        getCommand("onduty").setExecutor(new StaffCommand(this));
    }

    public void onDisable() {
        log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
        getLogger().info("|-----------------------------------------|");

    }


    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

    public static Permission getPermissions() {
        return perms;
    }

    public static Chat getChat() {
        return chat;
    }

    public static HashMap<String, PrintWriter> getStaff() {
        return staff;
    }

    public static ArrayList<Player> getInChests() { return inChests; }

}
