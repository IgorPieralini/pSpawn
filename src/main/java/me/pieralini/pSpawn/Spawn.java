package me.pieralini.pSpawn;

import me.pieralini.pSpawn.Listeners.SetSpawnCommand;
import me.pieralini.pSpawn.Listeners.SpawnCommand;
import me.pieralini.pSpawn.Listeners.SpawnListeners;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Spawn extends JavaPlugin {

    @Override
    public void onEnable() {


          Bukkit.getConsoleSender().sendMessage("\n" +
               "           ______                                      \n" +
               "         .' ____ \\                                    \n" +
               " _ .--.  | (___ \\_|_ .--.   ,--.  _   _   __  _ .--.  \n" +
               "[ '/'`\\ \\ _.____`.[ '/'`\\ \\`'_\\ :[ \\ [ \\ [  ][ `.-. |  \n" +
               " | \\__/ || \\____) || \\__/ |// | |,\\ \\/\\ \\/ /  | | | |  \n" +
               " | ;.__/  \\______.'| ;.__/ \\'-;__/ \\__/\\__/  [___||__] \n" +
               "[__|              [__|                                ");



        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[pSpawn]: " + ChatColor.GRAY + "Foi Iniciado com sucesso!!");

        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));

        getServer().getPluginManager().registerEvents(new SpawnListeners(this), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[pSpawn]: " + ChatColor.GRAY + "Foi desabilitado!!");
    }
}
