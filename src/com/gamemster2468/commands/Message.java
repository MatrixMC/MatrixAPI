/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamemster2468.commands;

import com.gamemster2468.matrixapi.Messages;
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
public class Message implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String args[]) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length < 1) {
                sender.sendMessage(Messages.TAG + ChatColor.DARK_AQUA + "Usage: /message [user] [message]");
            } else {
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                   sender.sendMessage(Messages.TAG + ChatColor.DARK_RED + "Could not find any user by that name!");
                } else {
                    StringBuilder str = new StringBuilder();
                    for (int i = 0; i < args.length; i++) {
                        str.append(args[i]).append(" ");
                    }
                    String message = str.toString();
                    target.sendMessage("§a§lPRIVATE \u2759 §r" + player.getDisplayName() + " §2\u27F6§r " + target.getDisplayName() + " §8\u00bb§f " + message);

                }
            }
        }

        return false;
    }
}
