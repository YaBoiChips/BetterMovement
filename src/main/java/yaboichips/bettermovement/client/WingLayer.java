package yaboichips.bettermovement.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.PigModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Pig;

import static yaboichips.bettermovement.BetterMovement.MOD_ID;

public class WingLayer<T extends Pig> extends RenderLayer<T, PigModel<T>> {

    private final WingModel model;

    public WingLayer(RenderLayerParent<T, PigModel<T>> renderLayerParent, EntityModelSet set) {
        super(renderLayerParent);
        this.model = new WingModel(set.bakeLayer(WingModel.LAYER_LOCATION));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T entity, float f, float g, float h, float j, float k, float l) {
        if(((IPigMixin) entity).isWinged()) {
            this.model.renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(new ResourceLocation(MOD_ID, "textures/entity/big_wind_charge.png"))), i, 3, 0.24f, 0.9f, 0.9f, 1);
        }
    }
}
