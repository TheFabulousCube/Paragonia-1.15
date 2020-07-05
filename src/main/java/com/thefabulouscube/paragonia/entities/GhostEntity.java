package com.thefabulouscube.paragonia.entities;

import java.util.UUID;

import javax.annotation.Nullable;

import com.thefabulouscube.paragonia.Paragonia;
import com.thefabulouscube.paragonia.init.ItemInit;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GhostEntity extends AnimalEntity implements IFlyingAnimal {

	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.COBWEB);
	private LivingEntity killer = null;
	private float rollAmount;
	private float rollAmountO;
	private UUID lastHurtBy;

	public GhostEntity(EntityType<? extends GhostEntity> type, World worldIn) {
		super(type, worldIn);
//		this.setGlowing(true);
		this.moveController = new FlyingMovementController(this, 20, true);
		this.setPathPriority(PathNodeType.WATER, -1.0F);
	}

//	public GhostEntity(World world) {
//		super(EntityInit.GHOST.get(), world);
//	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		return null;
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
//		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(0, new GhostEntity.AvengeDeathGoal(this));
		this.goalSelector.addGoal(1, new TemptGoal(this, 0.4D, TEMPTATION_ITEMS, false));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
	}

//	@Override
//	protected void updateAITasks() {
//		super.updateAITasks();
//	}
//
//	@Override
//	public void livingTick() {
//		super.livingTick();
//	}

	@Override
	public ItemStack getPickedResult(RayTraceResult target) {
		return new ItemStack(ItemInit.GHOST_SPAWN_EGG.get());

	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue((double) 0.6F);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.3F);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(48.0D);
	}

	/**
	 * Returns new PathNavigateGround instance
	 */
	protected PathNavigator createNavigator(World worldIn) {
		FlyingPathNavigator flyingpathnavigator = new FlyingPathNavigator(this, worldIn) {
			public boolean canEntityStandOnPos(BlockPos pos) {
				return !this.world.getBlockState(pos.down()).isAir();
			}
		};
		flyingpathnavigator.setCanOpenDoors(true);
		flyingpathnavigator.setCanSwim(false);
		flyingpathnavigator.setCanEnterDoors(true);
		return flyingpathnavigator;
	}

	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		super.handleStatusUpdate(id);
	}

	@OnlyIn(Dist.CLIENT)
	public float getBodyPitch(float p_226455_1_) {
		return MathHelper.lerp(p_226455_1_, this.rollAmountO, this.rollAmount);
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.BLOCK_PORTAL_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_BEE_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_BEE_DEATH;
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume() {
		return 0.4F;
	}

	public boolean onLivingFall(float distance, float damageMultiplier) {
		return false;
	}

	protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isInvulnerableTo(source)) {
			return false;
		} else {
			Entity entity = source.getTrueSource();
			if (!this.world.isRemote && entity instanceof PlayerEntity && !((PlayerEntity) entity).isCreative()
					&& !this.isAIDisabled()) {

				if (entity instanceof LivingEntity) {
					this.setRevengeTarget((LivingEntity) entity);
				}
			}

			return super.attackEntityFrom(source, amount);
		}
	}

	/**
	 * Sets the active target the Task system uses for tracking
	 */
	public void setAttackTarget(@Nullable LivingEntity entitylivingbaseIn) {
		super.setAttackTarget(entitylivingbaseIn);
//			Paragonia.LOGGER.info("setAttackTarget method: killer is set: " + entitylivingbaseIn);
		if (entitylivingbaseIn != null) {

			this.setGlowing(true);
		}

	}

	/**
	 * Hint to AI tasks that we were attacked by the passed EntityLivingBase and
	 * should retaliate. Is not guaranteed to change our actual active target (for
	 * example if we are currently busy attacking someone else)
	 */
	public void setRevengeTarget(@Nullable LivingEntity livingBase) {
		super.setRevengeTarget(livingBase);
		Paragonia.LOGGER.info("setRevengeTarget method: killer is set: " + livingBase);
		if (livingBase != null) {
			this.lastHurtBy = livingBase.getUniqueID();
		}

	}

	public boolean hasKiller() {
		return (this.killer != null);
	}

	public LivingEntity getKiller() {
		return this.killer;
	}

	public boolean setKiller(LivingEntity killerIn) {
		if (killerIn instanceof LivingEntity && killerIn.isAlive()) {
			Paragonia.LOGGER.info("setKiller method: killer is set: " + killerIn);
			this.killer = killerIn;
			return true;
		}

		Paragonia.LOGGER.info("setKiller method: FAILED ");
		return false;
	}

	class AvengeDeathGoal extends MeleeAttackGoal {

		AvengeDeathGoal(GhostEntity ghostIn) {
			super(ghostIn, 1.4D, true);
			Paragonia.LOGGER.info("Avenge Death Goal hit killer: " + ghostIn.getKiller());
			Paragonia.LOGGER.info("Avenge Death Goal attackTarget: " + ghostIn.getAttackTarget());
			Paragonia.LOGGER.info("Avenge Death Goal revengeTarget: " + ghostIn.getRevengeTarget());
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			GhostEntity.this.setGlowing(true);
			GhostEntity.this.killer.setGlowing(true);
			super.startExecuting();
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		public boolean shouldExecute() {
			if (super.shouldExecute() && GhostEntity.this.killer != null && GhostEntity.this.killer.isAlive()) {
				Paragonia.LOGGER.info("Avenge Death Goal begin: " + GhostEntity.this.killer);
				return true;
			}
			return false;
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting() {
			if (GhostEntity.this.killer != null && GhostEntity.this.killer.isAlive()) {
				return super.shouldContinueExecuting();
			} else {
				Paragonia.LOGGER.info("Avenge Death cancelled: " + GhostEntity.this.killer);
				GhostEntity.this.setKiller(null);
				GhostEntity.this.getNavigator().clearPath();
				GhostEntity.this.setGlowing(false);
				return false;
			}
		}

		public boolean isPreemptible() {
			return false;
		}
	}
}
