package com.snreloaded.beds;

import com.snreloaded.beds.nocturnal.NocturnalBed;
import com.snreloaded.beds.nocturnal.NocturnalBedEntity;
import com.snreloaded.beds.nocturnal.NocturnalBedRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdvancedBeds implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "advancedbeds";
    public static final String MOD_NAME = "Advanced Beds";

    /** Advanced Beds Item group **/
    public static final ItemGroup AdvancedBeds_Group = FabricItemGroupBuilder.build(new Identifier("advancedbeds", "general"), () -> new ItemStack(Blocks.RED_BED));

    /** Tutorial Item **/
    public static final FabricItem FABRIC_ITEM = new FabricItem(new Item.Settings().group(AdvancedBeds.AdvancedBeds_Group));

    /** Nocturnal Block **/
    public static final NocturnalBed NOCTURNAL_BED = new NocturnalBed(FabricBlockSettings.of(Material.WOOL).hardness(4.0f));

    public static BlockEntityType<NocturnalBedEntity> NOCTURNAL_BED_ENTITY;

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");

        /** FABRIC ITEM INIT **/
        Registry.register(Registry.ITEM, new Identifier("advancedbeds", "fabric_item"), FABRIC_ITEM);

        /** NOCTURNAL BED INIT **/
        Registry.register(Registry.BLOCK, new Identifier("advancedbeds", "nocturnal_bed"), NOCTURNAL_BED);
        NOCTURNAL_BED_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "modid:demo", BlockEntityType.Builder.create(NocturnalBedEntity::new, NOCTURNAL_BED).build(null));
        Registry.register(Registry.ITEM, new Identifier("advancedbeds", "nocturnal_bed"), new BlockItem(NOCTURNAL_BED, new Item.Settings().group(AdvancedBeds.AdvancedBeds_Group)));

        log(Level.INFO, "Done Initializing");
    }

    public static Identifier id(String path) {
        return new Identifier(AdvancedBeds.MOD_ID, path);
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}