package VoidClass.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitScheduler;


public class onJoin implements Listener {
    Main plugin;

    public onJoin(Main pl) {
        this.plugin = pl;
    }

    private String time(long seconds, Player p) {
        long time = plugin.getConfig().getLong("players." + p.getUniqueId() + ".time");
        String alltime = ChatColor.DARK_GREEN + "";
        int remainder;
        int days = 0;
        int hours = 0;
        int minutes = 0;
        if (time >= 86400) {
            days = (int) (time / 86400);
            time = time - 86400 * days;
            alltime += ChatColor.GREEN + String.valueOf(days) + " Days, ";
        }
        if (time >= 3600) {
            hours = (int) (time / 3600);
            time = time - 3600 * hours;
            alltime += ChatColor.GREEN + String.valueOf(hours) + " Hours, ";
        }
        if (time >= 60) {
            minutes = (int) (time / 60);
            time = time - 60 * minutes;
            alltime += ChatColor.GREEN + String.valueOf(minutes) + " Minutes, ";
        }
        alltime += ChatColor.GREEN + String.valueOf(time + " Seconds");
        return alltime;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (Main.started) {
            Main.started = false;
            BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
            scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
                @Override
                public void run() {
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        if (plugin.getConfig().get("players." + pl.getUniqueId() + ".time") != null) {
                            long num = plugin.getConfig().getLong("players." + pl.getUniqueId() + ".time");
                            int wnum = plugin.getConfig().getInt("players." + pl.getUniqueId() + ".wtime");
                            num += 1;
                            wnum += 1;
                            plugin.getConfig().set("players." + pl.getUniqueId() + ".time", num);
                            plugin.getConfig().set("players." + pl.getUniqueId() + ".wtime", wnum);
                            plugin.saveConfig();
                            if (plugin.getConfig().getInt("players." + pl.getUniqueId() + ".wtime") >= 43200) {

                                if (plugin.getConfig().getString("players." + pl.getUniqueId() + ".class") == "E") {

                                    int hnum = plugin.getConfig().getInt("players." + pl.getUniqueId() + ".hearts");
                                    if (hnum == 10) {
                                        plugin.getConfig().set("players." + pl.getUniqueId() + ".wtime", 0);
                                        plugin.saveConfig();

                                    } else {
                                        hnum += 1;
                                        plugin.getConfig().set("players." + pl.getUniqueId() + ".hearts", hnum);
                                        plugin.getConfig().set("players." + pl.getUniqueId() + ".wtime", 0);

                                        plugin.saveConfig();
                                        pl.setMaxHealth(20 + hnum);
                                    }
                                } else if (plugin.getConfig().getString("players." + pl.getUniqueId() + ".class") == "V") {

                                    int dnum = plugin.getConfig().getInt("players." + pl.getUniqueId() + ".damage");
                                    if (dnum >= 1.35) {
                                        plugin.getConfig().set("players." + pl.getUniqueId() + ".wtime", 0);
                                        plugin.saveConfig();
                                    } else {
                                        plugin.getConfig().set("players." + pl.getUniqueId() + ".wtime", 0);
                                        dnum += .05;
                                        plugin.getConfig().set("players." + pl.getUniqueId() + ".damage", dnum);
                                        plugin.saveConfig();
                                    }
                                }
                            }
                        }
                    }
                }
            }, 20L, 20L);

            BukkitScheduler scheduler1 = Bukkit.getServer().getScheduler();
            scheduler1.scheduleSyncRepeatingTask(plugin, new Runnable() {
                @Override
                public void run() {
                    for (Player pl : Bukkit.getOnlinePlayers()) {

                        long mynum = plugin.getConfig().getLong("players." + pl.getUniqueId() + ".time");
                        Object num11 = plugin.getConfig().get("time.top.1.time");
                        if (num11 == null) {
                            plugin.getConfig().set("time.top.1.time", 10);
                            plugin.getConfig().set("time.top.2.time", 10);
                            plugin.getConfig().set("time.top.3.time", 10);
                            plugin.getConfig().set("time.top.4.time", 10);
                            plugin.getConfig().set("time.top.5.time", 10);
                            plugin.getConfig().set("time.top.6.time", 10);
                            plugin.getConfig().set("time.top.7.time", 10);
                            plugin.getConfig().set("time.top.8.time", 10);
                            plugin.getConfig().set("time.top.9.time", 10);
                            plugin.getConfig().set("time.top.10.time", 10);
                            plugin.saveConfig();

                        } else {
                            long num1 = plugin.getConfig().getLong("time.top.1.time");
                            long num2 = plugin.getConfig().getLong("time.top.2.time");
                            long num3 = plugin.getConfig().getLong("time.top.3.time");
                            long num4 = plugin.getConfig().getLong("time.top.4.time");
                            long num5 = plugin.getConfig().getLong("time.top.5.time");
                            long num6 = plugin.getConfig().getLong("time.top.6.time");
                            long num7 = plugin.getConfig().getLong("time.top.7.time");
                            long num8 = plugin.getConfig().getLong("time.top.8.time");
                            long num9 = plugin.getConfig().getLong("time.top.9.time");
                            long num10 = plugin.getConfig().getLong("time.top.10.time");
                            String name1 = plugin.getConfig().getString("time.top.1.player");
                            String name2 = plugin.getConfig().getString("time.top.2.player");
                            String name3 = plugin.getConfig().getString("time.top.3.player");
                            String name4 = plugin.getConfig().getString("time.top.4.player");
                            String name5 = plugin.getConfig().getString("time.top.5.player");
                            String name6 = plugin.getConfig().getString("time.top.6.player");
                            String name7 = plugin.getConfig().getString("time.top.7.player");
                            String name8 = plugin.getConfig().getString("time.top.8.player");
                            String name9 = plugin.getConfig().getString("time.top.9.player");
                            String name10 = plugin.getConfig().getString("time.top.10.player");

                            if (num1 <= mynum) {
                                plugin.getConfig().set("time.top.1.player", pl.getName());
                                plugin.getConfig().set("time.top.1.time", mynum);
                                plugin.saveConfig();
                            } else if (num2 <= mynum) {
                                plugin.getConfig().set("time.top.2.player", pl.getName());
                                plugin.getConfig().set("time.top.2.time", mynum);
                                plugin.saveConfig();
                            } else if (num3 <= mynum) {
                                plugin.getConfig().set("time.top.3.player", pl.getName());
                                plugin.getConfig().set("time.top.3.time", mynum);
                                plugin.saveConfig();
                            } else if (num4 <= mynum) {
                                plugin.getConfig().set("time.top.4.player", pl.getName());
                                plugin.getConfig().set("time.top.4.time", mynum);
                                plugin.saveConfig();
                            } else if (num5 <= mynum) {
                                plugin.getConfig().set("time.top.5.player", pl.getName());
                                plugin.getConfig().set("time.top.5.time", mynum);
                                plugin.saveConfig();
                            } else if (num6 <= mynum) {
                                plugin.getConfig().set("time.top.6.player", pl.getName());
                                plugin.getConfig().set("time.top.6.time", mynum);
                                plugin.saveConfig();
                            } else if (num7 <= mynum) {
                                plugin.getConfig().set("time.top.7.player", pl.getName());
                                plugin.getConfig().set("time.top.7.time", mynum);
                                plugin.saveConfig();

                            } else if (num8 <= mynum) {
                                plugin.getConfig().set("time.top.8.player", pl.getName());
                                plugin.getConfig().set("time.top.8.time", mynum);
                                plugin.saveConfig();
                            } else if (num9 <= mynum) {
                                plugin.getConfig().set("time.top.9.player", pl.getName());
                                plugin.getConfig().set("time.top.9.time", mynum);
                                plugin.saveConfig();

                            } else if (num10 <= mynum) {
                                plugin.getConfig().set("time.top.10.player", pl.getName());
                                plugin.getConfig().set("time.top.10.time", mynum);
                                plugin.saveConfig();


                            }

                        }


                    }
                }


            }, 1000L, 1000L);


            Player p = e.getPlayer();
            if (p.getMaxHealth() <= 16) {
                p.setMaxHealth(18);
            }
			  /*String Conq = ChatColor.GOLD + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Conqueror" + ChatColor.YELLOW + " Side";
				 String yield = ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Yielder" + ChatColor.YELLOW + " Side";
				 String hab = ChatColor.WHITE + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Habitant" + ChatColor.YELLOW + " Side";
				 String S1 = replaceColors("&6The heroes of the dimensions, winners");
				 String S1r = replaceColors("&6of the conquest. They have conquered");
				 String S2 = replaceColors("&6All the dimensions. Will it be another win?");
				 String S3 = replaceColors("&a+2 hearts");
				 String S4 = replaceColors("&c-8% damage");
    			 String S5 = replaceColors("&aYour hearts increase by &c.5 &aevery 12 hours you play");
				 String space = "";
				 String S6 = replaceColors("&5The Yielders are the failures in the dimensions.");
				 String S6r = replaceColors("&5This species hate the Conquerors and their fame and might");
				 String S7 = replaceColors("&5They are the most aggressive species in all the dimensions. ");
				 String S8 = replaceColors("&5They must stop the Conquerors, is it their time now?");
				 String S9 = replaceColors("&a+10% damage");
				 String S10 = replaceColors("&c-1 heart");
				 String S11 = replaceColors("&aYour damage increases by &e.05% &aevery 12 hours you play");
			 if(plugin.getConfig().getString("players." + p.getUniqueId() + ".class") == null) {
			 
				 
				 Inventory inv = Bukkit.createInventory(null, 27, "Choose Your Side");
				 ItemStack sword = new ItemStack(Material.DIAMOND_CHESTPLATE);
				 ItemStack bone = new ItemStack(Material.BONE);
				 ItemMeta swordm = sword.getItemMeta();
				 swordm.setDisplayName(Conq);
				ArrayList<String> sl = new ArrayList<String>();
				
				 sl.add(S1);
				 sl.add(S1r);
				 sl.add(S2);
				 sl.add(space);
				 sl.add(S3);
				 sl.add(S4);
				 sl.add(space);
				 sl.add(S5); 
				 swordm.setLore(sl);
				 sword.setItemMeta(swordm);
				 ItemMeta bonem = bone.getItemMeta();
				 bonem.setDisplayName(yield);
				 ArrayList<String> nl = new ArrayList<String>();
				 nl.add(S6);
				 nl.add(S6r);
				 nl.add(S7);
				 nl.add(S8);
				 nl.add(space);
				 nl.add(S9);
				 nl.add(space); 
				 nl.add(S10);
				 
				 nl.add(space);
				 nl.add(S11);
				 bonem.setLore(nl);
				 bone.setItemMeta(bonem);
				 ItemStack apple = new ItemStack(Material.APPLE);
				 ItemMeta applem = apple.getItemMeta();
				 applem.setDisplayName(hab);
				 ArrayList<String> al = new ArrayList<String>();
				 al.add(ChatColor.GRAY + "Habitant gets no boosts");
				 al.add(ChatColor.GRAY + "It is neutral and gets nothing special");
				 al.add(ChatColor.GRAY + "You may change using /choose with this class");
				 al.add("");
				 al.add(ChatColor.GRAY + "You also do not gain time with this class.");
				 applem.setLore(al);
				 apple.setItemMeta(applem);
				inv.setItem(10, sword);
				inv.setItem(16, bone);
				inv.setItem(13, apple);
				 
				
				 p.sendMessage(ChatColor.RED + "Choose a class, place your cursor over each class for more information.");
				 
				
				BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
			     scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
			         @Override
			         public void run() {
			        	 p.openInventory(inv);
			        	 plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
			        	 
			         }
			     }, 15L);
			     
				
			 } */


        }
    }
}