package io.github.xxori.ggutil;

import io.github.xxori.ggutil.commands.spawn;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;
import io.github.xxori.ggutil.commands.help;
import io.github.xxori.ggutil.listeners.spawnListener;

public class ggutil extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getLogger().info(ChatColor.translateAlternateColorCodes('&', "&fLoading &aggutil &fversion &a1.0&f, let's hope this works"));
        this.getCommand("spawn").setExecutor(new spawn());
        this.getCommand("help").setExecutor(new help());
        Bukkit.getServer().getPluginManager().registerEvents(new spawnListener(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(ChatColor.translateAlternateColorCodes('&', "&fUnloading &aggutil &fversion &a1.0"));
    }
}