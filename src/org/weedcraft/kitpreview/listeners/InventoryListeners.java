package org.weedcraft.kitpreview.listeners;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.scheduler.BukkitRunnable;
import org.weedcraft.kitpreview.KitPreview;

public class InventoryListeners implements Listener {

    KitPreview plugin = KitPreview.pl();

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getInventory().getTitle().startsWith("Previewing") || plugin.xyz.contains(event.getWhoClicked().getUniqueId())) {
            event.setCancelled(true);
            if (plugin.references.isPlaySound()) {
                ((Player) event.getWhoClicked()).playSound(event.getWhoClicked().getLocation(), plugin.references.getSound(), 10.0F, 1.0F);
            }
        }
    }

    @EventHandler
    public void onDrag(InventoryDragEvent event) {
        if (event.getInventory().getTitle().startsWith("Previewing") || plugin.xyz.contains(event.getWhoClicked().getUniqueId())) {
            event.setCancelled(true);
            if (plugin.references.isPlaySound()) {
                ((Player) event.getWhoClicked()).playSound(event.getWhoClicked().getLocation(), plugin.references.getSound(), 10.0F, 1.0F);
            }
        }
    }

    @EventHandler
    public void onInteract(InventoryInteractEvent event) {
        if (event.getInventory().getTitle().startsWith("Previewing") || plugin.xyz.contains(event.getWhoClicked().getUniqueId())) {
            event.setCancelled(true);
            if (plugin.references.isPlaySound()) {
                ((Player) event.getWhoClicked()).playSound(event.getWhoClicked().getLocation(), plugin.references.getSound(), 10.0F, 1.0F);
            }
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        final Player player = (Player) event.getPlayer();
        if (plugin.xyz.contains(player.getUniqueId())) {
            new BukkitRunnable() {
                public void run() {
                    plugin.xyz.remove(player.getUniqueId());
                }
            }.runTaskLater(plugin, 20L);
        }
    }
}

