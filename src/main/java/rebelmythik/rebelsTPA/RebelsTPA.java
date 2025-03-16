package rebelmythik.rebelsTPA;

import org.bukkit.plugin.java.JavaPlugin;
import rebelmythik.rebelsTPA.commands.ReloadCommand;
import rebelmythik.rebelsTPA.commands.tpa.TpAllCommand;
import rebelmythik.rebelsTPA.commands.tpa.TpaCommand;
import rebelmythik.rebelsTPA.utils.TpaUtilities;

public final class RebelsTPA extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("tpa").setExecutor(new TpaCommand(this));
        getCommand("tpall").setExecutor(new TpAllCommand());
        getCommand("rtpa").setExecutor(new ReloadCommand(this));

        // Messaging
        saveDefaultConfig();
        TpaUtilities.createConfigs(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
