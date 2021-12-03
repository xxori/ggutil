package io.github.xxori.ggutil.commands;

import io.github.xxori.ggutil.ggutil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class giverewards implements CommandExecutor {
    private final ggutil plugin;
    private final Random randomGenerator;

    // Store uptime
    public giverewards(ggutil plugin) {
        this.plugin = plugin;
        randomGenerator = new Random();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            sender.sendMessage(ChatColor.RED + "This command cannot be run by players");
            return true;
        }
        if (args.length < 1) {
            plugin.getLogger().info(ChatColor.RED + "Target not specified");
            return false;
        }
        Player target = plugin.getServer().getPlayer(args[0]);
        if (target == null) {
            plugin.getLogger().info(ChatColor.RED + "Target was invalid");
            return false;
        }
        ItemStack reward = getItem();
        target.getInventory().addItem(reward);
        target.sendMessage(ChatColor.GRAY+"You have received "+ChatColor.GREEN+reward.getAmount()+ "x " +formatMaterialName(reward.getType()));
        return true;
    }

    public static String formatMaterialName(Material material) {
        String[] wordsSplit = material.name().split("_");
        List<String> rlist = new ArrayList<>();
        for(String w: wordsSplit) {
            String word = w.toUpperCase().replace(w.substring(1), w.substring(1).toLowerCase());
            rlist.add(word);
        }
        return String.join(" ", rlist);
    }

    // Gets a random item for daily reward
    private ItemStack getItem() {
        int r = randomGenerator.nextInt(100)+1; //1-100
        if (0<r && r<=10) {
            return new ItemStack(Material.IRON_INGOT, 4);
        } else if (10<r && r<=20) {
            return new ItemStack(Material.IRON_INGOT, 8);
        } else if (20<r && r<=30) {
            return new ItemStack(Material.IRON_INGOT, 16);
        } else if (30<r && r<=34) {
            return new ItemStack(Material.LAPIS_LAZULI, 16);
        } else if (34<r && r<=38) {
            return new ItemStack(Material.LAPIS_LAZULI, 32);
        } else if (38<r && r<=40) {
            return new ItemStack(Material.LAPIS_LAZULI, 64);
        } else if (40<r && r<=50) {
            return new ItemStack(Material.EXPERIENCE_BOTTLE, 3);
        } else if (50<r && r<=56) {
            return new ItemStack(Material.EXPERIENCE_BOTTLE, 5);
        } else if (56<r && r<=60) {
            return new ItemStack(Material.EXPERIENCE_BOTTLE, 8);
        } else if (60<r && r<=64) {
            return new ItemStack(Material.EMERALD, 2);
        } else if (64<r && r<=68) {
            return new ItemStack(Material.EMERALD, 4);
        } else if (68<r && r<=70) {
            return new ItemStack(Material.EMERALD, 5);
        } else if (70<r && r<=80) {
            return new ItemStack(Material.DIAMOND, 2);
        } else if (80<r && r<=88) {
            return new ItemStack(Material.DIAMOND, 4);
        } else if (88<r && r<=93) {
            return new ItemStack(Material.DIAMOND, 5);
        } else if (93<r && r<=95) {
            return new ItemStack(Material.NETHERITE_INGOT, 1);
        } else if (95<r && r<=98) {
            return new ItemStack(Material.WITHER_SKELETON_SKULL, 1);
        } else if (98<r && r<=100) {
            return new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1);
        } else {
            plugin.getLogger().info(ChatColor.RED + "FUCK");
            return new ItemStack(Material.DIRT, 6969);
        }
    }
}
