package io.github.sweetberrycollective;

import io.github.sweetberrycollective.client.render.SweetCropsRenderLayers;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.minecraft.ClientOnly;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

@ClientOnly
public class SweetCropsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient(ModContainer mod) {
		SweetCropsRenderLayers.init();
	}
}
