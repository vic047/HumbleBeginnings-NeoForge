package me.shortman.humblebeginnings.infrastructure.data.loot;

import me.shortman.humblebeginnings.AllItems;
import me.shortman.humblebeginnings.AllTags;
import me.shortman.humblebeginnings.HumbleBeginnings;
import me.shortman.humblebeginnings.infrastructure.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, HumbleBeginnings.MOD_ID);
    }

    @Override
    protected void start() {
        // Add skins to animals
        add("skin_from_village_butcher_chest", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_butcher")).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build()
        }, AllItems.SKIN_COW.get()));

        // Add skins to butchers chest
        add("skin_from_village_butcher_chest", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_butcher")).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build()
        }, AllItems.SKIN_COW.get()));
        add("skin_from_village_butcher_chest", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_butcher")).build(),
                LootItemRandomChanceCondition.randomChance(0.10f).build()
        }, AllItems.SKIN_HORSE.get()));
        add("skin_from_village_butcher_chest", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_butcher")).build(),
                LootItemRandomChanceCondition.randomChance(0.10f).build()
        }, AllItems.SKIN_PIG.get()));
        add("skin_from_village_butcher_chest", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_butcher")).build(),
                LootItemRandomChanceCondition.randomChance(0.10f).build()
        }, AllItems.SKIN_DONKEY.get()));
        add("skin_from_village_butcher_chest", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_butcher")).build(),
                LootItemRandomChanceCondition.randomChance(0.05f).build()
        }, AllItems.SKIN_WOLF.get()));
        add("skin_from_village_butcher_chest", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_butcher")).build(),
                LootItemRandomChanceCondition.randomChance(0.01f).build()
        }, AllItems.SKIN_POLAR_BEAR.get()));

    }
}
