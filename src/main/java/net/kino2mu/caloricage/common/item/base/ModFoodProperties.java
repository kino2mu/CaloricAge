package net.kino2mu.caloricage.common.item.base;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {

    public static final FoodProperties CALORIC_SWEET = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.1f)
            .alwaysEdible()
            .effect(()-> new MobEffectInstance(MobEffects.REGENERATION,50, 0), 0.3f)
            .build();
}
