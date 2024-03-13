package org.yakodan.yakodanmod.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import org.yakodan.yakodanmod.item.ModItemGroup;

public class DragonSword extends SwordItem {

    public static final Properties properties = new Item.Properties()
            .group(ModItemGroup.YAKODAN_GROUP)
            .isImmuneToFire();

    public DragonSword() {
        super(ItemTier.IRON, 6, 1.1f, properties);
    }

}
