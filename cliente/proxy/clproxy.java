package FunMod.cliente.proxy;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import FunMod.FunMod;
import FunMod.cliente.gui.GuiFantasyFurnace;
import FunMod.cliente.gui.GuiN64;
import FunMod.cliente.model.ModelBlinky;
import FunMod.cliente.model.ModelChaos;
import FunMod.cliente.model.ModelClyde;
import FunMod.cliente.model.ModelGanondorf;
import FunMod.cliente.model.ModelGoomba;
import FunMod.cliente.model.ModelHamtaro;
import FunMod.cliente.model.ModelInky;
import FunMod.cliente.model.ModelKirby;
import FunMod.cliente.model.ModelKoopa;
import FunMod.cliente.model.ModelNess;
import FunMod.cliente.model.ModelPikachu;
import FunMod.cliente.model.ModelPinky;
import FunMod.cliente.model.ModelSephiroth;
import FunMod.cliente.model.ModelSonic;
import FunMod.cliente.model.ModelYoshi;
import FunMod.cliente.render.ItemControleRender;
import FunMod.cliente.render.RenderBlinky;
import FunMod.cliente.render.RenderChaos;
import FunMod.cliente.render.RenderClyde;
import FunMod.cliente.render.RenderFlor;
import FunMod.cliente.render.RenderGanondorf;
import FunMod.cliente.render.RenderGoomba;
import FunMod.cliente.render.RenderHamtaro;
import FunMod.cliente.render.RenderInky;
import FunMod.cliente.render.RenderKirby;
import FunMod.cliente.render.RenderKoopaTroopa;
import FunMod.cliente.render.RenderNess;
import FunMod.cliente.render.RenderPikachu;
import FunMod.cliente.render.RenderPinky;
import FunMod.cliente.render.RenderSephiroth;
import FunMod.cliente.render.RenderSofa;
import FunMod.cliente.render.RenderSonic;
import FunMod.cliente.render.RenderTvN64;
import FunMod.cliente.render.RenderYoshi;
import FunMod.entidades.EntityAsh;
import FunMod.entidades.EntityBlinky;
import FunMod.entidades.EntityChaos;
import FunMod.entidades.EntityClyde;
import FunMod.entidades.EntityDarkLink;
import FunMod.entidades.EntityDoctorWilly;
import FunMod.entidades.EntityGanondorf;
import FunMod.entidades.EntityGoomba;
import FunMod.entidades.EntityHamtaro;
import FunMod.entidades.EntityHomemAranha;
import FunMod.entidades.EntityIchigo;
import FunMod.entidades.EntityInky;
import FunMod.entidades.EntityKirby;
import FunMod.entidades.EntityKoopaTroopa;
import FunMod.entidades.EntityLink;
import FunMod.entidades.EntityMage;
import FunMod.entidades.EntityMegaMan;
import FunMod.entidades.EntityNaruto;
import FunMod.entidades.EntityNess;
import FunMod.entidades.EntityPikachu;
import FunMod.entidades.EntityPinky;
import FunMod.entidades.EntitySephiroth;
import FunMod.entidades.EntitySonic;
import FunMod.entidades.EntityThrowing;
import FunMod.entidades.EntityVenom;
import FunMod.entidades.EntityWoody;
import FunMod.entidades.EntityYoshi;
import FunMod.ftp.ThreadGetData;
import FunMod.proxy.proxy;
import FunMod.tileentidades.EntidadeFantasyFurnace;
import FunMod.tileentidades.EntidadeN64;
import FunMod.tileentidades.EntidadeSofa;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public class clproxy extends proxy implements IGuiHandler
{

	public static int modelID;
    
    public static int sofamodelID;
	
    
    @Override
    public void registerRenderThings()
    {/*
	try{
    TextureFXManager.instance().addAnimation(new TextureFunFX("/FunMod/cliente/texturas/animacoes/QuestionBlock.png", FunMod.ANIMATED_TEXTURE_INDEX));
}
 catch (IOException e) {
	System.err.println("[FunMod] Error registering animation with FML: " + e.getMessage());}
    System.out.println("[FunMod] Registering Textures And Renders Completed Sucefful Without Any Erros");
    }  */
    }
	 @Override
	 	public void init()
	 	{   	   	
		// TickRegistry.registerTickHandler(new FunModClientTickHandler(), Side.CLIENT);	
	 	}
	    	 @Override
	         public Object getClientGuiElement(int id, EntityPlayer player, World world,
	                         int x, int y, int z) {
	               switch(id){  
	               case 1:
	            	   TileEntity tileEntity = world.getTileEntity(x, y, z);
	                 if(tileEntity instanceof EntidadeFantasyFurnace){
	                         return new GuiFantasyFurnace(player.inventory, ( EntidadeFantasyFurnace) tileEntity);
	                 }
	               case 2:
	            		TileEntity tileEntity2 = world.getTileEntity(x, y, z);
	               	 if(tileEntity2 instanceof EntidadeN64){
	                        return new GuiN64(player);}
	               return true;
	               }      	                   	                                
	                 return null;

	    	 }
	    	 @Override
	    	 @SideOnly(Side.CLIENT)
	    	 public void rendercontrole(){    	     	
	    	  MinecraftForgeClient.registerItemRenderer(FunMod.controle, new ItemControleRender());      	 
	    }

    
    public void renderMobs()
    {
    	
    	RenderingRegistry.registerEntityRenderingHandler( EntityThrowing.class, new RenderFlor());
        RenderingRegistry.registerEntityRenderingHandler(EntityLink.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityNess.class, new RenderNess(new ModelNess(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMegaMan.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityWoody.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityIchigo.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityClyde.class, new RenderClyde(new ModelClyde(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityGoomba.class, new RenderGoomba(new ModelGoomba(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityNaruto.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBlinky.class, new RenderBlinky(new ModelBlinky(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityInky.class, new RenderInky(new ModelInky(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityPinky.class, new RenderPinky(new ModelPinky(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityAsh.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityKirby.class, new RenderKirby(new ModelKirby(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityHomemAranha.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityVenom.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityPikachu.class, new RenderPikachu(new ModelPikachu(0, 0), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityChaos.class, new RenderChaos(new ModelChaos(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMage.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityDarkLink.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityGanondorf.class, new RenderGanondorf(new ModelGanondorf(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySephiroth.class, new RenderSephiroth(new ModelSephiroth(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityKoopaTroopa.class, new RenderKoopaTroopa(new ModelKoopa(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySonic.class, new RenderSonic(new ModelSonic(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityYoshi.class, new RenderYoshi(new ModelYoshi(), new ModelYoshi(0.5F), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityDoctorWilly.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityHamtaro.class, new RenderHamtaro(new ModelHamtaro(), 0.5F));
       
    }

    public void renderBlocoComModelo() {
    	 ClientRegistry.bindTileEntitySpecialRenderer(EntidadeN64.class, new RenderTvN64());
    	 modelID = RenderingRegistry.getNextAvailableRenderId();
	     ClientRegistry.bindTileEntitySpecialRenderer(EntidadeSofa.class, new RenderSofa());
         sofamodelID = RenderingRegistry.getNextAvailableRenderId();
         	
    }
    public void renderItemComModelos(int var1){ 	              
        
    }
	public void loadTickHandler()
	{
		//TickRegistry.registerTickHandler(new FunModClientTickHandler(), Side.CLIENT);
	}
    public void loadUtilities() {
    	new ThreadGetData();
    }
}
