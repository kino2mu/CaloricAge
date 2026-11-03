package net.kino2mu.caloricage.common.register;

import net.kino2mu.caloricage.common.CaloricAge;
import net.kino2mu.caloricage.common.item.food.CAgeFoodProperties;
import net.kino2mu.caloricage.common.item.fuel.ItemFuel;
import net.kino2mu.caloricage.common.item.tool.ItemNeoHammer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class CAgeItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(CaloricAge.MODID);

    public static final DeferredItem<Item> RAW_URANIUM = ITEMS.register("raw_uranium",
            () -> new Item(new Item.Properties())
    );
    public static final DeferredItem<Item> URANIUM_DUST = ITEMS.register("uranium_dust",
            ()-> new Item(new Item.Properties())
    );
    public static final DeferredItem<Item> APATITE = ITEMS.register("apatite",
            () -> new Item(new Item.Properties())
    );
    public static final DeferredItem<Item> APATITE_DUST = ITEMS.register("apatite_dust",
            () -> new Item(new Item.Properties())
    );
    public static final DeferredItem<Item> PHLOGISTON_FOOD = ITEMS.register("phlogiston_food",
            ()-> new Item(new Item.Properties().food(CAgeFoodProperties.PHLOGISTON_FOOD))
    );
    public static final DeferredItem<Item> CALORIC = ITEMS.register("caloric",
            ()-> new Item(new Item.Properties()){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.caloricage.CALORIC.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            }
    );
    public static final DeferredItem<Item> CALORIC_SWEET = ITEMS.register("caloric_sweet",
            ()-> new Item(new Item.Properties().food(CAgeFoodProperties.CALORIC_SWEET)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.caloricage.CALORIC.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            }
    );


    public static final DeferredItem<Item> CRIMSONITE_INGOT = ITEMS.register("crimsonite_ingot",
            ()-> new Item(new Item.Properties().rarity(Rarity.UNCOMMON))
    //Memo：crimsonite ingotの日本語は紅鋼(べにはがね)インゴットにする
    );
    public static final DeferredItem<ItemNeoHammer> NEO_HAMMER = ITEMS.register("neo_hammer",
            () -> new ItemNeoHammer(CAgeTiers.CRIMSONITE_TIER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(CAgeTiers.CRIMSONITE_TIER, 7F, -3.5f)))
    );






    public static void register(IEventBus eventBus){ ITEMS.register(eventBus); }

}
