package com.dayofpi.super_block_world.entity.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.ModAnimations;
import com.dayofpi.super_block_world.entity.custom.HungryLumaEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.joml.Vector3f;

public class HungryLumaModel<T extends HungryLumaEntity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SuperBlockWorld.MOD_ID, "hungry_luma"), "main");
	private final ModelPart root;
	private final ModelPart face;
	private final ModelPart body;
	private final ModelPart rightArm;
	private final ModelPart leftArm;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;

	public HungryLumaModel(ModelPart root) {
		this.root = root.getChild("root");
		this.face = this.root.getChild("face");
		this.body = this.root.getChild("body");
		this.rightArm = this.root.getChild("rightarm");
		this.leftArm = this.root.getChild("leftarm");
		this.rightLeg = this.root.getChild("rightleg");
		this.leftLeg = this.root.getChild("leftleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 14.0F, 0.0F));

		PartDefinition face = root.addOrReplaceChild("face", CubeListBuilder.create().texOffs(0, 34).addBox(-5.5F, -4.0F, -5.3F, 11.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -6.0F, -5.0F, 14.0F, 13.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition top = root.addOrReplaceChild("top", CubeListBuilder.create().texOffs(0, 24).addBox(-5.0F, -9.0F, -3.0F, 10.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = top.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(39, 39).addBox(-1.0F, -7.0F, 1.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition cube_r2 = top.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(44, 24).addBox(-4.0F, -7.0F, 1.0F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition rightarm = root.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(29, 29).addBox(-4.0F, -2.5F, -2.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -0.5F, 0.0F));

		PartDefinition rightstick = rightarm.addOrReplaceChild("rightstick", CubeListBuilder.create().texOffs(50, 14).addBox(-1.0F, -8.0F, 0.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(52, 36).addBox(-2.0F, -9.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(52, 30).addBox(-2.0F, -9.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offset(-2.0F, -2.5F, 0.0F));

		PartDefinition leftarm = root.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(29, 29).addBox(-1.0F, -2.5F, -2.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -0.5F, 0.0F));

		PartDefinition leftstick = leftarm.addOrReplaceChild("leftstick", CubeListBuilder.create().texOffs(50, 14).addBox(0.0F, -8.0F, 0.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(52, 36).addBox(-1.0F, -9.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(52, 30).addBox(-1.0F, -9.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offset(2.0F, -2.5F, 0.0F));

		PartDefinition rightleg = root.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(39, 0).addBox(-2.5F, -2.0F, -2.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 7.0F, 0.0F));

		PartDefinition leftleg = root.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(39, 0).addBox(-2.5F, -2.0F, -2.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 7.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}

	@Override
	public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animate(pEntity.idleAnimationState, ModAnimations.HUNGRY_LUMA_IDLE, pAgeInTicks, 3.0F);
		this.animate(pEntity.transformAnimationState, ModAnimations.HUNGRY_LUMA_TRANSFORM, pAgeInTicks);
		this.root.zRot = pHeadPitch * ((float)Math.PI / 180F) * 0.5F;
		this.body.offsetScale(new Vector3f(pEntity.getReceivedStarBits() * 0.01f));
		this.face.z -= pEntity.getReceivedStarBits() * 0.05f;
		this.rightArm.x -= pEntity.getReceivedStarBits() * 0.05f;
		this.leftArm.x += pEntity.getReceivedStarBits() * 0.05f;
		this.rightLeg.y += pEntity.getReceivedStarBits() * 0.05f;
		this.leftLeg.y += pEntity.getReceivedStarBits() * 0.05f;
	}
}