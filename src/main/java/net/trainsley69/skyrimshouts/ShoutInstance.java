package net.trainsley69.skyrimshouts;

import net.trainsley69.skyrimshouts.shouts.Shout;

public class ShoutInstance {
    private final Shout shout;
    private int cooldown;

    public ShoutInstance(Shout shout) {
        this.shout = shout;
        this.cooldown = shout.getCooldown();
    }

    public void tick() {
        this.cooldown--;
    }

    public boolean isOnCooldown() {
        return this.cooldown > 0;
    }
}
