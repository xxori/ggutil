package io.github.xxori.ggutil;

import io.github.xxori.ggutil.commands.*;
import io.github.xxori.ggutil.hooks.SkinsRestorerHook;
import io.github.xxori.ggutil.hooks.ggutilHook;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;
import io.github.xxori.ggutil.listeners.spawnListener;

import java.util.ArrayList;
import java.util.List;

/*
!TODO Use maven instead of IntelliJ artifacts thingy
 */
public class ggutil extends JavaPlugin {

    public long LAST_START_TIME;
    public List<ggutilHook> enabledHooks;

    @Override
    public void onEnable() {
        LAST_START_TIME = System.currentTimeMillis();
        enabledHooks = new ArrayList<>();
        loadHooks();
        this.getLogger().info(ChatColor.translateAlternateColorCodes('&', "&fLoading &aggutil &fversion &a"+ this.getDescription().getVersion() + "&f, let's hope this works"));
        // These will give nullpointer exceptions if the commands aren't  registered in plugin.yml. Tough luck
        this.getCommand("spawn").setExecutor(new spawn(this));
        this.getCommand("help").setExecutor(new help(this));
        this.getCommand("help").setExecutor(new help(this));
        this.getCommand("info").setExecutor(new info(this));
        this.getCommand("giverewards").setExecutor(new giverewards(this));
        this.getCommand("sus").setExecutor(new sus(this));
        Bukkit.getServer().getPluginManager().registerEvents(new spawnListener(), this);
    }

    @Override
    public void onDisable() {
        for (ggutilHook hook : enabledHooks) {
            hook.disable();
        }
        enabledHooks.clear();
        this.getLogger().info(ChatColor.translateAlternateColorCodes('&', "&fUnloading &aggutil &fversion &a"+ this.getDescription().getVersion()));
    }

    private void loadHooks() {
        if (Bukkit.getPluginManager().isPluginEnabled("SkinsRestorer")) {
            enabledHooks.add(new SkinsRestorerHook(this));
        }
    }
}