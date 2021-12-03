package io.github.xxori.ggutil.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class spawnListener implements Listener{
    @EventHandler(priority= EventPriority.HIGHEST)
    public void onPlayerTeleport(PlayerChangedWorldEvent e) {
        String fname = e.getFrom().getName();
        String dname = e.getPlayer().getWorld().getName();
        if (fname.equals("world_spawn") || !dname.equals("world_spawn")) {
            return;
        }
        Location dest = e.getPlayer().getWorld().getSpawnLocation();
        dest.setPitch(0);
        dest.setYaw(-180);
        e.getPlayer().teleport(dest);
        Bukkit.getLogger().info("POGGY");
    }
}
