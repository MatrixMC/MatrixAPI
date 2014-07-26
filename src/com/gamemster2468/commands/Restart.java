/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gamemster2468.commands;

import static com.gamemster2468.commands.Reload.i;
import com.gamemster2468.matrixapi.MatrixAPI;
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
public class Restart implements CommandExecutor{
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String args[]) {
        if (sender.isOp()) {
            sender.sendMessage(Messages.TAG + ChatColor.DARK_RED + "You have started the restart countdown!");
             Bukkit.getScheduler().scheduleSyncRepeatingTask(MatrixAPI.getPlugin(), new Runnable() {
            public void run() {
                if (i != -1) {
                    if (i != 0) {
                        Bukkit.broadcastMessage(Messages.TAG + ChatColor.DARK_RED + "The server will restart in " + i + " min!");
                        i--;
                    } else {
                        Bukkit.broadcastMessage(Messages.TAG + ChatColor.DARK_RED + "Server restarting...");
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            pl.kickPlayer(Messages.TAG + ChatColor.GREEN + "Server is " + ChatColor.DARK_PURPLE + "reloading! " + ChatColor.YELLOW + "Make sure to join back!");
                        }
                        Bukkit.reload();
                        i--;
                    }
                }
            }
        }, 0L, 360L);
        }
        else {
            sender.sendMessage(Messages.noPerms);
        }
        return false;
    }
    
}
