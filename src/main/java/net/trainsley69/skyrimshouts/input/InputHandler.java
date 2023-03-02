package net.trainsley69.skyrimshouts.input;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.trainsley69.skyrimshouts.shouts.Shout;

import java.util.Arrays;

public class InputHandler {

    private static final Minecraft MINECRAFT = Minecraft.getInstance();
    public static Shout[] selectedShoutsArray = new Shout[3];

    /*public static List<Shout> selectedShouts = Util.make(
            new ArrayList<>(3), InputHandler::initDefaultSelectShouts
    );*/

    public static void assignShout(Shout shout, int index){
        if(index <= 3){
            int shoutIndexInArray = Arrays.stream(selectedShoutsArray).toList().indexOf(shout);
            if(shoutIndexInArray != -1){
                selectedShoutsArray[shoutIndexInArray] = selectedShoutsArray[index];
                selectedShoutsArray[index] = shout;
            }
            selectedShoutsArray[index] = shout;
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
            // player.getShoutManager().use(selectedShouts.get(0));
            player.getShoutManager().use(selectedShoutsArray[0]);
        }

        while (KeyMappings.SECOND_SHOUT.consumeClick()) {
            // player.getShoutManager().use(selectedShouts.get(1));
            player.getShoutManager().use(selectedShoutsArray[1]);
        }
    }
}
