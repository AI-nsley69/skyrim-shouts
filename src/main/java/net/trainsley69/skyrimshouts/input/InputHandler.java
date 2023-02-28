package net.trainsley69.skyrimshouts.input;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

import net.trainsley69.skyrimshouts.shouts.ShoutManager;
import net.trainsley69.skyrimshouts.shouts.Shouts;

public class InputHandler {

    private static Minecraft minecraft = Minecraft.getInstance();

    public static void handleKeybinds() {
        if (minecraft.player == null) return;

        // TODO: do not hardcode
        while (KeyMappings.FIRST_SHOUT.consumeClick()) {
            minecraft.player.getShoutManager().use(Shouts.MARKED_FOR_DEATH);
        }
    }
}
