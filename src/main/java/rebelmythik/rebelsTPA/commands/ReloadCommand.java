package rebelmythik.rebelsTPA.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import rebelmythik.rebelsTPA.RebelsTPA;
import rebelmythik.rebelsTPA.utils.TpaUtilities;

public class ReloadCommand implements CommandExecutor {
    RebelsTPA plugin;

    public ReloadCommand(RebelsTPA plugin) {
        this.plugin = plugin;
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("rtpa")) {
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                if (!sender.hasPermission("rtpa.reload")) {
                    TpaUtilities.sendMessageFromConfig(sender, "messages.no-permission");
                    return false;
                }
                TpaUtilities.reloadConfigs();
                TpaUtilities.sendMessageFromConfig(sender, "messages.reload-message");

            }
            sender.sendMessage(ChatColor.RED + "Usage: /rtpa reload | version");
        }
        return false;
    }
}
