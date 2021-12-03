package io.github.xxori.ggutil.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;


public class help implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"\n&6GIHS Gaming Club" +
                "\n&d/help: &7Displays this message" +
                "\n&d/spawn: &7Teleports you to the spawn world" +
                "\n"));
        return true;
    }
}
