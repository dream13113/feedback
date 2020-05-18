package kode.koder.partyplugin.event;

import kode.koder.partyplugin.main.PlayerData;
import kode.koder.partyplugin.main.plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.UUID;

public class PlayerEvents implements Listener {
    private Main plugin;


    public PlayerEvents(Main plugin){
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }


    @EventHandler
    public void playerjoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        if(Main.playerList.get(p.getName()) == null){
            Main.playerList.put(p.getName(), p.getUniqueId());
        }
        if(Main.playerData.get(p.getUniqueId()) == null){
            Main.playerData.put(p.getUniqueId(), new PlayerData());
            Main.playerData.get(p.getUniqueId()).playtime = 0;
        }
        Main.playerData.get(p.getUniqueId()).isonline = true;
        Main.playerData.get(p.getUniqueId()).playtime += 1;
    }
    @EventHandler
    public void playerout(PlayerQuitEvent e){
        Player p = e.getPlayer();
        Main.playerData.get(p.getUniqueId()).isonline = false;
    }
}
