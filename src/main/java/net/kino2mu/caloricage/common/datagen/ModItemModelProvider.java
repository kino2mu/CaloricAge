package net.kino2mu.caloricage.common.datagen;

import net.kino2mu.caloricage.common.CaloricAge;
import net.kino2mu.caloricage.common.register.CAgeBlocks;
import net.kino2mu.caloricage.common.register.CAgeItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CaloricAge.MODID, exFileHelper);
    }

    @Override
    protected void registerModels() {

        basicItem(CAgeItems.APATITE.get());
        basicItem(CAgeItems.APATITE_DUST.get());

        basicItem(CAgeItems.RAW_URANIUM.get());
        basicItem(CAgeItems.URANIUM_DUST.get());

        basicItem(CAgeItems.CRIMSONITE_INGOT.get());

        basicItem(CAgeItems.PHLOGISTON_FOOD.get());

        basicItem(CAgeItems.CALORIC.get());
        basicItem(CAgeItems.CALORIC_SWEET.get());

        wallItem(CAgeBlocks.CONCRETE_REFRACTORY_WALL, CAgeBlocks.CONCRETE_REFRACTORY);
        fenceItem(CAgeBlocks.CONCRETE_REFRACTORY_FENCE, CAgeBlocks.CONCRETE_REFRACTORY);

    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(CaloricAge.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(CaloricAge.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

}
