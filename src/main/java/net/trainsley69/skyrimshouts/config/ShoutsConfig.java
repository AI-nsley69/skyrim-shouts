package net.trainsley69.skyrimshouts.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

import net.trainsley69.skyrimshouts.SkyrimShouts;

@Config(name = SkyrimShouts.MOD_ID)
public class ShoutsConfig implements ConfigData {

	@ConfigEntry.Gui.CollapsibleObject
	public MarkedForDeath markedForDeath = new MarkedForDeath();

	public static class MarkedForDeath {
        public float damageMultiplier = 1.2f;
        public float weaknessMultiplier = 0.8f;
    }
}
