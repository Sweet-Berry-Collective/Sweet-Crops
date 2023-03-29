package io.github.sweetberrycollective.client.render;

import io.github.sweetberrycollective.block.SweetCropsBlocks;
import net.minecraft.client.render.RenderLayer;
import org.quiltmc.loader.api.minecraft.ClientOnly;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;

@ClientOnly
public class SweetCropsRenderLayers {
	public static void init() {
		BlockRenderLayerMap.put(RenderLayer.getCutout(),
				SweetCropsBlocks.STRAWBERRY_BUSH,
				SweetCropsBlocks.MINT
		);
	}
}
