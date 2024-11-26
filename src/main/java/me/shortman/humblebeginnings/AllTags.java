package me.shortman.humblebeginnings;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static me.shortman.humblebeginnings.foundation.utility.ModTagHelper.*;

public final class AllTags {
    public static class Blocks {
        public static final TagKey<Block> LOGS_FOR_MEDIUM_BARK = createBlockTag("logs_for_medium_bark");
        public static final TagKey<Block> LOGS_FOR_BIG_BARK = createBlockTag("logs_for_big_bark");
        public static final TagKey<Block> GRAVEL_FOR_SHARP_FLINT = createBlockTag("gravel_for_sharp_flint");
    }

    public static class Items {
        // Get farmers "tools/knives" item tag
        public static final TagKey<Item> FARMER_KNIVES = createFarmersItemTag("tools/knives");
        public static final TagKey<Item> SKINS = createItemTag("skins");

    }
}
