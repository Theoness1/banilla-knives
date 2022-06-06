package ru.theone_ss.vanilla_knifes.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectCategory;
import ru.theone_ss.vanilla_knifes.registry.VanillaKnifesEffects;

public class BleedingEffect extends BaseStatusEffect{

    public BleedingEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(this == VanillaKnifesEffects.BLEEDING) {
            entity.damage(DamageSource.MAGIC, 1.0F);
        }
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 60 == 0;
    }

}
