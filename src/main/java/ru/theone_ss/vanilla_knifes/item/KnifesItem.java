package ru.theone_ss.vanilla_knifes.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import ru.theone_ss.vanilla_knifes.registry.VanillaKnifesEffects;

import java.util.Random;

public class KnifesItem extends SwordItem {

    private final float attackDamage;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public KnifesItem(ToolMaterial material, int damage, float attackSpeed, Settings settings) {
        super(material, damage, attackSpeed, settings);
        this.attackDamage = damage + material.getAttackDamage();

        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        builder.put(ReachEntityAttributes.ATTACK_RANGE, new EntityAttributeModifier("Weapon modifier", -0.75, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker instanceof PlayerEntity) {
            float yawDif = attacker.getYaw() - target.getYaw();
            if(yawDif > 0 && yawDif < 65) {
                target.damage(DamageSource.sting(attacker), attackDamage*1.75F);
            }else if(yawDif < 0 && yawDif > -65) {
                target.damage(DamageSource.sting(attacker), attackDamage*1.75F);
            }
            if(new Random().nextInt(0, 2) == 1) {
                target.addStatusEffect(new StatusEffectInstance(VanillaKnifesEffects.BLEEDING, 16 * 20, 0), attacker);
            }
            if(attacker.getMainHandStack().isOf(this) && attacker.getOffHandStack().isOf(this)) {
                target.damage(DamageSource.sting(attacker), attackDamage * 2);
            }
        }
        return super.postHit(stack, target, attacker);
    }
}
