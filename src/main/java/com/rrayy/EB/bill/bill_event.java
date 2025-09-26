package com.rrayy.EB.bill;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.rrayy.EB.EB;

public class bill_event implements Listener {
    private final EB plugin;

    public bill_event(EB plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteraction(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        Action action = event.getAction();
        if ((action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)) {
            ItemStack item = p.getInventory().getItemInMainHand();
            bill_item bill = new bill_item(plugin, 0);

            if (item != null && bill.is_bill(item)) { // 아이템이 지폐여야 실행
                bill.set_item(item);
                event.getPlayer().setLevel(event.getPlayer().getLevel() + bill.level);
                event.getPlayer().sendMessage(plugin.PREFIX+"경험치 지폐를 사용하여 "+bill.level+"만큼의 경험치를 얻었습니다.");
                item.setAmount(item.getAmount() - 1); // 지폐 1장 소모
                event.setCancelled(true); // 기본 동작 취소
            }
        }

    }
}