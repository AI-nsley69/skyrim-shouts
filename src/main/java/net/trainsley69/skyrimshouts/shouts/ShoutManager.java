package net.trainsley69.skyrimshouts.shouts;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.world.entity.player.Player;

import net.trainsley69.skyrimshouts.core.ModRegistries;

public class ShoutManager {

    private final Player owner;
    private final Map<Shout, ShoutInstance> activeShouts = new HashMap<>();

    public ShoutManager(Player player) {
        this.owner = player;

        for (Shout type : ModRegistries.SHOUT) {
            if (this.isShoutUnlocked(type)) {
                this.activeShouts.put(type, new ShoutInstance(type, this.owner));
            }
        }
    }

    private boolean isShoutUnlocked(Shout shout) {
        return true;
    }

    public void use(Shout type) {
        ShoutInstance shout = this.activeShouts.get(type);

        if (!shout.isOnCooldown()) {
            type.use(this.owner.level, this.owner);
            shout.use();
        }
    }

    public void tick() {
        for (ShoutInstance shout : this.activeShouts.values()) {
            shout.tick();
        }
    }
}
