package net.trainsley69.skyrimshouts.shouts;

import net.minecraft.world.InteractionResult;

public abstract class Shout {
    private final String name;

    public Shout(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract int getCooldown();

    public abstract InteractionResult use(ShoutInstance instance);

    public abstract void tick(ShoutInstance instance);
}
