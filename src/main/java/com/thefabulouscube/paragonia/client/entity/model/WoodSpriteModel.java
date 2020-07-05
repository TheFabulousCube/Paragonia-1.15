package com.thefabulouscube.paragonia.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.thefabulouscube.paragonia.entities.WoodSpriteEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class WoodSpriteModel<T extends WoodSpriteEntity> extends EntityModel<WoodSpriteEntity> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer antenna;
	private final ModelRenderer spire;
	private final ModelRenderer leaves;
	private final ModelRenderer leaf1;
	private final ModelRenderer leaf2;
	private final ModelRenderer leaf3;
	private final ModelRenderer arms;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightArm;
	private final ModelRenderer legs;
	private final ModelRenderer leftLeg;
	private final ModelRenderer rightLeg;
	private float antennaPos = 0;

	public WoodSpriteModel() {
		textureWidth = 32;
		textureHeight = 32;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 22).addBox(-2.5F, -10.0F, -2.0F, 5.0F, 6.0F, 4.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -10.0F, 0.0F);
		body.addChild(head);
		head.setTextureOffset(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);

		antenna = new ModelRenderer(this);
		antenna.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(antenna);
		
		// This is not where it should be, use the other corner
		spire = new ModelRenderer(this);
		spire.setRotationPoint(-1.25F, -6.0F, 1.25F);
		antenna.addChild(spire);
//		spire.setTextureOffset(15, 22).addBox(-0.75F, -2.0F, -0.25F, 0.5F, 2.0F, 0.5F, 0.0F, false);
		spire.setTextureOffset(15, 22).addBox(-0.25F, -2.0F, 0.25F, 0.5F, 2.0F, 0.5F, 0.0F, false);

		leaves = new ModelRenderer(this);
		leaves.setRotationPoint(-1.25F, -8.0F, 1.25F);
		antenna.addChild(leaves);
		

		leaf1 = new ModelRenderer(this);
		leaf1.setRotationPoint(-0.75F, 0.0F, 0.75F);
		leaves.addChild(leaf1);
		setRotationAngle(leaf1, 0.0F, -0.7854F, 0.0F);
		leaf1.setTextureOffset(19, 24).addBox(0.0F, 0.002F, -2.0F, 3.0F, 0.0F, 2.0F, 0.0F, false);

		leaf2 = new ModelRenderer(this);
		leaf2.setRotationPoint(0.75F, 0.0F, 0.75F);
		leaves.addChild(leaf2);
		setRotationAngle(leaf2, 0.0F, 0.7854F, 0.0F);
		leaf2.setTextureOffset(19, 27).addBox(0.0F, 0.001F, -2.0F, 3.0F, 0.0F, 2.0F, 0.0F, false);

		leaf3 = new ModelRenderer(this);
		leaf3.setRotationPoint(1.25F, 18.0F, -1.25F);
		leaves.addChild(leaf3);
		leaf3.setTextureOffset(19, 30).addBox(-4.3813F, -18.0F, 0.25F, 3.0F, 0.0F, 2.0F, 0.0F, false);

		arms = new ModelRenderer(this);
		arms.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(arms);
		

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(-4.0F, -9.0F, 0.0F);
		arms.addChild(leftArm);
		leftArm.setTextureOffset(0, 13).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(4.0F, -9.0F, 0.0F);
		arms.addChild(rightArm);
		rightArm.setTextureOffset(0, 13).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, true);

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(legs);
		

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(-1.0F, -4.0F, 0.0F);
		legs.addChild(leftLeg);
		leftLeg.setTextureOffset(13, 13).addBox(-2.0F, -1.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(1.0F, -4.0F, 0.0F);
		legs.addChild(rightLeg);
		rightLeg.setTextureOffset(13, 13).addBox(-1.0F, -1.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, true);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);

	}

	@Override
	public void setRotationAngles(WoodSpriteEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.leaf1.rotateAngleY = -0.7854F;
		this.leaf2.rotateAngleY = 0.7854F;
//		setRotationAngle(leaf1, 0.0F, -0.7854F, 0.0F);
//		setRotationAngle(leaf2, 0.0F, 0.7854F, 0.0F);
		this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.8F;
		this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.rightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.8F;
		this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		antennaPos = antennaPos < Math.PI ? antennaPos + 0.03F : (float) -(Math.PI);
		this.leaves.rotateAngleY = antennaPos;
		
	}

	private void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setLivingAnimations(WoodSpriteEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}
	
	public ModelRenderer getRightArm() {
		return rightArm;
	}
	
	public ModelRenderer getRightLeg() {
		return rightLeg;
	}
	
	public ModelRenderer getLeftArm() {
		return leftArm;
	}
	
	public ModelRenderer getLeftLeg() {
		return leftLeg;
	}
	
	public ModelRenderer getLeaf1() {
		return leaf1;
	}
	
	public ModelRenderer getLeaf2() {
		return leaf2;
	}
}