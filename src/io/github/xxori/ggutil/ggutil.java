package io.github.xxori.ggutil;

import io.github.xxori.ggutil.commands.info;
import io.github.xxori.ggutil.commands.spawn;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;
import io.github.xxori.ggutil.commands.help;
import io.github.xxori.ggutil.listeners.spawnListener;
/*
!TODO Use maven instead of IntelliJ artifacts thingy
 */
public class ggutil extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getLogger().info(ChatColor.translateAlternateColorCodes('&', "&fLoading &aggutil &fversion &a"+ this.getDescription().getVersion() + "&f, let's hope this works"));
        // These will give nullpointer exceptions if the commands aren't  registered in plugin.yml. Tough luck
        this.getCommand("spawn").setExecutor(new spawn());
        this.getCommand("help").setExecutor(new help());
        this.getCommand("info").setExecutor(new info(System.currentTimeMillis()));
        Bukkit.getServer().getPluginManager().registerEvents(new spawnListener(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(ChatColor.translateAlternateColorCodes('&', "&fUnloading &aggutil &fversion &a"+ this.getDescription().getVersion()));
    }
}