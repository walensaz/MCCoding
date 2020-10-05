package Fables.chat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

import Fables.chat.Name;
import Fables.core.Main;

public class Scoreboard {
	static Main plugin;

	private static org.bukkit.scoreboard.Scoreboard s = Bukkit.getScoreboardManager().getMainScoreboard();
	
	private static String getCustom(String string) {
		String name = plugin.getConfig().getString("names." + string);
		return name;
	}
	
	public static void registerHealthBar() {
		
		//Objective o = s.registerNewObjective("Health", "Health");
		
		Objective o = s.registerNewObjective("Name", "Name");
		String a = getCustom(o.getName());
		o.setDisplayName(a);
		o.setDisplaySlot(DisplaySlot.BELOW_NAME);
	}
	
	
	
}
