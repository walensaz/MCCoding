package me.dragon.test.Main;

import me.dragon.test.Events.InteractEvent;
import me.dragon.test.Events.InventoryClickEvent;
import me.dragon.test.Events.onPlace;
import me.dragon.test.GiveGeneratorCommand;
import me.dragon.test.Utils;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Main extends JavaPlugin  {

    public static String prefix;

    Main plugin;

    FileConfiguration data;

    public static int counter = 0;

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;
    private int maxcounter;

    public static HashMap<Player, Generator> ingui;

    public void onEnable() {
        maxcounter = 0;
        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        ingui = new HashMap<>();
        saveDefaultConfig();
        plugin = this;
        prefix = Utils.GenMessage(plugin.getConfig().getString("prefix"));
        this.data = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "data.yml"));
        this.getCommand("generator").setExecutor(new GiveGeneratorCommand(this));
        this.getServer().getPluginManager().registerEvents(new onPlace(this), this);
        this.getServer().getPluginManager().registerEvents(new InteractEvent(this), this);
        this.getServer().getPluginManager().registerEvents(new InventoryClickEvent(this), this);

        Map<String, Object> map = this.getConfig().getConfigurationSection("generatorintervals").getValues(false);

        for(Object o : map.values()) {
            if(maxcounter < (int) o) {
                maxcounter = (int) o;
            }
        }
        maxcounter = maxcounter / this.getConfig().getInt("interval");


        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
            ArrayList<String> list = (ArrayList<String>) data.getList("generators");
            if(list != null) {
                Main.counter++;
                for (String generator : list) {
                    Generator mygen = Generator.deserialize(generator);
                    if(mygen.getLocation().getBlock().getType() != Material.ENDER_PORTAL_FRAME) {
                        Generator.remove(this, mygen.getLocation(), null);
                        continue;
                    }
                    if (mygen.getTime(this) <= (Main.counter * this.getConfig().getInt("interval"))) {
                        mygen.generate(this);
                    }
                }
                if (Main.counter == maxcounter) {
                    Main.counter = 0;
                }
            }
        }, 180, this.getConfig().getInt("interval") * 20);
    }

    public void onDisable() { }

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

    public static Economy getEconomy() {
        return econ;
    }


    public FileConfiguration getData() {
        return data;
    }

    public void saveData() {
        try {
            data.save(new File(getDataFolder(), "data.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void openAcceptGUI(String message, Player p) {
        Inventory inventory = Bukkit.createInventory(null, 9, Utils.GenMessage("&aAccept GUI"));
        ItemStack yes = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);
        ItemMeta yesmeta = yes.getItemMeta();
        yesmeta.setDisplayName(Utils.GenMessage("&aAccept!"));
        yes.setItemMeta(yesmeta);
        ItemStack no = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)14);
        ItemMeta nometa = no.getItemMeta();
        nometa.setDisplayName(Utils.GenMessage("&cDeny!"));
        no.setItemMeta(nometa);
        ItemStack question = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta itemMeta = question.getItemMeta();
        itemMeta.setDisplayName(Utils.GenMessage(message));
        question.setItemMeta(itemMeta);
        inventory.setItem(1, yes);
        inventory.setItem(4, question);
        inventory.setItem(7, no);
        p.openInventory(inventory);
    }


}
