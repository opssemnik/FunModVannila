package FunMod;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.command.CommandHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.EnumHelper;
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
import FunMod.cliente.ticks.FunModClientTickHandler;
import FunMod.comandos.CommandFun;
import FunMod.dimensao.WorldProviderFantasy;
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
import FunMod.items.ItemFun;
import FunMod.items.ItemLinkBow;
import FunMod.items.ItemSuperCog;
import FunMod.items.ItemThrowing;
import FunMod.items.ItemThunderDust;
import FunMod.items.ItemTvCima;
import FunMod.items.ItemUpCog;
import FunMod.items.LinkSword;
import FunMod.items.MegaManBot;
import FunMod.items.MegaManChest;
import FunMod.items.MegaManHelm;
import FunMod.items.MegaManLeg;
import FunMod.items.SonicBoots;
import FunMod.items.ThunderBlade;
import FunMod.items.ThunderSword;
import FunMod.loader.FunModHooks;
import FunMod.loader.FunModVersion;
import FunMod.proxy.proxy;
import FunMod.struturas.WorldGeneratorFantasy;
import FunMod.tabs.CTabFun;
import FunMod.tileentidades.EntidadeFantasyFurnace;
import FunMod.tileentidades.EntidadeN64;
import FunMod.tileentidades.EntidadeSofa;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.Type;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
@Mod(modid = "FunMod", name = "FunMod", version = "Beta 1.1.0")
public class FunMod {
	@SidedProxy(clientSide = "FunMod.cliente.proxy.clproxy", serverSide = "FunMod.proxy.proxy")
	public static proxy proxy;
	static ToolMaterial Link = EnumHelper.addToolMaterial("Link", 1, 250, 1, 7,14);
	static ArmorMaterial MegaMan = EnumHelper.addArmorMaterial("MegaMan",30, new int[] {2, 7, 5, 3}, 15);
	static ArmorMaterial Sonic = EnumHelper.addArmorMaterial("Sonic",25, new int[] {2, 7, 5, 3}, 15);
	public static Item UpMushroom; 
	public static Item SuperMushroom;
	public static Item FireFlower;
	public static Item Starman;
	public static Item LinkSword;
	public static  Item ThunderSword;
	public static Item ThunderBlade;
	public static Item MarioCoin;
	public static Item MegaManHelmet;
	public static Item MegaManChest;
	public static Item MegaManPants;
	public static Item MegaManBoots;
	public static Item SonicBoots; 
	public static Item LinkBow;
	public static Item PearlOfLink;
	public static Item Battery;
	public static Item ThunderDust;
	public static Item ObsidianStick;
	public static Item Blade;
	public static Block QuestionBlockTop;
	public static Block QuestionBlockBottom;
	public static Block QuestionBlockSide; 
	public static Block QuestionBlock;
	public static Block BrickBlock;
	public static Block tv;	
	public static  Block FantasyGrass;
	public static Block FantasyStone;
	public static Block FantasyDirt;
	public static Block FantasyLeaf;
	public static Block FantasyLog;
	public static BiomeGenBase FantasyBiome;
	public static Block FantasyPortal;
	public static Block MysticalStone;
	public static Block sofa;
	public static Item controle;
	public static ItemThrowing itemtt;
 	public int var1;
	public static CreativeTabs funmodtab;
	public static Block ativa;
	public static Block desativada;
	public static Item coal;
	public static Item tvcima;
	public static Item nes;
	public static Item mesa;
	public static Block plank;
	public static Block cobble;
	public static int ANIMATED_TEXTURE_INDEX = 1;
	public static String latestVersionNumber;
	public static FunModHooks hooks;
	public static FunModVersion versionNumber = new FunModVersion(1, 0, 0);
	public static String recentNews;
	public static int ticksPassed = 0;
    public static HashMap playerStats = new HashMap();
	public static boolean FlyingEnabled = true;
	@Instance("FunMod")
	public static FunMod instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
	
        funmodtab = new CTabFun(CreativeTabs.getNextID(), "FunMod");
	}	
	
	@EventHandler
	 public void load(FMLInitializationEvent event) 
	 {
		System.out.println("[FunMod] Starting FunMod Init Phase");
		//registrando items e blocos
		UpMushroom = new ItemUpCog(500, 4, false).setPotionEffect(Potion.heal.id , 30, 0, 1.0F).setUnlocalizedName("Up Mushroom"); 	 
		SuperMushroom = new ItemSuperCog(501, 4, false).setPotionEffect(Potion.resistance.id , 30, 0, 1.0F).setUnlocalizedName("Super Mushroom"); 
		FireFlower = (new ItemFun(5000, 5, 1).setUnlocalizedName("Fire Flower").setMaxDamage(20));
		Starman = (new ItemFun(5001, 8, 1).setUnlocalizedName("Starman"));
		LinkSword = (new LinkSword (5002, Link)).setCreativeTab(FunMod.funmodtab).setUnlocalizedName("Link Sword"); 
		ThunderSword = (new ThunderSword (5003, Link)).setCreativeTab(FunMod.funmodtab).setUnlocalizedName("Thunder Sword"); 
		ThunderBlade = (new ThunderBlade(5015).setUnlocalizedName("Thunder Blade")); 
		MarioCoin = (new ItemFun(5004, 6, 16).setUnlocalizedName("Mario Coin"));
	 	MegaManHelmet = (new MegaManHelm(5007,MegaMan, 3, 0)).setUnlocalizedName("MegaMan Helmet");
	 	MegaManChest = (new MegaManChest(5008,MegaMan, 3, 1)).setUnlocalizedName("MegaMan Chest");
	 	 MegaManPants = (new MegaManLeg (5009, MegaMan, 3,2)).setUnlocalizedName("MegaMan Pants");
	 	MegaManBoots = (new MegaManBot (5010, MegaMan , 3,3)).setUnlocalizedName("MegaMan Boots");
	 	SonicBoots = (new SonicBoots (5011, Sonic ,3,3)).setUnlocalizedName("Sonic Boots");
	 	LinkBow = (new ItemLinkBow(5012).setUnlocalizedName("Link Bow").setCreativeTab(FunMod.funmodtab).setUnlocalizedName("Link Bow")); 	
	 	PearlOfLink = (new ItemFun(5016, 10, 64).setUnlocalizedName("Pearl Of Link"));
	 	Battery = (new ItemFun(5017, 7, 64).setUnlocalizedName("Battery"));
	 	ThunderDust = (new ItemThunderDust(5018).setUnlocalizedName("Thunder Dust"));
	 	ObsidianStick = (new ItemFun(5019, 19, 64).setUnlocalizedName("Obsidian Stick"));
	 	Blade = (new ItemFun(5020, 20 , 64).setUnlocalizedName("Blade"));
	 	QuestionBlock = new BlockQuestionBlock(225, 0).setHardness(2F).setResistance(200F).setCreativeTab(FunMod.funmodtab).setBlockName("Question Block"); 
	 	BrickBlock = new BlockBrickBlock(226,0, 0).setHardness(3F).setResistance(200F).setLightValue(0.2F).setCreativeTab(FunMod.funmodtab).setBlockName("Brick Block");
	 	tv = new BlockTv(200,0).setResistance(.5F).setBlockName("Test").setHardness(0.5f);
	 	sofa = new BlockSofa(255, 0, EntidadeN64.class).setResistance(.5F).setBlockName("Sofa").setHardness(0.5f);
	 	FantasyGrass = (new FantasyGrass(210,0).setStepSound(Block.soundTypeGrass).setHardness(0.5F).setResistance(1F).setBlockName("FantasyGrass"));
	 	FantasyStone = (new FantasyStone(211, 0).setHardness((float) 5.0).setStepSound(Block.soundTypeStone).setResistance(1.0F).setBlockName("FantasyStone"));
	 	FantasyDirt = (new FantasyDirt(212,0).setHardness(0.5F).setStepSound(Block.soundTypeGrass).setResistance(0.5F).setBlockName("FantasyDirt"));
	 	FantasyLeaf = (new FantasyLeaf(218, 0)).setHardness(1.0F).setRequiresSelfNotify().setStepSound(Block.soundTypeGrass).setResistance(1.0F).setBlockName("FantasyLeaf");
	 	FantasyLog = (new FantasyLog (217).setResistance(1.0F).setHardness(1.0F).setBlockName("forbiddenLog").setStepSound(Block.soundTypeWood)); 
	 	FantasyBiome = (new BiomeGenFantasy(65));
	 	FantasyPortal = (new BlockFantasyPortal(216, 0).setStepSound(Block.soundTypeWood).setHardness(0.5F).setResistance(1F).setBlockName("FantasyPortal"));	
	 	MysticalStone = (new MysticalStone(215,0, 0).setHardness(5.0F).setStepSound(Block.soundTypeStone).setResistance(1000000.0F).setBlockName("MysticalStone"));
	 	tvcima = (new ItemTvCima(10001).setUnlocalizedName("TvCima"));
	 	nes = (new ItemFun(10005, 36, 64).setUnlocalizedName("Nes"));
	 	mesa = (new ItemFun(10004, 37, 64).setUnlocalizedName("mesa"));
	 	plank = new BlockPlank(2222, 0).setHardness(2F).setResistance(200F).setCreativeTab(FunMod.funmodtab).setBlockName("Plank"); 
	 	cobble = new BlocCobble(2223, 0).setHardness(2F).setResistance(200F).setCreativeTab(FunMod.funmodtab).setBlockName("Cobble"); 
	 	//Item em 3d	 	
	 	controle = (new ItemFun(3025, 35 ,1).setUnlocalizedName("Controle").setCreativeTab(FunMod.funmodtab).setFull3D());
	 	desativada = new FantasyFurnace(2831, false).setBlockName("FantasyFurnace").setHardness(6F).setStepSound(Block.soundMetalFootstep).setCreativeTab(this.funmodtab);
	 	ativa = new FantasyFurnace(2832, true).setBlockName("BrickFurnaceActive").setHardness(6F).setStepSound(Block.soundMetalFootstep);
	 	coal = (new ItemFun(3024 , 46 , 64).setUnlocalizedName("CoaL").setCreativeTab(this.funmodtab));
	 	
	 	
	 	
	 	//geracao de ore
	 	 GameRegistry.registerWorldGenerator(new WorldGeneratorFantasy(), 15);
		 	//registrando blocos
	 	 
	 	GameRegistry.registerBlock(plank, "FMPlank");
	 	GameRegistry.registerBlock(cobble,"FMCobble");
	 	GameRegistry.registerBlock(QuestionBlock,"FMQuestionBlock");
	 	GameRegistry.registerBlock(BrickBlock,"FMBrick");
	 	GameRegistry.registerBlock(FantasyGrass,"FMGras");
	 	GameRegistry.registerBlock(FantasyStone,"FMStone");
	 	GameRegistry.registerBlock(FantasyDirt,"FMDirt");
	 	GameRegistry.registerBlock(FantasyLeaf,"FMLeaf");
	 	GameRegistry.registerBlock(FantasyLog,"FMLLog");
	 	GameRegistry.registerBlock(FantasyPortal,"FMPortal");
	 	GameRegistry.registerBlock(MysticalStone,"FMMStone");
	 	GameRegistry.registerBlock(tv,"FMTv");
	 	GameRegistry.registerBlock(sofa,"FMSofa");
	 	GameRegistry.registerBlock(desativada,"FMFurnace");
	 	//recipes
	    GameRegistry.addRecipe(new ItemStack(controle, 1), (new Object[] {" XY","XZX","HX ", Character.valueOf('X'), ObsidianStick,Character.valueOf('Y'), Item.redstone,Character.valueOf('Z'), Block.stoneButton,Character.valueOf('H'), Item.ingotIron }));  
	    GameRegistry.addSmelting(FantasyLog, new ItemStack(coal,1), 1f);
	    GameRegistry.addSmelting(cobble, new ItemStack(FantasyStone,1), 1f);
	    GameRegistry.addRecipe(new ItemStack(sofa, 1), (new Object[] {" X ","XXX","XXX", Character.valueOf('X'), Block.cloth}));  
	    GameRegistry.addRecipe(new ItemStack(desativada, 1), (new Object[] {"XXX","X X","XXX", Character.valueOf('X'), FantasyStone}));  
	    GameRegistry.addRecipe(new ItemStack (UpMushroom, 1), (new Object[] {"&&&", "&A&","&&&", Character.valueOf('&'),  Block.mushroomBrown , Character.valueOf('A'), Starman}));
	 	GameRegistry.addRecipe(new ItemStack (SuperMushroom, 1), (new Object[] {"&&&", "&A&","&&&", Character.valueOf('&'), Block.mushroomRed , Character.valueOf('A'), Starman}));
	 	GameRegistry.addRecipe(new ItemStack (Starman, 1), (new Object[] {" & ", "&&&"," & ", Character.valueOf('&'), Item.ingotGold }));
	 	GameRegistry.addRecipe(new ItemStack (LinkSword, 1), (new Object[] {" & ", " & "," A ", Character.valueOf('&'), PearlOfLink , Character.valueOf('A'), Item.stick }));
	 	GameRegistry.addRecipe(new ItemStack (ThunderSword, 1), (new Object[] {"   ", " & "," A ", Character.valueOf('&'), ThunderBlade , Character.valueOf('A'), ObsidianStick }));
	 	GameRegistry.addRecipe(new ItemStack (ThunderBlade, 1), (new Object[] {"&&&", "&A&","&&&", Character.valueOf('&'), ThunderDust , Character.valueOf('A'), Blade }));
	 	GameRegistry.addRecipe(new ItemStack (MegaManHelmet, 1), (new Object[] {"A&A", "O O","   ", Character.valueOf('A'), Item.ingotIron , Character.valueOf('&'), Battery , Character.valueOf('O'),  Item.diamond}));
	 	GameRegistry.addRecipe(new ItemStack (MegaManChest, 1), (new Object[] {"A A", "OPO","LOL", Character.valueOf('A'), Item.redstone , Character.valueOf('P'), Battery , Character.valueOf('O'),  Item.ingotIron , Character.valueOf('L'), Item.diamond}));
	 	GameRegistry.addRecipe(new ItemStack (MegaManPants, 1), (new Object[] {"IAI", "A A","O O" , Character.valueOf('A'), Item.ingotIron , Character.valueOf('O'),  Item.redstone , Character.valueOf('I'), Item.diamond}));
	 	GameRegistry.addRecipe(new ItemStack (MegaManBoots, 1), (new Object[] {"   ", "A A","O O" , Character.valueOf('A'), Item.ingotIron , Character.valueOf('O'), Item.redstone}));
	 	GameRegistry.addRecipe(new ItemStack (LinkBow, 1), (new Object[] {" A&", "B &"," A&", Character.valueOf('&'), Item.silk , Character.valueOf('A'), Item.stick , Character.valueOf('B'),  PearlOfLink }));
	 	GameRegistry.addRecipe(new ItemStack (ObsidianStick, 2), (new Object[] {"   " , " & ", " & ", Character.valueOf('&'), Block.obsidian }));
		GameRegistry.addRecipe(new ItemStack (Blade, 1), (new Object[] {"   " , " & ", " & ", Character.valueOf('&'), Item.ingotIron }));
		GameRegistry.addRecipe(new ItemStack (nes, 1), (new Object[] {"   " , "&X&", "&Y&", Character.valueOf('&'), Item.ingotIron,Character.valueOf('X'), Item.diamond, Character.valueOf('Y'), Item.redstone  }));
		GameRegistry.addRecipe(new ItemStack (tvcima, 1), (new Object[] {"&&&" , "&X&", "&&&", Character.valueOf('&'), Item.ingotIron,'X', Block.thinGlass}));
		GameRegistry.addShapelessRecipe(new ItemStack(plank), new Object[] {FantasyLog});
		GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 4), new Object[] {this.plank});
		GameRegistry.addRecipe(new ItemStack (mesa, 1), (new Object[] {"&&&" , "X X", "&&&", Character.valueOf('&'), Block.woodSingleSlab,'X', Item.stick}));
		GameRegistry.addRecipe(new ItemStack (tv, 1), (new Object[] {" & " , " X ", " Z ", Character.valueOf('&'), tvcima,'X', nes, 'Z', mesa}));
		//entidades
		GameRegistry.registerTileEntity(EntidadeN64.class, "Tv");
		GameRegistry.registerTileEntity(EntidadeSofa.class, "Sofa");
		EntityRegistry.registerGlobalEntityID(EntityThrowing.class, "Throwing", 126 );
		EntityRegistry.registerModEntity(EntityThrowing.class, "Throwing" ,126, this, 64, 1, true);
		EntityRegistry.registerGlobalEntityID(EntityLink.class,"Link",100,8510747, 2551400); 
		EntityRegistry.addSpawn(EntityLink.class, 100, 2, 3, EnumCreatureType.creature,  new BiomeGenBase[] {FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome}); 
		
		EntityRegistry.registerGlobalEntityID(EntityNess.class,"Ness",101,25500, 30144255); 
		EntityRegistry.addSpawn(EntityNess.class, 101, 1, 4, EnumCreatureType.creature,  new BiomeGenBase[] {FunMod.FantasyBiome}); 
		
		EntityRegistry.registerGlobalEntityID(EntityMegaMan.class,"Mega Man",102,135206250, 245245245); 
		EntityRegistry.addSpawn(EntityMegaMan.class, 102, 1, 2, EnumCreatureType.creature,  new BiomeGenBase[] {FunMod.FantasyBiome });
		
		EntityRegistry.registerGlobalEntityID(EntityWoody.class,"Woody",103,812712861, 245245245);
		EntityRegistry.addSpawn(EntityWoody.class, 103, 1, 3, EnumCreatureType.creature,  new BiomeGenBase[] {FunMod.FantasyBiome });
		
		EntityRegistry.registerGlobalEntityID(EntityIchigo.class,"Ichigo",104,23344499, 212823623);
		EntityRegistry.addSpawn(EntityIchigo.class, 104, 3, 5, EnumCreatureType.creature,  new BiomeGenBase[] {FunMod.FantasyBiome});
		
		EntityRegistry.registerGlobalEntityID(EntityClyde.class,"Clyde",105,46467576, 212823623);
		EntityRegistry.addSpawn(EntityClyde.class, 105, 3, 7, EnumCreatureType.monster,  new BiomeGenBase[] {FunMod.FantasyBiome}); 
		
		EntityRegistry.registerGlobalEntityID(EntityGoomba.class,"Goomba",106,18271293, 212823623);
		EntityRegistry.addSpawn(EntityGoomba.class, 106, 6, 8, EnumCreatureType.monster,  new BiomeGenBase[] {FunMod.FantasyBiome}); 
		
		EntityRegistry.registerGlobalEntityID(EntityNaruto.class,"Naruto",107,252520, 141415);
		EntityRegistry.addSpawn(EntityNaruto.class, 107, 2, 4, EnumCreatureType.creature,  new BiomeGenBase[] {FunMod.FantasyBiome}); 
		
		EntityRegistry.registerGlobalEntityID(EntityBlinky.class,"Blinky",108,12872382, 141415);
		EntityRegistry.addSpawn(EntityBlinky.class, 108, 8, 12, EnumCreatureType.monster,  new BiomeGenBase[] {FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome}); 
		
		EntityRegistry.registerGlobalEntityID(EntityInky.class,"Inky",109,12872382, 18191918);
		EntityRegistry.addSpawn(EntityInky.class, 109, 3, 5, EnumCreatureType.monster,  new BiomeGenBase[] {FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome});
				
		EntityRegistry.registerGlobalEntityID(EntityPinky.class,"Pinky",110,1281272, 18191918);
		EntityRegistry.addSpawn(EntityPinky.class, 110, 8, 12, EnumCreatureType.monster,  new BiomeGenBase[] {FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome});
		
		EntityRegistry.registerGlobalEntityID(EntityAsh.class,"Ash",111,19291201, 1821928);
		EntityRegistry.addSpawn(EntityAsh.class, 111, 2, 3, EnumCreatureType.creature,  new BiomeGenBase[] {FunMod.FantasyBiome ,  FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome});
		
		EntityRegistry.registerGlobalEntityID(EntityKirby.class,"Kirby",112,80807090, 8512712);
		EntityRegistry.addSpawn(EntityKirby.class, 112, 4, 8, EnumCreatureType.creature,  new BiomeGenBase[] {FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome});
		
		EntityRegistry.registerGlobalEntityID(EntityHomemAranha.class,"Spider Man",113, 60807090, 152152);
		EntityRegistry.addSpawn(EntityHomemAranha.class, 113, 1, 4, EnumCreatureType.creature,  new BiomeGenBase[] {FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome});
		
		EntityRegistry.registerGlobalEntityID(EntityVenom.class,"Venom",114, 9090706, 152152);
		EntityRegistry.addSpawn(EntityVenom.class, 114, 3, 5, EnumCreatureType.monster,  new BiomeGenBase[] {FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome});
		
		EntityRegistry.registerGlobalEntityID(EntityPikachu.class,"Pikachu",115, 80807060, 1515151 );
		EntityRegistry.addSpawn(EntityPikachu.class, 115, 1, 3, EnumCreatureType.creature,  new BiomeGenBase[] {FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome});
		
		EntityRegistry.registerGlobalEntityID(EntityChaos.class,"Chaos",116, 3636363, 1515151 );
		EntityRegistry.addSpawn(EntityChaos.class, 116, 5, 5, EnumCreatureType.monster,  new BiomeGenBase[] {FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome});
		
		EntityRegistry.registerGlobalEntityID(EntityMage.class,"Mage",117, 3636363, 66666666 );
		EntityRegistry.addSpawn(EntityMage.class, 117, 1, 2, EnumCreatureType.monster,  new BiomeGenBase[] {FunMod.FantasyBiome ,  FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome });
		
	    EntityRegistry.registerGlobalEntityID(EntityDarkLink.class,"Dark Link",119, 77777777, 88888888);
	    EntityRegistry.addSpawn(EntityDarkLink.class, 119, 2, 4, EnumCreatureType.monster,  new BiomeGenBase[] {FunMod.FantasyBiome ,  FunMod.FantasyBiome , FunMod.FantasyBiome });
	    
		EntityRegistry.registerGlobalEntityID(EntityGanondorf.class,"Ganondorf",70, 10277912, 16161616);
		EntityRegistry.addSpawn(EntityGanondorf.class, 120, 1, 3, EnumCreatureType.monster,  new BiomeGenBase[] {FunMod.FantasyBiome ,  FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome});
		
		EntityRegistry.registerGlobalEntityID(EntitySephiroth.class,"Sephiroth",121, 10277912, 67676767);
		EntityRegistry.addSpawn(EntitySephiroth.class, 121, 1, 3, EnumCreatureType.monster,  new BiomeGenBase[] {FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome});
		
		EntityRegistry.registerGlobalEntityID(EntityKoopaTroopa.class,"Koopa Troopa",122, 89898090, 67676767);
		EntityRegistry.addSpawn(EntityKoopaTroopa.class, 122, 6, 7, EnumCreatureType.monster,  new BiomeGenBase[] {FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome});
		
		EntityRegistry.registerGlobalEntityID(EntitySonic.class,"Sonic",123, 89898090, 49484047);
		EntityRegistry.addSpawn(EntitySonic.class, 123, 2, 5, EnumCreatureType.creature,  new BiomeGenBase[] {FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome});
		

		EntityRegistry.registerGlobalEntityID(EntityYoshi.class,"Yoshi",124, 13455332, 4234324);
		EntityRegistry.addSpawn(EntityYoshi.class, 124, 2, 5, EnumCreatureType.creature,  new BiomeGenBase[] {FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome});
		
		EntityRegistry.registerGlobalEntityID(EntityDoctorWilly.class,"Doctor Willy",125, 129128918, 88888888);
	    EntityRegistry.addSpawn(EntityDoctorWilly.class, 125, 1, 3, EnumCreatureType.monster,  new BiomeGenBase[] {FunMod.FantasyBiome ,  FunMod.FantasyBiome , FunMod.FantasyBiome });
		
	    EntityRegistry.registerGlobalEntityID(EntityHamtaro.class,"Hamtaro",72, 129128918, 81726162);
	    EntityRegistry.addSpawn(EntityDoctorWilly.class, 125, 1, 3, EnumCreatureType.creature,  new BiomeGenBase[] {FunMod.FantasyBiome ,  FunMod.FantasyBiome , FunMod.FantasyBiome });
	//sistema de proxy	
	proxy.registerRenderThings();
	proxy.renderMobs(); 
	proxy.renderBlocoComModelo();
	proxy.renderItemComModelos(var1);
	proxy.loadTickHandler();
	proxy.rendercontrole();
	FMLCommonHandler.instance().bus().register(new FunModClientTickHandler(Type.WORLD, Side.CLIENT, Phase.START));
	GameRegistry.registerTileEntity(EntidadeFantasyFurnace.class, "EntidadeFantasyFurnace");
	 //Dimensao
      DimensionManager.registerProviderType(10, WorldProviderFantasy.class, false);
      DimensionManager.registerDimension(10, 10);
      System.out.println("[FunMod] Finished FunMod Init Phase Without Any Errors");
      new ThreadGetData();
	 
	 }

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		CommandHandler commandManager = (CommandHandler)event.getServer().getCommandManager();
		commandManager.registerCommand(new CommandFun());
	}
	 
	 }

	    
	    
	    
	    
	    
	    
	










