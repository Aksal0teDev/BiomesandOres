package org.aksalotel.biomesandores.block.multiblock;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.aksalotel.biomesandores.api.multiblock.AbstractMultiblockBlock;
import org.jetbrains.annotations.Nullable;

public class FurnaceTile extends AbstractMultiblockBlock {

    protected FurnaceTile(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }
}
