package org.weedcraft.kitpreview.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.weedcraft.kitpreview.KitPreview;
import org.weedcraft.kitpreview.Lang;

import java.io.IOException;

public class CommandKitPreview implements CommandExecutor {

    KitPreview plugin = KitPreview.pl();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("kitpreview")) {
            if (args.length != 1) {
                sender.sendMessage(ChatColor.DARK_GRAY.toString() + ChatColor.STRIKETHROUGH + "+------------------------------------------------+");
                sender.sendMessage(ChatColor.RESET + "  " + ChatColor.GRAY + "» " + ChatColor.GOLD + "/" + label + " [reload]" + ChatColor.GRAY + " Main command.");
                sender.sendMessage(ChatColor.RESET + "  " + ChatColor.GRAY + "» " + ChatColor.GOLD + "/previewkit <kit>" + ChatColor.GRAY + " Preview a kit.");
                sender.sendMessage(ChatColor.RESET + "  " + ChatColor.YELLOW.toString() + ChatColor.ITALIC + "'< >' = required, '[ ]' = optional");
                sender.sendMessage(ChatColor.DARK_GRAY.toString() + ChatColor.STRIKETHROUGH + "+------------------------------------------------+");
            } else if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                if (!sender.isOp()) {
                    sender.sendMessage(plugin.references.getPrefix() + Lang.NO_PERM.getConfigValue(null));
                } else {
                    plugin.reloadConfig();
                    plugin.saveConfig();
                    sender.sendMessage(plugin.references.getPrefix() + ChatColor.GREEN + "Configuration file reloaded.");
                }
            } else {
                sender.sendMessage(plugin.references.getPrefix() + ChatColor.GRAY + "Were you looking for /kitpreview reload?");
            }
        }
        return true;
    }
}
