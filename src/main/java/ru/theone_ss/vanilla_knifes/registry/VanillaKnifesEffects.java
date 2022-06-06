package ru.theone_ss.vanilla_knifes.registry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.theone_ss.vanilla_knifes.VanillaKnifes;
import ru.theone_ss.vanilla_knifes.effect.BleedingEffect;

import java.util.LinkedHashMap;
import java.util.Map;

public class VanillaKnifesEffects {

    public static final Map<Identifier, StatusEffect> EFFECTS = new LinkedHashMap<>();

    public static final StatusEffect BLEEDING = add("bleeding", new BleedingEffect(StatusEffectCategory.HARMFUL, 14225681));

    private static StatusEffect add(String name, StatusEffect effect) {
        EFFECTS.put(VanillaKnifes.id(name), effect);
        return effect;
    }

    public static void init() {
        EFFECTS.forEach((id, effect) -> Registry.register(Registry.STATUS_EFFECT, id, effect));
    }
}
