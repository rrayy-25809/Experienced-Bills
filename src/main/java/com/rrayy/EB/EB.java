package com.rrayy.EB;

import org.bukkit.plugin.java.JavaPlugin;

public class EB extends JavaPlugin {
    public final String PREFIX = "[EB]"

    @Override
    public void onEnable() {
        getLogger().info("Experienced Bills Plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Experienced Bills Plugin has been disabled!");
    }
}
