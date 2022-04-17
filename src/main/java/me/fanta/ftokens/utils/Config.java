package me.fanta.ftokens.utils;

import me.fanta.ftokens.FTokens;

public class Config {

    static FTokens main;

    public Config(FTokens main){
        this.main = main;

    }


    public static int getStartingBalance(){
        return main.getConfig().getInt("configuration.starting-balance");

    }


}
