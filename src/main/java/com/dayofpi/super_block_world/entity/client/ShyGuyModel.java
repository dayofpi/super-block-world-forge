package com.dayofpi.super_block_world.entity.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.ModAnimations;
import com.dayofpi.super_block_world.entity.custom.ShyGuyEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.HumanoidArm;

public class ShyGuyModel<T extends ShyGuyEntity> extends HierarchicalModel<T> implements ArmedModel {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SuperBlockWorld.MOD_ID, "shy_guy"), "main");
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart rightArm;
	private final ModelPart leftArm;

	public ShyGuyModel(ModelPart root) {
		this.root = root.getChild("root");
		this.body = this.root.getChild("body");
		this.leftArm = this.root.getChild("leftarm");
		this.rightArm = this.root.getChild("rightarm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 13.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(0, 23).addBox(-5.0F, -6.0F, -7.0F, 10.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition hoodend = body.addOrReplaceChild("hoodend", CubeListBuilder.create().texOffs(19, 32).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 5.0F));

		PartDefinition rightarm = root.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(0, 34).addBox(-3.0F, -1.0F, -2.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -8.0F, 0.0F));

		PartDefinition leftarm = root.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(0, 34).mirror().addBox(0.0F, -1.0F, -2.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, -8.0F, 0.0F));

		PartDefinition rightfoot = root.addOrReplaceChild("rightfoot", CubeListBuilder.create().texOffs(24, 23).mirror().addBox(-3.0F, -1.0F, -4.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -2.0F, 1.0F));

		PartDefinition leftfoot = root.addOrReplaceChild("leftfoot", CubeListBuilder.create().texOffs(24, 23).addBox(-2.0F, -1.0F, -4.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -2.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}

	@Override
	public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(ModAnimations.SHY_GUY_WALK, pLimbSwing, pLimbSwingAmount, 2.0F, 100.0F);
		this.animate(pEntity.idleAnimationState, ModAnimations.SHY_GUY_IDLE, pAgeInTicks);
	}

	@Override
	public void translateToHand(HumanoidArm pSide, PoseStack pPoseStack) {
		boolean flag = pSide == HumanoidArm.RIGHT;
		ModelPart modelpart = flag ? this.rightArm : this.leftArm;
		this.root.translateAndRotate(pPoseStack);
		modelpart.translateAndRotate(pPoseStack);
		pPoseStack.scale(0.75F, 0.75F, 0.75F);
		this.offsetStackPosition(pPoseStack, flag);
	}

	private void offsetStackPosition(PoseStack poseStack, boolean isRightArm) {
		if (isRightArm) {
			poseStack.translate(0.0D, -0.295D, 0.078125D);
		} else {
			poseStack.translate(0.046875D, -0.295D, 0.078125D);
		}
	}
}