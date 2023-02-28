package net.trainsley69.skyrimshouts.shouts;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import net.trainsley69.skyrimshouts.SkyrimShouts;
import net.trainsley69.skyrimshouts.shouts.effects.ShoutMobEffects;
import net.trainsley69.skyrimshouts.utils.ShoutHelper;

public class MarkedForDeath extends Shout {

    public MarkedForDeath() {
        super("Marked For Death");
    }

    public int getCooldown() {
        return 20 * SkyrimShouts.getConfig().markedForDeath.cooldown;
    }

    @Override
    public void use(Level level, Player player) {
        AABB effectArea = ShoutHelper.getEffectAABB(5, 2, player);

        for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, effectArea)) {
            int duration = SkyrimShouts.getConfig().markedForDeath.effectDuration * 20;
            MobEffectInstance mfdEffect = new MobEffectInstance(ShoutMobEffects.MARKED_FOR_DEATH, duration);
            entity.addEffect(mfdEffect);

            MobEffectInstance weaknessEffect = new MobEffectInstance(MobEffects.WEAKNESS, duration, 2);
            entity.addEffect(weaknessEffect);
        }
    }

    @Override
    public void tick(ShoutInstance instance) {
    }
}
