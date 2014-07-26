/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gamemster.gui;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author Brandons Account
 */
public class QLGUI {
    
     public static Inventory getQLGUI() {
        Inventory inv = Bukkit.createInventory(null, 18, "[ST] Quick Links");
        {
            ItemStack item = new ItemStack(Material.PAPER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§aWebsite");
            List<String> lore = new ArrayList<String>();
            lore.add("§fSorry, but the website is currently down! It will be back soon! :)");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.addItem(item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§aReport Rule Breakers");
            List<String> lore = new ArrayList<String>();
            lore.add("§fReport rule breakers here: http://bit.ly/1of7cVW");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.addItem(item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§aAppeal Bans");
            List<String> lore = new ArrayList<String>();
            lore.add("§fAppeal bans by adding this user to skype: matrix.ban.appeal");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.addItem(item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§aFeedback");
            List<String> lore = new ArrayList<String>();
            lore.add("§fSubmit your feedback and or suggestions here: support.thematrixmc.com");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.addItem(item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§aTeamSpeak");
            List<String> lore = new ArrayList<String>();
            lore.add("§fMatrix Teamspeak IP: matrixmc.eu");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.addItem(item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§aSwearing");
            List<String> lore = new ArrayList<String>();
            lore.add("§fWatch the langauge please.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.addItem(item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§aCaps");
            List<String> lore = new ArrayList<String>();
            lore.add("§fWatch the caps please.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.addItem(item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§aDisrespect");
            List<String> lore = new ArrayList<String>();
            lore.add("§fPlease do not disrespect other players.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.addItem(item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§aStaff Disrespect");
            List<String> lore = new ArrayList<String>();
            lore.add("§fPlease do not disrespect staff.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.addItem(item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§aSpam");
            List<String> lore = new ArrayList<String>();
            lore.add("§fPlease do not spam.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.addItem(item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§aDirty Chat");
            List<String> lore = new ArrayList<String>();
            lore.add("§fPlease keep chat clean.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.addItem(item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§aBreaking rules [LAST WARNING]");
            List<String> lore = new ArrayList<String>();
            lore.add("§fStop breaking the rules! This is your LAST warning!");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.addItem(item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§aStaff Guide");
            List<String> lore = new ArrayList<String>();
            lore.add("§fSends you the staff guide!");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.addItem(item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§aBan Report");
            List<String> lore = new ArrayList<String>();
            lore.add("§fSends you the link to report ALL of your bans!");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.addItem(item);
        }
        return inv;
    }
    
}
