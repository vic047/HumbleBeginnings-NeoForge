package me.shortman.humblebeginnings.foundation.item.poking;

import me.shortman.humblebeginnings.foundation.utility.Random;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;

import java.util.*;

/*
* Takes a PokeProperties object and returns FinalPokeProperties with calculated
* item drops success and sound played.
* */
public class FinalPokeProperties {
    private final SoundEvent soundPlayed;
    private List<ItemStack> itemStackList = new ArrayList<>();
    private boolean isSuccess = false;

    FinalPokeProperties(PokeProperties props) {
        PokeResultItem[] resultItemsList = props.resultItems();
        for (PokeResultItem item : resultItemsList) {
            if (Random.isLuckyWithChanceOf(item.getChance())) {
                this.itemStackList.add(item.getItemStack());
                this.isSuccess = true;
            }
        }
        if (isSuccess) {
            this.soundPlayed = props.soundPlayedSuccess();
        } else {
            this.soundPlayed = props.soundPlayedFail();
        }
    }

    @Override
    public String toString() {
        String str = String.join("Success: ", String.valueOf(isSuccess), "; ",
                "Sound played: ", soundPlayed.toString());
        if (!itemStackList.isEmpty()) {
            str = String.join(str, "; Items: ");
            for (ItemStack itemStack: itemStackList) {
                str = String.join(str, itemStack.toString(), "; ");
            }
        }
        return str;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
    public SoundEvent getSoundPlayed() {
        return soundPlayed;
    }

    public List<ItemStack> getItemStackList() {
        return itemStackList;
    }

}
