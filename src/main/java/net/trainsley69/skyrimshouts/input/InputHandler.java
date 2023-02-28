package net.trainsley69.skyrimshouts.input;

import net.trainsley69.skyrimshouts.registry.ModRegistries;
import net.trainsley69.skyrimshouts.registry.shouts.Shouts;
import net.trainsley69.skyrimshouts.shouts.MarkedForDeath;
import net.trainsley69.skyrimshouts.shouts.ShoutManager;

public class InputHandler {
    public static void handleKeybinds() {
        while (KeyMappings.FIRST_SHOUT.consumeClick()) {
            // TODO: do not hardcode
            ShoutManager.onKeyPress(Shouts.MARKED_FOR_DEATH);
        }
    }
}
