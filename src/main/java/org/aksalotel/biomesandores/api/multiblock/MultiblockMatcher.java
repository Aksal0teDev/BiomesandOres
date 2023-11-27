package org.aksalotel.biomesandores.api.multiblock;

import java.util.Set;

public class MultiblockMatcher {
    Set<AbstractMultiblockBlock> matchStructure;

    public MultiblockMatcher(Set<AbstractMultiblockBlock> matchStructure) {
        this.matchStructure = matchStructure;
    }

    public boolean isMatch(Set<AbstractMultiblockBlock> checkIsMatch) {
        return matchStructure.contains(checkIsMatch);
    }
}
