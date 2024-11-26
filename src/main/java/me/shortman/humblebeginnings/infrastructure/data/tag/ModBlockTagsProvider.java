package me.shortman.humblebeginnings.infrastructure.data.tag;

import me.shortman.humblebeginnings.AllBlocks;
import me.shortman.humblebeginnings.AllTags;
import me.shortman.humblebeginnings.HumbleBeginnings;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, HumbleBeginnings.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(AllBlocks.TANNIN_COMPOUND_BLOCK.get());

        tag(AllTags.Blocks.GRAVEL_FOR_SHARP_FLINT)
                .add(Blocks.GRAVEL);

        tag(AllTags.Blocks.LOGS_FOR_MEDIUM_BARK)
                .add(Blocks.BIRCH_LOG)
                .add(Blocks.BIRCH_WOOD)
                .add(Blocks.SPRUCE_WOOD)
                .add(Blocks.SPRUCE_LOG);

        tag(AllTags.Blocks.LOGS_FOR_BIG_BARK)
                .add(Blocks.DARK_OAK_LOG)
                .add(Blocks.DARK_OAK_WOOD)
                .add(Blocks.JUNGLE_WOOD)
                .add(Blocks.JUNGLE_LOG);
    }
}
