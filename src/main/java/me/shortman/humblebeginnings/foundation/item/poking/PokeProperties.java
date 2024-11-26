package me.shortman.humblebeginnings.foundation.item.poking;

import net.minecraft.sounds.SoundEvent;

import java.util.Arrays;

/*
 * chance                -> int between 1 and 100    -> percentage of a successful result
 * resultItem            -> ItemStack                -> item which should drop at a successful result
 * soundPlayedSuccess    -> SoundEvent               -> sound played at a successful result
 * soundPlayedFail (opt) -> SoundEvent               -> sound played at a failed result, if null uses soundPlayedSuccess
 * */
public record PokeProperties(PokeResultItem[] resultItems, SoundEvent soundPlayedSuccess, SoundEvent soundPlayedFail) {
    public PokeProperties(PokeResultItem[] resultItems, SoundEvent soundPlayedSuccess, SoundEvent soundPlayedFail) {
        // Sort by chance
        Arrays.sort(resultItems);
        this.resultItems = resultItems;
        this.soundPlayedSuccess = soundPlayedSuccess;
        if (soundPlayedFail == null) {
            this.soundPlayedFail = soundPlayedSuccess;
        } else {
            this.soundPlayedFail = soundPlayedFail;
        }
    }

    public FinalPokeProperties getFinal() {
        return new FinalPokeProperties(this);
    }
}

