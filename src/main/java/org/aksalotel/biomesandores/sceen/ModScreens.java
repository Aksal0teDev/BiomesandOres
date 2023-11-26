package org.aksalotel.biomesandores.sceen;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.aksalotel.biomesandores.BiomesAndOres;


public class ModScreens {

    public static final ScreenHandlerType<BackpackScreenHandler> BACKPACK_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(BiomesAndOres.MOD_ID, "backpack"), new ScreenHandlerType<>(BackpackScreenHandler::new, FeatureSet.empty()));

    public static void register() {
        BiomesAndOres.LOGGER.info("Registering Screen Handlers for " + BiomesAndOres.MOD_ID);
    }
}
