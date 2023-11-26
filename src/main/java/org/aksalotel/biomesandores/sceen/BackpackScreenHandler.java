package org.aksalotel.biomesandores.sceen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class BackpackScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public BackpackScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(9));
    }

    public BackpackScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory)
    {
        super(ModScreens.BACKPACK_SCREEN_HANDLER, syncId);
        checkSize(inventory, 9);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

        this.addSlot(new Slot(inventory, 0, 8, 16));
        this.addSlot(new Slot(inventory, 1, 24, 16));
        this.addSlot(new Slot(inventory, 2, 48, 16));
        this.addSlot(new Slot(inventory, 3, 8, 34));
        this.addSlot(new Slot(inventory, 4, 24, 34));
        this.addSlot(new Slot(inventory, 5, 28, 34));
        this.addSlot(new Slot(inventory, 6, 8, 52));
        this.addSlot(new Slot(inventory, 7, 24, 52));
        this.addSlot(new Slot(inventory, 8, 48, 52));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    private void addPlayerInventory(PlayerInventory playerInventory)
    {
        for(int i = 0; i < 3; ++i)
        {
            for(int l = 0; l < 9; ++l)
            {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory)
    {
        for(int i = 0; i < 9; ++i)
        {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return false;
    }
}
