package net.trainsley69.skyrimshouts.registry;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import net.trainsley69.skyrimshouts.SkyrimShouts;
import net.trainsley69.skyrimshouts.shouts.Shout;

public class ModRegistries {

    public static final Registry<Shout> SHOUT = registerSimple("shout");

    private static <T> Registry<T> registerSimple(String name) {
        ResourceLocation id = new ResourceLocation(SkyrimShouts.MOD_ID, name);
        ResourceKey<Registry<T>> key = ResourceKey.createRegistryKey(id);

        return FabricRegistryBuilder.createSimple(key).buildAndRegister();
    }

    public static void bootstrap() { }
}
