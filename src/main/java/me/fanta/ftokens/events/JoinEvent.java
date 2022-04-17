package me.fanta.ftokens.events;

import me.fanta.ftokens.utils.Config;
import me.fanta.ftokens.utils.Data;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        if(!Data.containsPlayer(p)){
            Data.createnewTokensProfile(p, Config.getStartingBalance());
        }
    }

}
