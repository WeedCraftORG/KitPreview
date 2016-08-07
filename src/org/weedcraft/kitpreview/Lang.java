package org.weedcraft.kitpreview;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public enum Lang {

    /**
     * Prefix
     */
    PREFIX("prefix", "&6[KitPreview]"),
    /**
     * Console can't run command
     */
    NO_CONSOLE_ACCESS("no-console", "&cOnly players may do that."),
    /**
     * No permission for an action
     */
    NO_PERM("no-permission", "&cYou do not have permission to do that!"),
    /**
     * No kit supplied in command args
     */
    PREVIEW_NO_KIT_SUPPLIED("no-kit-supplied", "&7Please include a kit to preview."),
    /**
     * Kit doesn't exist within Essentials
     */
    KIT_DOESNT_EXIST("kit-doesnt-exist", "&cThat kit does not exist."),
    /**
     * Message about preparing their preview
     */
    PREPARING_PREVIEW("preparing-preview", "&7Preparing preview..."),
    /**
     * Previewing kit message
     */
    PREVIEWING_KIT("no-console", "&aYou are now previewing kit '{KIT}'"),
    /**
     * Title of the sign
     */
    SIGN_TITLE("sign-title", "&1[PreviewKit]"),
    /**
     * Sign created message
     */
    PREVIEW_SIGN_CREATED("sign-created", "&aPreview sign created for kit '{KIT}'");

    private String path;
    private String def;
    private static FileConfiguration LANG;

    Lang(String path, String start) {
        this.path = path;
        this.def = start;
    }

    public static void setFile(final FileConfiguration config) {
        LANG = config;
    }

    public String getDefault() {
        return this.def;
    }

    public String getPath() {
        return this.path;
    }

    public String getConfigValue(String kit) {
        String value = ChatColor.translateAlternateColorCodes('&', LANG.getString(this.path, this.def));

        if (kit != null) {
            return value.replace("{KIT}", kit);
        }
        return value;
    }
}
