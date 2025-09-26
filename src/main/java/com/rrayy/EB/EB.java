package com.rrayy.EB;

import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

import com.rrayy.EB.bill.bill_event;

public class EB extends JavaPlugin {
    public final String PREFIX = ChatColor.DARK_AQUA+"§l[EB] ";
    public atm atm = new atm(this);
    public bill_event bill_event = new bill_event(this);

    @Override
    public void onEnable() {
        this.getCommand("atm").setExecutor(atm);
        this.getServer().getPluginManager().registerEvents(bill_event, this);
        getLogger().info("Experienced Bills Plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Experienced Bills Plugin has been disabled!");
    }
}
