package me.pieralini.pSpawn.Listeners;

import me.pieralini.pSpawn.Spawn;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private final Spawn pluign;

    public SetSpawnCommand(Spawn pluign) {
        this.pluign = pluign;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if (player.hasPermission("pSpawn.setspawn")){
                Location location = player.getLocation();

                // Salvar a Direçao
                pluign.getConfig().set("spawn", location);
                pluign.saveConfig();;

                player.sendMessage(ChatColor.GREEN + "Spawn setado!!");
            }else{
                player.sendMessage(ChatColor.RED + "Você não tem permissão para isto.");
            }
        }else{
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Você não é um player");
        }

        return true;
    }
}
