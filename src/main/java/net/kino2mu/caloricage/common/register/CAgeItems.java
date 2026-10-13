package net.kino2mu.caloricage.common.register;

import net.kino2mu.caloricage.common.CaloricAge;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CAgeItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(CaloricAge.MODID);

    public static final DeferredItem<Item> RAW_URANIUM = ITEMS.register("raw_uranium",
            () -> new Item(new Item.Properties())
    );
    public static final DeferredItem<Item> APATITE = ITEMS.register("apatite",
            () -> new Item(new Item.Properties())
    );


    public static void register(IEventBus eventBus){ ITEMS.register(eventBus); }

}
