package net.vladosss491.yasha.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vladosss491.yasha.YashaMod;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(YashaMod.MOD_ID);

    public static final DeferredItem<Item> STONE_HEART = ITEMS.register("stone_heart",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
