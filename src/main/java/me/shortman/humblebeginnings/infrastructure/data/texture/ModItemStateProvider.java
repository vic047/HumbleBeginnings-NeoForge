package me.shortman.humblebeginnings.infrastructure.data.texture;

import me.shortman.humblebeginnings.AllItems;
import me.shortman.humblebeginnings.HumbleBeginnings;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemStateProvider extends ItemModelProvider {

    public ModItemStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, HumbleBeginnings.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // normal generated items
        item(AllItems.BARK_BIG.get());
        item(AllItems.BARK_MEDIUM.get());
        item(AllItems.BARK_SMALL.get());
        item(AllItems.HIDE_SOAKED.get());
        item(AllItems.HIDE_RAW.get());
        item(AllItems.POKE_STICK.get());
        item(AllItems.PEBBLE.get());
        item(AllItems.PRIMITIVE_AXE.get());
        item(AllItems.PRIMITIVE_KNIFE.get());
        item(AllItems.TANNIN_COMPOUND.get());
        item(AllItems.SHARP_FLINT.get());
        item(AllItems.SKIN_COW.get());
        item(AllItems.SKIN_DONKEY.get());
        item(AllItems.SKIN_HORSE.get());
        item(AllItems.SKIN_LLAMA.get());
        item(AllItems.SKIN_PIG.get());
        item(AllItems.SKIN_WOLF.get());
        item(AllItems.SKIN_POLAR_BEAR.get());
        item(AllItems.COPPER_NUGGET.get());
    }

    private void item(Item item) {
        String name =  getItemName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/"+name);
    }

    private String getItemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(HumbleBeginnings.MOD_ID + ":", "");
    }
}
