package net.trainsley69.skyrimshouts.input;

import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.trainsley69.skyrimshouts.shouts.Shout;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    private static final Minecraft MINECRAFT = Minecraft.getInstance();
    public static List<Shout> selectedShouts = Util.make(
            new ArrayList<>(3), InputHandler::initDefaultSelectShouts
    );

    public static void initDefaultSelectShouts(ArrayList<Shout> list){
        list.add(null);
        list.add(null);
        list.add(null);
    }
    public static void addSelectedShout(Shout shout){
        if(selectedShouts.size() < 3){
            selectedShouts.add(shout);
        }
    }

    public static void assignShout(Shout shout, int index){
        if(index <= 3){
            selectedShouts.add(index,shout);
        }

    }
    public static void handleKeybinds() {
        Player player = MINECRAFT.player;

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
