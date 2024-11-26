package me.shortman.humblebeginnings.foundation.item.poking;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PokeResultItem implements Comparable<PokeResultItem> {
    int chance;
    int count;
    Item item;

    public PokeResultItem(int chance, int count, Item item) {
        this.chance = chance;
        this.count = count;
        this.item = item;
    }

    public int getChance() {
        return chance;
    }

    public ItemStack getItemStack() {
        return new ItemStack(item, count);
    }

    @Override
    public int compareTo(@NotNull PokeResultItem o) {
        return Integer.compare(chance, o.getChance());
    }
}
