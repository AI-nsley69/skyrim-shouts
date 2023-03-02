package net.trainsley69.skyrimshouts.shouts;

import java.util.HashMap;
import java.util.Map;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;

import net.trainsley69.skyrimshouts.core.ModRegistries;
import net.trainsley69.skyrimshouts.network.NetworkConstants;
import net.trainsley69.skyrimshouts.network.c2s.ShoutUse;

public class ShoutManager {

    private final Player owner;
    private final Map<Shout, ShoutInstance> activeShouts = new HashMap<>();

    public ShoutManager(Player player) {
        this.owner = player;

        for (Shout type : ModRegistries.SHOUT) {
            if (this.isShoutUnlocked(type)) {
                this.activeShouts.put(type, new ShoutInstance(type, this.owner));
            }
        }
    }

    private boolean isShoutUnlocked(Shout shout) {
        return true;
    }

    public InteractionResult use(Shout type) {
        if (this.owner.getLevel().isClientSide()) return use(type, false);
        else return use(type, true);
    }

    public InteractionResult use(Shout type, boolean isAuthorized) {
        if (!isAuthorized) {
            ClientPlayNetworking.send(NetworkConstants.SHOUT_USE_ID, ShoutUse.pack(type));
            return InteractionResult.PASS;
        }

        if (!this.activeShouts.containsKey(type)) return InteractionResult.FAIL;
        ShoutInstance shout = this.activeShouts.get(type);

        if (!shout.isOnCooldown()) {
            InteractionResult result = type.use(shout);
            if (result == InteractionResult.SUCCESS) shout.setCooldown(type.getCooldown());

            return result;
        }

        return InteractionResult.FAIL;
    }

    public void clientUse(Shout type) {

    }

    public void tick() {
        for (ShoutInstance shout : this.activeShouts.values()) {
            shout.tick();
        }
    }
}
