package net.trainsley69.skyrimshouts.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

import net.trainsley69.skyrimshouts.SkyrimShouts;
import net.trainsley69.skyrimshouts.shouts.AuraWhisper;
import net.trainsley69.skyrimshouts.shouts.ClearSkies;

@Config(name = SkyrimShouts.MOD_ID)
public class ShoutsConfig implements ConfigData {

    @ConfigEntry.Gui.CollapsibleObject
    public MarkedForDeath markedForDeath = new MarkedForDeath();

    public static class MarkedForDeath {
        public float damageMultiplier = 1.2f;
        public int cooldown = 15;
        public int effectDuration = 15;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public ClearSkies clearSkies = new ClearSkies();

    public static class ClearSkies {
        public int cooldown = 60 * 5;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public AuraWhisper auraWhisper = new AuraWhisper();

    public static class AuraWhisper {
        public int cooldown = 60;
        public int duration = 30;
    }
}
