package net.trainsley69.skyrimshouts;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.trainsley69.skyrimshouts.config.ShoutsConfig;
import net.trainsley69.skyrimshouts.core.ModRegistries;
import net.trainsley69.skyrimshouts.input.InputHandler;
import net.trainsley69.skyrimshouts.network.Network;
import net.trainsley69.skyrimshouts.shouts.Shout;
import net.trainsley69.skyrimshouts.shouts.Shouts;
import net.trainsley69.skyrimshouts.shouts.effects.ShoutMobEffects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

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
        Network.bootstrap();

        AutoConfig.register(ShoutsConfig.class, GsonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(ShoutsConfig.class).get();

        ClientCommandRegistrationCallback.EVENT.register(
                (dispatcher, registryAccess) -> dispatcher.register(
                        ClientCommandManager.literal("selectShout").then(
                                ClientCommandManager.argument("index", IntegerArgumentType.integer(0,4)).then(
                                        ClientCommandManager.argument("shout", StringArgumentType.word()).executes(
                                                context -> {
                                                    String shoutName = context.getArgument("shout", String.class);
                                                    Integer index = context.getArgument("index", Integer.class);
                                                    Optional<Shout> shout = ModRegistries.SHOUT.getOptional(ResourceLocation.tryParse("skyrim-shouts:" + shoutName));
                                                    shout.ifPresent(shout1 -> InputHandler.assignShout(shout1,index));
                                                    shout.ifPresentOrElse(
                                                            shoutToAssign -> InputHandler.assignShout(shoutToAssign,index),
                                                            () -> context.getSource().sendError(Component.literal("not a valid shout"))
                                                    );
                                                    return 1;
                                                }
                                        )
                                )
                        )
                )
        );
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
