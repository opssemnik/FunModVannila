package FunMod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.util.EnumHelper;
import opssemnik.minecraft.funmod.fixes.StaticHelper;
import FunMod.biomas.BiomeGenFantasy;
import FunMod.blocks.BlocCobble;
import FunMod.blocks.BlockBrickBlock;
import FunMod.blocks.BlockFantasyPortal;
import FunMod.blocks.BlockPlank;
import FunMod.blocks.BlockQuestionBlock;
import FunMod.blocks.BlockSofa;
import FunMod.blocks.BlockTv;
import FunMod.blocks.FantasyDirt;
import FunMod.blocks.FantasyFurnace;
import FunMod.blocks.FantasyGrass;
import FunMod.blocks.FantasyLeaf;
import FunMod.blocks.FantasyLog;
import FunMod.blocks.FantasyStone;
import FunMod.blocks.MysticalStone;
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
import FunMod.struturas.WorldGeneratorFantasy;
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
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "FunMod", name = "FunMod", version = "Beta 1.2.0 for MC 1.7.10")
public class FunMod {
	@SidedProxy(clientSide = "FunMod.cliente.proxy.clproxy", serverSide = "FunMod.proxy.proxy")
	public static proxy proxy;
	public static BiomeGenBase FantasyBiome;
	public static CreativeTabs funmodtab;
	@Instance("FunMod")
	public static FunMod instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		funmodtab = new CTabFun(CreativeTabs.getNextID(), "FunMod");
		}
	@EventHandler
	public void init(FMLInitializationEvent evt){
		new StaticHelper.FMItemLoader().registerItems();
		new StaticHelper.FMBlockLoader().registerBlocks();
		FantasyBiome = (new BiomeGenFantasy(65));
		//GameRegistry.registerWorldGenerator(new WorldGeneratorFantasy(), 15);

		// entidades
		GameRegistry.registerTileEntity(EntidadeN64.class, "Tv");
		GameRegistry.registerTileEntity(EntidadeSofa.class, "Sofa");
		EntityRegistry.registerGlobalEntityID(EntityThrowing.class, "Throwing",
				126);
		EntityRegistry.registerModEntity(EntityThrowing.class, "Throwing", 126,
				this, 64, 1, true);
		EntityRegistry.registerGlobalEntityID(EntityLink.class, "Link", 180,
				8510747, 2551400);
		EntityRegistry.addSpawn(EntityLink.class, 180, 2, 3,
				EnumCreatureType.creature, new BiomeGenBase[] {
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityNess.class, "Ness", 181,
				25500, 30144255);
		EntityRegistry.addSpawn(EntityNess.class, 182, 1, 4,
				EnumCreatureType.creature,
				new BiomeGenBase[] { FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityMegaMan.class, "Mega Man",
				102, 135206250, 245245245);
		EntityRegistry.addSpawn(EntityMegaMan.class, 102, 1, 2,
				EnumCreatureType.creature,
				new BiomeGenBase[] { FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityWoody.class, "Woody", 103,
				812712861, 245245245);
		EntityRegistry.addSpawn(EntityWoody.class, 103, 1, 3,
				EnumCreatureType.creature,
				new BiomeGenBase[] { FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityIchigo.class, "Ichigo",
				104, 23344499, 212823623);
		EntityRegistry.addSpawn(EntityIchigo.class, 104, 3, 5,
				EnumCreatureType.creature,
				new BiomeGenBase[] { FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityClyde.class, "Clyde", 105,
				46467576, 212823623);
		EntityRegistry.addSpawn(EntityClyde.class, 105, 3, 7,
				EnumCreatureType.monster,
				new BiomeGenBase[] { FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityGoomba.class, "Goomba",
				106, 18271293, 212823623);
		EntityRegistry.addSpawn(EntityGoomba.class, 106, 6, 8,
				EnumCreatureType.monster,
				new BiomeGenBase[] { FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityNaruto.class, "Naruto",
				107, 252520, 141415);
		EntityRegistry.addSpawn(EntityNaruto.class, 107, 2, 4,
				EnumCreatureType.creature,
				new BiomeGenBase[] { FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityBlinky.class, "Blinky",
				108, 12872382, 141415);
		EntityRegistry.addSpawn(EntityBlinky.class, 108, 8, 12,
				EnumCreatureType.monster, new BiomeGenBase[] {
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityInky.class, "Inky", 109,
				12872382, 18191918);
		EntityRegistry.addSpawn(EntityInky.class, 109, 3, 5,
				EnumCreatureType.monster, new BiomeGenBase[] {
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityPinky.class, "Pinky", 110,
				1281272, 18191918);
		EntityRegistry.addSpawn(EntityPinky.class, 110, 8, 12,
				EnumCreatureType.monster, new BiomeGenBase[] {
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityAsh.class, "Ash", 111,
				19291201, 1821928);
		EntityRegistry.addSpawn(EntityAsh.class, 111, 2, 3,
				EnumCreatureType.creature, new BiomeGenBase[] {
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome, FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityKirby.class, "Kirby", 112,
				80807090, 8512712);
		EntityRegistry.addSpawn(EntityKirby.class, 112, 4, 8,
				EnumCreatureType.creature, new BiomeGenBase[] {
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityHomemAranha.class,
				"Spider Man", 113, 60807090, 152152);
		EntityRegistry.addSpawn(EntityHomemAranha.class, 113, 1, 4,
				EnumCreatureType.creature, new BiomeGenBase[] {
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityVenom.class, "Venom", 114,
				9090706, 152152);
		EntityRegistry.addSpawn(EntityVenom.class, 114, 3, 5,
				EnumCreatureType.monster, new BiomeGenBase[] {
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityPikachu.class, "Pikachu",
				115, 80807060, 1515151);
		EntityRegistry.addSpawn(EntityPikachu.class, 115, 1, 3,
				EnumCreatureType.creature, new BiomeGenBase[] {
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome, FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityChaos.class, "Chaos", 116,
				3636363, 1515151);
		EntityRegistry.addSpawn(EntityChaos.class, 116, 5, 5,
				EnumCreatureType.monster, new BiomeGenBase[] {
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityMage.class, "Mage", 117,
				3636363, 66666666);
		EntityRegistry.addSpawn(EntityMage.class, 117, 1, 2,
				EnumCreatureType.monster, new BiomeGenBase[] {
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome, FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityDarkLink.class,
				"Dark Link", 119, 77777777, 88888888);
		EntityRegistry.addSpawn(EntityDarkLink.class, 119, 2, 4,
				EnumCreatureType.monster, new BiomeGenBase[] {
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityGanondorf.class,
				"Ganondorf", 70, 10277912, 16161616);
		EntityRegistry.addSpawn(EntityGanondorf.class, 120, 1, 3,
				EnumCreatureType.monster, new BiomeGenBase[] {
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntitySephiroth.class,
				"Sephiroth", 121, 10277912, 67676767);
		EntityRegistry.addSpawn(EntitySephiroth.class, 121, 1, 3,
				EnumCreatureType.monster, new BiomeGenBase[] {
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome, FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityKoopaTroopa.class,
				"Koopa Troopa", 122, 89898090, 67676767);
		EntityRegistry.addSpawn(EntityKoopaTroopa.class, 122, 6, 7,
				EnumCreatureType.monster, new BiomeGenBase[] {
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome, FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntitySonic.class, "Sonic", 123,
				89898090, 49484047);
		EntityRegistry.addSpawn(EntitySonic.class, 123, 2, 5,
				EnumCreatureType.creature, new BiomeGenBase[] {
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome, FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityDoctorWilly.class,
				"Doctor Willy", 125, 129128918, 88888888);
		EntityRegistry.addSpawn(EntityDoctorWilly.class, 125, 1, 3,
				EnumCreatureType.monster, new BiomeGenBase[] {
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome });

		EntityRegistry.registerGlobalEntityID(EntityHamtaro.class, "Hamtaro",
				72, 129128918, 81726162);
		EntityRegistry.addSpawn(EntityDoctorWilly.class, 125, 1, 3,
				EnumCreatureType.creature, new BiomeGenBase[] {
						FunMod.FantasyBiome, FunMod.FantasyBiome,
						FunMod.FantasyBiome });
		// sistema de proxy
		proxy.registerRenderThings();
		proxy.renderMobs();
		proxy.renderBlocoComModelo();
		proxy.loadTickHandler();
		proxy.rendercontrole();
		
		GameRegistry.registerTileEntity(EntidadeFantasyFurnace.class,
				"EntidadeFantasyFurnace");
		// Dimensao
		//DimensionManager.registerProviderType(10, WorldProviderFantasy.class,
		//		false);
		//DimensionManager.registerDimension(10, 10);
	
		

	}

	

}
