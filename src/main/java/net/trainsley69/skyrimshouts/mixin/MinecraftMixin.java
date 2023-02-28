package net.trainsley69.skyrimshouts.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.Minecraft;

import net.trainsley69.skyrimshouts.input.InputHandler;

@Mixin(Minecraft.class)
public class MinecraftMixin {

    @Inject(at = @At("RETURN"), method = "handleKeybinds")
    private void handleKeybinds(CallbackInfo ci) {
        InputHandler.handleKeybinds();
    }
}
