package me.shortman.humblebeginnings.compat.create;

import me.shortman.humblebeginnings.foundation.utility.NameSpace;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class CreateCompat {
    public static Item CREATE_COPPER_NUGGET;

    public static boolean isLoaded() {
        return BuiltInRegistries.BLOCK.containsKey(ResourceLocation.fromNamespaceAndPath(NameSpace.CREATE, "copper_nugget"));
    }

    public static Item getCreateCopperNugget() {
        return BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NameSpace.CREATE, "copper_nugget"));
    }
    public static boolean init() {
        CREATE_COPPER_NUGGET = getCreateCopperNugget();
        return isLoaded();
    }
}
