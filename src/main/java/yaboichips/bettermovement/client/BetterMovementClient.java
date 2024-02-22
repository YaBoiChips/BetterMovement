package yaboichips.bettermovement.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.entity.WindChargeRenderer;
import yaboichips.bettermovement.core.MoveEntities;

public class BetterMovementClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(WingModel.LAYER_LOCATION, WingModel::createBodyLayer);
        EntityRendererRegistry.register(MoveEntities.WIND_CHARGE, WindChargeRenderer::new);
    }
}
