/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gamemster2468.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author Brandons Account
 */
public class Help implements CommandExecutor{
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String args[]) {
        sender.sendMessage(ChatColor.DARK_AQUA + "====== " + ChatColor.GREEN + "Commands" + ChatColor.DARK_AQUA + " ======");
        sender.sendMessage(ChatColor.YELLOW + "\u271a " + ChatColor.AQUA + "/help - " + ChatColor.DARK_RED + "Shows this menu.");
        sender.sendMessage(ChatColor.YELLOW + "\u271a " + ChatColor.AQUA + "/tokens - " + ChatColor.DARK_RED + "Amount of tokens.");
        sender.sendMessage(ChatColor.YELLOW + "\u271a " + ChatColor.AQUA + "/hub - " + ChatColor.DARK_RED + "Teleports you back to the hub.");
        sender.sendMessage(ChatColor.YELLOW + "\u271a " + ChatColor.AQUA + "/records - " + ChatColor.DARK_RED + "Shows your stats.");
        sender.sendMessage(ChatColor.DARK_AQUA + "====== " + ChatColor.GREEN + "Commands" + ChatColor.DARK_AQUA + " ======");
        
        return false;
    }
    
}
