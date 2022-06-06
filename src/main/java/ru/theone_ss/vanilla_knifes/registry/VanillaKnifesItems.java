package ru.theone_ss.vanilla_knifes.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.theone_ss.vanilla_knifes.VanillaKnifes;
import ru.theone_ss.vanilla_knifes.compat.WinterlyIntegration;
import ru.theone_ss.vanilla_knifes.item.KnifesItem;
import ru.theone_ss.vanilla_knifes.item.material.VanillaKnifesMaterials;

import java.util.LinkedHashMap;
import java.util.Map;

public class VanillaKnifesItems {

    public static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

    public static final Item NETHERITE_KNIFE = add("netherite_knife", new KnifesItem(VanillaKnifesMaterials.NETHERITE, 5, -2, settings()));
    public static final Item DIAMOND_KNIFE = add("diamond_knife", new KnifesItem(VanillaKnifesMaterials.DIAMOND, 4, -2, settings()));
    public static final Item IRON_KNIFE = add("iron_knife", new KnifesItem(VanillaKnifesMaterials.IRON, 3, -2, settings()));
    public static final Item GOLDEN_KNIFE = add("golden_knife", new KnifesItem(VanillaKnifesMaterials.GOLD, 1, -2, settings()));
    public static final Item COPPER_KNIFE = add("copper_knife", new KnifesItem(VanillaKnifesMaterials.COPPER, 2, -2, settings()));
    public static final Item STONE_KNIFE = add("stone_knife", new KnifesItem(VanillaKnifesMaterials.STONE, 2, -2, settings()));
    public static final Item WOODEN_KNIFE = add("wooden_knife", new KnifesItem(VanillaKnifesMaterials.WOOD, 1, -2, settings()));

    public static final Item CRYOMARBLE_KNIFE = add("cryomarble_knife", new KnifesItem(material("winterly"), 2, -2, settings("winterly")));

    private static ToolMaterial material(String modId) {
        if(FabricLoader.getInstance().isModLoaded(modId)) {
            if(modId.equals("winterly")) {
                return WinterlyIntegration.getMaterial();
            }
        }
        return VanillaKnifesMaterials.IRON;
    }

    private static Item add(String name, Item item) {
        ITEMS.put(VanillaKnifes.id(name), item);
        return item;
    }

    private static FabricItemSettings settings() {
        FabricItemSettings settings = new FabricItemSettings();
        settings.group(ItemGroup.COMBAT);
        return settings;
    }

    private static FabricItemSettings settings(String modId) {
        FabricItemSettings settings = new FabricItemSettings();
        if(FabricLoader.getInstance().isModLoaded(modId)) {
            settings.group(ItemGroup.COMBAT);
        }
        return settings;
    }

    public static void init() {
        ITEMS.forEach((id, item) -> Registry.register(Registry.ITEM, id, item));
    }
}
