package net.trainsley69.skyrimshouts.shouts;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public abstract class Shout {
    private final String name;

    public Shout(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getCooldown() {
        return 40;
    }

    public abstract void use(Player player, Level level);
}
