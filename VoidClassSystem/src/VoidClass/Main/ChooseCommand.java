package VoidClass.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ChooseCommand implements CommandExecutor {

    private final Main plugin;

    private String replaceColors(String message) {
        return message.replaceAll("(?i)&([a-f0-9])", "\u00A7$1");
    }

    public ChooseCommand(Main instance) {
        plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player pl = (Player) sender;

        } else {
            ConsoleCommandSender pl = (ConsoleCommandSender) sender;
        }
        if (commandLabel.equalsIgnoreCase("Choose")) {
            if (args.length == 1 && sender instanceof Player) {

                String Conq = ChatColor.GOLD + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Conqueror"
                        + ChatColor.YELLOW + " Side";
                String yield = ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Yielder"
                        + ChatColor.YELLOW + " Side";
                String hab = ChatColor.WHITE + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Habitant"
                        + ChatColor.YELLOW + " Side";
                Player p = (Player) sender;

                if (args[0].equalsIgnoreCase("conqueror")) {

                    plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                    plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                    plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                    plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                    plugin.saveConfig();
                    p.setMaxHealth(24);
                    p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                            + " to fight on!");
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                            "Pex user " + p.getName() + " group set Explorer");

                    if (p.hasPermission("zeus.class")) {

                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                        plugin.saveConfig();
                        p.setMaxHealth(24);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set explorer6");

                    } else if (p.hasPermission("poseideon.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                        plugin.saveConfig();
                        p.setMaxHealth(24);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set explorer5");

                    } else if (p.hasPermission("hades.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                        plugin.saveConfig();
                        p.setMaxHealth(24);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set explorer4");

                    } else if (p.hasPermission("ares.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                        plugin.saveConfig();
                        p.setMaxHealth(24);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set explorer3");

                    } else if (p.hasPermission("hermes.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                        plugin.saveConfig();
                        p.setMaxHealth(24);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set explorer2");

                    } else if (p.hasPermission("helper.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                        plugin.saveConfig();
                        p.setMaxHealth(24);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set explorer7");

                    } else if (p.hasPermission("mod.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                        plugin.saveConfig();
                        p.setMaxHealth(24);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set explorer8");

                    } else if (p.hasPermission("admin.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                        plugin.saveConfig();
                        p.setMaxHealth(24);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set explorer9");

                    } else if (p.hasPermission("owner.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                        plugin.saveConfig();
                        p.setMaxHealth(24);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set explorer10");

                    } else if (p.hasPermission("developer.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                        plugin.saveConfig();
                        p.setMaxHealth(24);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set explorer11");

                    } else if (p.hasPermission("builder.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                        plugin.saveConfig();
                        p.setMaxHealth(24);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set explorer12");

                    } else {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                        plugin.saveConfig();
                        p.setMaxHealth(24);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set explorer");

                    }

                } else if (args[0].equalsIgnoreCase("Yielder")) {

                    if (p.hasPermission("zeus.class")) {

                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                        plugin.saveConfig();

                        p.setMaxHealth(18);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set voidler6");

                    } else if (p.hasPermission("poseideon.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                        plugin.saveConfig();

                        p.setMaxHealth(18);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set voidler5");

                    } else if (p.hasPermission("hades.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                        plugin.saveConfig();

                        p.setMaxHealth(18);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set voidler4");

                    } else if (p.hasPermission("ares.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                        plugin.saveConfig();

                        p.setMaxHealth(18);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set voidler3");

                    } else if (p.hasPermission("hermes.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                        plugin.saveConfig();

                        p.setMaxHealth(18);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set voidler2");

                    } else if (p.hasPermission("helper.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                        plugin.saveConfig();

                        p.setMaxHealth(18);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set voidler7");

                    } else if (p.hasPermission("mod.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                        plugin.saveConfig();

                        p.setMaxHealth(18);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set voidler8");

                    } else if (p.hasPermission("admin.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                        plugin.saveConfig();

                        p.setMaxHealth(18);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set voidler9");

                    } else if (p.hasPermission("owner.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                        plugin.saveConfig();

                        p.setMaxHealth(18);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set voidler10");

                    } else if (p.hasPermission("developer.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                        plugin.saveConfig();

                        p.setMaxHealth(18);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set voidler11");

                    } else if (p.hasPermission("builder.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                        plugin.saveConfig();

                        p.setMaxHealth(18);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set voidler12");

                    } else {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                        plugin.saveConfig();

                        p.setMaxHealth(18);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set voidler");

                    }

                } else if (args[0].equalsIgnoreCase("Habitant")) {
                    if (p.hasPermission("zeus.class")) {

                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                        plugin.saveConfig();

                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                + "Habitant " + ChatColor.YELLOW + "Side!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set habitant6");

                    } else if (p.hasPermission("poseideon.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                        plugin.saveConfig();

                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                + "Habitant " + ChatColor.YELLOW + "Side!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set habitant5");

                    } else if (p.hasPermission("hades.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                        plugin.saveConfig();
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                + "Habitant " + ChatColor.YELLOW + "Side!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set habitant4");

                    } else if (p.hasPermission("ares.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                        plugin.saveConfig();

                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                + "Habitant " + ChatColor.YELLOW + "Side!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set habitant3");

                    } else if (p.hasPermission("hermes.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                        plugin.saveConfig();

                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                + "Habitant " + ChatColor.YELLOW + "Side!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set habitant2");

                    } else if (p.hasPermission("helper.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                        plugin.saveConfig();

                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                + "Habitant " + ChatColor.YELLOW + "Side!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set habitant7");

                    } else if (p.hasPermission("mod.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                        plugin.saveConfig();

                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                + "Habitant " + ChatColor.YELLOW + "Side!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set habitant8");

                    } else if (p.hasPermission("admin.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                        plugin.saveConfig();

                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                + "Habitant " + ChatColor.YELLOW + "Side!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set habitant9");

                    } else if (p.hasPermission("owner.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                        plugin.saveConfig();

                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                + "Habitant " + ChatColor.YELLOW + "Side!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set habitant10");

                    } else if (p.hasPermission("developer.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                        plugin.saveConfig();

                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                + "Habitant " + ChatColor.YELLOW + "Side!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set habitant11");

                    } else if (p.hasPermission("builder.class")) {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                        plugin.saveConfig();

                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                + "Habitant " + ChatColor.YELLOW + "Side!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set habitant12");

                    } else {
                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                        plugin.saveConfig();

                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                + "Habitant " + ChatColor.YELLOW + "Side!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set habitant");

                    }

                } else {
                    p.sendMessage(ChatColor.RED + "Use /choose <class>");
                    p.sendMessage(ChatColor.RED + "Class are Conqueror, Yielder or Habitant.");
                }

            } else if (args.length == 2 && sender instanceof ConsoleCommandSender) {

                String Conq = ChatColor.GOLD + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Conqueror"
                        + ChatColor.YELLOW + " Side";
                String yield = ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Yielder"
                        + ChatColor.YELLOW + " Side";
                String hab = ChatColor.WHITE + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Habitant"
                        + ChatColor.YELLOW + " Side";
                Player p = Bukkit.getPlayer(args[1]);
                if (p.getName() != null) {
                    if (args[0].equalsIgnoreCase("conqueror")) {

                        plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                        plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                        plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                        plugin.saveConfig();
                        p.setMaxHealth(24);
                        p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                + " to fight on!");
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                "Pex user " + p.getName() + " group set Explorer");

                        if (p.hasPermission("zeus.class")) {

                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                            plugin.saveConfig();
                            p.setMaxHealth(24);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                    + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set explorer6");

                        } else if (p.hasPermission("poseideon.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                            plugin.saveConfig();
                            p.setMaxHealth(24);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                    + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set explorer5");

                        } else if (p.hasPermission("hades.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                            plugin.saveConfig();
                            p.setMaxHealth(24);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                    + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set explorer4");

                        } else if (p.hasPermission("ares.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                            plugin.saveConfig();
                            p.setMaxHealth(24);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                    + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set explorer3");

                        } else if (p.hasPermission("hermes.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                            plugin.saveConfig();
                            p.setMaxHealth(24);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                    + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set explorer2");

                        } else if (p.hasPermission("helper.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                            plugin.saveConfig();
                            p.setMaxHealth(24);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                    + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set explorer7");

                        } else if (p.hasPermission("mod.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                            plugin.saveConfig();
                            p.setMaxHealth(24);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                    + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set explorer8");

                        } else if (p.hasPermission("admin.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                            plugin.saveConfig();
                            p.setMaxHealth(24);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                    + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set explorer9");

                        } else if (p.hasPermission("owner.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                            plugin.saveConfig();
                            p.setMaxHealth(24);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                    + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set explorer10");

                        } else if (p.hasPermission("developer.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                            plugin.saveConfig();
                            p.setMaxHealth(24);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                    + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set explorer11");

                        } else if (p.hasPermission("builder.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                            plugin.saveConfig();
                            p.setMaxHealth(24);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                    + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set explorer12");

                        } else {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "E");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".hearts", 4);
                            plugin.saveConfig();
                            p.setMaxHealth(24);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + Conq + ChatColor.GREEN
                                    + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set explorer");

                        }

                    } else if (args[0].equalsIgnoreCase("Yielder")) {

                        if (p.hasPermission("zeus.class")) {

                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                            plugin.saveConfig();

                            p.setMaxHealth(18);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield
                                    + ChatColor.GREEN + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set voidler6");

                        } else if (p.hasPermission("poseideon.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                            plugin.saveConfig();

                            p.setMaxHealth(18);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield
                                    + ChatColor.GREEN + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set voidler5");

                        } else if (p.hasPermission("hades.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                            plugin.saveConfig();

                            p.setMaxHealth(18);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield
                                    + ChatColor.GREEN + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set voidler4");

                        } else if (p.hasPermission("ares.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                            plugin.saveConfig();

                            p.setMaxHealth(18);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield
                                    + ChatColor.GREEN + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set voidler3");

                        } else if (p.hasPermission("hermes.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                            plugin.saveConfig();

                            p.setMaxHealth(18);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield
                                    + ChatColor.GREEN + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set voidler2");

                        } else if (p.hasPermission("helper.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                            plugin.saveConfig();

                            p.setMaxHealth(18);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield
                                    + ChatColor.GREEN + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set voidler7");

                        } else if (p.hasPermission("mod.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                            plugin.saveConfig();

                            p.setMaxHealth(18);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield
                                    + ChatColor.GREEN + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set voidler8");

                        } else if (p.hasPermission("admin.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                            plugin.saveConfig();

                            p.setMaxHealth(18);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield
                                    + ChatColor.GREEN + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set voidler9");

                        } else if (p.hasPermission("owner.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                            plugin.saveConfig();

                            p.setMaxHealth(18);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield
                                    + ChatColor.GREEN + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set voidler10");

                        } else if (p.hasPermission("developer.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                            plugin.saveConfig();

                            p.setMaxHealth(18);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield
                                    + ChatColor.GREEN + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set voidler11");

                        } else if (p.hasPermission("builder.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                            plugin.saveConfig();

                            p.setMaxHealth(18);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield
                                    + ChatColor.GREEN + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set voidler12");

                        } else {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "V");
                            plugin.getConfig().set("players." + p.getUniqueId() + ".time", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".wtime", 0);
                            plugin.getConfig().set("players." + p.getUniqueId() + ".damage", 1.10);
                            plugin.saveConfig();

                            p.setMaxHealth(18);
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + yield
                                    + ChatColor.GREEN + " to fight on!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set voidler");

                        }

                    } else if (args[0].equalsIgnoreCase("Habitant")) {
                        if (p.hasPermission("zeus.class")) {

                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                            plugin.saveConfig();

                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                    + "Habitant " + ChatColor.YELLOW + "Side!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set habitant6");

                        } else if (p.hasPermission("poseideon.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                            plugin.saveConfig();

                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                    + "Habitant " + ChatColor.YELLOW + "Side!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set habitant5");

                        } else if (p.hasPermission("hades.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                            plugin.saveConfig();
                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                    + "Habitant " + ChatColor.YELLOW + "Side!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set habitant4");

                        } else if (p.hasPermission("ares.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                            plugin.saveConfig();

                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                    + "Habitant " + ChatColor.YELLOW + "Side!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set habitant3");

                        } else if (p.hasPermission("hermes.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                            plugin.saveConfig();

                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                    + "Habitant " + ChatColor.YELLOW + "Side!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set habitant2");

                        } else if (p.hasPermission("helper.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                            plugin.saveConfig();

                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                    + "Habitant " + ChatColor.YELLOW + "Side!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set habitant7");

                        } else if (p.hasPermission("mod.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                            plugin.saveConfig();

                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                    + "Habitant " + ChatColor.YELLOW + "Side!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set habitant8");

                        } else if (p.hasPermission("admin.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                            plugin.saveConfig();

                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                    + "Habitant " + ChatColor.YELLOW + "Side!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set habitant9");

                        } else if (p.hasPermission("owner.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                            plugin.saveConfig();

                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                    + "Habitant " + ChatColor.YELLOW + "Side!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set habitant10");

                        } else if (p.hasPermission("developer.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                            plugin.saveConfig();

                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                    + "Habitant " + ChatColor.YELLOW + "Side!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set habitant11");

                        } else if (p.hasPermission("builder.class")) {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                            plugin.saveConfig();

                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                    + "Habitant " + ChatColor.YELLOW + "Side!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set habitant12");

                        } else {
                            plugin.getConfig().set("players." + p.getUniqueId() + ".class", "H");
                            plugin.saveConfig();

                            p.sendMessage(ChatColor.GREEN + "You have successfully chosen the " + ChatColor.WHITE
                                    + "Habitant " + ChatColor.YELLOW + "Side!");
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                                    "Pex user " + p.getName() + " group set habitant");

                        }
                    }
                }
            }

        }
        return true;
    }
}
