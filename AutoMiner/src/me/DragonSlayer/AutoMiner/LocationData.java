/**
 * Plugin made for CryptoMC by DragonSlayer
 * All Rights reserved
 * Inquired contact Zach#2129 on discord
 **/

package me.DragonSlayer.AutoMiner;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class LocationData {

    private Location location;

    public LocationData(Location location) {
        this.location = location;
    }

    public String convertToString() {
        String locationData = location.getWorld().getName() + ", " + String.valueOf(location.getX()) + ", " + String.valueOf(location.getY()) + ", " + String.valueOf(location.getZ());

        return locationData;
    }

    public static LocationData convertFromString(String locationData) {
        locationData = locationData.replaceAll("\\s", "");
        String[] locationArray = locationData.split(",");
        String locationWorldName = locationArray[0];
        double locX = Double.parseDouble(locationArray[1]);
        double locY = Double.parseDouble(locationArray[2]);
        double locZ = Double.parseDouble(locationArray[3]);

        return new LocationData(new Location(Bukkit.getWorld(locationWorldName), locX, locY, locZ));
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location l) {
        this.location = l;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.convertToString().equalsIgnoreCase(((LocationData) obj).convertToString())) {
            return true;
        }
        return false;
    }
}