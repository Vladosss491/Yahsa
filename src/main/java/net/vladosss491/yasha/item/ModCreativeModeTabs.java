package net.vladosss491.yasha.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vladosss491.yasha.YashaMod;
import net.vladosss491.yasha.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, YashaMod.MOD_ID);

    public static final Supplier<CreativeModeTab> YASHA_MOD_TAB = CREATIVE_MODE_TAB.register("yasha_mod",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PLATINUM.get()))
                    .title(Component.translatable("creativemodtab.yasha.yasha_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.PLATINUM);
                        output.accept(ModBlocks.PLATINUM_ORE);
                        output.accept(ModBlocks.DEEPSLATE_PLATINUM_ORE);
                        output.accept(ModBlocks.SNOW_BRICKS);
                        output.accept(ModBlocks.PACKED_ICE_BRICKS);
                    })
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
