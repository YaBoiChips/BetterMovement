package yaboichips.bettermovement.common;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.windcharge.AbstractWindCharge;
import net.minecraft.world.entity.projectile.windcharge.WindCharge;
import net.minecraft.world.level.Level;
import yaboichips.bettermovement.core.MoveEntities;

public class BigWindChargeEntity extends AbstractWindCharge {

    private static final BigWindChargeEntity.WindChargePlayerDamageCalculator EXPLOSION_DAMAGE_CALCULATOR = new BigWindChargeEntity.WindChargePlayerDamageCalculator();

    public BigWindChargeEntity(EntityType<? extends AbstractWindCharge> entityType, Level level) {
        super(entityType, level);
    }

    public BigWindChargeEntity(Player player, Level level, double d, double e, double f) {
        super(MoveEntities.WIND_CHARGE, level, player, d, e, f);
    }


    @Override
    protected void explode() {
        this.level().explode(this, null, EXPLOSION_DAMAGE_CALCULATOR, this.getX(), this.getY(), this.getZ(), 1.0F + 0.3F * this.random.nextFloat(), false, Level.ExplosionInteraction.BLOW, ParticleTypes.GUST_EMITTER_SMALL, ParticleTypes.GUST_EMITTER_LARGE, SoundEvents.WIND_CHARGE_BURST);
    }

    public static final class WindChargePlayerDamageCalculator extends AbstractWindCharge.WindChargeDamageCalculator {
        public WindChargePlayerDamageCalculator() {
        }

        public float getKnockbackMultiplier() {
            return 5.1F;
        }
    }
}
