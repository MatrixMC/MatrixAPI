/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamemster2468.matrixapi;
import java.sql.Connection;
import java.sql.SQLException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Brandons Account
 */
public class MatrixAPI extends JavaPlugin {

    private static Plugin plugin;
    public static Connection connection;

    @Override
    public void onEnable() {

        plugin = this;

        getLogger().info("[MatrixAPI] The Matrix API has been enabled.");

    }

    @Override
    public void onDisable() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        plugin = null;

        getLogger().info("[MatrixAPI] The Matrix API has been disabled!");

    }

    public static Plugin getPlugin() {
        return plugin;
    }

}
