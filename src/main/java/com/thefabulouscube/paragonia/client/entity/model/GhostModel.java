package com.thefabulouscube.paragonia.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.thefabulouscube.paragonia.entities.GhostEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class GhostModel<T extends GhostEntity> extends EntityModel<GhostEntity> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer headOverlay;
	private final ModelRenderer leftArm;
	private final ModelRenderer leftArmLower;
	private final ModelRenderer rightArm;
	private final ModelRenderer rightArmLower;

	public GhostModel() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 20.0F, 0.0F);
		body.setTextureOffset(16, 16).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -20.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		headOverlay = new ModelRenderer(this);
		headOverlay.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(headOverlay);
		headOverlay.setTextureOffset(0, 35).addBox(-4.5F, -21.0F, -4.5F, 9.0F, 9.0F, 9.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(leftArm, 0.0F, -0.2618F, 0.0F);
		body.addChild(leftArm);
		leftArm.setTextureOffset(21, 54).addBox(4.0F, -12.0F, -4.5F, 4.0F, 4.0F, 6.0F, 0.0F, true);

		leftArmLower = new ModelRenderer(this);
		leftArmLower.setRotationPoint(8.0F, -10.0F, -4.5F);
		setRotationAngle(leftArmLower, 0.0F, 0.2618F, 0.0F);
		leftArm.addChild(leftArmLower);
		leftArmLower.setTextureOffset(0, 54).addBox(-4.0F, -2.0F, -6.0F, 4.0F, 4.0F, 6.0F, 0.0F, true);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(rightArm, 0.0F, 0.2618F, 0.0F);
		body.addChild(rightArm);
		rightArm.setTextureOffset(21, 54).addBox(-8.0F, -12.0F, -4.5F, 4.0F, 4.0F, 6.0F, 0.0F, false);

		rightArmLower = new ModelRenderer(this);
		rightArmLower.setRotationPoint(-8.0F, -10.0F, -4.5F);
		setRotationAngle(rightArmLower, 0.0F, -0.2618F, 0.0F);
		rightArm.addChild(rightArmLower);
		rightArmLower.setTextureOffset(0, 54).addBox(0.0F, -2.0F, -6.0F, 4.0F, 4.0F, 6.0F, 0.0F, false);
	}


	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);

	}

	@Override
	public void setRotationAngles(GhostEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
//		this.body.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount/16;
		this.rightArm.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount) + 0.2618F;
		this.leftArm.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount) + -0.2618F;
		this.rightArmLower.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount/2) +  -0.2618F;
		this.leftArmLower.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount/2) + 0.2618F;
	}

	
	private void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;	
	}
	
	@Override
	public void setLivingAnimations(GhostEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}
	
	public ModelRenderer getRightArm() {
		return rightArm;
	}
	
	public ModelRenderer getRightArmLower() {
		return rightArmLower;
	}
	
	public ModelRenderer getLeftArm() {
		return leftArm;
	}
	
	public ModelRenderer getLeftArmLower() {
		return leftArmLower;
	}

}
