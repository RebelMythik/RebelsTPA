package rebelmythik.rebelsTPA.utils;


import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;

public class TpaUtilities {

    /// Finished ///
    public static final ColorCode colorCodes = new ColorCode();

    public static FileConfiguration messagesConfig;
    public static FileConfiguration homeConfig;
    public static FileConfiguration rtpConfig;
    public static FileConfiguration tpaConfig;


    public static void createConfigs(JavaPlugin javaPlugin) {
        messagesConfig = createConfig(javaPlugin, "messages.yml");
        tpaConfig = createConfig(javaPlugin, "tpa.yml");
    };

    private static FileConfiguration createConfig(JavaPlugin javaPlugin, String fileName) {
        File configFile = new File(javaPlugin.getDataFolder(), fileName);

        if (!configFile.exists()) {
            javaPlugin.saveResource(fileName, false);
        }
        return YamlConfiguration.loadConfiguration(configFile);
    }

    public static void sendMessageFromConfig(CommandSender sender, String path) {
        sender.sendMessage(colorCodes.cm(messagesConfig.getString(path)));
    }

    public static void reloadConfigs() {
        messagesConfig = YamlConfiguration.loadConfiguration(new File("messages.yml"));
        tpaConfig = YamlConfiguration.loadConfiguration(new File("tpa.yml"));
    }

    public static void registerGroupPermissions() {

    }


    /// TODO ///
    public static ArrayList<String> getHomes(Player player) {
        PlayerInformation player_data = getPlayerInformation(player);

        return new ArrayList<>();
    }

    public static Location getHome(Player player, String home_name) {
        PlayerInformation player_data = getPlayerInformation(player);

        return null;
    }

    public static void setNewHome(Player player, String home_name, Location loc) {
        PlayerInformation player_data = getPlayerInformation(player);


    }

    public static PlayerInformation getPlayerInformation(Player player) {

        return null;
    }

    public static PlayerInformation addPlayerToDatabase(Player player) {
        return null;
    }

}
