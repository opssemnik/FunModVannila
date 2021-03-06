package FunMod.cliente.proxy;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import opssemnik.minecraft.funmod.fixes.FMRenderHelper;
import opssemnik.minecraft.funmod.fixes.StaticHelper;
import FunMod.cliente.gui.GuiFantasyFurnace;
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
import FunMod.cliente.render.ItemControleRender;
import FunMod.cliente.render.RenderChaos;
import FunMod.cliente.render.RenderFlor;
import FunMod.cliente.render.RenderGanondorf;
import FunMod.cliente.render.RenderNess;
import FunMod.cliente.render.RenderPinky;
import FunMod.cliente.render.RenderSofa;
import FunMod.cliente.render.RenderTvN64;
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
	         public Object getClientGuiElement(int id, EntityPlayer player, World world,
	                         int x, int y, int z) {
	               switch(id){  
	               case 1:
	            	   TileEntity tileEntity = world.getTileEntity(x, y, z);
	                 if(tileEntity instanceof EntidadeFantasyFurnace){
	                         return new GuiFantasyFurnace(player.inventory, ( EntidadeFantasyFurnace) tileEntity);
	                 }
	           	               
	               return true;
	               }      	                   	                                
	                 return null;

	    	 }
	    	 @Override
	    	 @SideOnly(Side.CLIENT)
	    	 public void rendercontrole(){    	     	
	    	  MinecraftForgeClient.registerItemRenderer( StaticHelper.FMItemLoader.controle, new ItemControleRender());      	 
	    }

    
    public void renderMobs()
    {
    	
    	RenderingRegistry.registerEntityRenderingHandler( EntityThrowing.class, new RenderFlor());
        RenderingRegistry.registerEntityRenderingHandler(EntityLink.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityNess.class, new RenderNess(new ModelNess(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMegaMan.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityWoody.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityIchigo.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityClyde.class, new FMRenderHelper(new ModelClyde(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityGoomba.class, new FMRenderHelper(new ModelGoomba(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityNaruto.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBlinky.class, new FMRenderHelper(new ModelBlinky(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityInky.class, new FMRenderHelper(new ModelInky(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityPinky.class, new RenderPinky(new ModelPinky(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityAsh.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityKirby.class, new FMRenderHelper(new ModelKirby(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityHomemAranha.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityVenom.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityPikachu.class, new FMRenderHelper(new ModelPikachu(0, 0), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityChaos.class, new RenderChaos(new ModelChaos(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMage.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityDarkLink.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityGanondorf.class, new RenderGanondorf(new ModelGanondorf(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySephiroth.class, new FMRenderHelper(new ModelSephiroth(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityKoopaTroopa.class, new FMRenderHelper(new ModelKoopa(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySonic.class, new FMRenderHelper(new ModelSonic(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityDoctorWilly.class, new RenderBiped(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityHamtaro.class, new FMRenderHelper(new ModelHamtaro(), 0.5F));
       
    }

    public void renderBlocoComModelo() {
    	 ClientRegistry.bindTileEntitySpecialRenderer(EntidadeN64.class, new RenderTvN64());
    	 modelID = RenderingRegistry.getNextAvailableRenderId();
	     ClientRegistry.bindTileEntitySpecialRenderer(EntidadeSofa.class, new RenderSofa());
         sofamodelID = RenderingRegistry.getNextAvailableRenderId();
         	
    }

	
}
