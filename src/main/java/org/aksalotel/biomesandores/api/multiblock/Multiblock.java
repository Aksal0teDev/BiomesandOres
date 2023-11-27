package org.aksalotel.biomesandores.api.multiblock;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

import java.util.HashSet;
import java.util.Set;

public abstract class Multiblock extends AbstractMultiblockTile {
    protected HashSet<AbstractMultiblockBlock> structureBlocks;
    protected MultiblockState multiblockState = MultiblockState.WAIT_STRUCTURE;
    protected BlockPos startPosition = null;
    protected BlockPos endPosition = null;

    protected Multiblock(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public Set<AbstractMultiblockBlock> getStructureBlocks() {
        return structureBlocks;
    }

    protected void onBreakPart(AbstractMultiblockBlock brokenTile)
    {
        structureBlocks.remove(brokenTile);
    }

    protected void onPlacePart(AbstractMultiblockBlock placedTile)
    {
        structureBlocks.add(placedTile);
    }
}