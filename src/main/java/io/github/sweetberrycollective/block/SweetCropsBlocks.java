package io.github.sweetberrycollective.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class SweetCropsBlocks {
	public static final StrawberryBushBlock STRAWBERRY_BUSH = new StrawberryBushBlock(QuiltBlockSettings.copy(Blocks.SWEET_BERRY_BUSH));
	public static final MintBlock MINT = new MintBlock(QuiltBlockSettings.copy(Blocks.BEETROOTS));

	public static void register(Block block, String id) {
		Registry.register(Registry.BLOCK, new Identifier("sweet_crops", id), block);
	}

	public static void initialize() {
		register(STRAWBERRY_BUSH, "strawberry_bush");
		register(MINT, "mint");
	}
}
