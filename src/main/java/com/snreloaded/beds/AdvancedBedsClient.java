package com.snreloaded.beds;

import com.snreloaded.beds.nocturnal.NocturnalBedRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import org.apache.logging.log4j.Level;

public class AdvancedBedsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        log(Level.INFO, "Initializing Client");
        BlockEntityRendererRegistry.INSTANCE.register(AdvancedBeds.NOCTURNAL_BED_ENTITY, NocturnalBedRenderer::new);
        log(Level.INFO, "Done Initializing Client");
    }

    public static void log(Level level, String message){
        AdvancedBeds.LOGGER.log(level, "["+AdvancedBeds.MOD_NAME+"] " + message);
    }
}