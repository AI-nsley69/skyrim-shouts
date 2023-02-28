package net.trainsley69.skyrimshouts.registry.effects;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;

public class SSEffects {
    public static final MobEffect MFD = new MarkedForDeath();

    public static void register(String name) {
        Registry.register(BuiltInRegistries.MOB_EFFECT, new ResourceLocation(name, "marked_for_death"), MFD);
    }
}
