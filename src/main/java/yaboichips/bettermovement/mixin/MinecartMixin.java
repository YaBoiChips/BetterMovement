package yaboichips.bettermovement.mixin;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;


@Mixin(Minecart.class)
public abstract class MinecartMixin extends AbstractMinecart {


    protected MinecartMixin(EntityType<?> p_38087_, Level p_38088_) {
        super(p_38087_, p_38088_);
    }

    public double getMaxSpeed() {
        return 100f;
    }
}
