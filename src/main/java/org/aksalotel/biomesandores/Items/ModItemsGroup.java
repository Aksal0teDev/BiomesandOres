package org.aksalotel.biomesandores.Items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.aksalotel.biomesandores.BiomesAndOres;

public class ModItemsGroup
{
    public static final ItemGroup BAO_GROUP = FabricItemGroup.builder(new Identifier(BiomesAndOres.MOD_ID,"")).icon(() ->  new ItemStack(ModItems.NEW_ITEM)).build();
}
