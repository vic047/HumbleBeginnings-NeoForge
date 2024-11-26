package me.shortman.humblebeginnings;

import me.shortman.humblebeginnings.foundation.utility.ModResourceLocationHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AllCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HumbleBeginnings.MOD_ID);

    public static final Supplier<CreativeModeTab> WOOD_WORKING_TAB = CREATIVE_MODE_TAB.register("wood_working_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(AllItems.PRIMITIVE_AXE.get()))
                    .title(Component.translatable("creativetab.humblebeginnings.wood_working"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(AllItems.POKE_STICK);
                        output.accept(AllItems.SHARP_FLINT);
                        output.accept(AllItems.PRIMITIVE_AXE);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> STONE_WORKING_TAB = CREATIVE_MODE_TAB.register("stone_working_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(AllItems.PEBBLE.get()))
                    .withTabsBefore(ModResourceLocationHelper.withModId("wood_working_tab"))
                    .title(Component.translatable("creativetab.humblebeginnings.stone_working"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(AllItems.PEBBLE);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> COPPER_WORKING_TAB = CREATIVE_MODE_TAB.register("copper_working_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(AllItems.COPPER_NUGGET.get()))
                    .withTabsBefore(ModResourceLocationHelper.withModId("stone_working_tab"))
                    .title(Component.translatable("creativetab.humblebeginnings.copper_working"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(AllItems.COPPER_NUGGET);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> LEATHER_WORKING_TAB = CREATIVE_MODE_TAB.register("leather_working_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(AllItems.HIDE_RAW.get()))
                    .withTabsBefore(ModResourceLocationHelper.withModId( "copper_working_tab"))
                    .title(Component.translatable("creativetab.humblebeginnings.leather_working"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(AllItems.PRIMITIVE_KNIFE);
                        output.accept(AllItems.HIDE_RAW);
                        output.accept(AllItems.HIDE_SOAKED);
                        output.accept(AllItems.BARK_SMALL);
                        output.accept(AllItems.BARK_MEDIUM);
                        output.accept(AllItems.BARK_BIG);
                        output.accept(AllItems.TANNIN_COMPOUND);
                        output.accept(AllBlocks.TANNIN_COMPOUND_BLOCK);
                        output.accept(AllItems.SKIN_COW);
                        output.accept(AllItems.SKIN_DONKEY);
                        output.accept(AllItems.SKIN_HORSE);
                        output.accept(AllItems.SKIN_LLAMA);
                        output.accept(AllItems.SKIN_PIG);
                        output.accept(AllItems.SKIN_POLAR_BEAR);
                        output.accept(AllItems.SKIN_WOLF);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
