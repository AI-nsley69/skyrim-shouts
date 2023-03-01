package net.trainsley69.skyrimshouts.shouts;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import net.minecraft.world.phys.Vec3;
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
        int range = 3;
        int radius = 2;
        AABB effectArea = ShoutHelper.getEffectAABB(range, radius, player);

        if (!level.isClientSide()) {
            for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, effectArea)) {
                int duration = SkyrimShouts.getConfig().markedForDeath.effectDuration * 20;
                MobEffectInstance mfdEffect = new MobEffectInstance(ShoutMobEffects.MARKED_FOR_DEATH, duration);
                entity.addEffect(mfdEffect);

                MobEffectInstance weaknessEffect = new MobEffectInstance(MobEffects.WEAKNESS, duration, 2);
                entity.addEffect(weaknessEffect);
            }
        } else {
            for (int i = 0; i < 100; i++) {
                Vec3 look = player.getLookAngle();
                level.addParticle(ParticleTypes.DRAGON_BREATH,
                        effectArea.minX + level.getRandom().nextFloat() * (effectArea.maxX - effectArea.minX),
                        effectArea.minY + level.getRandom().nextFloat() * (effectArea.maxY - effectArea.minY),
                        effectArea.minZ + level.getRandom().nextFloat() * (effectArea.maxZ - effectArea.minZ),
                        look.x() / 5, look.y() / 5, look.z() / 5
                );
            }
        }

    }

    @Override
    public void tick(ShoutInstance instance) {
    }
}
