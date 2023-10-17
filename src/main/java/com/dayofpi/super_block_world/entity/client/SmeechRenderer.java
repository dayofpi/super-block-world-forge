package com.dayofpi.super_block_world.entity.client;

import com.dayofpi.super_block_world.entity.custom.SmeechEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SmeechRenderer extends GeoEntityRenderer<SmeechEntity> {
    public SmeechRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SmeechModel<>());
        this.shadowRadius = 0.5F;
    }
}
