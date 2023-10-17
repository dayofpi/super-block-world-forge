package com.dayofpi.super_block_world.entity.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.custom.SmeechEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SmeechModel<T extends SmeechEntity> extends GeoModel<T> {
	private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(SuperBlockWorld.MOD_ID,"textures/entity/smeech/smeech.png");
	private static final ResourceLocation INFATUATED_TEXTURE_LOCATION = new ResourceLocation(SuperBlockWorld.MOD_ID,"textures/entity/smeech/smeech_infatuated.png");
	private static final ResourceLocation LATCHED_TEXTURE_LOCATION = new ResourceLocation(SuperBlockWorld.MOD_ID,"textures/entity/smeech/smeech_latched.png");


	@Override
	public ResourceLocation getModelResource(T animatable) {
		return new ResourceLocation(SuperBlockWorld.MOD_ID, "geo/smeech.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(T animatable) {
		return TEXTURE_LOCATION;
	}

	@Override
	public ResourceLocation getAnimationResource(T animatable) {
		return new ResourceLocation(SuperBlockWorld.MOD_ID, "animations/smeech.animation.json");
	}
}