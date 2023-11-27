package org.aksalotel.biomesandores.api.multiblock;

import net.minecraft.block.BlockWithEntity;

public abstract class AbstractMultiblockBlock extends BlockWithEntity {

    protected AbstractMultiblockBlock(Settings settings) {
        super(settings);
    }

    public void getBlockClass() {
    }
}
