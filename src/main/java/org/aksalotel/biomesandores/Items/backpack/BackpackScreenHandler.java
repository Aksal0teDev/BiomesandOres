package org.aksalotel.biomesandores.Items.backpack;

import com.google.common.collect.Sets;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import org.aksalotel.biomesandores.sceen.ModScreens;

import java.util.Set;

public class BackpackScreenHandler extends GenericContainerScreenHandler {
  private final ScreenHandlerType<?> type;
  public static final Set<Item> SHULKER_BOXES;

  public final Inventory inventory;
  public final PlayerInventory playerInventory;
  public final int inventoryWidth = 9;
  public final int inventoryHeight = 6;

  static {
    SHULKER_BOXES =
        Sets.newHashSet(
            Items.SHULKER_BOX,
            Items.BLACK_SHULKER_BOX,
            Items.BLUE_SHULKER_BOX,
            Items.BROWN_SHULKER_BOX,
            Items.CYAN_SHULKER_BOX,
            Items.GRAY_SHULKER_BOX,
            Items.GREEN_SHULKER_BOX,
            Items.LIGHT_BLUE_SHULKER_BOX,
            Items.LIGHT_GRAY_SHULKER_BOX,
            Items.LIME_SHULKER_BOX,
            Items.MAGENTA_SHULKER_BOX,
            Items.ORANGE_SHULKER_BOX,
            Items.PINK_SHULKER_BOX,
            Items.RED_SHULKER_BOX,
            Items.WHITE_SHULKER_BOX,
            Items.YELLOW_SHULKER_BOX,
            Items.PURPLE_SHULKER_BOX);
  }

  public BackpackScreenHandler(int syncId, PlayerInventory playerInventory) {
    this(syncId, playerInventory, new SimpleInventory(54));
  }

  public BackpackScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
    this(ModScreens.BACKPACK_SCREEN_HANDLER, syncId, playerInventory, inventory);
  }

  public BackpackScreenHandler(
      ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, Inventory inventory) {
    super(ScreenHandlerType.GENERIC_9X6, syncId, playerInventory, inventory, 6);
    this.type = type;
    this.inventory = inventory;
    this.playerInventory = playerInventory;

    checkSize(inventory, 54);
    inventory.onOpen(playerInventory.player);
    setupSlots(false);
  }

  public void setupSlots(final boolean includeChestInventory) {
    int i = (this.inventoryHeight - 4) * 18;
    int n;
    int m;

    for (n = 0; n < this.inventoryHeight; ++n) {
      for (m = 0; m < 9; ++m) {
        this.addSlot(new BackpackSlot(inventory, m + n * 9, 8 + m * 18, 18 + n * 18));
      }
    }

    for (n = 0; n < 3; ++n) {
      for (m = 0; m < 9; ++m) {
        this.addSlot(
            new BackpackSlot(playerInventory, m + n * 9 + 9, 8 + m * 18, 103 + n * 18 + i));
      }
    }

    for (n = 0; n < 9; ++n) {
      this.addSlot(new BackpackSlot(playerInventory, n, 8 + n * 18, 161 + i));
    }
  }

  public static class BackpackSlot extends Slot {
    public BackpackSlot(Inventory inventory, int index, int x, int y) {
      super(inventory, index, x, y);
    }

    @Override
    public boolean canTakeItems(PlayerEntity playerEntity) {
      return canMoveStack(getStack());
    }

    @Override
    public boolean canInsert(ItemStack stack) {
      return canMoveStack(stack);
    }

    // Prevents items that override canBeNested() from being inserted into backpack
    public boolean canMoveStack(ItemStack stack) {
      return stack.getItem().canBeNested();
    }
  }

  @Override
  public ScreenHandlerType<?> getType() {
    return type;
  }

  @Override
  public void onSlotClick(
          int slotId, int clickData, SlotActionType actionType, PlayerEntity playerEntity) {
    // Prevents single or shift-click while pack is open
    if (slotId >= 0) // slotId < 0 are used for networking internals
    {
      ItemStack stack = getSlot(slotId).getStack();

      if (stack.getItem() instanceof BackpackItem
          || SHULKER_BOXES.contains(stack.getItem())) {
        // Return to caller with no action
        return;
      }
    }

    super.onSlotClick(slotId, clickData, actionType, playerEntity);
  }

  @Override
  public boolean canUse(final PlayerEntity player) {
    return this.inventory.canPlayerUse(player);
  }

  // Disable shift-click movement for now
  @Override
  public ItemStack quickMove(PlayerEntity player, int index) {
    return ItemStack.EMPTY;
  }
}