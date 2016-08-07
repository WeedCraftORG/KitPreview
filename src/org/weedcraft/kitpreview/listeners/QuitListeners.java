package org.weedcraft.kitpreview.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.weedcraft.kitpreview.KitPreview;

public class QuitListeners implements Listener {

    KitPreview plugin = KitPreview.pl();

    @EventHandler
    public void quit(PlayerQuitEvent event) {
        if (plugin.xyz.contains(event.getPlayer().getUniqueId())) {
            plugin.xyz.remove(event.getPlayer().getUniqueId());
        }
    }
}

