package net.trainsley69.skyrimshouts.mixin;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Options;
import net.trainsley69.skyrimshouts.input.KeyMappings;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collection;

@Mixin(Options.class)
public class OptionsMixin {
    @Shadow @Final @Mutable public KeyMapping[] keyMappings;

    @Inject(method = "<init>", at = @At(value = "INVOKE", shift = At.Shift.BEFORE, target = "Lnet/minecraft/client/Options;load()V"))
    private void initKeys(CallbackInfo ci) {
        Collection<KeyMapping> shoutKeys = KeyMappings.getKeyMappings();
        KeyMapping[] vanillaKeys = keyMappings;
        keyMappings = new KeyMapping[vanillaKeys.length + shoutKeys.size()];

        int index = 0;
        for (KeyMapping key : vanillaKeys) {
            keyMappings[index++] = key;
        }
        for (KeyMapping key : shoutKeys) {
            keyMappings[index++] = key;
        }
    }
}
