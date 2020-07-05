package com.thefabulouscube.paragonia.entities;

import com.thefabulouscube.paragonia.init.ItemInit;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class WoodSpriteEntity extends AnimalEntity {
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromTag(ItemTags.SAPLINGS);

//	public WoodSpriteEntity(World world) {
//		this(EntityInit.WOOD_SPRITE.get(), world);
//	}

	public WoodSpriteEntity(EntityType<? extends WoodSpriteEntity> type, World worldIn) {
		super(type, worldIn);
		this.moveController = new MovementController(this);
		this.setPathPriority(PathNodeType.WATER, -1.0F);
	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		return null;
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new TemptGoal(this, 0.4D, TEMPTATION_ITEMS, false));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
	      this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
	}


	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.7F);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(12.0D);
	}
	@Override
	public ItemStack getPickedResult(RayTraceResult target) {
		return new ItemStack(ItemInit.WOOD_SPRITE_SPAWN_EGG.get());

	}

}
