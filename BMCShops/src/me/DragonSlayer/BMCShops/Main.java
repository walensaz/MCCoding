package me.DragonSlayer.BMCShops;

import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin {

	private static final Logger log = Logger.getLogger("Minecraft");
	private static Economy econ = null;
	private static Permission perms = null;
	private static Chat chat = null;

	public HashMap<Player, Boolean> setshop = new HashMap<Player, Boolean>();

	static Main plugin;

	public String prefix = ChatColor.translateAlternateColorCodes('&', "&7[&6BMCShops&7] ");

	PluginManager pm = Bukkit.getServer().getPluginManager();

	public void onEnable() {
		this.saveDefaultConfig();
		this.getCommand("ps").setExecutor(new ShopCommand(this));
		this.getCommand("setps").setExecutor(new SetShopCommand(this));
		this.getCommand("bmcshops").setExecutor(new BMCShopCommand(this));
		this.getCommand("pshops").setExecutor(new ShopsCommand(this));
		this.getCommand("psreset").setExecutor(new BMCResetAdvertCommand(this));

		pm.registerEvents(new InventoryClick(this), this);

		if (!setupEconomy()) {
			log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		setupPermissions();
		setupChat();

	}

	public void onDisable() {

		setshop.clear();
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
	
}
