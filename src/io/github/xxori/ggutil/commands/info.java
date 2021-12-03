package io.github.xxori.ggutil.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.time.Duration;


public class info implements CommandExecutor {
    private static long LAST_START_TIME;
    // Store uptime
    public info(long start_time) {
        LAST_START_TIME = start_time;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Duration duration = Duration.ofMillis(System.currentTimeMillis() - LAST_START_TIME);
        // God this is cursed
        String formatted_uptime = "&4Something went wrong";
        if (duration.toDays()==0) {
            if (duration.toHours()==0) {
                if (duration.toMinutes()==0) {
                    formatted_uptime = String.format("%d Seconds", duration.toSeconds()%60);
                } else {
                    formatted_uptime = String.format("%d Minutes, %d Seconds", duration.toMinutes()%60, duration.toSeconds()%60);
                }
            } else {
                formatted_uptime = String.format("%d Hours, %d Minutes, %d Seconds", duration.toHours()%24, duration.toMinutes()%60, duration.toSeconds()%60);
            }
        } else {
            formatted_uptime = String.format("%d Days, %d Hours, %d Minutes, %d Seconds", duration.toDays(), duration.toHours()%24,duration.toMinutes()%60,duration.toSeconds()%60);
        }
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "\n&6GIHS Gaming Club" +
                "\n&7Uptime: &a" +  formatted_uptime +
                "\n&7Version: &a"+Bukkit.getServer().getVersion()+
                "\n&7Admins\n    - &aCodian &7(Martin)\n    - &a__Orij &7(Patrick)" +
                "\n"));
        return true;
    }
}
