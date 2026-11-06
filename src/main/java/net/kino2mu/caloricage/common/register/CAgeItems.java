package net.kino2mu.caloricage.common.register;

import net.kino2mu.caloricage.common.CaloricAge;
import net.kino2mu.caloricage.common.item.base.ModFoodProperties;
import net.kino2mu.caloricage.common.item.base.WithTooltipItem;
import net.kino2mu.caloricage.common.item.tool.ItemNeoHammer;
import net.kino2mu.caloricage.common.item.tool.ScannerItem;
import net.kino2mu.caloricage.common.data.CAgeTiers;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

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

    public static final DeferredItem<Item> CALORIC = ITEMS.register("caloric",
            ()-> new WithTooltipItem(new Item.Properties(), "tooltip.caloricage.caloric.tooltip")
    );
    public static final DeferredItem<Item> CALORIC_SWEET = ITEMS.register("caloric_sweet",
            ()-> new WithTooltipItem(new Item.Properties().food(ModFoodProperties.CALORIC_SWEET),"tooltip.caloricage.caloric.tooltip")
    );

    public static final DeferredItem<Item> CRIMSONITE_INGOT = ITEMS.register("crimsonite_ingot",
            ()-> new Item(new Item.Properties().rarity(Rarity.UNCOMMON))
    //Memo：crimsonite ingotの日本語は紅鋼(べにはがね)インゴットにする
    );

    public static final DeferredItem<Item> CRIMSONITE_SWORD = ITEMS.register("crimsonite_sword",
            ()-> new SwordItem(CAgeTiers.CRIMSONITE_TIER,
                    new Item.Properties().attributes(SwordItem.createAttributes(CAgeTiers.CRIMSONITE_TIER,1,1)))
    );
    public static final DeferredItem<Item> CRIMSONITE_PICKAXE = ITEMS.register("crimsonite_pickaxe",
            ()-> new PickaxeItem(CAgeTiers.CRIMSONITE_TIER,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(CAgeTiers.CRIMSONITE_TIER,1,1)))
    );
    public static final DeferredItem<Item> CRIMSONITE_SHOVEL = ITEMS.register("crimsonite_shovel",
            ()-> new ShovelItem(CAgeTiers.CRIMSONITE_TIER,
                    new Item.Properties().attributes(ShovelItem.createAttributes(CAgeTiers.CRIMSONITE_TIER,1,1)))
    );
    public static final DeferredItem<Item> CRIMSONITE_AXE = ITEMS.register("crimsonite_axe",
            ()-> new AxeItem(CAgeTiers.CRIMSONITE_TIER,
                    new Item.Properties().attributes(AxeItem.createAttributes(CAgeTiers.CRIMSONITE_TIER,1,1)))
    );
    public static final DeferredItem<Item> CRIMSONITE_HOE = ITEMS.register("crimsonite_hoe",
            ()-> new HoeItem(CAgeTiers.CRIMSONITE_TIER,
                    new Item.Properties().attributes(HoeItem.createAttributes(CAgeTiers.CRIMSONITE_TIER,1,1)))
    );

    public static final DeferredItem<ItemNeoHammer> NEO_HAMMER = ITEMS.register("neo_hammer",
            () -> new ItemNeoHammer(CAgeTiers.CRIMSONITE_TIER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(CAgeTiers.CRIMSONITE_TIER, 7F, -3.5f)))
    );

    public static final DeferredItem<Item> TEST_SCANNER = ITEMS.register("test_scanner",
            ()-> new ScannerItem(new Item.Properties().stacksTo(1))
    );



    public static void register(IEventBus eventBus){ ITEMS.register(eventBus); }

}
