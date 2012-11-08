package FunMod.blocks;
import java.util.Random;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import FunMod.FunMod;
import FunMod.cliente.proxy.clproxy;
import FunMod.tileentidades.EntidadeSofa;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
public class BlockSofa extends BlockContainer  
{

	public static boolean disableValidation = false;

public BlockSofa(int par1, int par2, Class class1)
{

super(par1, par2, Material.rock);
this.setCreativeTab(FunMod.funmodtab);
this.setRequiresSelfNotify(); 
this.blockIndexInTexture = 45;

}

 public int idDropped()
{
return FunMod.tv.blockID; 
}
public int quantityDropped(Random par1Random)
{
return 1;
}
@SideOnly(Side.CLIENT)
public int getRenderType()
{
return clproxy.sofamodelID;
} //Linkado ao proxy do cliente pois somente ele que possui os metodos de renderizacao, caso linkasse ao do server o bloco bugaria


public boolean isOpaqueCube() {
return false;
}
public boolean renderAsNormalBlock() {
return false;
}


/**
* Determines the damage on the item the block drops. Used in cloth and wood.
*/
public int damageDropped(int par1)
{
return par1;
}
private void setDefaultDirection(World par1World, int par2, int par3, int par4)
{
    if (!par1World.isRemote)
    {
        int var5 = par1World.getBlockId(par2, par3, par4 - 1);
        int var6 = par1World.getBlockId(par2, par3, par4 + 1);
        int var7 = par1World.getBlockId(par2 - 1, par3, par4);
        int var8 = par1World.getBlockId(par2 + 1, par3, par4);
        byte var9 = 3;

        if (Block.opaqueCubeLookup[var5] && !Block.opaqueCubeLookup[var6])
        {
            var9 = 3;
        }

        if (Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var5])
        {
            var9 = 2;
        }

        if (Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var8])
        {
            var9 = 5;
        }

        if (Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var7])
        {
            var9 = 4;
        }

        par1World.setBlockMetadataWithNotify(par2, par3, par4, var9);
    }
}
public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
{
    int var6 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
    par1World.setBlockMetadataWithNotify(par2, par3, par4, var6);
}
public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
{
    this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
    return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
}
public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
{
    this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
    return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
}

public void onBlockAdded(World par1World, int par2, int par3, int par4)
{
    super.onBlockAdded(par1World, par2, par3, par4);
    this.setDefaultDirection(par1World, par2, par3, par4);
}

public boolean onblockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer){

int p = MathHelper.floor_double((double)((par5EntityPlayer.rotationYaw * 4F) / 360F) + 0.5D) & 3; //i don't know what this is for, so we better keep that there

byte byte0 = 3;


if (p == 0)
{
byte0 = 4;
}
if (p == 1)
{
byte0 = 3;
}
if (p == 2)
{
byte0 = 2;
}
if (p == 3)
{
byte0 = 1;
}

par1World.setBlockMetadataWithNotify(par2, par3, par4, byte0);

return true;
}
public TileEntity getBlockEntity() {
return new EntidadeSofa();

}


public TileEntity createNewTileEntity(World var1)
{
	return new EntidadeSofa();

}
public String getTextureFile(){       
return "/FunMod/cliente/texturas/texturas.png";}

}










	
	
 // to get all sub blocks. make it more or less ass you please.


