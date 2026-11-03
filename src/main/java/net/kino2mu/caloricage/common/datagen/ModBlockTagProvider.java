package net.kino2mu.caloricage.common.datagen;

import net.kino2mu.caloricage.common.CaloricAge;
import net.kino2mu.caloricage.common.register.CAgeBlocks;
import net.kino2mu.caloricage.common.register.CAgeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

/*
    Memo:
    これは「ブロック」のタグを付けるプロパイダーです！！！！！
*/

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CaloricAge.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(CAgeBlocks.APATITE_BLOCK.get())
                .add(CAgeBlocks.URANIUM_ORE_STONE.get())
                .add(CAgeBlocks.URANIUM_ORE_DEEPSLATE.get())
        ;
        //↑セミコロン忘れずに

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(CAgeBlocks.URANIUM_ORE_STONE.get())
                .add(CAgeBlocks.URANIUM_ORE_DEEPSLATE.get())
        ;
        //↑セミコロン忘れずに

        tag(BlockTags.FENCES)
                .add(CAgeBlocks.CONCRETE_REFRACTORY_FENCE.get())
        ;
        tag(BlockTags.FENCE_GATES)
                .add(CAgeBlocks.CONCRETE_REFRACTORY_FENCEGATE.get())
        ;
        tag(BlockTags.WALLS)
                .add(CAgeBlocks.CONCRETE_REFRACTORY_WALL.get())
        ;
        //↑セミコロン忘れずに

        tag(CAgeTags.Blocks.LOW_HEAT_BLOCK)
                .add(Blocks.CAMPFIRE)
                .add(Blocks.SOUL_CAMPFIRE)
        ;
        //↑セミコロン忘れずに

        tag(CAgeTags.Blocks.HIGH_HEAT_BLOCK)
                .add(Blocks.MAGMA_BLOCK)
        ;
        //↑セミコロン忘れずに

    }
}
