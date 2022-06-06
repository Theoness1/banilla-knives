package ru.theone_ss.vanilla_knifes.compat;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import ru.theone_ss.vanilla_knifes.item.material.BaseToolMaterial;
import ru.tlmclub.winterly.registry.WinterlyItems;

public class WinterlyIntegration {

    public static ToolMaterial CRYOMARBLE_MATERIAL = new BaseToolMaterial(1, 521, 2.0F, 2.0F, 6, () -> Ingredient.ofItems(WinterlyItems.CRYOMARBLE));

    public static ToolMaterial getMaterial() {
        return CRYOMARBLE_MATERIAL;
    }

    public static void init() {

    }
}
