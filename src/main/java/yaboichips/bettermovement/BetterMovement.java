package yaboichips.bettermovement;

import net.fabricmc.api.ModInitializer;
import yaboichips.bettermovement.core.MoveEntities;
import yaboichips.bettermovement.core.MoveItems;

public class BetterMovement implements ModInitializer {
    public static final String MOD_ID = "bettermovement";
    @Override
    public void onInitialize() {
        MoveItems.init();
        MoveEntities.init();
    }
}

// mega wind charge
// bicycle
// slime boots