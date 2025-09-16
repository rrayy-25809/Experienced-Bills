package com.rrayy.EB;

import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class EB extends JavaPlugin {
    public final String PREFIX = ChatColor.DARK_AQUA+"§l[EB] ";

    @Override
    public void onEnable() {
        getLogger().info("Experienced Bills Plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Experienced Bills Plugin has been disabled!");
    }
}
