package net.kino2mu.caloricage.common.block.heat;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class ThermoreactiveLampBlock extends Block {

    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public ThermoreactiveLampBlock(Properties properties) {

        super(properties.lightLevel(state -> state.getValue(LIT) ? 15 : 0));

        this.registerDefaultState(this.defaultBlockState().setValue(LIT, false));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {

        if(!level.isClientSide){
            if (state.getValue(LIT)){
                level.setBlockAndUpdate(pos, state.setValue(LIT, false));
                level.playSound(null, pos, SoundEvents.IRON_DOOR_CLOSE, SoundSource.BLOCKS);
            }
            else {
                level.setBlockAndUpdate(pos, state.setValue(LIT, true));
                level.playSound(null, pos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }
    //↑これで、作ったLITをstate.getValue(...)により読み取りができるようになる
}
