package rebelmythik.rebelsTPA;

import org.bukkit.plugin.java.JavaPlugin;
import rebelmythik.rebelsTPA.commands.ReloadCommand;
import rebelmythik.rebelsTPA.commands.tpa.TpAllCommand;
import rebelmythik.rebelsTPA.commands.tpa.TpCommand;
import rebelmythik.rebelsTPA.commands.tpa.TpaCommand;
import rebelmythik.rebelsTPA.database.DatabaseManager;
import rebelmythik.rebelsTPA.utils.TpaUtilities;

public final class RebelsTPA extends JavaPlugin {

    private DatabaseManager databaseManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("tpa").setExecutor(new TpaCommand(this));
        getCommand("tpall").setExecutor(new TpAllCommand(this));
        getCommand("rtpa").setExecutor(new ReloadCommand(this));
        getCommand("tp").setExecutor(new TpCommand(this));

        getCommand("tp").setTabCompleter(new TpCommand(this));

        // Messaging
        saveDefaultConfig();
        TpaUtilities.createConfigs(this);

        databaseManager = new DatabaseManager();
        databaseManager.connect();



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        databaseManager.disconnect();
    }
}
