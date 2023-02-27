package net.trainsley69.skyrimshouts;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.trainsley69.skyrimshouts.shouts.Shout;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ShoutManager {
    private final HashMap<String, List<ShoutInstance>> activeShouts = new HashMap<>();

    public ShoutManager() {
    }

    public void tick(Player player, Level level) {
        for (Map.Entry<String, List<ShoutInstance>> entry : this.activeShouts.entrySet()) {
            Iterator<ShoutInstance> it = entry.getValue().iterator();
            while (it.hasNext()) {
                ShoutInstance shout = it.next();
                shout.tick();
                if (!shout.isOnCooldown()) it.remove();
            }
        }
    }

    public void onKeyPress(Shout shout) {
        ShoutInstance instance = new ShoutInstance(shout);
        Minecraft client = Minecraft.getInstance();
        Player player = client.player;
        Level level = client.level;
        shout.use(player, level);
    }
}
