package me.fanta.ftokens.commands;

import me.fanta.ftokens.utils.Config;
import me.fanta.ftokens.utils.Data;
import me.fanta.ftokens.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

import static me.fanta.ftokens.utils.Messages.admingivetokens;
import static me.fanta.ftokens.utils.Messages.toColor;

public class AdminBalanceCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;

            if(args.length == 3){

                if(args[0].equalsIgnoreCase("give")){

                    if(Data.containsPlayer(args[1])){

                        try{
                            int amount = Integer.parseInt(args[2]);
                            Data.addTokensToPlayer(args[1], amount);
                            p.sendMessage(toColor(admingivetokens).replaceAll("%tokens", String.valueOf(amount)).replaceAll("%player%", args[1]));
                            Data.saveFile();
                            if(Bukkit.getServer().getPlayer(args[1]) != null){

                                Player receiver = Bukkit.getServer().getPlayer(args[1]);
                                receiver.sendMessage(toColor(Messages.giventokens).replaceAll("%tokens%", String.valueOf(amount)));
                            }

                        } catch(NumberFormatException e){

                            p.sendMessage(toColor(Messages.ftaerrorgive));
                            return false;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return false;
                        }


                    }


                }



            }


        }
        return false;
    }
}
