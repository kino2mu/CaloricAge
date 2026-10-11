package net.kino2mu.caloricage.common.item;

import net.kino2mu.caloricage.common.CaloricAge;
import net.kino2mu.caloricage.common.item.tool.ItemChisel;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CaloricAge.MODID);

    public static final DeferredItem<Item> BISMUTH = ITEMS.register("bismuth",
            () -> new Item(new Item.Properties())
    );
    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.register("raw_bismuth",
            () -> new Item(new Item.Properties())
    );
    public static final DeferredItem<Item> RAW_URANIUM = ITEMS.register("raw_uranium",
            () -> new Item(new Item.Properties())
    );
    public static final DeferredItem<Item> RAW_APATITE = ITEMS.register("raw_apatite",
            () -> new Item(new Item.Properties())
    );
    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            ()-> new ItemChisel(new Item.Properties().durability(32))
    );

    public  static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
