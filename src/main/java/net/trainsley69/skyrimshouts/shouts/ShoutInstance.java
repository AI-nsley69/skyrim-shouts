package net.trainsley69.skyrimshouts.shouts;

import net.minecraft.world.entity.player.Player;

public class ShoutInstance {

    private final Shout type;
    private final Player owner;

    private int cooldown;

    public ShoutInstance(Shout type, Player owner) {
        this.type = type;
        this.owner = owner;

        this.cooldown = 0;
    }

    public Shout getType() {
        return this.type;
    }

    public Player getOwner() {
        return this.owner;
    }

    public boolean isOnCooldown() {
        return this.cooldown != 0;
    }

    public void tick() {
        if (this.cooldown > 0) {
            this.cooldown--;
        } else {
            this.type.tick(this);
        }
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }
}
