package com.gamemster2468.matrixapi;

import com.gamemster.gui.QLHandler;
import com.gamemster.gui.STGUIHandler;
import com.gamemster.gui.VGUIHandler;
import com.gamemster2468.commands.Announce;
import com.gamemster2468.commands.Fly;
import com.gamemster2468.commands.Help;
import com.gamemster2468.commands.HelpOp;
import com.gamemster2468.commands.Hub;
import com.gamemster2468.commands.Message;
import com.gamemster2468.commands.Reload;
import com.gamemster2468.commands.Restart;
import com.gamemster2468.commands.Say;
import com.gamemster2468.commands.Stats;
import com.gamemster2468.listeners.Launchpad;
import com.gamemster2468.listeners.Listeners;
import com.gamemster2468.tokens.GiveTokens;
import java.sql.Connection;
import java.sql.SQLException;
import static org.bukkit.Bukkit.getPluginManager;
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
        getCommand("announce").setExecutor(new Announce());
        getCommand("fly").setExecutor(new Fly());
        getCommand("help").setExecutor(new Help());
        getCommand("helpop").setExecutor(new HelpOp());
        getCommand("hub").setExecutor(new Hub());
        getCommand("message").setExecutor(new Message());
        getCommand("reload").setExecutor(new Reload());
        getCommand("restart").setExecutor(new Restart());
        getCommand("say").setExecutor(new Say());
        getCommand("stats").setExecutor(new Stats());
        getCommand("givetokens").setExecutor(new GiveTokens());
        
        getPluginManager().registerEvents(new QLHandler(), this);
        getPluginManager().registerEvents(new STGUIHandler(), this);
        getPluginManager().registerEvents(new VGUIHandler(), this);
        getPluginManager().registerEvents(new Launchpad(), this);
        getPluginManager().registerEvents(new Listeners(), this);
       
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
