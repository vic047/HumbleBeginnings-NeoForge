package me.shortman.humblebeginnings.infrastructure.data;

import me.shortman.humblebeginnings.AllTags;
import me.shortman.humblebeginnings.HumbleBeginnings;
import me.shortman.humblebeginnings.infrastructure.data.lang.ModEnLangProvider;
import me.shortman.humblebeginnings.infrastructure.data.loottable.ModLootTablesProvider;
import me.shortman.humblebeginnings.infrastructure.data.recipe.MainModRecipeProvider;
import me.shortman.humblebeginnings.infrastructure.data.tag.ModBlockTagsProvider;
import me.shortman.humblebeginnings.infrastructure.data.tag.ModItemTagProvider;
import me.shortman.humblebeginnings.infrastructure.data.texture.ModBlockStateProvider;
import me.shortman.humblebeginnings.infrastructure.data.texture.ModItemStateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGenerators {
    public static void gatherData(GatherDataEvent event) {
        try {
            DataGenerator generator = event.getGenerator();
            PackOutput output = generator.getPackOutput();
            ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

            // Add provider for all data providers
            generator.addProvider(true, new ModEnLangProvider(output));
            generator.addProvider(true, new ModItemStateProvider(output, existingFileHelper));
            generator.addProvider(true, new ModBlockStateProvider(output, existingFileHelper));
            ModBlockTagsProvider modBlockTagsProvider = new ModBlockTagsProvider(output, event.getLookupProvider(), existingFileHelper);
            generator.addProvider(true, modBlockTagsProvider);
            generator.addProvider(true, new ModItemTagProvider(output, event.getLookupProvider(), modBlockTagsProvider, existingFileHelper));
            generator.addProvider(true, new ModLootTablesProvider(output, event.getLookupProvider()));
            generator.addProvider(true, new MainModRecipeProvider(generator, event.getLookupProvider()));
        } catch (Exception e) {
            HumbleBeginnings.LOGGER.error("Failed to generate data!", e);
        }
    }
}
