package com.snreloaded.beds;

import java.util.Arrays;
import java.util.function.Consumer;

import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LogEventListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
@Mixin(TexturedRenderLayers.class)
public class TexturedRenderLayersMixin {

    public static Logger LOGGER = LogManager.getLogger();

    public static final Identifier BED_ATLAS_TEXTURE = AdvancedBeds.id("textures/atlas/beds.png");

    @Inject(at = @At("HEAD"), method = "addDefaultTextures(Ljava/util/function/Consumer;)V")
    private static void onAddDefaultTextures(Consumer<SpriteIdentifier> consumer, CallbackInfo ci) {
        log(Level.INFO, "Starting mixin injection");
        makeAtlases(consumer);
        log(Level.INFO, "Ending mixin injection");
    }

    public static void makeAtlases(Consumer<SpriteIdentifier> consumer) {
        consumer.accept(new SpriteIdentifier(BED_ATLAS_TEXTURE, AdvancedBeds.id("textures/item/nocturnal_bed")));
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+AdvancedBeds.MOD_NAME+"] " + message);
    }

}