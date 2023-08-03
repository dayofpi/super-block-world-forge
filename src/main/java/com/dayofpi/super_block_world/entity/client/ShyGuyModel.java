package com.dayofpi.super_block_world.entity.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.custom.ShyGuyEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ShyGuyModel<T extends ShyGuyEntity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SuperBlockWorld.MOD_ID, "shy_guy"), "main");
	private final ModelPart root;
	private final ModelPart leftFoot;
	private final ModelPart rightFoot;
	private final ModelPart body;
	private final ModelPart rightArm;
	private final ModelPart leftArm;

	public ShyGuyModel(ModelPart root) {
		this.root = root.getChild("root");
		this.leftFoot = this.root.getChild("left_foot");
		this.rightFoot = this.root.getChild("right_foot");
		this.body = this.root.getChild("body");
		this.leftArm = this.body.getChild("left_arm");
		this.rightArm = this.body.getChild("right_arm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition left_foot = root.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(0, 19).addBox(-2.0F, 4.0F, -4.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -6.0F, 1.0F, 0.0F, -0.0349F, 0.0F));

		PartDefinition right_foot = root.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(0, 19).addBox(-2.0F, 4.0F, -4.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -6.0F, 1.0F, 0.0F, 0.0349F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -11.5F, -4.1667F, 8.0F, 11.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(24, 0).addBox(-3.0F, -10.5F, 3.8333F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(20, 19).addBox(-4.0F, -10.5F, -5.1667F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, 0.1667F));

		PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(32, 12).addBox(-2.0F, -1.0F, -1.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -4.5F, -0.1667F));

		PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 12).addBox(0.0F, -1.0F, -1.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -4.5F, -0.1667F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.zRot = Mth.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;

		this.rightFoot.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftFoot.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;

		if (!entity.isAggressive() && !entity.isOnFire() && !entity.isFreezing()) {
			this.rightArm.zRot = 0F;
			this.leftArm.zRot = 0F;
		}
		else {
			this.rightArm.zRot = 1.5F;
			this.leftArm.zRot = -1.5F;
			return;
		}

		this.rightArm.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
		this.leftArm.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}