/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamemster2468.tokens;

import com.gamemster2468.matrixapi.Messages;
import com.gamemster2468.matrixapi.Ranks;
import java.sql.SQLException;
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
public class GiveTokens implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String args[]) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (Ranks.isPlayer(player) || Ranks.isSrStaff(player)) {
                if (args.length < 1) {
                    player.sendMessage(Messages.TAG + ChatColor.DARK_AQUA + "Usage: /givetokens [user] [amount]");

                } else {

                    int tokens = Integer.parseInt(args[1]);
                    Player user = Bukkit.getPlayer(args[0]);

                    try {
                        TokenAPI.addTokens(player, tokens);
                        sender.sendMessage(Messages.TAG + ChatColor.DARK_AQUA + "Set user " + user.getName() + " token count to " + tokens);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
            } else {
            }

        }
        return false;
    }
}
