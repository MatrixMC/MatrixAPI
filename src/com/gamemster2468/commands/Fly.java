/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gamemster2468.commands;

import com.gamemster2468.matrixapi.Messages;
import com.gamemster2468.matrixapi.Ranks;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Brandons Account
 */
public class Fly implements CommandExecutor{
    
    public boolean flight = false;
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String args[]) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (Ranks.isPlayer(player)||Ranks.isSrStaff(player)) {
                if (flight==false) {
                    
                    player.setAllowFlight(true);
                    player.sendMessage(Messages.TAG + ChatColor.DARK_AQUA + "Flight has been toggled - §a§lenabled!");
                }
                else {
                    
                    player.setAllowFlight(false);
                    player.sendMessage(Messages.TAG + ChatColor.DARK_AQUA + "Flight has been toggled - §c§ldisabled!");
                }
            }
            else {
                sender.sendMessage(Messages.noPerms);
            }
        }
        return false;
    }
    
}
