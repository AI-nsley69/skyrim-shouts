package net.trainsley69.skyrimshouts.mixin;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.trainsley69.skyrimshouts.SkyrimShouts;
import net.trainsley69.skyrimshouts.config.Config;
import net.trainsley69.skyrimshouts.registry.effects.SSEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Shadow public abstract boolean hasEffect(MobEffect mobEffect);

    @ModifyVariable(method= "actuallyHurt(Lnet/minecraft/world/damagesource/DamageSource;F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/damagesource/CombatTracker;recordDamage(Lnet/minecraft/world/damagesource/DamageSource;FF)V"), argsOnly = true, index = 2)
    private float applyMarkedForDeathDamageIncrease(float damage) {
        if (!this.hasEffect(SSEffects.MFD)) return damage;
        return damage * Config.MarkedForDeath.damageMultiplier;
    }
}
