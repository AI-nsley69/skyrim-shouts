package net.trainsley69.skyrimshouts.input;

import net.minecraft.client.Minecraft;

import net.trainsley69.skyrimshouts.shouts.ShoutUser;
import net.trainsley69.skyrimshouts.shouts.Shouts;

public class InputHandler {

    private static Minecraft minecraft = Minecraft.getInstance();

    public static void handleKeybinds() {
        if (minecraft.player == null) return;

        // TODO: do not hardcode
        while (KeyMappings.FIRST_SHOUT.consumeClick()) {
            // Cast here fixes "cannot find symbol method getShoutManager()" somehow
            ((ShoutUser)minecraft.player).getShoutManager().use(Shouts.MARKED_FOR_DEATH);
        }
    }
}
