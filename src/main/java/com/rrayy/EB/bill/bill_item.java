package com.rrayy.EB.bill;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import com.rrayy.EB.EB;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class bill_item {
    private final EB plugin;
    private final ItemStack item = new ItemStack(Material.PAPER);

    public bill_item(EB plugin){
        this.plugin = plugin;
    }

    public ItemStack get_item(int amount) {
        ItemMeta meta = this.item.getItemMeta();
        meta.customName(Component.text("경험치 지폐", NamedTextColor.GREEN));

        List<Component> lore = new ArrayList<>();
        lore.add(Component.text("저장된 경험치 값:", NamedTextColor.AQUA));
        lore.add(Component.text(amount, NamedTextColor.YELLOW));
        meta.lore(lore);
        this.item.setItemMeta(meta);

        // meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        // meta.addEnchant(Enchantment.DURABILITY, 3, true);
        // meta.addItemFlags(ItemFlag.HIDE_ENCHANTS); 이거 좋다

        // 커스텀 아이템 식별용 PersistentData
        NamespacedKey key = new NamespacedKey(plugin, "Experienced Bills");
        this.item.editPersistentDataContainer(pdc -> {
            pdc.set(key, PersistentDataType.STRING, "EB "+amount);
        });

        return this.item;
    }

    public int get_level(ItemStack bill){
        return 0;
    }
}
