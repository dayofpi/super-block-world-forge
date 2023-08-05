package com.dayofpi.super_block_world.entity.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.ModAnimations;
import com.dayofpi.super_block_world.entity.custom.BoomBoomEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class BoomBoomModel<T extends BoomBoomEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SuperBlockWorld.MOD_ID, "boom_boom"), "main");
    private final ModelPart root;
    private final ModelPart leftLeg;
    private final ModelPart rightLeg;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart rightArm;
    private final ModelPart leftArm;
    private final ModelPart rightWing;
    private final ModelPart leftWing;

    public BoomBoomModel(ModelPart root) {
        this.root = root.getChild("root");
        this.leftLeg = this.root.getChild("left_leg");
        this.rightLeg = this.root.getChild("right_leg");
        this.body = this.root.getChild("body");
        this.head = this.body.getChild("head");
        this.leftArm = this.body.getChild("left_arm");
        this.rightArm = this.body.getChild("right_arm");
        this.leftWing = this.body.getChild("left_wing");
        this.rightWing = this.body.getChild("right_wing");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(36, 0).addBox(-2.5F, -1.0F, -2.5F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, -5.0F, -1.5F));

        PartDefinition left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-2.5F, -1.0F, -2.5F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.5F, -5.0F, -1.5F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(20, 44).mirror().addBox(-1.0F, -2.0F, -3.0F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, -9.0F, -4.0F));

        PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 44).addBox(-4.0F, -1.0F, -3.0F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -10.0F, -4.0F));

        PartDefinition right_wing = body.addOrReplaceChild("right_wing", CubeListBuilder.create(), PartPose.offset(-6.0F, -9.0F, -4.0F));

        PartDefinition cube_r1 = right_wing.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(42, 47).addBox(-11.0F, -17.0F, 0.0F, 11.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, 0.1745F, -0.2618F));

        PartDefinition left_wing = body.addOrReplaceChild("left_wing", CubeListBuilder.create(), PartPose.offset(6.0F, -9.0F, -4.0F));

        PartDefinition cube_r2 = left_wing.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(42, 47).addBox(-11.0F, -17.0F, 0.0F, 11.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, -0.1745F, 2.9671F, 0.2618F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 24).addBox(-5.0F, -8.25F, -7.25F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(30, 24).addBox(-5.0F, -3.25F, -8.25F, 10.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.75F, -4.75F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animate(pEntity.idleAnimationState, ModAnimations.BOOM_BOOM_IDLE, pAgeInTicks);
        this.animate(pEntity.spinAnimationState, ModAnimations.BOOM_BOOM_SPIN, pAgeInTicks);

        this.rightArm.visible = !pEntity.isFlyingState();
        this.leftArm.visible = !pEntity.isFlyingState();
        this.rightWing.visible = pEntity.isFlyingState();
        this.leftWing.visible = pEntity.isFlyingState();

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
        this.body.yRot = pNetHeadYaw * ((float)Math.PI / 180F) * 0.5F;

        if (pEntity.isFlyingState() && !pEntity.onGround()) {
            float flapProgress = pAgeInTicks * 0.2F;
            this.rightWing.yRot = Mth.cos(flapProgress) * 0.8F;
            this.leftWing.yRot = Mth.cos(flapProgress) * -0.8F;
            this.rightLeg.xRot = -1.3F;
            this.leftLeg.xRot = -1.3F;
        } else {
            this.rightLeg.xRot = Mth.cos(pLimbSwing * 0.6662F) * 1.4F * pLimbSwingAmount;
            this.leftLeg.xRot = Mth.cos(pLimbSwing * 0.6662F + 3.1415927F) * 1.4F * pLimbSwingAmount;
        }

        if (pEntity.isDizzyState()) {
            float dizzyProgress = pAgeInTicks * 0.1F;
            this.head.zRot = Mth.cos(dizzyProgress) * 0.1F;
        }
        if (!pEntity.isSpinningState() && !pEntity.isDizzyState()) {
            if (pEntity.isAggressive() & pEntity.walkAnimation.isMoving()) {
                this.rightArm.zRot = 0.8F + Mth.cos(pLimbSwing * 0.6662F) * 1.4F * pLimbSwingAmount;
                this.leftArm.zRot = -0.8F + Mth.cos(pLimbSwing * 0.6662F) * 1.4F * pLimbSwingAmount;
            }

            this.rightArm.xRot = Mth.cos(pLimbSwing * 0.6662F + 3.1415927F) * 1.4F * pLimbSwingAmount;
            this.leftArm.xRot = Mth.cos(pLimbSwing * 0.6662F) * 1.4F * pLimbSwingAmount;
        }
    }
}
