package yaboichips.bettermovement.core;


import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import yaboichips.bettermovement.common.BigWindChargeItem;
import yaboichips.bettermovement.common.PigWings;

import static yaboichips.bettermovement.BetterMovement.MOD_ID;

public class MoveItems {


    public static final Item PIG_WINGS = registerItem("pig_wings", new PigWings(new Item.Properties()));
    public static final Item BIG_WINDCHARGE = registerItem("big_wind_charge", new BigWindChargeItem(new Item.Properties()));
    public static Item registerItem(String id, Item item){
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, id), item);
    }

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(content -> {
            content.accept(PIG_WINGS);
            content.accept(BIG_WINDCHARGE);
        });
    }
}
