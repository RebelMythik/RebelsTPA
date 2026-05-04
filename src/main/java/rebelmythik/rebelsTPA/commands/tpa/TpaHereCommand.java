package rebelmythik.rebelsTPA.commands.tpa;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import rebelmythik.rebelsTPA.RebelsTPA;

public class TpaHereCommand implements CommandExecutor {
    RebelsTPA rebelsTPA;
    public TpaHereCommand(RebelsTPA plugin) {
        rebelsTPA = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        return false;
    }
}
