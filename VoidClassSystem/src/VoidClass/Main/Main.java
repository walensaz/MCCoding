//Copyright � Zachary Walensa 2017


package VoidClass.Main;

import com.massivecraft.factions.Factions;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Server;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin implements Listener {

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;
    public WorldGuardPlugin worldGuard = null;
    public Factions factions = null;

    private static Main plugin;
    public static boolean started;


    static Main instance;

    public Main() {
        instance = this;
    }

    public static Main instance() {
        return instance;
    }

    Server server = getServer();
    PluginManager pm = server.getPluginManager();

    public void onEnable() {
        //Vault
        if (!setupEconomy()) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        setupPermissions();
        setupChat();
        worldGuard = (WorldGuardPlugin) loadPlugin("worldGuard");
        factions = (Factions) loadPlugin("Factions");
        plugin = this;
        started = true;

        getLogger().info("|----------------------------------------|");

        //Events
        pm.registerEvents(this, this);
        pm.registerEvents(new onJoin(this), this);
        //pm.registerEvents(new InventoryClick(this), this);
        pm.registerEvents(new Fight(this), this);
        pm.registerEvents(new Abilities(this), this);
        //pm.registerEvents(new PlayerLogin(this), this);

        //Commands
        getCommand("time").setExecutor(new Time(this));
        getCommand("Choose").setExecutor(new ChooseCommand(this));
        getCommand("Settime").setExecutor(new SetTime(this));
//getCommand("clearchat").setExecutor(new CommandClearChat(this));

        saveDefaultConfig();
    }

    public void onDisable() {
        log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
        getLogger().info("|-----------------------------------------|");

    }

    public static Main getInstance() {
        return plugin;
    }

    //Vault Methods
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

    public static Economy getEcononomy() {
        return econ;
    }

    public static Permission getPermissions() {
        return perms;
    }

    public static Chat getChat() {
        return chat;
    }

    private Plugin loadPlugin(String pluginName) {
        Plugin plugin = getServer().getPluginManager().getPlugin(pluginName);
        if (plugin == null) {
            return null;
        }
        return plugin;
    }

}