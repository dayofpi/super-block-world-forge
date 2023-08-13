package com.dayofpi.super_block_world.entity.client;// Made with Blockbench 4.8.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.ModAnimations;
import com.dayofpi.super_block_world.entity.custom.UnagiEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class UnagiModel<T extends UnagiEntity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SuperBlockWorld.MOD_ID, "unagi"), "main");
	private final ModelPart head;

	public UnagiModel(ModelPart root) {
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -8.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(27, 2).addBox(-2.0F, 0.0F, -8.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 0.0F));

		PartDefinition neck = head.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, -3.5F, 0.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(22, 22).addBox(0.0F, -5.5F, 0.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = neck.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 38).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(22, 22).addBox(0.0F, -3.5F, 0.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 8.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 38).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(22, 23).addBox(0.0F, -2.5F, 0.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));

		PartDefinition tailend = tail.addOrReplaceChild("tailend", CubeListBuilder.create().texOffs(0, 54).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(40, 23).addBox(0.0F, -2.0F, 0.0F, 0.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 13).addBox(-2.0F, 0.0F, -8.0F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(25, 9).addBox(-2.0F, -1.0F, -8.0F, 4.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animate(entity.swimAnimationState, ModAnimations.MAW_RAY_SWIM, ageInTicks);
		this.animate(entity.attackAnimationState, ModAnimations.MAW_RAY_ATTACK, ageInTicks);
		this.animate(entity.sufferAnimationState, ModAnimations.MAW_RAY_SUFFER, ageInTicks);
	}

	@Override
	public ModelPart root() {
		return this.head;
	}
}