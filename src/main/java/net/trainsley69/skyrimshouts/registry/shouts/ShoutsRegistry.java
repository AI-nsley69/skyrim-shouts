package net.trainsley69.skyrimshouts.registry.shouts;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.trainsley69.skyrimshouts.shouts.MarkedForDeath;
import net.trainsley69.skyrimshouts.shouts.Shout;

public class ShoutsRegistry {
    public static Registry<Shout> registry;
    public static final String name = "shouts";

    public static void create() {
        ResourceLocation location = new ResourceLocation(name, "skyrimshouts");
        ResourceKey<Registry<Shout>> key = ResourceKey.createRegistryKey(location);
        registry = FabricRegistryBuilder.createSimple(key)
                .attribute(RegistryAttribute.SYNCED)
                .buildAndRegister();

        addShouts();
    }

    public static final MarkedForDeath MARKED_FOR_DEATH = new MarkedForDeath();
    private static void addShouts() {
        Registry.register(registry, new ResourceLocation(name, "marked_for_death"), MARKED_FOR_DEATH);
    }


}
