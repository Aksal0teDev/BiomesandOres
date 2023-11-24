package org.aksalotel.biomesandores.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.aksalotel.biomesandores.BiomesAndOres;
import org.aksalotel.biomesandores.Items.ModItems;
import org.aksalotel.biomesandores.Items.ModItemsGroup;

public class ModBlocks
{
    public static final Block NEW_BLOCK = registerBlock("new_block", new Block(FabricBlockSettings.of(Material.METAL).strength(3.0f).requiresTool().luminance(6)), ModItemsGroup.BAO_GROUP);



    private static Block registerBlock(String id, Block block) {
        ModItems.registerItem(id, new BlockItem(block, new Item.Settings()));
        return Registry.register(Registries.BLOCK, new Identifier(BiomesAndOres.MOD_ID, id), block);
    }
    private static Block registerBlock(String id, Block block, ItemGroup group) {
        ModItems.registerItem(id, new BlockItem(block, new Item.Settings()), group);
        return Registry.register(Registries.BLOCK, new Identifier(BiomesAndOres.MOD_ID, id), block);
    }
    private static Block registerNoItemBlock(String id, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(BiomesAndOres.MOD_ID, id), block);
    }

    public static void register() {
        BiomesAndOres.LOGGER.info("Registering blocks for: " + BiomesAndOres.MOD_ID);
    }
}