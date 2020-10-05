package Fables.econ;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.plugins.Economy_Essentials;

public class Public {
	public static Economy economy;
	
	public void givemoney(String player, double amount) {
		Player p = Bukkit.getPlayer(player);
		if(p != null) {
			economy.bankDeposit(player.toString(), amount);
		} else if(economy.hasAccount(player)) {
			economy.bankDeposit(player.toString(), amount);
		}
			
		}
	
	
	
	public void takemoney(String player, double amount) {
		Player p = Bukkit.getPlayer(player);
		if(p != null) {
			if(economy.getBalance(player) >= amount) {
				economy.bankWithdraw(player, amount);
			}
		}else if(economy.hasAccount(player)) {
			if(economy.getBalance(player) >= amount) {
				economy.bankWithdraw(player, amount);
			}
		}
	}
	
	}


