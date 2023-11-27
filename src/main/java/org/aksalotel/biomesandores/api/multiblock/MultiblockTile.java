package org.aksalotel.biomesandores.api.multiblock;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class MultiblockTile extends BlockEntity implements Multiblock {

    public MultiblockTile(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public boolean isMaster() {
        return false;
    }

    @Override
    public Multiblock getMaster() {
        return null;
    }
}
