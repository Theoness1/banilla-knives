package ru.theone_ss.vanilla_knifes.compat;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.theone_ss.vanilla_knifes.item.material.BaseToolMaterial;

public class WinterlyIntegration {

    public static ToolMaterial CRYOMARBLE_MATERIAL = new BaseToolMaterial(1, 521, 2.0F, 2.0F, 6, () -> Ingredient.ofItems(Registry.ITEM.get(new Identifier("winterly", "cryomarble"))));

    public static ToolMaterial getMaterial() {
        return CRYOMARBLE_MATERIAL;
    }

    public static void init() {

    }
}
