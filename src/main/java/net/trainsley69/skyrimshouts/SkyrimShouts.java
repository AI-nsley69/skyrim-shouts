package net.trainsley69.skyrimshouts;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.trainsley69.skyrimshouts.config.Config;
import net.trainsley69.skyrimshouts.registry.effects.MarkedForDeath;
import net.trainsley69.skyrimshouts.registry.effects.SSEffects;
import net.trainsley69.skyrimshouts.registry.shouts.ShoutsRegistry;
import org.intellij.lang.annotations.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkyrimShouts implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("skyrim-shouts");

	public static final Config CONFIG = new Config();

	public static final ShoutManager SHOUT_MANAGER = new ShoutManager();


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		this.register();
		LOGGER.info("Dovahkiin. Dragonborn. FUS RO DAH!");
	}


	public void register() {
		String name = "skyrimshouts";
		SSEffects.register(name);
		ShoutsRegistry.create();
	}
}
