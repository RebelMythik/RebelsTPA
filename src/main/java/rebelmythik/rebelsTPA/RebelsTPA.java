package rebelmythik.rebelsTPA;

import org.bukkit.plugin.java.JavaPlugin;
import rebelmythik.rebelsTPA.utils.TpaUtilities;

public final class RebelsTPA extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("rtpa").setExecutor(new RebelsTPA());
        getCommand("tpa").setExecutor(new RebelsTPA());
        getCommand("tpall").setExecutor(new RebelsTPA());

        // Messaging
        saveDefaultConfig();
        TpaUtilities.createConfigs(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
