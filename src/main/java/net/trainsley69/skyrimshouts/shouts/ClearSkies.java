package net.trainsley69.skyrimshouts.shouts;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.trainsley69.skyrimshouts.SkyrimShouts;
import net.trainsley69.skyrimshouts.network.NetworkConstants;
import net.trainsley69.skyrimshouts.network.c2s.ShoutUse;

import java.util.Objects;

public class ClearSkies extends Shout {
    public ClearSkies() {
        super("Clear Skies");
    }

    public int getCooldown() {
        return 20 * SkyrimShouts.getConfig().clearSkies.cooldown;
    }

    @Override
    public InteractionResult use(ShoutInstance instance) {
        Player player = instance.getOwner();
        if (!player.getLevel().isClientSide()) {
            ServerLevel level = Objects.requireNonNull(player.getServer()).overworld();
            level.setWeatherParameters(0, 0, false, false);
            level.setDayTime(6000);

            return InteractionResult.SUCCESS;
        } else {
            ClientPlayNetworking.send(NetworkConstants.SHOUT_USE_ID, ShoutUse.pack(this));
        }

        return InteractionResult.FAIL;
    }

    @Override
    public void tick(ShoutInstance instance) {

    }
}
