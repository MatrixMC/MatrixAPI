/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gamemster2468.tokens;

import com.gamemster2468.matrixapi.MatrixAPI;
import com.gamemster2468.matrixapi.Messages;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.bukkit.entity.Player;

/**
 *
 * @author Brandons Account
 */
public class TokenAPI {
    
    public synchronized static void openConnection(){
        try{
            String username = "root";
            String password = "G6J4m8Y6dg6U";
            MatrixAPI.connection = DriverManager.getConnection("jdbc:mysql://sql.matrixmc.eu:3306/matrixtokens", "root", "G6J4m8Y6dg6U");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public synchronized static boolean databaseContainsPlayer(Player player){
        try{
            PreparedStatement sql = MatrixAPI.connection.prepareStatement("SELECT * FROM `users` WHERE uuid=?;");
            sql.setString(1, player.getUniqueId().toString());
            ResultSet set = sql.executeQuery();
            boolean containsPlayer = set.next();
            sql.close();
            set.close();
            return containsPlayer;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public static int getTokens(Player player) throws SQLException{
        openConnection();
        try{
            int tokens = 0;
            if(databaseContainsPlayer(player)){
                PreparedStatement sql = MatrixAPI.connection.prepareStatement("SELECT tokens FROM `users` WHERE uuid=?;");
                sql.setString(1, player.getUniqueId().toString());
                
                ResultSet set = sql.executeQuery();
                set.next();
                
                tokens = set.getInt("tokens");
                                
                sql.close();
                set.close();
                
                return tokens;
            } else {
                PreparedStatement newPlayer = MatrixAPI.connection.prepareStatement("INSERT INTO `users` values(?,0,?);");
                newPlayer.setString(1, player.getUniqueId().toString());
                newPlayer.setString(2, player.getName());
                newPlayer.execute();
                newPlayer.close();
                return 0;
            }
            
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        } finally {
            MatrixAPI.connection.close();
        }
    }
    
    public static void addTokens(Player player, int i) throws SQLException{
        openConnection();
        try{
            int tokens = 0;
            if(databaseContainsPlayer(player)){
                PreparedStatement sql = MatrixAPI.connection.prepareStatement("SELECT tokens FROM `users` WHERE uuid=?;");
                sql.setString(1, player.getUniqueId().toString());
                
                ResultSet set = sql.executeQuery();
                set.next();
                
                tokens = set.getInt("tokens");
                int newTokens = tokens + i;
                
                PreparedStatement tokensUpdate = MatrixAPI.connection.prepareStatement("UPDATE `users` SET tokens=? WHERE uuid=?;");
                tokensUpdate.setInt(1, tokens + i);
                tokensUpdate.setString(2, player.getUniqueId().toString());
                tokensUpdate.executeUpdate();
                
                tokensUpdate.close();
                sql.close();
                set.close();
               
            } else {
                PreparedStatement newPlayer = MatrixAPI.connection.prepareStatement("INSERT INTO `users` values(?,0,?);");
                newPlayer.setString(1, player.getUniqueId().toString());
                newPlayer.setString(2, player.getName());
                newPlayer.execute();
                newPlayer.close();
            }
            
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            MatrixAPI.connection.close();
        }
        
    }
    
    public static void takeTokens(Player player, int i) throws SQLException{
        openConnection();
        try{
            int tokens = 0;
            if(databaseContainsPlayer(player)){
                PreparedStatement sql = MatrixAPI.connection.prepareStatement("SELECT tokens FROM `users` WHERE uuid=?;");
                sql.setString(1, player.getUniqueId().toString());
                
                ResultSet set = sql.executeQuery();
                set.next();
                
                tokens = set.getInt("tokens");
                int newTokens = tokens - i;
                
                PreparedStatement tokensUpdate = MatrixAPI.connection.prepareStatement("UPDATE `users` SET tokens=? WHERE uuid=?;");
                tokensUpdate.setInt(1, tokens - i);
                tokensUpdate.setString(2, player.getUniqueId().toString());
                tokensUpdate.executeUpdate();
                
                tokensUpdate.close();
                sql.close();
                set.close();
                
            } else {
                PreparedStatement newPlayer = MatrixAPI.connection.prepareStatement("INSERT INTO `users` values(?,0,?);");
                newPlayer.setString(1, player.getUniqueId().toString());
                newPlayer.setString(2, player.getName());
                newPlayer.execute();
                newPlayer.close();
            }
            
        }catch(Exception e){
            e.printStackTrace();
        } finally {
           MatrixAPI.connection.close();
        }
        
    }
    
    public static boolean hasEnough(Player player, int i) throws SQLException{
        openConnection();
        try{
            int tokens = 0;
            if(databaseContainsPlayer(player)){
                PreparedStatement sql = MatrixAPI.connection.prepareStatement("SELECT tokens FROM `users` WHERE uuid=?;");
                sql.setString(1, player.getUniqueId().toString());
                
                ResultSet set = sql.executeQuery();
                set.next();
                
                tokens = set.getInt("tokens");
                
                sql.close();
                set.close();
                
                return tokens >= i;

            } else {
                PreparedStatement newPlayer = MatrixAPI.connection.prepareStatement("INSERT INTO `users` values(?,0,?);");
                newPlayer.setString(1, player.getUniqueId().toString());
                newPlayer.setString(2, player.getName());
                newPlayer.execute();
                newPlayer.close();
                return false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            MatrixAPI.connection.close();
        }
        return false;
    }
    
}
