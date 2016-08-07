package org.weedcraft.kitpreview.api;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.Kit;
import com.earth2me.essentials.MetaItemStack;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.weedcraft.kitpreview.KitPreview;

public class EssAPI {

    public static List<ItemStack> getItems(Essentials ess, Player p, String kitName) {
        Kit kit = null;
        List<String> items = null;
        List<ItemStack> stacks = new ArrayList();
        try {
            kit = new Kit(kitName, ess);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            items = kit.getItems(ess.getUser(p));
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String str : items) {
            String[] parts = str.split(" +");
            ItemStack parseStack = null;
            try {
                parseStack = ess.getItemDb().get(parts[0], parts.length > 1 ? Integer.parseInt(parts[1]) : 1);
            } catch (NumberFormatException e1) {
                e1.printStackTrace();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            MetaItemStack metaStack = new MetaItemStack(parseStack);
            if (parts.length > 2) {
                try {
                    metaStack.parseStringMeta(null, true, parts, 2, ess);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            stacks.add(metaStack.getItemStack());
        }
        return stacks;
    }

    public static void displayKit(Essentials ess, Player p, String kitName) {
        KitPreview.pl().xyz.add(p.getUniqueId());
        Inventory i = Bukkit.createInventory(p, 54, "Previewing " + StringUtils.capitalize(kitName) + " Kit");
        for (ItemStack is : getItems(ess, p, kitName)) {
            i.addItem(new ItemStack[]{is});
        }
        p.openInventory(i);
    }
}
