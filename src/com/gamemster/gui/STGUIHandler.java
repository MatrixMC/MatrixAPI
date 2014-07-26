/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamemster.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Brandons Account
 */
public class STGUIHandler implements Listener {

    private SpectateGUI spectategui = new SpectateGUI();

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getInventory().getTitle().equalsIgnoreCase("[ST] Select a tool!")) {
            if (event.getCurrentItem() != null && event.getCurrentItem().getType() != null) {
                event.setCancelled(true);
                Player player = (Player) event.getWhoClicked();
                if (event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasDisplayName()) {
                    event.setCancelled(true);
                    ItemStack clicked = event.getCurrentItem();
                    if (clicked != null) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§bSpectate")) {
                            spectategui.openSpectateGUI(player, Bukkit.getOnlinePlayers(), 1, new ItemStack(Material.SKULL_ITEM, 1, (byte) 3));
                        } else if (event.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.YELLOW + "Quick Links")) {
                            QLGUI.getQLGUI();
                        } else if (event.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.GREEN + "Vanish")) {

                            VGUI.getVGUI();
                        }
                    }
                }
            }
        }
    }

}
