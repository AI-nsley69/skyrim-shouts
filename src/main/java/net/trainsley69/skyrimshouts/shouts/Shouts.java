package net.trainsley69.skyrimshouts.shouts;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import net.trainsley69.skyrimshouts.SkyrimShouts;
import net.trainsley69.skyrimshouts.core.ModRegistries;

public class Shouts {

    public static final MarkedForDeath MARKED_FOR_DEATH = register("marked_for_death", new MarkedForDeath());
    public static final ClearSkies CLEAR_SKIES = register("clear_skies", new ClearSkies());

    private static <T extends Shout> T register(String name, T shout) {
        return Registry.register(ModRegistries.SHOUT, new ResourceLocation(SkyrimShouts.MOD_ID, name), shout);
    }

    public static void bootstrap() { }
}
