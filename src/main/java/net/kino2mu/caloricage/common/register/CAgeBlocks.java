package net.kino2mu.caloricage.common.register;

import net.kino2mu.caloricage.common.CaloricAge;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CAgeBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CaloricAge.MODID);

    public static final DeferredBlock<Block> APATITE_BLOCK = registerBlock("apatite_block",
            ()-> new Block(
                    BlockBehaviour.Properties.of()
                            .strength(4f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.AMETHYST)
            ));

    public static final DeferredBlock<Block> URANIUM_ORE_STONE = registerBlock("uranium_ore_stone",
            ()-> new Block(
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> URANIUM_ORE_DEEPSLATE = registerBlock("uranium_ore_deepslate",
            ()-> new Block(
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.STONE)
            ));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static<T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        CAgeItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties())
        );
    }

    public static void register(IEventBus eventBus){ BLOCKS.register(eventBus); }

}
