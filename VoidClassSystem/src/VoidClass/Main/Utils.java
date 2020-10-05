package VoidClass.Main;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Utils {
    Main plugin;


    //Gets the players class
    public String getClass(Player p) {
        String theclass = plugin.getConfig().getString("players." + p.getUniqueId() + ".class");
        return theclass;
    }

    //Gets players time
    public long getTime(Player p) {
        long time = plugin.getConfig().getLong("players." + p.getUniqueId() + ".time");
        return time;
    }

    //Checks if player has the group
    public boolean hasGroup(Player p, String group) {
        String[] groups = Main.getPermissions().getPlayerGroups(p);
        boolean groupyes = false;
        for (int i = 0; i == groups.length; i++) {
            if (groups[i].contains(group)) {
                i = group.length() + 1;
                groupyes = true;
            }
        }
        return groupyes;
    }

    public ItemStack createEnchantments(ItemStack item, List<Integer> level, List<org.bukkit.enchantments.Enchantment> enchant) {
        ItemStack testEnchant = item;
        ItemMeta testEnchantMeta = testEnchant.getItemMeta();
        for (int i = 0; i <= enchant.size() && i <= level.size(); i++) {
            testEnchantMeta.addEnchant(enchant.get(i), level.get(i), true);
        }
        testEnchant.setItemMeta(testEnchantMeta);
        return testEnchant;
    }


}
