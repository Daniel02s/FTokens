package me.fanta.ftokens.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Messages {


    public static String boughtanenchant;
    public static String giventokens;
    public static String removedtokens;
    public static String payedtokens;
    public static String ftaerrorgive;
    public static String admingivetokens;
    public static String balance;
    public static List<String> helpcommand;
    public static List<String> adminhelpcommand;
    static File messages;
    static YamlConfiguration messagesyaml;



    public Messages(){

        messages = new File(Bukkit.getServer().getPluginManager().getPlugin("FTokens").getDataFolder(), "messages.yml");


        if(!messages.exists()){
            try{
                messages.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }


        messagesyaml = YamlConfiguration.loadConfiguration(messages);





        boughtanenchant = messagesyaml.getString("boughtanenchant");
        giventokens = messagesyaml.getString("giventokens");
        removedtokens = messagesyaml.getString("removedtokens");
        payedtokens = messagesyaml.getString("payedtokens");
        ftaerrorgive = messagesyaml.getString("ftaerrorgive");
        admingivetokens = messagesyaml.getString("admingivetokens");
        balance = messagesyaml.getString("balance");
        helpcommand = messagesyaml.getStringList("help-command");
        adminhelpcommand = messagesyaml.getStringList("adminhelp-command");



    }



    public static String toColor(String s){
        return ChatColor.translateAlternateColorCodes('&', s);

    }

    public static void reloadMessages() throws IOException, InvalidConfigurationException {
        messagesyaml.load(messages);
    }










}
