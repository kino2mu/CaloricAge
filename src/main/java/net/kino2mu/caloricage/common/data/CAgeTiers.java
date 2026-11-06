package net.kino2mu.caloricage.common.data;

import net.kino2mu.caloricage.common.register.CAgeItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class CAgeTiers {

    public static final Tier CRIMSONITE_TIER =
            new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
                    50,
                    9.0f,
                    -10.0f,
                    30,
                    ()-> Ingredient.of(CAgeItems.CRIMSONITE_INGOT.get())
            );
}
