package net.kino2mu.caloricage.common.datagen;

import net.kino2mu.caloricage.common.register.CAgeBlocks;
import net.kino2mu.caloricage.common.register.CAgeItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CAgeBlocks.APATITE_BLOCK.get(), 1)
                .pattern("AAA").pattern("AAA").pattern("AAA")
                .define('A', CAgeItems.APATITE.get())
                .unlockedBy("has_apatite", has(CAgeItems.APATITE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CAgeItems.APATITE.get(),9)
                .requires(CAgeBlocks.APATITE_BLOCK.get())
                .unlockedBy("has_apatite", has(CAgeItems.APATITE)).save(recipeOutput);
    }
}
