import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PermissionCommand implements CommandExecutor {

    Main plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("timedperm")) {
            if (args.length == 3) {
                if (sender.hasPermission("timedperm.admin")) {
                    String[] times = args[2].split(":");
                    long add = 0;
                    for(String time : times) {
                        if(time.contains("m")) {
                            add += 2592000000L * Integer.valueOf(time.split("m")[0]);
                        } else if(time.contains("d")) {
                            add += 86400000L * Integer.valueOf(time.split("d")[0]);
                        } else if(time.contains("min")) {
                            add+=  60000L * Integer.valueOf(time.split("min")[0]);
                        } else if(time.contains("s")){
                            add += 1000L * Integer.valueOf(time.split("s")[0]);
                        }
                        Main.getPermissions().playerAdd(Bukkit.getPlayer(args[0]), args[1]);
                        plugin.getConfig().set("timedperms." , System.currentTimeMillis() + add);
                    }
                }
            }
        }
        return true;
    }
}
