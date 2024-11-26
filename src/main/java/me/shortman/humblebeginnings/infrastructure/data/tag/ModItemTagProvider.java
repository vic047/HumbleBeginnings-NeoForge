package me.shortman.humblebeginnings.infrastructure.data.tag;

import me.shortman.humblebeginnings.AllItems;
import me.shortman.humblebeginnings.AllTags;
import me.shortman.humblebeginnings.HumbleBeginnings;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider provider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, provider.contentsGetter(), HumbleBeginnings.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(AllTags.Items.FARMER_KNIVES)
                .add(AllItems.PRIMITIVE_KNIFE.get());

        tag(AllTags.Items.SKINS)
                .add(AllItems.SKIN_COW.get())
                .add(AllItems.SKIN_DONKEY.get())
                .add(AllItems.SKIN_HORSE.get())
                .add(AllItems.SKIN_LLAMA.get())
                .add(AllItems.SKIN_PIG.get())
                .add(AllItems.SKIN_POLAR_BEAR.get())
                .add(AllItems.SKIN_WOLF.get());

        tag(Tags.Items.NUGGETS)
                .add(AllItems.COPPER_NUGGET.get());

    }
}
