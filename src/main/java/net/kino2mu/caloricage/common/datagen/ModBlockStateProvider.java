package net.kino2mu.caloricage.common.datagen;

import net.kino2mu.caloricage.common.CaloricAge;
import net.kino2mu.caloricage.common.block.heat.ThermoreactiveLampBlock;
import net.kino2mu.caloricage.common.register.CAgeBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper){
        super(output, CaloricAge.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        fullBlockWithItem(CAgeBlocks.APATITE_BLOCK);
        fullBlockWithItem(CAgeBlocks.URANIUM_ORE_STONE);
        fullBlockWithItem(CAgeBlocks.URANIUM_ORE_DEEPSLATE);

        fullBlockWithItem(CAgeBlocks.MAGIC_BLOCK);
//-------------------------耐熱コンクリート始め
        fullBlockWithItem(CAgeBlocks.CONCRETE_REFRACTORY);
        //DeferredBlock<?> con_ref = CAgeBlocks.CONCRETE_REFRACTORY;

        stairsBlock(CAgeBlocks.CONCRETE_REFRACTORY_STAIRS.get(), blockTexture(CAgeBlocks.CONCRETE_REFRACTORY.get())
        );
        blockItemAdd(CAgeBlocks.CONCRETE_REFRACTORY_STAIRS);

        slabBlock(CAgeBlocks.CONCRETE_REFRACTORY_SLAB.get(), blockTexture(CAgeBlocks.CONCRETE_REFRACTORY.get()), blockTexture(CAgeBlocks.CONCRETE_REFRACTORY.get())
        );
        blockItemAdd(CAgeBlocks.CONCRETE_REFRACTORY_SLAB);

        wallBlock(CAgeBlocks.CONCRETE_REFRACTORY_WALL.get(), blockTexture(CAgeBlocks.CONCRETE_REFRACTORY.get())
        );
        //Register as _wallItem_ in ItemModelProvider

        fenceBlock(CAgeBlocks.CONCRETE_REFRACTORY_FENCE.get(), blockTexture(CAgeBlocks.CONCRETE_REFRACTORY.get())
        );
        //Register as _fenceItem_ in ItemModelProvider

        fenceGateBlock(CAgeBlocks.CONCRETE_REFRACTORY_FENCEGATE.get(), blockTexture(CAgeBlocks.CONCRETE_REFRACTORY.get())
        );
        blockItemAdd(CAgeBlocks.CONCRETE_REFRACTORY_FENCEGATE);
//-------------------------耐熱コンクリート終わり

        thermoreactivelampWithItem();


    }

    private void fullBlockWithItem(DeferredBlock<?> defBlock){
        simpleBlockWithItem(defBlock.get(), cubeAll(defBlock.get()));
    }
    private void blockItemAdd(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("caloricage:block/" + deferredBlock.getId().getPath()));
    }
    private void thermoreactivelampWithItem(){

        ModelFile lampOff = models().cubeAll(
                "thermoreactive_lamp_off", modLoc("block/thermoreactive_lamp_off"));
        ModelFile lampOn = models().cubeAll(
                "thermoreactive_lamp_on", modLoc("block/thermoreactive_lamp_on"));

        getVariantBuilder(CAgeBlocks.THERMOREACTIVE_LAMP.get()).forAllStates(state -> {

            boolean LIT = state.getValue(ThermoreactiveLampBlock.LIT);

            return ConfiguredModel.builder().modelFile(LIT ? lampOn : lampOff).build();

        });

        simpleBlockItem(CAgeBlocks.THERMOREACTIVE_LAMP.get(), new ModelFile.UncheckedModelFile("caloricage:block/thermoreactive_lamp_off"));

    }


}
