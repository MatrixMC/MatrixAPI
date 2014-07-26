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
public class HelpOp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String args[]) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                sender.sendMessage(Messages.TAG + ChatColor.DARK_AQUA + "Usage: /helpop [message]");
            } else {
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < args.length; i++) {
                    str.append(args[i] + " ");
                    String Message = str.toString();
                    for (Player pl:Bukkit.getOnlinePlayers()) {
                        if (Ranks.isStaff(pl)||Ranks.isPlayer(pl)) {
                            pl.sendMessage(Messages.STAFF + ChatColor.AQUA + "HelpOp Notification" + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + Message);
                        }
                    }
                    sender.sendMessage(Messages.TAG + ChatColor.DARK_RED + "If you are trolling staff and or making their job harder by sending in a false report you will be punished!");
                }
            }
        }
        return false;
    }

}
