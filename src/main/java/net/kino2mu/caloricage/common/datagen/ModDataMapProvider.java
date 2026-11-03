package net.kino2mu.caloricage.common.datagen;

import net.kino2mu.caloricage.common.register.CAgeItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {

    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider){

        //builder(NeoForgeDataMaps.FURNACE_FUELS)
        //       .add(CAgeItems.CALORIC.get().builtInRegistryHolder(), new FurnaceFuel(600),false);

        builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(CAgeItems.RAW_URANIUM.getId(), new FurnaceFuel(100), false);

        builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(CAgeItems.CALORIC.getId(), new FurnaceFuel(1200), false);

        builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(CAgeItems.CALORIC_SWEET.getId(), new FurnaceFuel(600), false);

    }

}
