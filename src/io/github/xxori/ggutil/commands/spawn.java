package io.github.xxori.ggutil.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            // Console cannot /spawn
            Bukkit.getLogger().info(ChatColor.RED+"You can only run this command as a player!");
            return true;
        }
        Player p = (Player)sender;
        World spawnWorld = Bukkit.getServer().getWorld("world_spawn");
        if (spawnWorld == null) {
            // Sus
            return true;
        }
        // Send to the spawn world
        p.teleport(spawnWorld.getSpawnLocation());
        sender.sendMessage(ChatColor.GRAY + "Teleporting to " + ChatColor.GREEN + " world_spawn");
        return true;
    }
}
