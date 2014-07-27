/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamemster2468.listeners;

import com.gamemster2468.matrixapi.Messages;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 *
 * @author Brandons Account
 */
public class Listeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
        event.getPlayer().sendMessage(Messages.TAG + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "REMINDER: " + ChatColor.RESET + "" + ChatColor.AQUA + "The Matrix v2 is in beta! Report bugs on our forums! Also make sure to NEVER click links from people you don't trust and or know! Be safe!");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = (Player) event.getPlayer();

        if (player.getGameMode() == GameMode.CREATIVE) {
            event.setCancelled(false);
        } else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = (Player) event.getPlayer();

        if (player.getGameMode() == GameMode.CREATIVE) {
            event.setCancelled(false);
        } else {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        event.setFormat("%s" + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE);
    }

}
