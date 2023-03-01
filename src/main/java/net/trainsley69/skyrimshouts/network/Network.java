package net.trainsley69.skyrimshouts.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.world.entity.player.Player;
import net.trainsley69.skyrimshouts.network.c2s.ShoutUse;
import net.trainsley69.skyrimshouts.shouts.Shout;

public class Network {
    private static void server() {
        ServerPlayNetworking.registerGlobalReceiver(NetworkConstants.SHOUT_USE_ID, (server, player, handler, buf, responseHandler) -> {
            Shout shout = ShoutUse.unpack(buf);
            Player player1 = player;
            player1.getShoutManager().use(shout);
        });
    }

    private static void client() {
        // empty for now
    }

    public static void bootstrap() {
        server();
        client();
    }
}
