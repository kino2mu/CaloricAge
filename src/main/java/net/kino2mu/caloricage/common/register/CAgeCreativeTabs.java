package net.kino2mu.caloricage.common.register;

import net.kino2mu.caloricage.common.CaloricAge;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CAgeCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CUSTOM_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CaloricAge.MODID);

    public static final Supplier<CreativeModeTab> CUSTOM_TAB_MAIN =
            CUSTOM_TAB.register("caloricage_tab_main",()-> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.caloricage.tab_main"))
                    .icon(()-> new ItemStack(CAgeItems.APATITE.get()))
                    .displayItems((params, output) ->{

                        output.accept(CAgeItems.APATITE.get());
                        output.accept(CAgeItems.APATITE_DUST.get());
                        output.accept(CAgeBlocks.APATITE_BLOCK.get());

                        output.accept(CAgeItems.RAW_URANIUM.get());
                        output.accept(CAgeItems.URANIUM_DUST.get());

                        output.accept(CAgeItems.CRIMSONITE_INGOT.get());

                        output.accept(CAgeItems.CRIMSONITE_SWORD);
                        output.accept(CAgeItems.CRIMSONITE_PICKAXE);
                        output.accept(CAgeItems.CRIMSONITE_SHOVEL);
                        output.accept(CAgeItems.CRIMSONITE_AXE);
                        output.accept(CAgeItems.CRIMSONITE_HOE);

                        //output.accept(CAgeItems.NEO_HAMMER.get());

                        output.accept(CAgeBlocks.MAGIC_BLOCK.get());

                        //output.accept(CAgeItems.PHLOGISTON_FOOD.get());

                        output.accept(CAgeItems.CALORIC.get());
                        output.accept(CAgeItems.CALORIC_SWEET.get());

                        output.accept(CAgeItems.TEST_SCANNER);


                    }).build()
            );
    public static final Supplier<CreativeModeTab> CUSTOM_TAB_BLOCKS =
            CUSTOM_TAB.register("caloricage_tab_blocks",()-> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.caloricage.tab_blocks"))
                    .icon(()-> new ItemStack(CAgeItems.APATITE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CaloricAge.MODID, "caloricage_tab_main"))
                    .displayItems((params, output) ->{

                        output.accept(CAgeBlocks.URANIUM_ORE_STONE.get());
                        output.accept(CAgeBlocks.URANIUM_ORE_DEEPSLATE.get());

                        output.accept(CAgeBlocks.CONCRETE_REFRACTORY.get());
                        output.accept(CAgeBlocks.CONCRETE_REFRACTORY_SLAB.get());
                        output.accept(CAgeBlocks.CONCRETE_REFRACTORY_STAIRS.get());
                        output.accept(CAgeBlocks.CONCRETE_REFRACTORY_WALL.get());
                        output.accept(CAgeBlocks.CONCRETE_REFRACTORY_FENCE.get());
                        output.accept(CAgeBlocks.CONCRETE_REFRACTORY_FENCEGATE.get());

                        output.accept(CAgeBlocks.THERMOREACTIVE_LAMP.get());

                    }).build()
            );

    public static void register(IEventBus eventBus){
        CUSTOM_TAB.register(eventBus);
    }

}
