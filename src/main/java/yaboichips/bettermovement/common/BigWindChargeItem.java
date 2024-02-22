package yaboichips.bettermovement.common;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class BigWindChargeItem extends Item {
    public BigWindChargeItem(Properties properties) {
        super(properties);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        if (!level.isClientSide()) {
            Vec3 vec3 = (new Vec3(player.position().x(), player.getEyeY(), player.position().z())).add(player.getForward().scale(0.800000011920929));
            if (!level.getBlockState(BlockPos.containing(vec3)).canBeReplaced()) {
                vec3 = (new Vec3(player.position().x(), player.getEyeY(), player.position().z())).add(player.getForward().scale(0.05000000074505806));
            }

            BigWindChargeEntity windCharge = new BigWindChargeEntity(player, level, vec3.x(), vec3.y(), vec3.z());
            windCharge.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(windCharge);
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.WIND_CHARGE_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        ItemStack itemStack = player.getItemInHand(interactionHand);
        player.getCooldowns().addCooldown(this, 10);
        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.isCreative()) {
            itemStack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }
}
