package io.github.xxori.ggutil.hooks;

import io.github.xxori.ggutil.ggutil;
import net.skinsrestorer.api.PlayerWrapper;
import net.skinsrestorer.api.SkinsRestorerAPI;
import net.skinsrestorer.api.exception.SkinRequestException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class SkinsRestorerHook implements ggutilHook{
    private final ggutil plugin;
    private final SkinsRestorerAPI skinsRestorerAPI;
    private boolean enabled;

    public SkinsRestorerHook(ggutil plugin) {
        this.plugin = plugin;
        plugin.getLogger().info("ggutils hooking into " + ChatColor.GREEN + "SkinsRestorer");
        skinsRestorerAPI = SkinsRestorerAPI.getApi();
        enabled = true;
    }

    public boolean SetSkin(Player player, String skin) {
       // try {
            // Set the skin
            //skinsRestorerAPI.setSkin(player.getName(), skin);


            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "skin set "+ player.getName()+" "+skin);

            // Force skin refresh for player
            //skinsRestorerAPI.applySkin(new PlayerWrapper(player));
            return true;
        /*} catch (SkinRequestException e) {
            plugin.getLogger().warning(e.toString());
            return false;
        }*/
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String getName() {
        return "SkinsRestorer";
    }

    @Override
    public void disable() {
        enabled = false;
    }
}
