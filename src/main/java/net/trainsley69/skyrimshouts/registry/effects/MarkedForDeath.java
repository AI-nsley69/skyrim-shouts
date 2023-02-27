package net.trainsley69.skyrimshouts.registry.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class MarkedForDeath extends MobEffect {
    public MarkedForDeath() {
        super(MobEffectCategory.HARMFUL, 0x5A247B);
    }

    @Override
    public boolean isDurationEffectTick(int i, int j) { return true; }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int i) {
        if (livingEntity.hurtTime > 5) livingEntity.hurtTime = 5;
    }
}
