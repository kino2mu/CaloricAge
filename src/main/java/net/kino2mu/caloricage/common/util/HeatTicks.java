package net.kino2mu.caloricage.common.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class HeatTicks {

    public static void UpdateHeat(Level level, BlockPos pos, BlockState state){
        if(level.isClientSide()){
            return;
        }

    }
}
