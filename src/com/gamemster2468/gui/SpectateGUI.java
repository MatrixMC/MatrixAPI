/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamemster.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author Brandons Account
 */
public class SpectateGUI implements Listener {

    private Inventory spectate;

    public void openSpectateGUI(Player p, Player[] players, int rows, ItemStack item) {
        ItemStack i = item;
        ItemMeta m = i.getItemMeta();
        spectate = Bukkit.createInventory(p, rows * 9, "Click on a name");
        for (int z = 0; z < players.length; z++) {
            m.setDisplayName(players[z].getName());
            i.setItemMeta(m);
            spectate.setItem(z, i);
        }
        p.openInventory(spectate);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getInventory().getTitle().equalsIgnoreCase("Click on a name")) {
            if (e.getCurrentItem() != null && e.getCurrentItem().getType() != null) {
                e.setCancelled(true);
                Player p = (Player) e.getWhoClicked();
                if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName()) {
                    Player c = Bukkit.getPlayer(e.getCurrentItem().getItemMeta().getDisplayName().trim());
                    if (c != null) {
                        p.teleport(c);
                    }
                }
            }
        }
    }

}
