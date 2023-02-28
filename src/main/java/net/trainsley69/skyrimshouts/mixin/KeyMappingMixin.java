package net.trainsley69.skyrimshouts.mixin;

import net.minecraft.client.KeyMapping;
import net.trainsley69.skyrimshouts.input.KeyMappings;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(KeyMapping.class)
public class KeyMappingMixin {
    @Shadow @Final private static Map<String, Integer> CATEGORIES;

    @Inject(at = @At("RETURN"), method = "<clinit>")
    private static void initKeyMappings(CallbackInfo ci) {
        CATEGORIES.put(KeyMappings.MAIN, CATEGORIES.size() + 1);
    }
}
