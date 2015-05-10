package FunMod.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import FunMod.containers.ContainerFantasyFurnace;
import FunMod.tileentidades.EntidadeFantasyFurnace;
import FunMod.tileentidades.EntidadeN64;
import cpw.mods.fml.common.network.IGuiHandler;
public class proxy implements IGuiHandler
{
    public void registerRenderThings()
    {
        
    }
    public void renderMobs()
    {
    }
	public void renderBlocoComModelo() {
	}
	@Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
        switch(id){
        case 0:
		TileEntity tileEntity = world.getTileEntity(x, y, z);
            if(tileEntity instanceof EntidadeFantasyFurnace){
                    return new ContainerFantasyFurnace(player.inventory, (EntidadeFantasyFurnace) tileEntity);
            }
        case 2:
        	TileEntity tileEntity2 = world.getTileEntity(x, y, z);
        	 if(tileEntity2 instanceof EntidadeN64){
                 return null;}
        }      
		
	return null;
       
        }
	
	public void loadUtilities() {}
	public void loadTickHandler()
	{
		
	}
	
	public void init() {
}
 
	public void renderItemComModelos(int var1){          
       
}
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		return null;
	}
	public void rendercontrole() {
	
	}

    
}