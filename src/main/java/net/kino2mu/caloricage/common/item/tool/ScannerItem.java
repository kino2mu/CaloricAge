package net.kino2mu.caloricage.common.item.tool;

import net.kino2mu.caloricage.common.data.CAgeDataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class ScannerItem extends Item {

    public ScannerItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        ItemStack stack = player.getItemInHand(usedHand);

        if (!level.isClientSide) {

            BlockPos savedPos = stack.get(CAgeDataComponents.COORDINATES.get());

            if(!player.isShiftKeyDown()){
                if (savedPos == null) {
                    // 未保存なら現在見ている座標を保存
                    HitResult hitResult = player.pick(100.0D, 0.0F, false);

                    if (hitResult instanceof BlockHitResult blockHit) {
                        BlockPos pos = blockHit.getBlockPos();
                        stack.set(CAgeDataComponents.COORDINATES.get(), pos);
                        player.sendSystemMessage(Component.translatable("item.caloricage.scanner.message.save"));
                        level.playSound(null, player.blockPosition(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS,0.5f,1);
                    }
                }
                else {
                    // 保存済みなら表示
                    player.sendSystemMessage(Component.translatable("item.caloricage.scanner.message.position", savedPos.getX(), savedPos.getY(), savedPos.getZ()));
                }
            }
            else {
                //Shiftを押していれば削除
                stack.remove(CAgeDataComponents.COORDINATES.get());
                player.sendSystemMessage(Component.translatable("item.caloricage.scanner.message.delete"));

            }
        }
        return InteractionResultHolder.success(stack);
    }
}
