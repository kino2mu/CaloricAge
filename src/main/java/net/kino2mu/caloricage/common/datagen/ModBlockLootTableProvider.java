package net.kino2mu.caloricage.common.datagen;

import net.kino2mu.caloricage.common.block.ModBlocks;
import net.kino2mu.caloricage.common.item.ModItems;
import net.kino2mu.caloricage.common.register.CAgeBlocks;
import net.kino2mu.caloricage.common.register.CAgeItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
//import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider registries){
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }


    @Override
    protected void generate() {
/*
        dropSelf(ModBlocks.BISMUTH_BLOCK.get());

        add(ModBlocks.BISMUTH_ORE.get(),
                block -> createOreDrop(ModBlocks.BISMUTH_ORE.get(), ModItems.BISMUTH.get())
        );
        add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.BISMUTH_ORE.get(), ModItems.BISMUTH.get(), 2, 5)
        );

 */
        dropSelf(CAgeBlocks.APATITE_BLOCK.get());

        add(CAgeBlocks.URANIUM_ORE_STONE.get(),
                block -> createMultipleOreDrops(
                        CAgeBlocks.URANIUM_ORE_STONE.get(),
                        CAgeItems.RAW_URANIUM.get(),
                        1, 2)
        );

        add(CAgeBlocks.URANIUM_ORE_DEEPSLATE.get(),
                block -> createMultipleOreDrops(
                        CAgeBlocks.URANIUM_ORE_DEEPSLATE.get(),
                        CAgeItems.RAW_URANIUM.get(),
                        1, 3)
        );

    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return CAgeBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
    //Memo:「CAgeBlocksにより、このMODで登録されているブロック一覧はこちらです」と返す部分
}
