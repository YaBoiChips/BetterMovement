package yaboichips.bettermovement.mixin;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.FireworkRocketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FireworkRocketItem.class)
public abstract class FireworkItemMixin {


    @Shadow public abstract InteractionResultHolder<ItemStack> use(Level p_41218_, Player p_41219_, InteractionHand p_41220_);

    @Inject(method = "use", at = @At(value = "HEAD"))
    private void use(Level p_41218_, Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir){
        if(player.getVehicle() instanceof AbstractMinecart mc){
            ItemStack itemStack = player.getItemInHand(hand);
            mc.setDeltaMovement(mc.getDeltaMovement().relative(mc.getMotionDirection(), 1));
            itemStack.consume(1, player);
            player.playSound(SoundEvents.FIREWORK_ROCKET_LAUNCH);
        }
    }
}
