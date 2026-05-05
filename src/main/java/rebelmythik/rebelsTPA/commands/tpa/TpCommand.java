package rebelmythik.rebelsTPA.commands.tpa;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import rebelmythik.rebelsTPA.RebelsTPA;
import rebelmythik.rebelsTPA.utils.TpaUtilities;

import java.util.ArrayList;
import java.util.List;

public class TpCommand implements CommandExecutor, TabCompleter {

    RebelsTPA rebelsTPA;
    public TpCommand(RebelsTPA plugin) {
        rebelsTPA = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!TpaUtilities.tpaConfig.getBoolean("tpa.enabled")) return false;
        if (!cmd.getName().equalsIgnoreCase("tp")) return false;
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;
        if (args.length == 1 ) {
            Player tpTarget = Bukkit.getPlayer(args[0]);

            if (tpTarget == null) {
                player.sendMessage("player not found");
                return true;
            }

            player.teleport(tpTarget.getLocation());
            player.sendMessage("teleported to " + tpTarget.getName());

        }

        if (args.length == 2) {
            // for tp player player
            Player tpTarget = Bukkit.getPlayer(args[0]);
            Player tpReciever = Bukkit.getPlayer(args[1]);

            if (tpTarget == null || tpReciever == null) {
                player.sendMessage("One or more players not found");
                return true;
            }

            tpTarget.teleport(tpReciever.getLocation());
            player.sendMessage("Teleported " + tpTarget.getName() + "to " + tpReciever.getName());

        }

        return true;

    }


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        List<String> list = new ArrayList<>();

        if (args.length == 1 || args.length == 2) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                list.add(p.getName());
            }
        }

        return list;
    }
}
