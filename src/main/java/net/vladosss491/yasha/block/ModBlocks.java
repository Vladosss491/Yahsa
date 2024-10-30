package net.vladosss491.yasha.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vladosss491.yasha.YashaMod;
import net.vladosss491.yasha.item.ModItems;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(YashaMod.MOD_ID);






    public static final DeferredBlock<Block> PACKED_ICE_BRICKS = registerBlock("packed_ice_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.5F).sound(SoundType.GLASS).mapColor(MapColor.ICE).noOcclusion()));

    public static final DeferredBlock<Block> SNOW_BRICKS = registerBlock("snow_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.5F).sound(SoundType.SNOW).mapColor(MapColor.SNOW)));

    public static final DeferredBlock<Block> PLATINUM_ORE = registerBlock("platinum_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5F,6F).sound(SoundType.STONE).mapColor(MapColor.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_PLATINUM_ORE = registerBlock("deepslate_platinum_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3F, 6F).sound(SoundType.DEEPSLATE).mapColor(MapColor.DEEPSLATE).requiresCorrectToolForDrops()));




    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);

    }
}
