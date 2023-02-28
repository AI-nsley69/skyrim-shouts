package net.trainsley69.skyrimshouts.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;

import net.trainsley69.skyrimshouts.SkyrimShouts;
import net.trainsley69.skyrimshouts.registry.effects.SSEffects;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Shadow public boolean hasEffect(MobEffect mobEffect) { return false; }

    @ModifyVariable(
    	method= "actuallyHurt(Lnet/minecraft/world/damagesource/DamageSource;F)V",
    	argsOnly = true,
    	index = 2,
    	at = @At(
    		value = "INVOKE",
    		target = "Lnet/minecraft/world/damagesource/CombatTracker;recordDamage(Lnet/minecraft/world/damagesource/DamageSource;FF)V"
    	)
    )
    private float applyMarkedForDeathDamageIncrease(float damage) {
        if (this.hasEffect(SSEffects.MFD))
        	return damage * SkyrimShouts.getConfig().markedForDeath.damageMultiplier;
        return damage;
    }
}
