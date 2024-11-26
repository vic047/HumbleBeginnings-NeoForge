package me.shortman.humblebeginnings;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AllBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(HumbleBeginnings.MOD_ID);
    /*
     *      REGISTER BLOCKS
     * */
    // Wood Working Blocks
    // Leather Working Blocks
    public static final DeferredBlock<Block> TANNIN_COMPOUND_BLOCK = registerBlock("tannin_compound_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));

    /*
     *      END OF REGISTER BLOCKS
     * */

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
     }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        AllItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
