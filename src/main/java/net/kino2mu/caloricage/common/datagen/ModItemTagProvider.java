package net.kino2mu.caloricage.common.datagen;

import net.kino2mu.caloricage.common.CaloricAge;
import net.kino2mu.caloricage.common.register.CAgeItems;
import net.kino2mu.caloricage.common.register.CAgeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

/*
    Memo:
    これは「アイテム」のタグを付けるプロパイダーです！！！！！
*/

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, CaloricAge.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(CAgeTags.Items.MAGIC_USABLE_ITEM)

                .add(Items.COAL)
                .add(Items.COMPASS)
                .add(Items.STICK)

                .add(CAgeItems.CALORIC.get())
                .add(CAgeItems.CALORIC_SWEET.get())
                .add(CAgeItems.CRIMSONITE_INGOT.get())
        ;
        //↑セミコロンを消さないように

    }
}
