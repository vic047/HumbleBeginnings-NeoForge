package me.shortman.humblebeginnings;

import me.shortman.humblebeginnings.foundation.item.PokeItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AllItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(HumbleBeginnings.MOD_ID);
    /*
     *      REGISTER ITEMS
     * */
    // WOOD WORKING
    public static final DeferredItem<Item> SHARP_FLINT = ITEMS.register("sharp_flint",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> POKE_STICK = ITEMS.register("poke_stick",
            () -> new PokeItem(new Item.Properties().durability(40)));

    public static final DeferredItem<Item> PRIMITIVE_AXE = ITEMS.register("primitive_axe",
            () -> new AxeItem(Tiers.STONE, new Item.Properties().durability(50)));

    // STONE WORKING
    public static final DeferredItem<Item> PEBBLE = ITEMS.register("pebble",
            () -> new Item(new Item.Properties()));

    // Leather Working Items
    public static final DeferredItem<Item> PRIMITIVE_KNIFE = ITEMS.register("primitive_knife",
            () -> new Item(new Item.Properties().durability(20)));

    public static final DeferredItem<Item> TANNIN_COMPOUND = ITEMS.register("tannin_compound",
            () -> new Item(new Item.Properties()));

    // Bark
    public static final DeferredItem<Item> BARK_SMALL = ITEMS.register("bark_small",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BARK_MEDIUM = ITEMS.register("bark_medium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BARK_BIG = ITEMS.register("bark_big",
            () -> new Item(new Item.Properties()));

    // Skin
    public static final DeferredItem<Item> SKIN_COW = ITEMS.register("skin_cow",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SKIN_PIG = ITEMS.register("skin_pig",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SKIN_HORSE = ITEMS.register("skin_horse",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SKIN_DONKEY = ITEMS.register("skin_donkey",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SKIN_LLAMA = ITEMS.register("skin_llama",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SKIN_POLAR_BEAR = ITEMS.register("skin_polar_bear",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SKIN_WOLF = ITEMS.register("skin_wolf",
            () -> new Item(new Item.Properties()));

    // Hide
    public static final DeferredItem<Item> HIDE_RAW = ITEMS.register("hide_raw",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> HIDE_SOAKED = ITEMS.register("hide_soaked",
            () -> new Item(new Item.Properties()));

    // COPPER WORKING
    public static final DeferredItem<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties()));

    /*
     *      END OF REGISTER ITEMS
     * */
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
