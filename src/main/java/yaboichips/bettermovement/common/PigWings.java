package yaboichips.bettermovement.common;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import yaboichips.bettermovement.client.IPigMixin;

public class PigWings extends Item {
    public PigWings(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity entity, InteractionHand interactionHand) {
        System.out.println("works");
        if (entity instanceof Pig pig){
            ((IPigMixin)pig).setWinged(true);
            itemStack.consume(1, player);
            player.playSound(SoundEvents.ENDER_DRAGON_FLAP);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.FAIL;
    }
}
