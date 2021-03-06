package FunMod.blocks;

import java.util.Random;

import opssemnik.minecraft.funmod.fixes.StaticHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import FunMod.FunMod;
public class FantasyGrass extends Block
{
    public FantasyGrass(int par1, int par2)
    {
        super(Material.ground);
        setTickRandomly(true);
        this.setCreativeTab(FunMod.funmodtab);
    }
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return StaticHelper.FMBlockLoader.FantasyDirt.getItemDropped(p_149650_1_, p_149650_2_, p_149650_3_);
    }
/*
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (par1World.isRemote)
        {
            return;
        }

        if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && Block.lightOpacity[par1World.getBlockId(par2, par3 + 1, par4)] > 2)
        {
            par1World.setBlockWithNotify(par2, par3, par4, FunMod.FantasyGrass.blockID);
        }
        else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
        {
            for (int i = 0; i < 45; i++)
            {
                int j = (par2 + par5Random.nextInt(3)) - 1;
                int k = (par3 + par5Random.nextInt(5)) - 3;
                int l = (par4 + par5Random.nextInt(3)) - 1;
                int i1 = par1World.getBlockId(j, k + 1, l);

                if (par1World.getBlockId(j, k, l) == Block.grass.blockID && par1World.getBlockLightValue(j, k + 1, l) >= 4 && Block.lightOpacity[i1] <= 2)
                {
                    par1World.setBlockWithNotify(j, k, l, FunMod.FantasyGrass.blockID);
                }
            }
        }
    }
   
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.randomDisplayTick(par1World, par2, par3, par4, par5Random);

        if (par5Random.nextInt(75) == 0)
        {
            par1World.spawnParticle("depthsuspend", (float)par2 + par5Random.nextFloat(), (float)par3 + 1.1F, (float)par4 + par5Random.nextFloat(), 20.0D, 20.0D, 20.0D);
        }
    }
    public String getTextureFile(){
     return "/FunMod/cliente/texturas/texturas.png";
    }
    	
    	
    	public int getBlockTextureFromSideAndMetadata (int i, int j)
    {
    	
    	if (i == 0)
    		
    		return 28;
    	if (i == 1)
    		
    		return 26;
    	
    	if (i == 2)
    		
    		return 27;
    	if (i == 3)
    		
    		return 27;
    	if (i == 4)
	
    		return 27;
    	if (i == 5)
	
    		return 27;
   
    	if (j ==1)
    	{
    		return 166;
    	}
    
    		return j != 2 ? 20 : 177;
    }
*/
}
