package me.shortman.humblebeginnings.foundation.utility;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTagHelper {
    public static TagKey<Item> createItemTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(NameSpace.MOD, name));
    }
    public static TagKey<Block> createBlockTag(String name) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(NameSpace.MOD, name));
    }
    public static TagKey<Item> createForgeItemTag(String name) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(NameSpace.FORGE, name));
    }
    public static TagKey<Block> createForgeBlockTag(String name) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(NameSpace.FORGE, name));
    }
    public static TagKey<Item> createFarmersItemTag(String name) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(NameSpace.FARMERS, name));
    }
    public static TagKey<Block> createFarmersBlockTag(String name) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(NameSpace.FARMERS, name));
    }

}
