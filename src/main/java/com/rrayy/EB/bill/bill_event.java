package com.rrayy.EB.bill;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class bill_event implements Listener {
    public void onPlayerInteraction(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
    }
}