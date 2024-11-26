package me.shortman.humblebeginnings.infrastructure.data.texture;

import me.shortman.humblebeginnings.AllBlocks;
import me.shortman.humblebeginnings.HumbleBeginnings;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, HumbleBeginnings.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        normalBlock(AllBlocks.TANNIN_COMPOUND_BLOCK.get());
    }

    private void normalBlock(Block block) {
        ResourceLocation blockKey = BuiltInRegistries.BLOCK.getKey(block);
        String path = blockKey.getPath();
        simpleBlock(block, models().cubeAll(path, modLoc("block/" + path)));
        simpleBlockItem(block, models().getExistingFile(modLoc("block/" + path)));
    }
}
