package VoidClass.Main;

import com.massivecraft.factions.Rel;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.flags.StateFlag.State;
import com.sk89q.worldguard.protection.managers.RegionManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;


public class Abilities implements Listener {
    Main plugin;

    public static String getCardinalDirection(Player player) {
        double rot = (player.getEyeLocation().getYaw() - 90) % 360;
        if (rot < 0) {
            rot += 360.0;
        }
        return getDirection(rot);
    }

    /**
     * Converts a rotation to a cardinal direction name.
     *
     * @param rot
     * @return
     */
    private static String getDirection(double rot) {
        if (0 <= rot && rot < 22.5) {
            return "RWest";
        } else if (22.5 <= rot && rot < 67.5) {
            return "RNorthwest";
        } else if (67.5 <= rot && rot < 112.5) {
            return "RNorth";
        } else if (112.5 <= rot && rot < 157.5) {
            return "RNortheast";
        } else if (157.5 <= rot && rot < 202.5) {
            return "REast";
        } else if (202.5 <= rot && rot < 247.5) {
            return "RSouthEast";
        } else if (247.5 <= rot && rot < 292.5) {
            return "RSouth";
        } else if (292.5 <= rot && rot < 337.5) {
            return "RSouthwest";
        } else if (337.5 <= rot && rot < 360.0) {
            return "RWest";
        } else {
            return null;
        }
    }

    public Abilities(Main pl) {
        this.plugin = pl;
    }

    WorldGuardPlugin plugin1 = WGBukkit.getPlugin();

    @EventHandler
    public void Fight(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            Player p = (Player) e.getDamager();
            Player pl = (Player) e.getEntity();

            PotionEffect effect = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 400, 1);
            PotionEffect effect2 = new PotionEffect(PotionEffectType.SPEED, 200, 1);
            PotionEffect effect3 = new PotionEffect(PotionEffectType.WITHER, 100, 1);
            Random rand = new Random();
            int n = rand.nextInt(100) + 1;
            MPlayer fplayer = (MPlayer) p;
            MPlayer f2player = (MPlayer) pl;
            Faction pfaction = fplayer.getFaction();
            Location loca = new Location(null, 0, 0, 0);
            loca.setX(p.getLocation().getX());
            loca.setZ(p.getLocation().getZ());
            loca.setY(p.getLocation().getY());
            loca.setWorld(p.getWorld());
            if (!(pfaction.getRelationTo(f2player.getFaction()) == Rel.ALLY || pfaction.getOnlinePlayers().contains(pl))) {
                World world = p.getWorld();
                LocalPlayer localPlayer = plugin.worldGuard.wrapPlayer(p);
                RegionManager regionManager = plugin.worldGuard.getRegionManager(world);
                ApplicableRegionSet set = WGBukkit.getPlugin().getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation());
                if (set.queryState(null, DefaultFlag.PVP) == State.ALLOW) {


                    if (plugin.getConfig().getString("players." + p.getUniqueId() + ".class").equalsIgnoreCase("E")) {

                        if (n <= 35) {
                            effect.apply(p);
                            p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "STONE-SKIN");


                        }
                    } else if (plugin.getConfig().getString("players." + pl.getUniqueId() + ".class").equalsIgnoreCase("E")) {
                        if (n <= 5 && n >= 0) {
                            double damage = e.getFinalDamage();
                            pl.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "COUNTER-ATTACK");
                            e.setCancelled(true);
                            p.damage(damage);


                        }

                    } else if (plugin.getConfig().getString("players." + p.getUniqueId() + ".class").equalsIgnoreCase("V")) {
                        Random rand1 = new Random();
                        int n1 = rand1.nextInt(100) + 1;
                        if (n1 <= 25) {
                            effect2.apply(p);
                            effect3.apply(pl);
                            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "STAB");
                            Location loc = pl.getLocation();
                            String compass = getCardinalDirection(pl);


                            if (n1 <= 3 && n1 >= 0) {
                                if (compass == "RNorth") {
                                    double Z = loc.getZ() + 1;
                                    loc.setZ(Z);
                                    if (loc.getBlock().getType().equals(Material.AIR)) {
                                        p.teleport(loc);
                                        p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "BACKSTAB");
                                    }
                                } else if (compass == "RNorthwest") {
                                    double Z = loc.getZ() + 1;
                                    double X = loc.getX() - 1;
                                    loc.setZ(Z);
                                    loc.setX(X);
                                    if (loc.getBlock().getType().equals(Material.AIR)) {
                                        p.teleport(loc);
                                        p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "BACKSTAB");
                                    }
                                } else if (compass == "RWest") {
                                    double X = loc.getX() + 1;
                                    loc.setX(X);
                                    if (loc.getBlock().getType().equals(Material.AIR)) {
                                        p.teleport(loc);
                                        p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "BACKSTAB");
                                    }
                                } else if (compass == "RSouthwest") {
                                    double Z = loc.getZ() - 1;
                                    double X = loc.getX() + 1;
                                    loc.setZ(Z);
                                    loc.setX(X);
                                    if (loc.getBlock().getType().equals(Material.AIR)) {
                                        p.teleport(loc);
                                        p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "BACKSTAB");
                                    }

                                } else if (compass == "RSouth") {
                                    double Z = loc.getZ() - 1;
                                    loc.setZ(Z);
                                    if (loc.getBlock().getType().equals(Material.AIR)) {
                                        p.teleport(loc);
                                        p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "BACKSTAB");
                                    }

                                } else if (compass == "RSouthEast") {
                                    double Z = loc.getZ() - 1;
                                    double X = loc.getX() - 1;
                                    loc.setZ(Z);
                                    loc.setX(X);
                                    if (loc.getBlock().getType().equals(Material.AIR)) {
                                        p.teleport(loc);
                                        p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "BACKSTAB");
                                    }

                                } else if (compass == "REast") {
                                    double X = loc.getX() - 1;
                                    loc.setX(X);
                                    if (loc.getBlock().getType().equals(Material.AIR)) {
                                        p.teleport(loc);
                                        p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "BACKSTAB");
                                    }
                                } else if (compass == "RNortheast") {
                                    double Z = loc.getZ() + 1;
                                    double X = loc.getX() - 1;
                                    loc.setZ(Z);
                                    loc.setX(X);
                                    if (loc.getBlock().getType().equals(Material.AIR)) {
                                        p.teleport(loc);
                                        p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "BACKSTAB");
                                    }


                                } else {
                                    p.sendMessage(ChatColor.RED + "Can't teleport please contact administrator!");
                                }

                            }
                        }
                    }
                }


            }
        }
    }
}
		 
