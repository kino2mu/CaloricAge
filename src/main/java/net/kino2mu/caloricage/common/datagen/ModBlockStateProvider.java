package net.kino2mu.caloricage.common.datagen;

import net.kino2mu.caloricage.common.CaloricAge;
import net.kino2mu.caloricage.common.block.ModBlocks;
import net.kino2mu.caloricage.common.register.CAgeBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper){
        super(output, CaloricAge.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItems(ModBlocks.BISMUTH_BLOCK);
        blockWithItems(ModBlocks.BISMUTH_ORE);
        blockWithItems(ModBlocks.BISMUTH_DEEPSLATE_ORE);

        FullBlockWithItem(CAgeBlocks.APATITE_BLOCK);
        FullBlockWithItem(CAgeBlocks.URANIUM_ORE_STONE);
        FullBlockWithItem(CAgeBlocks.URANIUM_ORE_DEEPSLATE);
    }

    private void blockWithItems(DeferredBlock<?> deferredBlock){

        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void FullBlockWithItem(DeferredBlock<?> defBlock){
        simpleBlockWithItem(defBlock.get(), cubeAll(defBlock.get()));
    }
}
