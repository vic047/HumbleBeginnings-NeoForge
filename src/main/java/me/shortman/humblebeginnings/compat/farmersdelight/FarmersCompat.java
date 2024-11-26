package me.shortman.humblebeginnings.compat.farmersdelight;

import me.shortman.humblebeginnings.compat.create.CreateCompat;
import me.shortman.humblebeginnings.foundation.utility.NameSpace;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class FarmersCompat {
private static boolean isLoaded() {
        return BuiltInRegistries.BLOCK.containsKey(ResourceLocation.fromNamespaceAndPath(NameSpace.FARMERS, "cutting_board"));
    }

    public static boolean init() {
        return isLoaded();
    }

}
