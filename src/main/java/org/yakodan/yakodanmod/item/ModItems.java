package org.yakodan.yakodanmod.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.yakodan.yakodanmod.YakodanMod;
import org.yakodan.yakodanmod.item.custom.DragonStone;
import org.yakodan.yakodanmod.item.custom.DragonSword;


public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, YakodanMod.MOD_ID);


    public static final RegistryObject<Item> DRAGON_CLAW = ITEMS.register("dragon_claw",
            () -> new Item(new Item.Properties()
                    .group(ModItemGroup.YAKODAN_GROUP)));

    public static final RegistryObject<Item> DRAGON_SWORD = ITEMS.register("dragon_sword",
            () -> new DragonSword());

    public static final RegistryObject<Item> DRAGON_STONE = ITEMS.register("dragon_stone",
            () -> new DragonStone(new Item.Properties()
                    .group(ModItemGroup.YAKODAN_GROUP)
                    .maxDamage(8)));


    // Just a shortcut for the main mod file
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
