package rebelmythik.rebelsTPA.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DatabaseManager {

    private Connection connection;

    public void connect() {
        try {
            String url = "jdbc:sqlite:plugins/RebelsTPA/database.db";
            connection = DriverManager.getConnection(url);

            // Table for back command
            String sqlBack = "CREATE TABLE IF NOT EXISTS back_locations (" +
                    "uuid TEXT PRIMARY KEY," +
                    "world TEXT NOT NULL," +
                    "x DOUBLE NOT NULL," +
                    "y DOUBLE NOT NULL," +
                    "z DOUBLE NOT NULL," +
                    "yaw FLOAT NOT NULL," +
                    "pitch FLOAT NOT NULL" +
                    ");";


            try (PreparedStatement statement = connection.prepareStatement(sqlBack)) {
                statement.execute();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Sethome
    public void addHome(String uuid, String homeName, String world, double x, double y, double z, float yaw, float pitch) {
        String sql = "INSERT OR REPLACE INTO homes (uuid, home_name, world, x, y, z, yaw, pitch) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, uuid);
            statement.setString(2, homeName);
            statement.setString(3, world);
            statement.setDouble(4, x);
            statement.setDouble(5, y);
            statement.setDouble(6, z);
            statement.setFloat(7, yaw);
            statement.setFloat(8, pitch);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean homeExists(String uuid, String homeName) {
        String sql = "SELECT COUNT(*) FROM homes WHERE uuid = ? AND home_name = ?;";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, uuid);
            stmt.setString(2, homeName);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void removeHome(String uuid, String homeName) {
        String sql = "DELETE FROM homes WHERE uuid = ? AND home_name = ?;";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, uuid);
            stmt.setString(2, homeName);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> listHomes(UUID uuid) {
        List<String> homes = new ArrayList<>();

        String sql = "SELECT home_name FROM homes WHERE uuid = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, uuid.toString());
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                homes.add(result.getString("home_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return homes;
    }




}
