package io.github.sweetberrycollective.block;

import io.github.sweetberrycollective.item.SweetCropsItems;
import net.minecraft.block.BeetrootsBlock;
import net.minecraft.item.ItemConvertible;

public class MintBlock extends BeetrootsBlock {
	public MintBlock(Settings settings) {
		super(settings);
	}

	protected ItemConvertible getSeedsItem() {
		return SweetCropsItems.MINT;
	}
}
