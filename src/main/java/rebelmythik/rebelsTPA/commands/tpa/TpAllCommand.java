package rebelmythik.rebelsTPA.commands.tpa;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import rebelmythik.rebelsTPA.RebelsTPA;
import rebelmythik.rebelsTPA.utils.TpaUtilities;

public class TpAllCommand implements CommandExecutor {

    RebelsTPA rebelsTPA;
    public TpAllCommand(RebelsTPA plugin) {
        rebelsTPA = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!TpaUtilities.tpaConfig.getBoolean("tpa.enabled")) return false;
        if (!cmd.getName().equalsIgnoreCase("tpall")) return false;
        if (!(sender instanceof Player)) return false;

        if(args.length == 1 && args[0].equalsIgnoreCase("here")) {

            Location senderLocation = ((Player) sender).getLocation();
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (!player.equals(sender)) {
                    player.teleport(senderLocation);
                }
            }

        }

        if(args.length == 3) {
            try {
                double x = Double.parseDouble(args[0]);
                double y = Double.parseDouble(args[1]);
                double z = Double.parseDouble(args[2]);

                World senderWorld = ((Player) sender).getWorld();
                if (senderWorld == null) {
                    sender.sendMessage(ChatColor.RED + "World is not found");
                    return true;
                }
                Location tpaLocation = new Location(senderWorld, x, y, z);

                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.teleport(tpaLocation);
                }

            } catch (NumberFormatException exception) {
                sender.sendMessage("Not valid coords");
                return true;
            }

        }

        if(args.length == 4) {
            try {
                double x = Double.parseDouble(args[0]);
                double y = Double.parseDouble(args[1]);
                double z = Double.parseDouble(args[2]);

                World specifiedWorld = Bukkit.getWorld(args[3]);

                if (specifiedWorld == null) {
                    sender.sendMessage(ChatColor.RED + "World is not found");
                    return true;
                }
                Location tpaLocation = new Location(specifiedWorld, x, y, z);

                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.teleport(tpaLocation);
                }

            } catch (NumberFormatException exception) {
                sender.sendMessage("Not valid coords");
                return true;
            }

        }
        return false;
    }
}
