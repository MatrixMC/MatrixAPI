/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamemster.gui;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author Brandons Account
 */
public class VGUI {

    public static Inventory getVGUI() {
        Inventory inv = Bukkit.createInventory(null, 9, "[ST] Click to toggle vanish!");
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 10);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§eVanish \u27a0 Enable");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§7Enable vanish mode.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.setItem(3, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§cVanish \u27a0 Disable");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§7Disable vanish mode.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.setItem(5, item);
        }
        return inv;
    }

}
