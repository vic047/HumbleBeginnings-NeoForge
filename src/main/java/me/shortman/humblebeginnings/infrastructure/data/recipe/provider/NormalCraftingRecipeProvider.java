package me.shortman.humblebeginnings.infrastructure.data.recipe.provider;

import me.shortman.humblebeginnings.AllBlocks;
import me.shortman.humblebeginnings.AllItems;
import me.shortman.humblebeginnings.AllTags;
import me.shortman.humblebeginnings.compat.Mods;
import me.shortman.humblebeginnings.foundation.utility.ModResourceLocationHelper;
import me.shortman.humblebeginnings.infrastructure.data.recipe.MainModRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class NormalCraftingRecipeProvider extends MainModRecipeProvider {
    private final RecipeOutput recipeOutput;
    private final Map<Item, Block> materialToBlockMap = Map.of(
            AllItems.TANNIN_COMPOUND.get(), AllBlocks.TANNIN_COMPOUND_BLOCK.get()
    );
    private final Map<Item, Item> materialToItemMap = Map.of(
            AllItems.COPPER_NUGGET.get(), Items.COPPER_INGOT
    );

    public NormalCraftingRecipeProvider(DataGenerator generator, CompletableFuture<HolderLookup.Provider> registries, RecipeOutput recipeOutput) {
        super(generator, registries);
        this.recipeOutput = recipeOutput;
    }

    public void build() {
        // Generate 3x3 material to block and reversed (e.g. 9x iron_ingot <-> 1x iron_block) from materialToBlockMap
        for (Map.Entry<Item, Block> entry: materialToBlockMap.entrySet()) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, entry.getValue(), 1)
                    .requires(Ingredient.of(entry.getKey()), 9)
                    .unlockedBy("has_item", has(entry.getKey()))
                    .save(this.recipeOutput, ModResourceLocationHelper.withModId(entry.getValue().getDescriptionId()));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, entry.getKey(), 9)
                    .requires(Ingredient.of(entry.getValue()), 1)
                    .unlockedBy("has_item", has(entry.getValue()))
                    .save(this.recipeOutput, ModResourceLocationHelper.withModId(entry.getKey().getDescriptionId()));

        }

        // Generate 3x3 material to item and reversed (e.g. 9x iron_nugget <-> 1x iron_ingot) from materialToItemMap
        for (Map.Entry<Item, Item> entry: materialToItemMap.entrySet()) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, entry.getValue(), 1)
                    .requires(Ingredient.of(entry.getKey()), 9)
                    .unlockedBy("has_item", has(entry.getKey()))
                    .save(this.recipeOutput, ModResourceLocationHelper.withModId(entry.getValue().getDescriptionId()));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, entry.getKey(), 9)
                    .requires(Ingredient.of(entry.getValue()), 1)
                    .unlockedBy("has_item", has(entry.getValue()))
                    .save(this.recipeOutput, ModResourceLocationHelper.withModId(entry.getKey().getDescriptionId()));
        }

        // Primitive knife + any skin -> raw hide
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AllItems.HIDE_RAW.get(), 1)
                .requires(Ingredient.of(AllTags.Items.SKINS), 1)
                .unlockedBy("has_item", has(AllTags.Items.SKINS))
                .save(this.recipeOutput, ModResourceLocationHelper.withModId("hide_raw"));
    }
}
