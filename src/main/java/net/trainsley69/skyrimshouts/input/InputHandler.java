package net.trainsley69.skyrimshouts.input;

import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

import net.trainsley69.skyrimshouts.shouts.Shout;
import net.trainsley69.skyrimshouts.shouts.Shouts;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    private static Minecraft minecraft = Minecraft.getInstance();
    public static List<Shout> selectedShouts = Util.make(new ArrayList<>(3), list -> {
        list.add(Shouts.MARKED_FOR_DEATH);
        list.add(Shouts.CLEAR_SKIES);
    });

    public static void handleKeybinds() {
        Player player = minecraft.player;

        if (player == null) {
            return;
        }

        // TODO: do not hardcode
        while (KeyMappings.FIRST_SHOUT.consumeClick()) {
            // Cast here fixes "cannot find symbol method getShoutManager()" somehow
            player.getShoutManager().use(selectedShouts.get(0));
        }

        while (KeyMappings.SECOND_SHOUT.consumeClick()) {
            player.getShoutManager().use(selectedShouts.get(1));
        }
    }
}
