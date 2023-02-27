package net.trainsley69.skyrimshouts.shouts;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public abstract class Shout {
    public final String name;
    public final int cooldown;

    public Shout(String name, int cooldown) {
        this.name = name;
        this.cooldown = cooldown;
    }

    public abstract void use(Player player, Level level);
}
