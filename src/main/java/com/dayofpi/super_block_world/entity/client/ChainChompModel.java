package com.dayofpi.super_block_world.entity.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.ModAnimations;
import com.dayofpi.super_block_world.entity.custom.ChainChompEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class ChainChompModel<T extends ChainChompEntity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SuperBlockWorld.MOD_ID, "chain_chomp"), "main");
	private final ModelPart root;

	public ChainChompModel(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(56, 8).addBox(-4.0F, -8.0F, 8.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = root.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(68, 36).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 10.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition top = root.addOrReplaceChild("top", CubeListBuilder.create().texOffs(4, 0).addBox(-8.0F, 0.0F, -12.0F, 16.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(-8.0F, -8.0F, -12.0F, 16.0F, 8.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 4.0F));

		PartDefinition cube_r2 = top.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(48, 48).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -12.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition bottom = root.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 40).addBox(-8.0F, 0.0F, -12.0F, 16.0F, 8.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(48, 20).addBox(-8.0F, -4.0F, -12.0F, 16.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 4.0F));

		PartDefinition cube_r3 = bottom.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(48, 48).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -12.0F, 0.2182F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 96, 64);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}

	@Override
	public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(ModAnimations.CHAIN_CHOMP_CHOMP, pLimbSwing, pLimbSwingAmount, 2.0F, 100.0F);
	}
}