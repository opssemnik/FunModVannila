package FunMod.blocks;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemCoal;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import FunMod.FunMod;
import FunMod.cliente.proxy.clproxy;
import FunMod.dimensao.FantasyTeleporter;
import FunMod.items.ItemControle;
import FunMod.tileentidades.EntidadeN64;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public class BlockTv extends BlockContainer  

{


private  WorldServer server;

public BlockTv(int par1, int par2, Class class1)
{

super(par1, par2, Material.rock);
this.setCreativeTab(FunMod.funmodtab);
this.setRequiresSelfNotify(); 
this.blockIndexInTexture = 33;
this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
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
return clproxy.modelID;
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
    int var6 = ((MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
    par1World.setBlockMetadataWithNotify(par2, par3, par4, var6);
    
}
@Override
public void onBlockAdded(World par1World, int par2, int par3, int par4)
{
    super.onBlockAdded(par1World, par2, par3, par4);
    this.setDefaultDirection(par1World, par2, par3, par4);
}


@Override
public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {

EntidadeN64 tile = (EntidadeN64) world.getBlockTileEntity(i, j, k);





Item equipped = entityplayer.getCurrentEquippedItem() != null ? entityplayer.getCurrentEquippedItem().getItem() : null;
if (entityplayer instanceof EntityPlayerMP)
{
	EntityPlayerMP playerMP = (EntityPlayerMP)entityplayer;
playerMP.addChatMessage("You need a Remote Control to activate the Televison");}
if (equipped instanceof ItemControle)

	
		        if (entityplayer instanceof EntityPlayerMP)
		        {
		        	EntityPlayerMP playerMP = (EntityPlayerMP)entityplayer;
		        	playerMP.addChatMessage("Teleporting");
		        if (playerMP.dimension != 10){	
		        	playerMP.timeUntilPortal = 10;
		            MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension(playerMP, 10, new FantasyTeleporter(server));
		            
		            return true;
		        }
		        else {
		      
		        	MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension(playerMP, 0, new FantasyTeleporter(server));	
		            return true;
		        }}
		        if (equipped instanceof ItemCoal){
		        	 if (entityplayer instanceof EntityPlayerMP)
				        {        	
		        		 EntityPlayerMP playerMP = (EntityPlayerMP)entityplayer;
				         playerMP.addChatMessage("Carregando lista de recipes");
				        }
				         entityplayer.openGui(FunMod.instance, 2, world, i, j, k);
		        }
		        else {
		        	return true;
		        }
	    

		        


return true;

}
	
	
	
	public TileEntity getBlockEntity() {
return new EntidadeN64();

}


public TileEntity createNewTileEntity(World var1)
{
	return new EntidadeN64();

}
public String getTextureFile(){       
return "/FunMod/cliente/texturas/texturas.png";}

}










	
	
 // to get all sub blocks. make it more or less ass you please.


