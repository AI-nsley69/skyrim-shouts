package net.trainsley69.skyrimshouts.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.world.entity.player.Player;

import net.trainsley69.skyrimshouts.shouts.ShoutManager;
import net.trainsley69.skyrimshouts.shouts.ShoutUser;

@Mixin(Player.class)
public class PlayerMixin implements ShoutUser {

    private final ShoutManager shoutManager = new ShoutManager((Player)(Object)this);

    @Inject(
        method = "tick",
        at = @At(
            value = "TAIL"
        )
    )
    private void tick(CallbackInfo ci) {
        this.shoutManager.tick();
    }

    @Override
    public ShoutManager getShoutManager() {
        return this.shoutManager;
    }
}
