package FunMod.blocks;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import FunMod.FunMod;
import FunMod.cliente.proxy.clproxy;
import FunMod.dimensao.FantasyTeleporter;
import FunMod.tileentidades.EntidadeN64;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public class BlockTv extends BlockContainer  

{


private  WorldServer server;

public BlockTv(int par1, int par2)
{
super(Material.rock);
this.setCreativeTab(FunMod.funmodtab);
this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
}
@SideOnly(Side.CLIENT)
public int getRenderType()
{
return clproxy.modelID;
} 
public boolean isOpaqueCube() {
return false;
}
public boolean renderAsNormalBlock() {
return false;
}
/*
private void setDefaultDirection(World par1World, int par2, int par3, int par4)
{
    if (!par1World.isRemote)
    {
    	Block var5 = par1World.getBlock(par2, par3, par4 - 1);
        Block var6 = par1World.getBlock(par2, par3, par4 + 1);
        Block var7 = par1World.getBlock(par2 - 1, par3, par4);
        Block var8 = par1World.getBlock(par2 + 1, par3, par4);
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
*/
public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
{
    int var6 = ((MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
    par1World.setBlockMetadataWithNotify(par2, par3, par4, var6, 2);
    
}
@Override
public void onBlockAdded(World par1World, int par2, int par3, int par4)
{
    super.onBlockAdded(par1World, par2, par3, par4);
   // this.setDefaultDirection(par1World, par2, par3, par4);
}


@Override
public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
EntityPlayerMP playerMP = null;
Item equipped = entityplayer.getCurrentEquippedItem().getItem() != null ? entityplayer.getCurrentEquippedItem().getItem() : null;
if (entityplayer instanceof EntityPlayerMP)
{
	 playerMP = (EntityPlayerMP)entityplayer;
playerMP.addChatMessage(new ChatComponentText("You need a Remote Control to activate the Televison"));}
if (equipped == FunMod.controle){
		        	playerMP.addChatMessage(new ChatComponentText("Teleporting"));
		        if (playerMP.dimension != 10){	
		            MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension(playerMP, 10, new FantasyTeleporter(playerMP.getServerForPlayer()));         
		            return true;
		        }
		        else {    
		        	MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension(playerMP, 0, new FantasyTeleporter(server));	
		        	 return true;
		        }
}     
		        if (equipped == Items.coal){     	
				         playerMP.addChatMessage(new ChatComponentText("Carregando lista de recipes"));
				         entityplayer.openGui(FunMod.instance, 2, world, i, j, k);
				         return true;
		        }else return false;
}	
public TileEntity createNewTileEntity(World var1,int var2)
{
	return new EntidadeN64();

}
}
