package rebelmythik.rebelsTPA.commands.tpa;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import rebelmythik.rebelsTPA.RebelsTPA;
import rebelmythik.rebelsTPA.utils.TpaUtilities;

public class TpaCommand implements CommandExecutor {
    RebelsTPA rebelsTPA;
    public TpaCommand(RebelsTPA plugin) {
        rebelsTPA = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!cmd.getName().equalsIgnoreCase("tpa")) return false;
        if (!TpaUtilities.tpaConfig.getBoolean("tpa.enabled")) return false;
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        if (args.length > 0) {
            String firstArg = args[0];
            Player target = Bukkit.getPlayer(firstArg);

            if (target == null || !target.isOnline()) {
                player.sendMessage(ChatColor.RED + "Not a person");
                return false;
            }
            // Command has been run properly, time to rock
            player.teleport(target.getLocation());


            //
        } else {
            sender.sendMessage(ChatColor.RED + "Usage: /tpa <player>");
        }

        return false;
    }

}
