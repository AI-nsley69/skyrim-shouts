package net.trainsley69.skyrimshouts.network.c2s;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.trainsley69.skyrimshouts.core.ModRegistries;
import net.trainsley69.skyrimshouts.shouts.Shout;

public class ShoutUse {
    public static FriendlyByteBuf pack(Shout shout) {
        FriendlyByteBuf buffer = PacketByteBufs.create();
        buffer.writeResourceLocation(ModRegistries.SHOUT.getKey(shout));

        return buffer;
    }

    public static Shout unpack(FriendlyByteBuf buffer) {
        ResourceLocation key = buffer.readResourceLocation();
        return ModRegistries.SHOUT.get(key);
    }
}
