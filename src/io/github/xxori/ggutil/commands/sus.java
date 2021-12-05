package io.github.xxori.ggutil.commands;

import io.github.xxori.ggutil.ggutil;
import io.github.xxori.ggutil.hooks.SkinsRestorerHook;
import io.github.xxori.ggutil.hooks.ggutilHook;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class sus implements CommandExecutor {
    private final ggutil plugin;
    private final List<String> amoguses;
    private final Random randomGenerator;

    public sus(ggutil plugin) {
        randomGenerator = new Random();
        this.plugin = plugin;
        amoguses = new ArrayList<>();
        amoguses.add("https://i.imgur.com/nMM1ApA.png");
        amoguses.add("https://i.imgur.com/08BHnNw.png");
        amoguses.add("https://i.imgur.com/hKpRklI.png");
        amoguses.add("https://i.imgur.com/spGlEOd.png");
        amoguses.add("https://i.imgur.com/9CmWkvq.png");
        amoguses.add("https://i.imgur.com/TIfyZoI.png");
        amoguses.add("https://i.imgur.com/nTefeZF.png");
        amoguses.add("https://i.imgur.com/suc1uya.png");
        amoguses.add("https://i.imgur.com/1AJmh9L.png");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        boolean any = false;
        SkinsRestorerHook hook= null;
        for (ggutilHook h : this.plugin.enabledHooks) {
            if (h.getName().equals("SkinsRestorer")) {
                hook = (SkinsRestorerHook) h;
                any = true;
            } else {
                any = false;
            }
        }
        Player p = (Player) sender;
        int r = randomGenerator.nextInt(2);
        if (r == 1) {
            p.playSound(p.getLocation(), Sound.MUSIC_DISC_MALL, 1000, 1);
        } else {
            p.playSound(p.getLocation(), Sound.MUSIC_DISC_WAIT, 500, 1);
        }
        if (any) {
            boolean result = hook.SetSkin(p,amoguses.get(randomGenerator.nextInt(amoguses.size())));

            if (!result) {
                plugin.getLogger().info("sus");
            }
        }
        return true;
    }
}
