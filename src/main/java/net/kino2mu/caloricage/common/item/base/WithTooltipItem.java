package net.kino2mu.caloricage.common.item.base;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class WithTooltipItem extends Item {


    private final String tooltipKey;

    public WithTooltipItem(Properties properties, String tooltipKey) {
        super(properties);
        this.tooltipKey = tooltipKey;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

        if (Screen.hasShiftDown()){
            tooltipComponents.add(Component.translatable(tooltipKey)
                    .withStyle(ChatFormatting.YELLOW));
        }
        else {
            tooltipComponents.add(Component.translatable("tooltip.caloricage.hold_shift")
                    .withStyle(ChatFormatting.DARK_GRAY));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
