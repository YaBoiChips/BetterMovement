package yaboichips.bettermovement.core;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.flag.FeatureFlags;
import yaboichips.bettermovement.common.BigWindChargeEntity;

import static yaboichips.bettermovement.BetterMovement.MOD_ID;

public class MoveEntities {

    public static final EntityType<BigWindChargeEntity> WIND_CHARGE = register("big_wind_charge", EntityType.Builder.<BigWindChargeEntity>of(BigWindChargeEntity::new, MobCategory.MISC).sized(0.3125F, 0.3125F).eyeHeight(0.0F).clientTrackingRange(4).updateInterval(10).requiredFeatures(FeatureFlags.UPDATE_1_21).build("big_wind_charge"));


    public static <T extends Entity> EntityType<T> register(String id, EntityType<T> entityType) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, new ResourceLocation(MOD_ID, id), entityType);
    }

    public static void init() {
    }
}
