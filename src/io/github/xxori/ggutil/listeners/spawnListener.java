package io.github.xxori.ggutil.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class spawnListener implements Listener{

    @EventHandler(priority= EventPriority.HIGH)
    public void onPlayerTeleport(PlayerChangedWorldEvent e) {
        // Override the multiverse thingy for our spawn world, we want /spawn to return you
        // to the spawn location instead of your previous location (the overworld portal)

        // Destination and previous location
        String fname = e.getFrom().getName();
        String dname = e.getPlayer().getWorld().getName();

        // We only want to intercept the event when the player is tp'ing from any other world to the spawn world
        if (fname.equals("world_spawn") || !dname.equals("world_spawn")) {
            return;
        }
        // Teleport the player to the spawn location with the correct orientation instead, will override the multiverse tp
        Location dest = e.getPlayer().getWorld().getSpawnLocation();
        dest.setPitch(0);
        dest.setYaw(-180);
        e.getPlayer().teleport(dest);
    }
}
