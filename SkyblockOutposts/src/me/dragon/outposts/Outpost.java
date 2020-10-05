package me.dragon.outposts;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class Outpost {

    private double x, y, z;
    private int radius;
    private float percentage;
    private UUID leader;
    private List<UUID> members;

    public Outpost(double x, double y, double z, int radius) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
        this.percentage = 0;
        leader = null;
        members = null;
    }

    public boolean capture(SkyblockOutposts plugin, Player player) {
        if(percentage == 0) {
            leader = plugin.getaSkyBlockAPI().getTeamLeader(player.getUniqueId());
            members = plugin.getaSkyBlockAPI().getTeamMembers(player.getUniqueId());
            percentage++;
            return true;
        }
        if(canCapture(player)) {
            percentage += 0.4;
        }
        return true;
    }

    public boolean canCapture(Player player) {
        if(isInOutpost(player)) {
            if (player.getNearbyEntities(radius, radius, radius).size() > 1) {
                for (Entity entity : player.getNearbyEntities(radius, radius, radius)) {
                    if (entity instanceof Player) {
                        if (members.contains(entity.getUniqueId())) {
                            continue;
                        } else {
                            return false;
                        }
                    }
                }
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean isInOutpost(Player player) {
        if(player.getLocation().getZ() < z + radius && player.getLocation().getZ() > z - radius) {
            if (player.getLocation().getX() < x + radius && player.getLocation().getX() > x - radius) {
                if (player.getLocation().getY() < z + radius + 5 && player.getLocation().getZ() > z - radius + 5) {
                    return true;
                }
            }
        }
        return false;
    }


}
