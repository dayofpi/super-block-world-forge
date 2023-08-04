package com.dayofpi.super_block_world.block.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.block_entities.FlagBlockEntity;
import com.dayofpi.super_block_world.block.custom.FlagBlock;
import com.dayofpi.super_block_world.util.ModTags;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;

import java.util.Arrays;
import java.util.Comparator;

public class FlagRenderer implements BlockEntityRenderer<FlagBlockEntity> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SuperBlockWorld.MOD_ID, "flag"), "main");
    public static final Material POLE_TEXTURE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation(SuperBlockWorld.MOD_ID, "entity/flag/flag"));
    public static final Material[] COLOR_TEXTURES = Arrays.stream(DyeColor.values()).sorted(Comparator.comparingInt(DyeColor::getId)).map(dyeColor -> new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation(SuperBlockWorld.MOD_ID, "entity/flag/" + dyeColor.getName()))).toArray(Material[]::new);
    public static final Material RAINBOW_FLAG = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation(SuperBlockWorld.MOD_ID, "entity/flag/rainbow"));
    public static final Material TRANS_FLAG = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation(SuperBlockWorld.MOD_ID, "entity/flag/trans"));
    public static final Material BI_FLAG = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation(SuperBlockWorld.MOD_ID, "entity/flag/bi"));
    public static final Material LESBIAN_FLAG = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation(SuperBlockWorld.MOD_ID, "entity/flag/lesbian"));

    public static final String ROOT = "root";
    public static final String FLAG = "flag";
    public static final String POLE = "pole";
    private final ModelPart flag;
    private final ModelPart pole;

    public FlagRenderer(BlockEntityRendererProvider.Context context) {
        ModelPart modelPart = context.bakeLayer(LAYER_LOCATION);
        ModelPart root = modelPart.getChild(ROOT);
        this.flag = root.getChild(FLAG);
        this.pole = root.getChild(POLE);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition root = partDefinition.addOrReplaceChild(ROOT, CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
        root.addOrReplaceChild(FLAG, CubeListBuilder.create().texOffs(8, 8).addBox(-12.0F, -6.0F, 0.0F, 12.0F, 12.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
        root.addOrReplaceChild(POLE, CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -16.0F, 6.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(8.0F, 0.0F, -8.0F));
        return LayerDefinition.create(meshDefinition, 32, 32);
    }

    private Material getSpecialFlag(FlagBlockEntity entity) {
        Component text = entity.getCustomName();
        if (text != null) {
            for (String name : FlagBlock.TRANS) {
                if (text.getString().contains(name))
                    return TRANS_FLAG;
            }
            for (String name : FlagBlock.BI) {
                if (text.getString().contains(name))
                    return BI_FLAG;
            }
            for (String name : FlagBlock.LESBIAN) {
                if (text.getString().contains(name))
                    return LESBIAN_FLAG;
            }
        }
        return RAINBOW_FLAG;
    }

    @Override
    public void render(FlagBlockEntity entity, float tickDelta, PoseStack poseStack, MultiBufferSource multiBufferSource, int light, int overlay) {
        Level level = entity.getLevel();
        BlockPos blockPos = entity.getBlockPos();
        if (level != null) {
            poseStack.pushPose();
            poseStack.scale(1.0F, -1.0F, -1.0F);
            poseStack.translate(0.5, 0.0, -0.5);
            poseStack.pushPose();
            VertexConsumer consumer = POLE_TEXTURE.buffer(multiBufferSource, RenderType::entitySolid);
            this.pole.render(poseStack, consumer, light, overlay);
            poseStack.popPose();
            renderFlag(poseStack, level, blockPos, entity, multiBufferSource, light, overlay);
            poseStack.popPose();
        }
    }

    private void renderFlag(PoseStack poseStack, Level world, BlockPos blockPos, FlagBlockEntity entity, MultiBufferSource provider, int light, int overlay) {
        poseStack.pushPose();
        Material id = COLOR_TEXTURES[entity.getColor().getId()];
        if (entity.isRainbow()) id = this.getSpecialFlag(entity);

        int rotation = 0;
        if (world.getBlockState(blockPos).is(ModTags.Blocks.FLAGS))
            rotation = world.getBlockState(blockPos).getValue(FlagBlock.ROTATION);
        float angle = (rotation * 22.5F) % 360;
        float wave = Mth.cos(world.getGameTime()) + angle;

        poseStack.mulPose(Axis.YP.rotationDegrees(wave));
        this.flag.render(poseStack, id.buffer(provider, RenderType::entityCutout), light, overlay);
        poseStack.popPose();
    }
}
