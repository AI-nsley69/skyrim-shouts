package net.trainsley69.skyrimshouts.shouts;

import net.trainsley69.skyrimshouts.shouts.Shout;

public class ShoutInstance {
    private final Shout shout;
    private int cooldown;

    public ShoutInstance(Shout shout) {
        this.shout = shout;
        this.cooldown = shout.getCooldown();
    }

    public void tick() {
        if (this.cooldown > 0) this.cooldown--;
        this.shout.tick(this);
    }

    public boolean isOnCooldown() {
        return this.cooldown > 0;
    }
}
