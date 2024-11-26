package me.shortman.humblebeginnings.infrastructure.data.lang;

import me.shortman.humblebeginnings.AllBlocks;
import me.shortman.humblebeginnings.AllCreativeModeTabs;
import me.shortman.humblebeginnings.AllItems;
import me.shortman.humblebeginnings.HumbleBeginnings;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModEnLangProvider extends LanguageProvider {
    public ModEnLangProvider(PackOutput output) {
        super(output, HumbleBeginnings.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Items
        addItem(AllItems.POKE_STICK, "Poke Stick");
        addItem(AllItems.SHARP_FLINT, "Sharp Flint");
        addItem(AllItems.PEBBLE, "Pebble");
        addItem(AllItems.TANNIN_COMPOUND, "Tannin Compound");
        addItem(AllItems.PRIMITIVE_KNIFE, "Primitive Knife");
        addItem(AllItems.PRIMITIVE_AXE, "Primitive Axe");
        addItem(AllItems.BARK_SMALL, "Small Piece of Bark");
        addItem(AllItems.BARK_MEDIUM, "Piece of Bark");
        addItem(AllItems.BARK_BIG, "Big Piece of Bark");
        addItem(AllItems.HIDE_RAW, "Raw Hide");
        addItem(AllItems.HIDE_SOAKED, "Soaked Hide");
        addItem(AllItems.SKIN_COW, "Cow Skin");
        addItem(AllItems.SKIN_DONKEY, "Donkey Skin");
        addItem(AllItems.SKIN_HORSE, "Horse Skin");
        addItem(AllItems.SKIN_LLAMA, "Llama Skin");
        addItem(AllItems.SKIN_PIG, "Pig Skin");
        addItem(AllItems.SKIN_POLAR_BEAR, "Polar Bear Skin");
        addItem(AllItems.SKIN_WOLF, "Wolf Skin");
        addItem(AllItems.COPPER_NUGGET, "Copper Nugget");

        // Blocks
        addBlock(AllBlocks.TANNIN_COMPOUND_BLOCK, "Tannin Compound Block");

        // Creative Tabs
        add("creativetab.humblebeginnings.wood_working", "Wood Working");
        add("creativetab.humblebeginnings.stone_working", "Stone Working");
        add("creativetab.humblebeginnings.copper_working", "Copper Working");
        add("creativetab.humblebeginnings.leather_working", "Leather Working");

        // Sounds
        add("sounds.humble_beginnings.flint_hit", "Flint Hit");
        add("sounds.humble_beginnings.flint_break", "Flint Break");

    }
}
