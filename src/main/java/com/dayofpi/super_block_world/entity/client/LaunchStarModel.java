package com.dayofpi.super_block_world.entity.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.ModAnimations;
import com.dayofpi.super_block_world.entity.custom.LaunchStarEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class LaunchStarModel<T extends LaunchStarEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SuperBlockWorld.MOD_ID, "launch_star"), "main");
    private final ModelPart root;
    public LaunchStarModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        root.addOrReplaceChild("tiny", CubeListBuilder.create().texOffs(0, 22).addBox(-4.0F, -6.5F, -1.5F, 8.0F, 0.0F, 8.0F), PartPose.offset(0.0F, -2.0F, -1.0F));
        root.addOrReplaceChild("big", CubeListBuilder.create().texOffs(0, 0).addBox(-11.0F, -7.0F, -8.5F, 22.0F, 0.0F, 22.0F), PartPose.offset(0.0F, -2.0F, -1.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animate(entity.idleAnimationState, ModAnimations.LAUNCH_STAR_IDLE, ageInTicks);
        this.animate(entity.launchAnimationState, ModAnimations.LAUNCH_STAR_LAUNCH, ageInTicks);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}