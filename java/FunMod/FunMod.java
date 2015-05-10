package FunMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.biome.BiomeGenBase;
import opssemnik.minecraft.funmod.fixes.StaticHelper.FMBlockLoader;
import opssemnik.minecraft.funmod.fixes.StaticHelper.FMEntityLoader;
import opssemnik.minecraft.funmod.fixes.StaticHelper.FMItemLoader;
import FunMod.biomas.BiomeGenFantasy;
import FunMod.proxy.proxy;
import FunMod.tabs.CTabFun;
import FunMod.tileentidades.EntidadeFantasyFurnace;
import FunMod.tileentidades.EntidadeN64;
import FunMod.tileentidades.EntidadeSofa;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "FunMod", name = "FunMod", version = "Beta 1.2.0 for MC 1.7.10")
public class FunMod {
	@SidedProxy(clientSide = "FunMod.cliente.proxy.clproxy", serverSide = "FunMod.proxy.proxy")
	public static proxy proxy;
	public static BiomeGenBase FantasyBiome;
	public static CreativeTabs funmodtab;
	public FMBlockLoader blockLoader;
	public FMItemLoader itemLoader;
	public FMEntityLoader entityLoader;
	@Instance("FunMod")
	public static FunMod instance;


	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		funmodtab = new CTabFun(CreativeTabs.getNextID(), "FunMod");
		}
	@EventHandler
	public void init(FMLInitializationEvent evt){
		FantasyBiome = (new BiomeGenFantasy(65));
		blockLoader = new FMBlockLoader();
		itemLoader = new FMItemLoader();
		entityLoader = new FMEntityLoader();
		itemLoader.registerItems();
		itemLoader.loadRecipes();
		blockLoader.registerBlocks();
		blockLoader.registerBlockRecipes();
	
		//GameRegistry.registerWorldGenerator(new WorldGeneratorFantasy(), 15);
		// entidades
		GameRegistry.registerTileEntity(EntidadeN64.class, "Tv");
		GameRegistry.registerTileEntity(EntidadeSofa.class, "Sofa");
		GameRegistry.registerTileEntity(EntidadeFantasyFurnace.class,"EntidadeFantasyFurnace");
		// sistema de proxy
		proxy.registerRenderThings();
		proxy.renderMobs();
		proxy.renderBlocoComModelo();
		proxy.rendercontrole();

		// Dimensao
		//DimensionManager.registerProviderType(10, WorldProviderFantasy.class,
		//		false);
		//DimensionManager.registerDimension(10, 10);
	
		

	}

	

}
