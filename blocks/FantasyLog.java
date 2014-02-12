package FunMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import FunMod.FunMod;
public class FantasyLog extends Block
{
    public FantasyLog(int par1)
    {
        super(Material.wood);
        this.setCreativeTab(FunMod.funmodtab);
    }
    public void onBlockRemoval(World par1World, int par2, int par3, int par4)
    {
        byte byte0 = 4;
        int i = byte0 + 1;

        if (par1World.checkChunksExist(par2 - i, par3 - i, par4 - i, par2 + i, par3 + i, par4 + i))
        {
            for (int j = -byte0; j <= byte0; j++)
            {
                for (int k = -byte0; k <= byte0; k++)
                {
                    for (int l = -byte0; l <= byte0; l++)
                    {
                        Block i1 = par1World.getBlock(par2 + j, par3 + k, par4 + l);

                        if (i1 != Blocks.leaves)
                        {
                            continue;
                        }

                        int j1 = par1World.getBlockMetadata(par2 + j, par3 + k, par4 + l);

                        if ((j1 & 8) == 0)
                        {
                            par1World.setBlock(par2 + j, par3 + k, par4 + l, par1World.getBlock(par2 + j, par3 + k, par4 + l), j1 | 8, 0);
                        }
                    }
                }
            }
        }
    }

    /**
    public int getBlockTextureFromSideAndMetadata(int i, int j)  
    {
    	if(i == 0)
			return 29; //This is the bottom of the log
		if(i == 1)
			return 29; //This is the top
		if(i == 2)
			return 30; //These are the sides
		if(i == 3)
			return 30;
		if(i == 4)
			return 30;
		if(i == 5)
			return 30;
		
        if(j == 1)
        {
            return 116;
        }
        return j != 2 ? 20 : 117;
    }
*/

}
