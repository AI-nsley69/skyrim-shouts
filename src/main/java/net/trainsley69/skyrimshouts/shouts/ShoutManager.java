package net.trainsley69.skyrimshouts.shouts;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.trainsley69.skyrimshouts.registry.ModRegistries;
import net.trainsley69.skyrimshouts.shouts.Shout;
import net.trainsley69.skyrimshouts.shouts.ShoutInstance;

import java.util.*;

public class ShoutManager {
    private final HashMap<Shout, ShoutInstance> shoutsOnCooldown = new HashMap();
    private final Player parent;

    public ShoutManager(Player player) {
        this.parent = player;

        List<Shout> shouts = ModRegistries.SHOUT.stream().toList();
        for (Shout shout : shouts) {
            if (!isShoutUnlocked(shout)) continue;
            ShoutInstance instance = new ShoutInstance(shout);
            shoutsOnCooldown.put(shout, instance);
        }
    }

    private boolean isShoutUnlocked(Shout shout) {
        return true;
    }

    public void tick(Player player, Level level) {
        for (ShoutInstance shout : shoutsOnCooldown.values()) {
            shout.tick();
        }
    }

    public void onKeyPress(Shout shout, Level level) {
        if (isShoutOnCooldown(shout)) return;
    }

    private boolean isShoutOnCooldown(Shout shout) {

        return false;
    }
}
