package com.rrayy.EB.bill;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import com.rrayy.EB.EB;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class bill_item {
    private final ItemStack item = new ItemStack(Material.PAPER);
    private NamespacedKey key;
    public int level;

    public bill_item(EB plugin, int level){
        this.key = new NamespacedKey(plugin, "Experienced Bills");
        this.level = level;
    }

    public ItemStack get_item() {
        ItemMeta meta = this.item.getItemMeta();
        meta.customName(Component.text("경험치 지폐", NamedTextColor.GREEN));

        List<Component> lore = new ArrayList<>();
        lore.add(Component.text("저장된 경험치 값:", NamedTextColor.AQUA));
        lore.add(Component.text(this.level, NamedTextColor.YELLOW));
        meta.lore(lore);
        
        // meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        // meta.addEnchant(Enchantment.DURABILITY, 3, true);
        // meta.addItemFlags(ItemFlag.HIDE_ENCHANTS); 이거 좋다
        
        PersistentDataContainer pdc = meta.getPersistentDataContainer(); // 커스텀 아이템 식별용 PersistentData
        pdc.set(this.key, PersistentDataType.STRING, "EB "+this.level);
        
        this.item.setItemMeta(meta);
        return this.item;
    }

    public void set_item(ItemStack bill){
        PersistentDataContainer data = bill.getItemMeta().getPersistentDataContainer();
        String storedId = data.get(key, PersistentDataType.STRING);

        this.level = Integer.parseInt(storedId.split(" ")[1]); // 공백 기준으로 나눈 후 뒤의 level 값만 가져옴
    }

    public boolean is_bill(ItemStack item){
        if (item.getType().equals(Material.PAPER)){
            ItemMeta meta = item.getItemMeta();
            PersistentDataContainer data = meta.getPersistentDataContainer();

            if (data.has(key, PersistentDataType.STRING)){
                String storedId = data.get(key, PersistentDataType.STRING);
                return storedId.startsWith("EB ");
            }
        }
        return false;
    }
}
