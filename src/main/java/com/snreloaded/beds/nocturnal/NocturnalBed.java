package com.snreloaded.beds.nocturnal;

import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.world.BlockView;

public class NocturnalBed extends BedBlock implements BlockEntityProvider {
    public NocturnalBed(Settings settings) {
        super(DyeColor.BLACK, settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new NocturnalBedEntity();
    }
}
