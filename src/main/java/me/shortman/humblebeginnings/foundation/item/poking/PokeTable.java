package me.shortman.humblebeginnings.foundation.item.poking;

import me.shortman.humblebeginnings.AllItems;
import me.shortman.humblebeginnings.AllTags;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;



public class PokeTable {
    private static final PokeResultItem[] GRAVEL_RESULT_ITEMS = {
        new PokeResultItem(25, 1, AllItems.SHARP_FLINT.get()),
            new PokeResultItem(40, 1, AllItems.PEBBLE.get()),
            new PokeResultItem(5, 2, AllItems.SHARP_FLINT.get())
    };
    private static final PokeProperties GRAVEL_PROPS = new PokeProperties(GRAVEL_RESULT_ITEMS, SoundEvents.GRAVEL_BREAK, SoundEvents.GRAVEL_PLACE);

    private static final PokeResultItem[] DIRT_RESULT_ITEMS = {
        new PokeResultItem(1, 1, AllItems.SHARP_FLINT.get()),
            new PokeResultItem(10, 1, AllItems.PEBBLE.get())
    };
    private static final PokeProperties DIRT_PROPS = new PokeProperties(DIRT_RESULT_ITEMS, SoundEvents.ROOTED_DIRT_BREAK, SoundEvents.ROOTED_DIRT_PLACE);

    private static final Map<TagKey<Block>, PokeProperties> GROUND_POKE_TABLE =
            Map.of(
                    AllTags.Blocks.GRAVEL_FOR_SHARP_FLINT, GRAVEL_PROPS,
                    BlockTags.DIRT, DIRT_PROPS
            );

    public static boolean isValidGroundBlock(BlockState blockState, BlockState blockStateAbove) {
        for(TagKey<Block> key: GROUND_POKE_TABLE.keySet()) {
            if (blockState.is(key)) {
                return true;
            }
        }
        return false;
    }

    public static FinalPokeProperties getFinalGroundPokeProperties(BlockState blockState) {
        for(TagKey<Block> key: GROUND_POKE_TABLE.keySet()) {
            if (blockState.is(key)) {
                return GROUND_POKE_TABLE.get(key).getFinal();
            }
        }
        return null;
    }
}
