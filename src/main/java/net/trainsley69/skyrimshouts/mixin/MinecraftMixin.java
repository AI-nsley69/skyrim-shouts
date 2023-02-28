package net.trainsley69.skyrimshouts.mixin;

import net.minecraft.client.Minecraft;
import net.trainsley69.skyrimshouts.input.InputHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(at = @At("RETURN"), method = "handleKeybinds")
    private void handleKeybinds(CallbackInfo ci) {
        InputHandler.handleKeybinds();
    }
}
