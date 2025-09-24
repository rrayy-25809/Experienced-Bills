package com.rrayy.EB.bill;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.rrayy.EB.EB;

public class bill_event implements Listener {
    private final EB plugin;

    public bill_event(EB plugin){
        this.plugin = plugin;
    }

    public void onPlayerInteraction(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        if (item == null) return;
        bill_item bill = new bill_item(plugin, 0);
        if (bill.is_bill(item)) {
            bill.set_item(item);
            event.getPlayer().setLevel(event.getPlayer().getLevel() + bill.level);
            event.getPlayer().sendMessage(plugin.PREFIX+"경험치 지폐를 사용하여 "+bill.level+"만큼의 경험치를 얻었습니다.");
            item.setAmount(item.getAmount() - 1); // 지폐 1장 소모
            event.setCancelled(true); // 기본 동작 취소
        }
    }
}