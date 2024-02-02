package me.pieralini.pSpawn.Listeners;

import me.pieralini.pSpawn.Spawn;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final Spawn plugin;

    public SpawnCommand(Spawn plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(player.hasPermission("pSpawn.spawn")){
                Location location = (Location) plugin.getConfig().get("spawn");

                if (location != null ){
                    player.teleport(location);

                    player.sendMessage(ChatColor.GREEN + "Você se teleportou para o Spawn");
                }else {
                    player.sendMessage(ChatColor.RED + "O Spawn não foi setado pelo admin");
                }
            }else {
                player.sendMessage(ChatColor.RED + "Você não tem permissão para isto.");
            }
        }else {
           Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Você não é um player");
        }
        return true;
    }
}
