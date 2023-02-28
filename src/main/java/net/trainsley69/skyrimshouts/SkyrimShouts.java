package net.trainsley69.skyrimshouts;

import net.trainsley69.skyrimshouts.shouts.ShoutManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

import net.fabricmc.api.ModInitializer;

import net.minecraft.client.gui.screens.Screen;

import net.trainsley69.skyrimshouts.config.ShoutsConfig;
import net.trainsley69.skyrimshouts.registry.ModRegistries;
import net.trainsley69.skyrimshouts.registry.effects.ShoutMobEffects;
import net.trainsley69.skyrimshouts.registry.shouts.Shouts;

public class SkyrimShouts implements ModInitializer {
    public static final String MOD_ID = "skyrim-shouts";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static ShoutsConfig config;

    @Override
    public void onInitialize() {
        LOGGER.info("Dovahkiin. Dragonborn. FUS RO DAH!");
        ModRegistries.bootstrap();
        ShoutMobEffects.bootstrap();
        Shouts.bootstrap();

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
}
