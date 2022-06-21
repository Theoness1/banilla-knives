package ru.theone_ss.vanilla_knifes.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import ru.theone_ss.vanilla_knifes.registry.VanillaKnifesEffects;

public class BleedingEffect extends BaseStatusEffect{

    public BleedingEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(this == VanillaKnifesEffects.BLEEDING) {
            entity.damage(DamageSource.MAGIC, 1.0F);
        }
        if(entity.getWorld() instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(ParticleTypes.DAMAGE_INDICATOR, entity.getX() - 0.3, entity.getY() + 0.5, entity.getZ() - 0.4, 1, 0.0, 0.0, 0, 0);
            serverWorld.spawnParticles(ParticleTypes.DAMAGE_INDICATOR, entity.getX() + 0.6, entity.getY() + 0.4, entity.getZ() + 0.1, 1, 0.0, 0.0, 0, 0);
            serverWorld.spawnParticles(ParticleTypes.DAMAGE_INDICATOR, entity.getX() - 0.6, entity.getY() + 0.3, entity.getZ() + 0.3, 1, 0.0, 0.0, 0, 0);
        }
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 60 == 0;
    }

}
