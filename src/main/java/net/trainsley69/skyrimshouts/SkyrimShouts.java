package net.trainsley69.skyrimshouts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

import net.fabricmc.api.ModInitializer;

import net.minecraft.client.gui.screens.Screen;

import net.trainsley69.skyrimshouts.config.ShoutsConfig;
import net.trainsley69.skyrimshouts.registry.effects.SSEffects;
import net.trainsley69.skyrimshouts.registry.shouts.ShoutsRegistry;

public class SkyrimShouts implements ModInitializer {
    public static final String MOD_ID = "skyrim-shouts";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final ShoutManager SHOUT_MANAGER = new ShoutManager();

    private static ShoutsConfig config;

    @Override
    public void onInitialize() {
        this.register();
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

    public void register() {
        String name = "skyrimshouts";
        SSEffects.register(name);
        ShoutsRegistry.create();
    }
}
