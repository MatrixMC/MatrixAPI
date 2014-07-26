/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamemster.gui;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author Brandons Account
 */
public class STGUI {

    public static Inventory getSTGUI() {
        Inventory inv = Bukkit.createInventory(null, 9, "[ST] Select a tool!");
        {

            ItemStack item = new ItemStack(Material.WOOL, 1, DyeColor.LIGHT_BLUE.getData());
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§bSpectator");
            List<String> lore = new ArrayList<String>();
            lore.add("§7Allows you to teleport to a current online player!");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.setItem(2, item);
        }
        {

            ItemStack item = new ItemStack(Material.WOOL, 1, DyeColor.YELLOW.getData());
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§bQuick Links");
            List<String> lore = new ArrayList<String>();
            lore.add("§7Allows you to quickly post links!");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.setItem(4, item);
        }
        {

            ItemStack item = new ItemStack(Material.WOOL, 1, DyeColor.LIME.getData());
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§aVanish");
            List<String> lore = new ArrayList<String>();
            lore.add("§7Allows you to go into vanish mode!");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.setItem(6, item);
        }
        return inv;
    }

}
