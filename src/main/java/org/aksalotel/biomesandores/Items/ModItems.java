package org.aksalotel.biomesandores.Items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.aksalotel.biomesandores.BiomesAndOres;
import org.aksalotel.biomesandores.Items.backpack.BackpackItem;

public class ModItems
{
  // Создание предметов
    public static final Item NEW_ITEM = registerItem("new_item", new Item(new Item.Settings()), ModItemsGroup.BAO_GROUP);
    public static final Item BACKPACK = registerItem("backpack", new BackpackItem(new Item.Settings().maxCount(1)), ModItemsGroup.BAO_GROUP);

    public static Item registerItem(String id, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BiomesAndOres.MOD_ID, id), item);
    }

    public static Item registerItem(String id, Item item, ItemGroup group) {
        Item registeredItem = registerItem(id, item);
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(registeredItem));
        return registeredItem;
    }

    public static void register() {
        BiomesAndOres.LOGGER.info("Registering items for: " + BiomesAndOres.MOD_ID);
    }
}
