package org.aksalotel.biomesandores.block.multiblock;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import org.aksalotel.biomesandores.api.multiblock.Multiblock;

public class FurnaceControllerEntity extends Multiblock {

    public FurnaceControllerEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.startPosition = pos.add(-1, -1, -1);
        this.endPosition = pos.add(1, 1, 1);
    }
}
