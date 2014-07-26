/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamemster2468.commands;

import com.gamemster2468.matrixapi.Messages;
import com.gamemster2468.matrixapi.Ranks;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Brandons Account
 */
public class Announce implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String args[]) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (Ranks.isPlayer(player)||Ranks.isAdmin(player)||Ranks.isDeveloper(player)||Ranks.isOwner(player)) {
                if (args.length == 0) {
                    sender.sendMessage(Messages.TAG + ChatColor.DARK_AQUA + "Usage: /announce [message]");
                } else {

                    StringBuilder str = new StringBuilder();
                    for (int i = 0; i < args.length; i++) {
                        str.append(args[i] + " ");
                        String Message = str.toString();
                        for (Player pl:Bukkit.getOnlinePlayers()) {
                            pl.sendMessage(ChatColor.YELLOW + "[ANNOUNCEMENT] " + ChatColor.GOLD + "\u27a4 " + ChatColor.GREEN + Message);
                        }
                    }

                }
            } else {
                sender.sendMessage(Messages.noPerms);
            }
        }
        return false;
    }

}
