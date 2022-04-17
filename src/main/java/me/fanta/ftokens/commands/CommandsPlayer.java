package me.fanta.ftokens.commands;

import me.fanta.ftokens.FTokens;
import me.fanta.ftokens.utils.Data;
import me.fanta.ftokens.utils.Messages;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

import java.io.IOException;

import static me.fanta.ftokens.utils.Messages.reloadMessages;
import static me.fanta.ftokens.utils.Messages.toColor;

public class CommandsPlayer implements CommandExecutor {

    FTokens main;
    public CommandsPlayer(FTokens main){

        this.main = main;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){

            Player p = (Player) sender;

            if(args.length == 0){
                if(p.hasPermission("ftokens.helpadmin")){
                    for(String s : Messages.adminhelpcommand){
                        p.sendMessage(toColor(s));

                    }

                    return true;

                } else {
                    for(String s : Messages.helpcommand){
                        p.sendMessage(toColor(s));
                    }
                    return true;
                }




            }




            if(args.length == 1){

                if(args[0].equalsIgnoreCase("reload")){

                    main.reloadConfig();
                    try {
                        reloadMessages();
                        p.sendMessage("§7Configuration reloaded!");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InvalidConfigurationException e) {
                        e.printStackTrace();
                    }

                    return true;
                }

                if(args[0].equalsIgnoreCase("balance")){
                    p.sendMessage(toColor(Messages.balance).replaceAll("%balance%", String.valueOf(Data.getPlayerBalance(p))));

                    return true;
                }





            }
        }


        return false;
    }
}
