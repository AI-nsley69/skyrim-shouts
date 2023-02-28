package net.trainsley69.skyrimshouts.shouts.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class MarkedForDeath extends MobEffect {

    public MarkedForDeath() {
        super(MobEffectCategory.HARMFUL, 0x5A247B);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
