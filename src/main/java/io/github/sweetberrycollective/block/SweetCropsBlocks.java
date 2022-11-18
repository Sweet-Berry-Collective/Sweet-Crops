package io.github.sweetberrycollective.block;

import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class SweetCropsBlocks {
	public static final StrawberryBushBlock STRAWBERRY_BUSH = new StrawberryBushBlock(QuiltBlockSettings.copy(Blocks.SWEET_BERRY_BUSH));

	public static void initialize() {
		Registry.register(Registry.BLOCK, new Identifier("sweet_crops", "strawberry_bush"), STRAWBERRY_BUSH);
	}
}
