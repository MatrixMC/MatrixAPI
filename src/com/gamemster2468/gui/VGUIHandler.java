/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamemster.gui;

import com.gamemster2468.matrixapi.Messages;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Brandons Account
 */
public class VGUIHandler implements Listener {

    private ArrayList<Player> vanished = new ArrayList<Player>();

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getInventory().getTitle().equalsIgnoreCase("[ST] Click to toggle vanish!")) {
            if (event.getCurrentItem() != null && event.getCurrentItem().getType() != null) {
                event.setCancelled(true);
                Player player = (Player) event.getWhoClicked();
                if (event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasDisplayName()) {
                    event.setCancelled(true);
                    ItemStack clicked = event.getCurrentItem();
                    if (clicked != null) {
                        if (clicked.getItemMeta().getDisplayName().contains("§eVanish \u27a0 Enable")) {
                            for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
                                pl.hidePlayer(player);
                            }
                            vanished.add(player);
                            player.closeInventory();
                            player.sendMessage(Messages.TAG + ChatColor.DARK_AQUA + "Vanish mode toggled - " + ChatColor.GREEN + "" + ChatColor.BOLD + "enabled!");
                        } else if (clicked.getItemMeta().getDisplayName().contains("§cVanish \u27a0 Disable")) {
                            for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
                                pl.showPlayer(player);
                            }
                            vanished.remove(player);
                            player.closeInventory();
                            player.sendMessage(Messages.TAG + ChatColor.DARK_AQUA + "Vanish mode toggled - " + ChatColor.RED + "" + ChatColor.BOLD + "disbaled!");
                        }
                    }
                }
            }

        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        for (Player p : vanished) {
            e.getPlayer().hidePlayer(p);
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        vanished.remove(e.getPlayer());
    }
}
