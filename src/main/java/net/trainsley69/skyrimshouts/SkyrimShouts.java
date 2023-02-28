package net.trainsley69.skyrimshouts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

import net.fabricmc.api.ModInitializer;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;

import net.trainsley69.skyrimshouts.config.ShoutsConfig;
import net.trainsley69.skyrimshouts.registry.effects.MarkedForDeath;

public class SkyrimShouts implements ModInitializer {
	public static final String MOD_ID = "skyrim-shouts";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static ShoutsConfig config;

	@Override
	public void onInitialize() {
		Register();
		LOGGER.info("Dovahkiin. Dragonborn. FUS RO DAH!");

		AutoConfig.register(ShoutsConfig.class, GsonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(ShoutsConfig.class).get();
	}

	public static ShoutsConfig getConfig() {
		if (config == null)
			throw new IllegalStateException("cannot access the config before it is registered!");
		return config;
	}

	public static Screen getConfigScreen(Screen parent) {
		return AutoConfig.getConfigScreen(ShoutsConfig.class, parent).get();
	}

	// Registries
	public static final MobEffect MFD = new MarkedForDeath();
	public void Register() {
		String name = "skyrimshouts";
		Registry.register(BuiltInRegistries.MOB_EFFECT, new ResourceLocation(name, "marked_for_death"), MFD);
	}
}
