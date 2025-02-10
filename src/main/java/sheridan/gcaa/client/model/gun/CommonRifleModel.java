package sheridan.gcaa.client.model.gun;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import sheridan.gcaa.client.animation.frameAnimation.AnimationDefinition;
import sheridan.gcaa.client.model.modelPart.ModelPart;
import sheridan.gcaa.client.render.GunRenderContext;

@OnlyIn(Dist.CLIENT)
public class CommonRifleModel extends NewAutoMagPositionModel{
    protected AnimationDefinition shoot;
    protected ModelPart bullet;

    public CommonRifleModel(ResourceLocation modelPath, ResourceLocation animationPath, ResourceLocation texture,
                            @Nullable ResourceLocation lowQualityModelPath, @Nullable ResourceLocation lowQualityTexture) {
        super(modelPath, animationPath, texture, lowQualityModelPath, lowQualityTexture);
    }

    public CommonRifleModel(ResourceLocation modelPath, ResourceLocation animationPath, ResourceLocation texture) {
        super(modelPath, animationPath, texture);
    }

    @Override
    protected void postInit(ModelPart main, ModelPart gun, ModelPart root) {
        super.postInit(main, gun, root);
        shoot = animations.get("shoot");
        bullet = mag.getChild("bullet");
    }

    @Override
    protected void renderGunModel(GunRenderContext context) {
        VertexConsumer solid = context.solid(texture);
        bullet.visible = context.shouldBulletRender();
        mag.visible = context.notHasMag();
        context.render(solid, main);
        if (context.isFirstPerson) {
            context.renderArm(right_arm, true);
            context.renderArm(left_arm, false);
        }
    }

    @Override
    protected void animationGlobal(GunRenderContext context) {
        defaultAssaultRifleAnimation(context, shoot);
    }

    @Override
    protected void renderGunModelLowQuality(GunRenderContext context) {
        VertexConsumer solid = context.solid(lowQualityTexture);
        context.render(solid, lowQualityMain);
    }
}
