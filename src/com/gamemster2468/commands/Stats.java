package com.gamemster2468.commands;

import com.gamemster2468.matrixapi.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Stats implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            player.sendMessage(Messages.TAG + "§3This feature hasn't been implemented yet, try again later.");
            return true;
        }
        return true;
    }
    
}
