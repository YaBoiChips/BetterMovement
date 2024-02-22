package yaboichips.bettermovement.mixin;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.ParticleUtils;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yaboichips.bettermovement.client.IPigMixin;

import java.util.Random;

@Mixin(Pig.class)
public class PigMixin extends Animal implements IPigMixin {

    private static final EntityDataAccessor<Boolean> WINGED = SynchedEntityData.defineId(Pig.class, EntityDataSerializers.BOOLEAN);

    protected PigMixin(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Shadow
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        throw new IllegalStateException("mixin didnt work XD");
    }

    @Inject(method = "tickRidden", at = @At("TAIL"))
    public void flyYouFool(Player player, Vec3 vec3, CallbackInfo ci){
        if (this.isWinged()) {
            this.fallDistance = 0;
            float f = player.getYRot();
            float g = player.getXRot();
            float h = -Mth.sin(f * 0.017453292F) * Mth.cos(g * 0.017453292F);
            float l = -Mth.sin(g * 0.017453292F);
            float m = Mth.cos(f * 0.017453292F) * Mth.cos(g * 0.017453292F);
            float n = Mth.sqrt(h * h + l * l + m * m);
            float o = 3.0F * ((1.0F + 1) / 4.0F);
            h *= o / n;
            l *= o / n;
            m *= o / n;
            this.setDeltaMovement(h, l, m);
            this.setRot(f, g);
            Random rand = new Random();
            if(rand.nextBoolean()) {
                player.playSound(SoundEvents.BUBBLE_COLUMN_BUBBLE_POP, 2, 1);
            }
        }
    }

    @Inject(method = "defineSynchedData", at = @At("TAIL"))
    public void injectData(SynchedEntityData.Builder builder, CallbackInfo ci){
        builder.define(WINGED, false);
    }

    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    public void addInject(CompoundTag compoundTag, CallbackInfo ci){
        compoundTag.putBoolean("winged", this.isWinged());
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    public void readInject(CompoundTag compoundTag, CallbackInfo ci){
        this.setWinged(compoundTag.getBoolean("winged"));
    }


    public void setWinged(boolean bool){
        this.entityData.set(WINGED, bool);
    }
    public boolean isWinged(){
        return this.entityData.get(WINGED);
    }
}
