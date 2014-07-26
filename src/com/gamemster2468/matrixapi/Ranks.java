/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamemster2468.matrixapi;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 *
 * @author Brandons Account
 */
public class Ranks {
    
    public static boolean isOwner(Player player) {
        return player.hasPermission("matrix.rank.owner");
    }
    
    public static boolean isDeveloper(Player player) {
        return player.hasPermission("matrix.rank.developer");
    }
    
    public static boolean isAdmin(Player player) {
        return player.hasPermission("matrix.rank.admin");
    }
    
    public static boolean isSrMod(Player player) {
        return player.hasPermission("matrix.rank.srmod");
    }
    
    public static boolean isMod(Player player) {
        return player.hasPermission("matrix.rank.mod");
    }
    
    public static boolean isSeaborgia(Player player) {
        return player.hasPermission("matrix.rank.seaborgia");
        
    }
    
    public static boolean isYT(Player player) {
        return player.hasPermission("matrix.rank.yt");
    }
    
    public static boolean isVIP(Player player) {
        return player.hasPermission("matrix.rank.vip");
    }
    
    public static boolean isDiamond(Player player) {
        return player.hasPermission("matrix.rank.diamond");
    }
    
    public static boolean isGold(Player player) {
        return player.hasPermission("matrix.rank.gold");
    }
    
    public static boolean isIron(Player player) {
        return player.hasPermission("matrix.rank.iron");
    }
    
    public static boolean isPlayer(Player player) {
        return player.hasPermission("matrix.player");
    }
    
    public static boolean isPremium(Player player) {
        return player.hasPermission("matrix.premium");
    }
    
    public static boolean isStaff(Player player) {
        return player.hasPermission("matrix.staff");
    }
    
    public static boolean isSrStaff(Player player) {
        return player.hasPermission("matrix.srstaff");
    }
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (isOwner(player)) {
            player.setDisplayName(ChatColor.GREEN + player.getName());
        } else if (isDeveloper(player) || isAdmin(player) || isSrMod(player)) {
            player.setDisplayName(ChatColor.DARK_RED + player.getName());
        } else if (isMod(player)) {
            player.setDisplayName(ChatColor.RED + player.getName());
        } else if (isSeaborgia(player)) {
            player.setDisplayName(ChatColor.DARK_BLUE + player.getName());
        } else if (isYT(player)) {
            player.setDisplayName(ChatColor.LIGHT_PURPLE + player.getName());
        } else if (isVIP(player)) {
            player.setDisplayName(ChatColor.YELLOW + player.getName());
        } else if (isDiamond(player)) {
            player.setDisplayName(ChatColor.AQUA + player.getName());
        } else if (isGold(player)) {
            player.setDisplayName(ChatColor.GOLD + player.getName());
        } else if (isIron(player)) {
            player.setDisplayName(ChatColor.GRAY + player.getName());
        } else {
            player.setDisplayName(ChatColor.DARK_AQUA + player.getName());
        }
    }
}
