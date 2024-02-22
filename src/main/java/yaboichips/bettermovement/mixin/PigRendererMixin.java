package yaboichips.bettermovement.mixin;

import net.minecraft.client.model.PigModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.PigRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Pig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yaboichips.bettermovement.client.WingLayer;

@Mixin(PigRenderer.class)
public class PigRendererMixin extends MobRenderer<Pig, PigModel<Pig>> {

    public PigRendererMixin(EntityRendererProvider.Context context, PigModel<Pig> entityModel, float f) {
        super(context, entityModel, f);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void injectRenderer(EntityRendererProvider.Context context, CallbackInfo ci){
        this.addLayer(new WingLayer<>(((PigRenderer)(Object)this), context.getModelSet()));
    }

    @Shadow
    public ResourceLocation getTextureLocation(Pig entity) {
        throw new IllegalStateException("mixin sucks");
    }
}
