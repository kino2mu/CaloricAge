package net.kino2mu.caloricage.common.registries;

import net.kino2mu.caloricage.common.CaloricAge;
import net.kino2mu.caloricage.common.block.ModBlocks;
import net.kino2mu.caloricage.common.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CustomCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CUSTOM_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CaloricAge.MODID);

    public static final Supplier<CreativeModeTab> CUSTOM_TAB_MAIN =
            CUSTOM_TAB.register("caloricage_tab_main",()-> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.caloricage.tab_main"))
                    .icon(()-> new ItemStack(ModItems.RAW_URANIUM.get()))
                    .displayItems((params, output) ->{

                        output.accept(ModItems.RAW_URANIUM.get());
                        output.accept(ModItems.RAW_APATITE.get());
                        //output.accept(ModItems.CHISEL.get());
                        output.accept(ModBlocks.BISMUTH_BLOCK);

                    }).build()
            );
    public static final Supplier<CreativeModeTab> CUSTOM_TAB_BLOCKS =
            CUSTOM_TAB.register("caloricage_tab_blocks",()-> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.caloricage.tab_blocks"))
                    .icon(()-> new ItemStack(ModItems.RAW_APATITE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CaloricAge.MODID, "caloricage_tab_main"))
                    .displayItems((params, output) ->{

                        output.accept(ModItems.RAW_URANIUM.get());
                        output.accept(ModItems.RAW_APATITE.get());
                        output.accept(ModItems.CHISEL.get());
                        //output.accept(ModBlocks.BISMUTH_BLOCK);

                    }).build()
            );

    public static void register(IEventBus eventBus){
        CUSTOM_TAB.register(eventBus);
    }
}
