package net.trainsley69.skyrimshouts.shouts;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.trainsley69.skyrimshouts.SkyrimShouts;
import net.trainsley69.skyrimshouts.utils.ShoutHelper;

public class MarkedForDeath extends Shout {
    public MarkedForDeath() {
        super("Marked For Death", 40 * 20);
    }

    @Override
    protected void use(Level level, Player player) {
        AABB effectArea = ShoutHelper.getEffectAABB(5, 2, player);

        for (Entity entity : level.getEntitiesOfClass(Entity.class, effectArea)) {
            if (entity instanceof LivingEntity) {
                LivingEntity target = (LivingEntity)entity;

                MobEffectInstance mfdEffect = new MobEffectInstance(SkyrimShouts.MFD, 15 * 20);
                target.addEffect(mfdEffect);

                MobEffectInstance weaknessEffect = new MobEffectInstance(MobEffects.WEAKNESS, 15, 2);
                target.addEffect(weaknessEffect);
            }
        }
    }
}