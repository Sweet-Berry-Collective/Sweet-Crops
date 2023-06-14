package io.github.sweetberrycollective.item;

import io.github.sweetberrycollective.block.SweetCropsBlocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class SweetCropsItems {
	public static final Item STRAWBERRY = new AliasedBlockItem(SweetCropsBlocks.STRAWBERRY_BUSH, new QuiltItemSettings().food(FoodComponents.SWEET_BERRIES));
	public static final Item MINT = new AliasedBlockItem(SweetCropsBlocks.MINT, new QuiltItemSettings());
	public static final Item MINT_LEAF = new Item(new QuiltItemSettings().food(FoodComponents.BEETROOT));

	public static void register(Item item, String id) {
		Registry.register(Registries.ITEM, new Identifier("sweet_crops", id), item);
	}

	public static void initialize() {
		register(STRAWBERRY, "strawberry");
		register(MINT, "mint");
		register(MINT_LEAF, "mint_leaf");
	}
}
