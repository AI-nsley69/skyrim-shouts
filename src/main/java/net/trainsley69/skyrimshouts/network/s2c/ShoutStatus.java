package net.trainsley69.skyrimshouts.network.s2c;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.InteractionResult;

public class ShoutStatus {
    public static FriendlyByteBuf pack(InteractionResult result) {
        FriendlyByteBuf buffer = PacketByteBufs.create();
        boolean bool = result == InteractionResult.SUCCESS;
        buffer.writeBoolean(bool);

        return buffer;
    }

    public static InteractionResult unpack(FriendlyByteBuf buffer) {
        boolean bool = buffer.readBoolean();

        return bool ? InteractionResult.SUCCESS : InteractionResult.FAIL;
    }
}
