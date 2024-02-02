package me.pieralini.pSpawn.Listeners;

import me.pieralini.pSpawn.Spawn;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListeners implements Listener {

    private final Spawn plugin;

    public SpawnListeners(Spawn plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        if(!player.hasPlayedBefore()){
            Location location = (Location) plugin.getConfig().get("spawn");

            if(location != null){
                player.teleport(location);
            }

            if (player.isOp()){
                player.sendMessage(ChatColor.GREEN + "Use /setspawn para definir o spawn");
            }
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){

        Player player = event.getPlayer();

        Location location = (Location) plugin.getConfig().get("spawn");
        if (location != null){
            event.setRespawnLocation(location);
        }
    }
}
