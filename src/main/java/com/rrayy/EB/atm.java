package com.rrayy.EB;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import com.rrayy.EB.bill.bill_item;

import net.md_5.bungee.api.ChatColor;

public class atm implements CommandExecutor {
    private final EB plugin;

    public atm(EB plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if(sender instanceof Player) {
            Player Experienced_pl = (Player) sender;
            try {
                int level = Integer.parseInt(args[0]); // 입력한 값 string을 int로 변환

                if (Experienced_pl.getLevel() < level) {
                    sender.sendMessage(plugin.PREFIX+ChatColor.RED+"본인의 레벨보다 큰 값의 경험치 지폐를 만들 수 없습니다.");
                    return false;
                } else {
                    bill_item item_gen = new bill_item(plugin, level);
                    ItemStack item = item_gen.get_item();

                    Experienced_pl.setLevel(Experienced_pl.getLevel() - level); // 현재 경험치에서 입력한 값 빼서 지정
                    Experienced_pl.give(item);
                    sender.sendMessage(plugin.PREFIX+ChatColor.GREEN+"레벨 "+ChatColor.BOLD+level+ChatColor.GREEN+"만큼을 지폐로 인출하였습니다.");
                    return true;
                }
            } catch (Exception e) {
                sender.sendMessage(plugin.PREFIX+ChatColor.RED+"입력할 값은 무조건 정수이여야 합니다.");
                return false;
            }
        } else{
            sender.sendMessage("test");
            return true;
        }
    }
    
}
