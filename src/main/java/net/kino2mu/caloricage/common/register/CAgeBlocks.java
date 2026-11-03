package net.kino2mu.caloricage.common.register;

import net.kino2mu.caloricage.common.CaloricAge;
import net.kino2mu.caloricage.common.block.MagicBlock;
import net.kino2mu.caloricage.common.block.heat.ThermoreactiveLampBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CAgeBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CaloricAge.MODID);


    public static final DeferredBlock<Block> APATITE_BLOCK = registerBlock("apatite_block",
            ()-> new Block(
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST))
    );
    public static final DeferredBlock<Block> URANIUM_ORE_STONE = registerBlock("uranium_ore_stone",
            ()-> new Block(
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE))
    );
    public static final DeferredBlock<Block> URANIUM_ORE_DEEPSLATE = registerBlock("uranium_ore_deepslate",
            ()-> new Block(
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE))
    );

    //------------------------耐熱コンクリートブロック始め
    public static final DeferredBlock<Block> CONCRETE_REFRACTORY = registerBlock("concrete_refractory",
            ()-> new Block(
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.BAMBOO_WOOD))
    );

    public static final DeferredBlock<SlabBlock> CONCRETE_REFRACTORY_SLAB = registerBlock("concrete_refractory_slab",
            ()-> new SlabBlock(
                    BlockBehaviour.Properties.ofFullCopy(CAgeBlocks.CONCRETE_REFRACTORY.get()))
    );
    public static final DeferredBlock<StairBlock> CONCRETE_REFRACTORY_STAIRS = registerBlock("concrete_refractory_stairs",
            ()-> new StairBlock(CAgeBlocks.CONCRETE_REFRACTORY.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(CAgeBlocks.CONCRETE_REFRACTORY.get()))
    );

    public static final DeferredBlock<WallBlock> CONCRETE_REFRACTORY_WALL = registerBlock("concrete_refractory_wall",
            () -> new WallBlock(
                    BlockBehaviour.Properties.ofFullCopy(CAgeBlocks.CONCRETE_REFRACTORY.get()))
    );
    public static final DeferredBlock<FenceBlock> CONCRETE_REFRACTORY_FENCE = registerBlock("concrete_refractory_fence",
            ()-> new FenceBlock(
                    BlockBehaviour.Properties.ofFullCopy(CAgeBlocks.CONCRETE_REFRACTORY.get()))
    );
    public static final DeferredBlock<FenceGateBlock> CONCRETE_REFRACTORY_FENCEGATE = registerBlock("concrete_refractory_fencegate",
            ()-> new FenceGateBlock(
                    WoodType.ACACIA,
                    BlockBehaviour.Properties.ofFullCopy(CAgeBlocks.CONCRETE_REFRACTORY.get()))
    );
    //------------------------耐熱コンクリートブロック終わり

    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block",
            ()-> new MagicBlock(
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.SAND))
    );
    public static final DeferredBlock<Block> THERMOREACTIVE_LAMP = registerBlock("thermoreactive_lamp",
            ()-> new ThermoreactiveLampBlock(
                    BlockBehaviour.Properties.of().strength(1f).requiresCorrectToolForDrops().sound(SoundType.GLASS))
    );


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
