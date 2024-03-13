package org.yakodan.yakodanmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.GameSettings;
import net.minecraft.client.audio.Sound;
import net.minecraft.client.audio.SoundEngine;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import org.yakodan.yakodanmod.item.custom.DragonStone;

import java.util.UUID;

public class DragonStoneBlock extends Block {

    public DragonStoneBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    @SuppressWarnings("depricated")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult blockRayTraceResult) {

        if(!world.isRemote){
            if(hand == Hand.MAIN_HAND){
                System.out.println("I right-clicked a Dragon Stone Block! Called for main hand.");
            }
            if(hand == Hand.OFF_HAND){
                System.out.println("I right-clicked a Dragon Stone Block! Called for off-hand.");
            }

            player.sendMessage(new StringTextComponent("I right-clicked"), player.getUniqueID());

        }

        return super.onBlockActivated(state, world, pos, player, hand, blockRayTraceResult);
    }

    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {

        if(!worldIn.isRemote){
            System.out.println("I lef-clicked a Dragon Stone Block!");
            player.sendMessage(new StringTextComponent("I left-clicked"), player.getUniqueID());
        }


        super.onBlockClicked(state, worldIn, pos, player);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        DragonStone.lightEntityOnFire(entityIn,5);
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        worldIn.createExplosion(worldIn.getClosestPlayer(pos.getX(),pos.getY(),pos.getZ(),10,true),pos.getX(),pos.getY(),pos.getZ(),10, Explosion.Mode.BREAK);

        super.onBlockAdded(state, worldIn, pos, oldState, isMoving);
    }
}
