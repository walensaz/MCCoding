package me.dragon.test.Main;

import me.dragon.test.Utils;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Dye;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;

public class Generator implements Serializable {

    static final long serialVersionUID = 420473L;

    Location location;
    int level;
    int generate;


    public Generator(Location location, int level) {
        this.location = location;
        this.level = level;
        generate = 0;
    }

    public int getTime(Main plugin) {
        return plugin.getConfig().getInt("generatorintervals.level" + level);
    }

    public void upgrade(Main plugin, Player p) {
        if(this.level <= 4) {
            this.level += 1;
            ArrayList<String> list = (ArrayList) plugin.getData().getList("generators") != null ?
                    (ArrayList) plugin.getData().getList("generators") : new ArrayList<>();
            Generator generatortoremove = null;
            if ((generatortoremove = getGeneratorAt(plugin, location)) != null) {
                list.remove(generatortoremove.serialize());
                list.add(new Generator(location, level).serialize());
                plugin.getData().set("generators", list);
                plugin.saveData();
                p.sendMessage(Utils.GenMessage(Main.prefix + plugin.getConfig().getString("upgradesuccessmessage").replace("%LEVEL%", String.valueOf(this.getLevel()))));
            }
        } else {
            p.sendMessage(Utils.GenMessage(Main.prefix + plugin.getConfig().getString("maxlevelmessage")));
        }
    }

    public void generate(Main plugin) {
        if(this.location.getChunk().isLoaded()) {
            int amount = plugin.getConfig().getInt("generatoramounts.level" + this.getLevel());
            int item = new Random().nextInt(8);
            ItemStack itemStack;
            switch (item) {
                case 1:
                    itemStack = new ItemStack(Material.EMERALD, amount);
                    break;
                case 2:
                    itemStack = new ItemStack(Material.REDSTONE, amount);
                    break;
                case 3:
                    itemStack = new ItemStack(Material.IRON_INGOT, amount);
                    break;
                case 4:
                    itemStack = new ItemStack(Material.DIAMOND, amount);
                    break;
                case 5:
                    itemStack = new ItemStack(Material.GOLD_INGOT, amount);
                    break;
                case 6:
                    Dye l = new Dye();
                    l.setColor(DyeColor.BLUE);
                    itemStack = l.toItemStack();
                    itemStack.setAmount(amount);
                    break;
                case 7:
                    itemStack = new ItemStack(Material.COAL, amount);
                    break;
                default:
                    itemStack = new ItemStack(Material.IRON_INGOT, amount);
                    break;
            }
            if (this.location.getBlock().getType() != Material.ENDER_PORTAL_FRAME) {
                Generator.remove(plugin, this.location, null);
            }
            this.location.getWorld().dropItem(this.location, itemStack);
        }
    }

    public int getLevel() {
        return level;
    }

    public Location getLocation() {
        return location;
    }

    public String serialize() {
        return "" + level +","+this.location.getWorld().getName()+","+this.location.getX()+","+this.location.getY()+","+this.location.getZ();
    }

    public static Generator deserialize(String serial) {
        String[] array = serial.split(",");
        return new Generator(new Location(Bukkit.getWorld(array[1]),Double.parseDouble(array[2]), Double.parseDouble(array[3]), Double.parseDouble(array[4])), Integer.parseInt(array[0]));
    }

    /*@Override
    public Map<String, Object> serialize() {
        Map<String, Object> data = new HashMap();
        data.put("Location", this.location);
        data.put("level", this.level);
        return data;
    }*/





    public void openupgradegui(Main plugin, Player p) {
        Inventory inventory = Bukkit.createInventory(null, 27, Utils.GenMessage("&bUpgrade Menu!"));
        ItemStack place = new ItemStack(Material.STAINED_GLASS_PANE);
        ItemMeta placemeta = place.getItemMeta();
        placemeta.setDisplayName("");
        place.setItemMeta(placemeta);
        for(int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, place);
        }
        ItemStack gen = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta genmeta = gen.getItemMeta();
        genmeta.setDisplayName(Utils.GenMessage(plugin.getConfig().getString("genname")));
        genmeta.setLore(Arrays.asList(Utils.GenMessage("&bLevel: " + this.level),
                Utils.GenMessage("&bTime: " + this.getTime(plugin) + " second(s)"),
                Utils.GenMessage("&bAmount dropped: " + plugin.getConfig().getInt("generatoramounts.level" + this.getLevel()))));
        gen.setItemMeta(genmeta);
        inventory.setItem(13, gen);

        ItemStack upgrade = new ItemStack(Material.NETHER_STAR);
        ItemMeta upgrademeta = upgrade.getItemMeta();
        upgrademeta.setDisplayName(Utils.GenMessage(plugin.getConfig().getString("upgradename")));
        upgrademeta.setLore(Arrays.asList(Utils.GenMessage("&bNext Level: " + (this.level + 1)),
                Utils.GenMessage("&bTime: " + plugin.getConfig().getInt("generatorintervals.level" + (level + 1)) + " second(s)"),
                Utils.GenMessage("&bAmount dropped: " + plugin.getConfig().getInt("generatoramounts.level" + (this.getLevel() + 1))),
                Utils.GenMessage("&bPrice: $" + plugin.getConfig().getInt("level"+((this.level < 5 ? this.level + 1 : 0))))));
        upgrade.setItemMeta(upgrademeta);
        inventory.setItem(16, upgrade);
        ItemStack destroy = new ItemStack(Material.WOOD_PICKAXE);
        ItemMeta destroymeta = destroy.getItemMeta();
        destroymeta.setDisplayName(Utils.GenMessage(plugin.getConfig().getString("destroyname")));
        destroymeta.setLore(Arrays.asList(Utils.GenMessage("&bThis will put the item back in your inventory"),
                Utils.GenMessage("&bBut next time you place it, it will be level 1.")));
        destroy.setItemMeta(destroymeta);
        inventory.setItem(10, destroy);
        p.openInventory(inventory);
    }




    public static void giveGenerator(Main plugin, Player p) {
        giveGenerator(plugin, p, (short)1);
    }

    public static void giveGenerator(Main plugin, Player p, short level) {
        ItemStack itemStack = new ItemStack(Material.ENDER_PORTAL_FRAME);
        itemStack.setType(Material.ENDER_PORTAL_FRAME);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(Utils.GenMessage(plugin.getConfig().getString("genname"))); //TODO: add to config and line 81
        ArrayList<String> list = new ArrayList<>();
        for (String string : Utils.getList(plugin, "genlore")) {
            list.add(string.replace("%LEVEL%", "1"));
        }
        itemMeta.setLore(list);
        itemStack.setItemMeta(itemMeta);
        p.getInventory().addItem(itemStack);
    }


    public static void add(Main plugin, Location location, int level) {
        ArrayList<String> list = (ArrayList) plugin.getData().getList("generators") != null ?
                (ArrayList) plugin.getData().getList("generators") : new ArrayList<>();
        list.add(new Generator(location, level).serialize());
        plugin.getData().set("generators", list);
        plugin.saveData();
    }

    public static boolean remove(Main plugin, Location location, Player p) {
        ArrayList<String> list = (ArrayList) plugin.getData().getList("generators") != null ?
                (ArrayList) plugin.getData().getList("generators") : new ArrayList<>();
        Generator generatortoremove = null;
        if((generatortoremove = getGeneratorAt(plugin, location)) != null) {
            list.remove(generatortoremove.serialize());
            plugin.getData().set("generators", list);
            plugin.saveData();
            location.getBlock().setType(Material.AIR);
            if(plugin.getConfig().getBoolean("logbreakingandplacing")) {
                plugin.getLogger().log(Level.INFO, "GENERATOR: Generator broken at " + location.toString() + " by " + p.getName() + " level: " + generatortoremove.level);
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (player.isOp() || player.hasPermission("gens.notify")) {
                        player.sendMessage(Utils.GenMessage("&c&lGenerator &cbroken at " + location.toString() + " by " + p.getName() + " level: " + generatortoremove.level));
                    }
                }
            }
            if(p == null) {
                return true;
            }
            giveGenerator(plugin, p, (short)generatortoremove.level);
            return true;
        }
        return false;
    }

    public static Generator getGeneratorAt(Main plugin, Location location) {
        ArrayList<String> list = (ArrayList) plugin.getData().getList("generators") != null ?
                (ArrayList) plugin.getData().getList("generators") : new ArrayList<>();
        Generator gen = null;
        for(String generator : list) {
            if(deserialize(generator).location.toString().equalsIgnoreCase(location.toString())) {
                gen = deserialize(generator);
                break;
            }
        }
        if(gen == null) {
            return null;
        }
        return gen;
    }

}
