package org.weedcraft.kitpreview.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.weedcraft.kitpreview.KitPreview;
import org.weedcraft.kitpreview.Lang;
import org.weedcraft.kitpreview.api.EssAPI;

public class CommandPreviewKit implements CommandExecutor {

    KitPreview plugin = KitPreview.pl();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("previewkit")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(plugin.references.getPrefix() + Lang.NO_CONSOLE_ACCESS.getConfigValue(null));
            } else {
                Player player = (Player) sender;
                if (!player.hasPermission("previewkit.use")) {
                    player.sendMessage(plugin.references.getPrefix() + Lang.NO_PERM.getConfigValue(null));
                } else {
                    if (args.length != 1) {
                        player.sendMessage(plugin.references.getPrefix() + Lang.PREVIEW_NO_KIT_SUPPLIED.getConfigValue(null));
                    } else {
                        String kit = args[0].toLowerCase();
                        if (plugin.ess.getSettings().getKit(kit) == null) {
                            player.sendMessage(plugin.references.getPrefix() + Lang.KIT_DOESNT_EXIST.getConfigValue(kit));
                        } else {
                            player.sendMessage(plugin.references.getPrefix() + Lang.PREPARING_PREVIEW.getConfigValue(kit));
                            EssAPI.displayKit(plugin.ess, player, kit);
                            player.sendMessage(plugin.references.getPrefix() + Lang.PREVIEWING_KIT.getConfigValue(kit));
                        }
                    }
                }
            }
        }
        return true;
    }
}
