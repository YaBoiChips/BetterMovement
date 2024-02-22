package yaboichips.bettermovement.client;// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

import static yaboichips.bettermovement.BetterMovement.MOD_ID;


public class WingModel extends Model {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MOD_ID, "wings"), "main");
	private final ModelPart WingLeft;
	private final ModelPart WingRight;

	public WingModel(ModelPart root) {
        super(RenderType::entityCutoutNoCull);
        this.WingLeft = root.getChild("WingLeft");
		this.WingRight = root.getChild("WingRight");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition WingLeft = partdefinition.addOrReplaceChild("WingLeft", CubeListBuilder.create().texOffs(0, 58).addBox(5.0F, -14.0F, -4.0F, 11.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, -6.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WingRight = partdefinition.addOrReplaceChild("WingRight", CubeListBuilder.create().texOffs(34, 58).addBox(-16.0F, -14.0F, -4.0F, 11.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, -6.0F, 0.0F, 0.6109F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		WingLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		WingRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}