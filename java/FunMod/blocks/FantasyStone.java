package FunMod.blocks;

import java.util.Random;

import opssemnik.minecraft.funmod.fixes.StaticHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import FunMod.FunMod;
public class FantasyStone extends Block
{
    public FantasyStone(int par1, int par2)
    {
        super(Material.rock);
        this.setCreativeTab(FunMod.funmodtab);
    }
 @Override
 public Item getItemDropped(int par1, Random par2Random, int par3)
 {
     return StaticHelper.FMBlockLoader.cobble.getItemDropped(0, par2Random, par3);
 }
}