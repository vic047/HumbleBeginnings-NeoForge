package me.shortman.humblebeginnings.infrastructure.data.recipe;

import me.shortman.humblebeginnings.HumbleBeginnings;
import me.shortman.humblebeginnings.foundation.utility.NameSpace;
import me.shortman.humblebeginnings.infrastructure.data.recipe.provider.FurnaceRecipeProvider;
import me.shortman.humblebeginnings.infrastructure.data.recipe.provider.NormalCraftingRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class MainModRecipeProvider extends RecipeProvider {
    protected final DataGenerator generator;
    private final CompletableFuture<HolderLookup.Provider> registries;

    public MainModRecipeProvider(DataGenerator generator, CompletableFuture<HolderLookup.Provider> registries) {
        super(generator.getPackOutput(), registries);
        this.generator = generator;
        this.registries = registries;
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        new NormalCraftingRecipeProvider(generator, registries, recipeOutput).build();
        new FurnaceRecipeProvider(generator, registries, recipeOutput).build();
    }

}
