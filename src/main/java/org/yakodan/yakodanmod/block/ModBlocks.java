package org.yakodan.yakodanmod.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.yakodan.yakodanmod.YakodanMod;
import org.yakodan.yakodanmod.block.custom.DragonStoneBlock;
import org.yakodan.yakodanmod.item.ModItemGroup;
import org.yakodan.yakodanmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, YakodanMod.MOD_ID);


    public static final RegistryObject<Block> DRAGON_PAW = registerBlock("dragon_paw",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1).harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(5f)
                    .setRequiresTool()
                    .sound(SoundType.BONE)));

    public static final RegistryObject<Block> DRAGON_STONE_BLOCK = registerBlock("dragon_stone_block",
            () -> new DragonStoneBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1).harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(5f)
                    .setRequiresTool()
                    .sound(SoundType.BONE)));


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.YAKODAN_GROUP)));
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
