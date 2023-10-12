package com.dayofpi.super_block_world.entity.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.ModAnimations;
import com.dayofpi.super_block_world.entity.custom.OctoombaEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class OctoombaModel<T extends OctoombaEntity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SuperBlockWorld.MOD_ID, "octoomba"), "main");
	private final ModelPart root;

	public OctoombaModel(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition mouth = head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(20, 30).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -6.0F));

		PartDefinition topthing = head.addOrReplaceChild("topthing", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition cube_r1 = topthing.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(40, -1).addBox(0.0F, -6.0F, -5.0F, 0.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition frontrightfoot = root.addOrReplaceChild("frontrightfoot", CubeListBuilder.create().texOffs(30, 0).addBox(-2.5F, -1.0F, -4.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -3.0F, -2.0F));

		PartDefinition frontleftfoot = root.addOrReplaceChild("frontleftfoot", CubeListBuilder.create().texOffs(0, 30).addBox(-2.5F, -1.0F, -4.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -3.0F, -2.0F));

		PartDefinition backrightfoot = root.addOrReplaceChild("backrightfoot", CubeListBuilder.create().texOffs(0, 21).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -3.0F, 2.0F));

		PartDefinition backleftfoot = root.addOrReplaceChild("backleftfoot", CubeListBuilder.create().texOffs(20, 21).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -3.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}

	@Override
	public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(ModAnimations.OCTOOMBA_WALK, pLimbSwing, pLimbSwingAmount, 2.0F, 100.0F);
		this.animate(pEntity.idleAnimationState, ModAnimations.OCTOOMBA_IDLE, pAgeInTicks);
		this.animate(pEntity.attackAnimationState, ModAnimations.OCTOOMBA_ATTACK, pAgeInTicks);
	}
}