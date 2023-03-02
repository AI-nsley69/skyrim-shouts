package net.trainsley69.skyrimshouts.shouts;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.trainsley69.skyrimshouts.SkyrimShouts;
import net.trainsley69.skyrimshouts.utils.ShoutHelper;

public class AuraWhisper extends Shout {
    public AuraWhisper() {
        super("Aura Whisper");
    }

    @Override
    public int getCooldown() {
        return SkyrimShouts.getConfig().auraWhisper.cooldown * 20;
    }

    @Override
    public InteractionResult use(ShoutInstance instance) {
        Player player = instance.getOwner();
        Level level = player.getLevel();

        int range = 0;
        int radius = 40;
        AABB effectBox = ShoutHelper.getEffectAABB(range, radius, instance.getOwner());

        if (!level.isClientSide()) {
            for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, effectBox)) {
                int duration = SkyrimShouts.getConfig().auraWhisper.duration * 20;
                MobEffectInstance glow = new MobEffectInstance(MobEffects.GLOWING, duration, 1);
                entity.addEffect(glow);
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    public void tick(ShoutInstance instance) {
    }
}
