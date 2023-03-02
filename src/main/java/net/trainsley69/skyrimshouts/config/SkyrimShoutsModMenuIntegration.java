package net.trainsley69.skyrimshouts.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import net.trainsley69.skyrimshouts.SkyrimShouts;

public class SkyrimShoutsModMenuIntegration implements ModMenuApi {

	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return SkyrimShouts::getConfigScreen;
	}
}
