package net.trainsley69.skyrimshouts.input;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class KeyMappings {
    private static final Map<String, KeyMapping> KEY_BINDINGS = new LinkedHashMap<>();

    public static final String MAIN;
    public static final KeyMapping FIRST_SHOUT;
    public static final KeyMapping SECOND_SHOUT;
    public static final KeyMapping THIRD_SHOUT;

    private static KeyMapping registerKeyMapping(KeyMapping key, String name) {
        KEY_BINDINGS.putIfAbsent(name, key);
        return key;
    }

    public static Collection<KeyMapping> getKeyMappings() {
        return Collections.unmodifiableCollection(KEY_BINDINGS.values());
    }

    public static int getGlfwKey(String key) {
        return InputConstants.getKey(key).getValue();
    }

    static {
        MAIN = "Skyrim Shouts";
        FIRST_SHOUT = registerKeyMapping(new KeyMapping("text.options.first_shout", getGlfwKey("key.keyboard.g"), MAIN), "first_shout");
        SECOND_SHOUT = registerKeyMapping(new KeyMapping("text.options.second_shout", getGlfwKey("key.keyboard.x"), MAIN), "second_shout");
        THIRD_SHOUT = registerKeyMapping(new KeyMapping("text.options.third_shout", getGlfwKey("key.keyboard.v"), MAIN), "third_shout");
    }
}
