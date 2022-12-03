package io.github.sweetberrycollective.block;

import io.github.sweetberrycollective.item.SweetCropsItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class MintBlock extends CropBlock {
	public static final int MAX_AGE = 3;
	public static final IntProperty AGE;
	private static final VoxelShape[] AGE_TO_SHAPE;

	public MintBlock(Settings settings) {
		super(settings);
	}

	public IntProperty getAgeProperty() {
		return AGE;
	}

	public int getMaxAge() {
		return 3;
	}

	protected ItemConvertible getSeedsItem() {
		return SweetCropsItems.MINT;
	}

	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, RandomGenerator random) {
		if (random.nextInt(3) != 0) {
			super.randomTick(state, world, pos, random);
		}
	}

	protected int getGrowthAmount(World world) {
		return super.getGrowthAmount(world) / 3;
	}

	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(new Property[]{AGE});
	}

	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return AGE_TO_SHAPE[(Integer) state.get(this.getAgeProperty())];
	}

	static {
		AGE = Properties.AGE_3;
		AGE_TO_SHAPE = new VoxelShape[]{Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 2.0, 16.0), Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 16.0), Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 6.0, 16.0), Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 16.0)};
	}
}
