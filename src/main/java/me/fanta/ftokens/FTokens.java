package me.fanta.ftokens;

import me.fanta.ftokens.commands.AdminBalanceCommands;
import me.fanta.ftokens.commands.CommandsPlayer;
import me.fanta.ftokens.events.JoinEvent;
import me.fanta.ftokens.utils.Config;
import me.fanta.ftokens.utils.Data;
import me.fanta.ftokens.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class FTokens extends JavaPlugin {


    @Override
    public void onEnable() {
        this.getConfig().options().copyDefaults(true);
        saveConfig();
        new Data();
        new Messages();
        new Config(this);

        Bukkit.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getCommand("ftokens").setExecutor(new CommandsPlayer(this));
        getCommand("ftokensadmin").setExecutor(new AdminBalanceCommands());




    }

    @Override
    public void onDisable() {
    }












}
