package net.trainsley69.skyrimshouts.registry.effects;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;

import net.trainsley69.skyrimshouts.SkyrimShouts;

public class ShoutMobEffects {

    public static final MobEffect MARKED_FOR_DEATH = register("marked_for_death", new MarkedForDeath());

    private static <T extends MobEffect> T register(String name, T effect) {
        return Registry.register(BuiltInRegistries.MOB_EFFECT, new ResourceLocation(SkyrimShouts.MOD_ID, "marked_for_death"), effect);
    }

    public static void bootstrap() { }
}
