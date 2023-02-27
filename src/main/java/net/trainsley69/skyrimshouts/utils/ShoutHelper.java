package net.trainsley69.skyrimshouts.utils;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ShoutHelper {
    public static AABB getEffectAABB(double range, double radius, Player player) {
        Vec3 src = new Vec3(player.getX(), player.getY() + player.getEyeHeight(), player.getZ());
        Vec3 look = player.getLookAngle().scale(range);
        Vec3 dest = src.add(look.x(), look.y(), look.z());

        return new AABB(
                dest.x() - radius, dest.y() - radius, dest.z() - radius,
                dest.x() + radius, dest.y() + radius, dest.z() + radius
        );
    }
}
