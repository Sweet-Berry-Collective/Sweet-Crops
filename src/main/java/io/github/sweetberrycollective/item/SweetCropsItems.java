package io.github.sweetberrycollective.item;

import io.github.sweetberrycollective.block.SweetCropsBlocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class SweetCropsItems {
	public static final Item STRAWBERRY = new AliasedBlockItem(SweetCropsBlocks.STRAWBERRY_BUSH, new QuiltItemSettings().food(FoodComponents.SWEET_BERRIES));
	public static final Item MINT = new AliasedBlockItem(SweetCropsBlocks.MINT, new QuiltItemSettings());
	public static final Item MINT_LEAF = new Item(new QuiltItemSettings().food(FoodComponents.BEETROOT));

	public static void initialize() {
		Registry.register(Registry.ITEM, new Identifier("sweet_crops", "strawberry"), STRAWBERRY);
		Registry.register(Registry.ITEM, new Identifier("sweet_crops", "mint"), MINT);
		Registry.register(Registry.ITEM, new Identifier("sweet_crops", "mint_leaf"), MINT_LEAF);
	}
}
