package org.yakodan.yakodanmod.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup YAKODAN_GROUP = new ItemGroup("yakodanModTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.DRAGON_CLAW.get());
        }
    };
}
