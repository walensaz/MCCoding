package VoidClass.Main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;


public class Fight implements Listener {
    Main plugin;

    public Fight(Main pl) {
        this.plugin = pl;
    }


    @EventHandler
    public void Fight(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player p = (Player) e.getDamager();
            ItemStack DAxe = new ItemStack(Material.DIAMOND_AXE);
            ItemStack GAxe = new ItemStack(Material.GOLD_AXE);
            ItemStack IAxe = new ItemStack(Material.IRON_AXE);
            ItemStack WAxe = new ItemStack(Material.WOOD_AXE);

            if (plugin.getConfig().getString("players." + e.getDamager().getUniqueId() + ".rank") == "V") {
                if (p.getItemInHand() == DAxe || p.getItemInHand() == WAxe || p.getItemInHand() == IAxe || p.getItemInHand() == GAxe) {
                    double dmodifier = plugin.getConfig().getDouble("players." + p.getUniqueId() + ".damage");
                    double damaged = e.getDamage();
                    dmodifier -= .10;
                    //Supply amount of damage
                    e.setCancelled(true);
                    e.setDamage((double) damaged * dmodifier);
                } else {
                    double dmodifier = plugin.getConfig().getDouble("players." + p.getUniqueId() + ".damage");
                    double damaged = e.getDamage();
                    //Supply amount of damage
                    e.setCancelled(true);
                    e.setDamage((double) damaged + dmodifier);
                }
            } else if (plugin.getConfig().getString("players." + e.getDamager().getUniqueId() + ".rank") == "E") {
                double dmodifier = .92;
                double damaged = e.getDamage();
                //Supply amount of damage
                e.setCancelled(true);
                e.setDamage((double) damaged * dmodifier);

            }
        }
    }


}
