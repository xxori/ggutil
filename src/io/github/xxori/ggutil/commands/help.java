package io.github.xxori.ggutil.commands;

import io.github.xxori.ggutil.ggutil;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;


public class help implements CommandExecutor {
    private final ggutil plugin;

    public help(ggutil plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"\n&6GIHS Gaming Club" +
                "\n&d/help: &7Displays this message" +
                "\n&d/spawn: &7Teleports you to the spawn world" +
                "\n&d/menu: &7Opens your player menu"+
                "\n&d/info: &7Shows information about the server\n"));
        return true;
    }
}
