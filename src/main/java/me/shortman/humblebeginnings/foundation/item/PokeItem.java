package me.shortman.humblebeginnings.foundation.item;


import me.shortman.humblebeginnings.foundation.item.poking.FinalPokeProperties;
import me.shortman.humblebeginnings.foundation.item.poking.PokeTable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class PokeItem extends Item {
    public PokeItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        boolean isValidBlock = false;
        Level level = context.getLevel();
        Player player = context.getPlayer();
        assert player != null;
        BlockPos clickedBlockPos = context.getClickedPos();
        BlockState clickedBlockState = level.getBlockState(clickedBlockPos);
        Direction clickedBlockDirection = context.getClickedFace();
        BlockState aboveBlockState = level.getBlockState(clickedBlockPos.above());
        FinalPokeProperties props;
        if (PokeTable.isValidGroundBlock(clickedBlockState, aboveBlockState)) {
            isValidBlock = true;
            context.getItemInHand().hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
            player.getCooldowns().addCooldown(context.getItemInHand().getItem(), 10);
            if (!level.isClientSide()) {
                InteractionHand hand = player.getUsedItemHand();
                ItemStack itemStack = player.getItemInHand(hand);
                ItemStack original = itemStack.copy();
                itemStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
                if(itemStack.isEmpty()) {
                    net.neoforged.neoforge.event.EventHooks.onPlayerDestroyItem(player, original, hand);
                }
                props = PokeTable.getFinalGroundPokeProperties(clickedBlockState);
                assert props != null;
                player.sendSystemMessage(Component.literal(props.toString()));
                if (props.isSuccess()) {
                    level.playSound(null, clickedBlockPos, props.getSoundPlayed(), SoundSource.BLOCKS, 1f, 1f);
                    // Drop all items from ItemStack list above block
                    for (ItemStack i: props.getItemStackList()) {
                        level.addFreshEntity(new ItemEntity(level, clickedBlockPos.getX(), clickedBlockPos.getY() + 1, clickedBlockPos.getZ(), i));
                    }
                }
            }
        }
        if (isValidBlock) {
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }
}
