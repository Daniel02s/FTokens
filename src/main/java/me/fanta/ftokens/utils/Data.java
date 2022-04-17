package me.fanta.ftokens.utils;

import me.fanta.ftokens.FTokens;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Data {

    static File data;
    static YamlConfiguration datayaml;

    public Data(){
        data = new File(Bukkit.getServer().getPluginManager().getPlugin("FTokens").getDataFolder(), "data.yml");


        if(!data.exists()){
            try{
                data.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }


        datayaml = YamlConfiguration.loadConfiguration(data);
    }


    public static void saveFile() throws IOException {
        datayaml.save(data);
    }

    public static int getPlayerBalance(Player p){

        return datayaml.getInt("datas." + p.getUniqueId() + ".balance");





    }

    public static int getPlayerBalance(String s){

        return datayaml.getInt("datas." + Bukkit.getServer().getOfflinePlayer(s).getUniqueId() + ".balance");





    }

    public static boolean removeTokensFromPlayer(Player p, int cost){

        if(cost > getPlayerBalance(p))
            return false;



        datayaml.set("datas." + p.getUniqueId() + ".balance", cost - getPlayerBalance(p));
        try {
            datayaml.save(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;







    }

    public static boolean addTokensToPlayer(Player p, int amount){



        datayaml.set("datas." + p.getUniqueId() + ".balance", amount + getPlayerBalance(p));
        try {
            datayaml.save(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;







    }

    public static boolean addTokensToPlayer(String s, int amount){



        datayaml.set("datas." + Bukkit.getServer().getOfflinePlayer(s).getUniqueId() + ".balance", amount + getPlayerBalance(s));
        try {
            datayaml.save(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;







    }

    public static boolean createnewTokensProfile(Player p, int amount){



        datayaml.set("datas." + p.getUniqueId() + ".balance", amount);
        try {
            datayaml.save(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;







    }


    public static boolean payToPlayer(Player sender, Player receiver, int amount){


        if(getPlayerBalance(sender) < amount)
            return false;


        datayaml.set("datas." + receiver.getUniqueId() + ".balance", amount + getPlayerBalance(receiver));
        datayaml.set("datas." + sender.getUniqueId() + ".balance", amount - getPlayerBalance(sender));
        try {
            datayaml.save(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;







    }

    public static boolean containsPlayer(Player p){


        if(datayaml.contains("datas." + p.getUniqueId())){
            return true;

        }

        return false;



    }

    public static boolean containsPlayer(String s){


        if(datayaml.contains("datas." + Bukkit.getOfflinePlayer(s).getUniqueId())){
            return true;

        }

        return false;



    }






}
