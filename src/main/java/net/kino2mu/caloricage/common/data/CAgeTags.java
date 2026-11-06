package net.kino2mu.caloricage.common.data;

import net.kino2mu.caloricage.common.CaloricAge;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CAgeTags {

    public static class Blocks{

        public static final TagKey<Block> LOW_HEAT_BLOCK = createTag("low_heat_block");
        public static final TagKey<Block> HIGH_HEAT_BLOCK = createTag("high_heat_block");

        public static final TagKey<Block> CRIMSONITE_BREAK = createTag("crimsonite_break");
        public static final TagKey<Block> CRIMSONITE_NOT_BREAK = createTag("crimsonite_not_break");

        public static final TagKey<Block> DRILL_MINEABLE = createTag("drill_mineable");

        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(CaloricAge.MODID, name));
        }

    }

    public static class Items{

        public static final TagKey<Item> MAGIC_USABLE_ITEM = createTag("magic_usable_item");

        public static final TagKey<Item> LOW_BURNABLE = createTag("low_burnable");
        public static final TagKey<Item> HIGH_BURNABLE = createTag("high_burnable");


        private static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(CaloricAge.MODID, name));
        }
    }
}
