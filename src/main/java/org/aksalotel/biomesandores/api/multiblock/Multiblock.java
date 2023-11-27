package org.aksalotel.biomesandores.api.multiblock;

public interface Multiblock {
    boolean isMaster();

    Multiblock getMaster();
}