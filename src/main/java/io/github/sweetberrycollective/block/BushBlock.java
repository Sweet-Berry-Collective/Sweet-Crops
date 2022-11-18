package io.github.sweetberrycollective.block;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class BushBlock extends PlantBlock implements Fertilizable {
	private static final float HURT_SPEED_THRESHOLD = 0.003F;
	public static final int MAX_AGE = 3;
	public static final IntProperty AGE;
	private static final VoxelShape SMALL_SHAPE;
	private static final VoxelShape LARGE_SHAPE;

	public BushBlock(AbstractBlock.Settings settings) {
		super(settings);
		this.setDefaultState((BlockState) ((BlockState) this.stateManager.getDefaultState()).with(AGE, 0));
	}

	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		if ((Integer) state.get(AGE) == 0) {
			return SMALL_SHAPE;
		} else {
			return (Integer) state.get(AGE) < 3 ? LARGE_SHAPE : super.getOutlineShape(state, world, pos, context);
		}
	}

	public boolean hasRandomTicks(BlockState state) {
		return (Integer) state.get(AGE) < 3;
	}

	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, RandomGenerator random) {
		int i = (Integer) state.get(AGE);
		if (i < 3 && random.nextInt(5) == 0 && world.getBaseLightLevel(pos.up(), 0) >= 9) {
			BlockState blockState = (BlockState) state.with(AGE, i + 1);
			world.setBlockState(pos, blockState, 2);
			world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.create(blockState));
		}

	}

	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		if (entity instanceof LivingEntity && entity.getType() != EntityType.FOX && entity.getType() != EntityType.BEE) {
			entity.slowMovement(state, new Vec3d(0.800000011920929, 0.75, 0.800000011920929));
			if (!world.isClient && (Integer) state.get(AGE) > 0 && (entity.lastRenderX != entity.getX() || entity.lastRenderZ != entity.getZ())) {
				double d = Math.abs(entity.getX() - entity.lastRenderX);
				double e = Math.abs(entity.getZ() - entity.lastRenderZ);
				if (d >= 0.003000000026077032 || e >= 0.003000000026077032) {
					entity.damage(DamageSource.SWEET_BERRY_BUSH, 1.0F);
				}
			}

		}
	}

	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(new Property[]{AGE});
	}

	public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
		return (Integer) state.get(AGE) < 3;
	}

	public boolean canGrow(World world, RandomGenerator random, BlockPos pos, BlockState state) {
		return true;
	}

	public void grow(ServerWorld world, RandomGenerator random, BlockPos pos, BlockState state) {
		int i = Math.min(3, (Integer) state.get(AGE) + 1);
		world.setBlockState(pos, (BlockState) state.with(AGE, i), 2);
	}

	static {
		AGE = Properties.AGE_3;
		SMALL_SHAPE = Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 8.0, 13.0);
		LARGE_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);
	}
}
