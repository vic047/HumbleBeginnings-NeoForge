package me.shortman.humblebeginnings.infrastructure.data.recipe.provider;

import me.shortman.humblebeginnings.AllItems;
import me.shortman.humblebeginnings.compat.Mods;
import me.shortman.humblebeginnings.compat.create.CreateCompat;
import me.shortman.humblebeginnings.foundation.utility.ModResourceLocationHelper;
import me.shortman.humblebeginnings.infrastructure.data.recipe.MainModRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class FurnaceRecipeProvider extends MainModRecipeProvider {
    private final RecipeOutput recipeOutput;
    private final Map<Item, Item> smeltingOreNuggetMap = Map.of(
            Items.RAW_IRON, Items.IRON_NUGGET,
            Items.RAW_GOLD, Items.GOLD_NUGGET,
            Items.RAW_COPPER, AllItems.COPPER_NUGGET.get()
    );

    public FurnaceRecipeProvider(DataGenerator generator, CompletableFuture<HolderLookup.Provider> registries, RecipeOutput recipeOutput) {
        super(generator, registries);
        this.recipeOutput = recipeOutput;
    }

    public void build() {
        // Create Ore -> Nugget recipes for smelting and blasting from smelting_ore_nugget_map
        // Blasting will provide two nuggets, while smelting provides only one
        for (Map.Entry<Item, Item> entry : smeltingOreNuggetMap.entrySet()) {
            SimpleCookingRecipeBuilder.smelting(Ingredient.of(entry.getKey()), RecipeCategory.MISC,
                            entry.getValue(), 0.6f, 300)
                    .unlockedBy("has_item", has(entry.getKey()))
                    .save(this.recipeOutput, ModResourceLocationHelper.withMinecraftId(entry.getKey().toString() + "_smelting"));

            SimpleCookingRecipeBuilder.blasting(Ingredient.of(entry.getKey()), RecipeCategory.MISC,
                            new ItemStack(entry.getValue(), 2), 0.6f, 100)
                    .unlockedBy("has_item", has(entry.getKey()))
                    .save(this.recipeOutput, ModResourceLocationHelper.withMinecraftId(entry.getKey().toString() + "_blasting"));
        }
    }
}
