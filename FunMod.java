package FunMod;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.CommandHandler;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Packet23VehicleSpawn;
import net.minecraft.src.Potion;
import net.minecraft.src.World;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
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
import FunMod.comandos.CommandFun;
import FunMod.comandos.ServerCommandHandler;
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
import FunMod.items.ItemBattery;
import FunMod.items.ItemBlade;
import FunMod.items.ItemCoalF;
import FunMod.items.ItemControle;
import FunMod.items.ItemFireFlower;
import FunMod.items.ItemLinkBow;
import FunMod.items.ItemMarioCoin;
import FunMod.items.ItemObsidianStick;
import FunMod.items.ItemPearl;
import FunMod.items.ItemStarman;
import FunMod.items.ItemSuperCog;
import FunMod.items.ItemThrowing;
import FunMod.items.ItemThunderDust;
import FunMod.items.ItemTvCima;
import FunMod.items.ItemUpCog;
import FunMod.items.Itemmesa;
import FunMod.items.Itemnes;
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

import com.google.common.collect.Maps;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.asm.SideOnly;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
@Mod(modid = "FunMod", name = "FunMod", version = "Beta 1.1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)



public class FunMod {
	@SidedProxy(clientSide = "FunMod.cliente.proxy.clproxy", serverSide = "FunMod.proxy.proxy")
	public static proxy proxy;
	static EnumToolMaterial Link = EnumHelper.addToolMaterial("Link", 1, 250, 1, 7,14);
	static EnumArmorMaterial MegaMan = EnumHelper.addArmorMaterial("MegaMan",30, new int[] {2, 7, 5, 3}, 15);
	static EnumArmorMaterial Sonic = EnumHelper.addArmorMaterial("Sonic",25, new int[] {2, 7, 5, 3}, 15);
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
	public static Item throwItem; 
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
 	private Map<Integer, ISimpleBlockRenderingHandler> blockRenderers = Maps.newHashMap();
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
	@Instance
	public static
	FunMod instance;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event){
		  
		System.out.println("[FunMod] Starting FunMod Pre Init Phase");
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		int UpMushId = config.get("Up MushRoom", "item", 500).getInt();
		int SuperMushId = config.get("Super MushRoom", "item", 501).getInt();
		int FireFlowerId = config.get("Fire Flower", "item", 5000).getInt();
		int StarManId = config.get("Starman", "item", 5001).getInt();
		int LinkSwordId = config.get("Link Sword", "item", 5002).getInt();
		int ThunderSwordId = config.get("Thunder Sword", "item", 5003).getInt();
		int ThunderBladeId = config.get("Thunder Blade", "item", 5015).getInt();
		int MarioCoinId = config.get("Mario Coin", "item", 5004).getInt();
		int MegaManHelId = config.get("MegaMan Helmet", "item", 5007).getInt();
		int MegaManChesId = config.get("MegaMan ChestPlate", "item", 5008).getInt();
		int MegaManPantId = config.get("MegaMan Pants", "item", 5009).getInt();
		int MegaManBotId = config.get("MegaMan Boots", "item", 5010).getInt();
		int SonicBootsId = config.get("Sonic Boots", "item", 5011).getInt();
		int LinkBowId = config.get("Link Bow", "item", 5012).getInt();
		int throwItemId = config.get("Throwing Item", "item", 5013).getInt();
		int PearlId = config.get("Pearl Of Link", "item", 5016).getInt();
		int BatId = config.get("Battery", "item", 5017).getInt();
		int ThunderDustId = config.get("Thunder Dust", "item", 5018).getInt();
		int ObsId = config.get("Obsidian Stick", "item", 5019).getInt();
		int BladeId = config.get("Blade", "item", 5020).getInt();
		int QuestBlId = config.get("Question Block", "block", 225).getInt();
		int BrickId = config.get("Brick Block", "block", 226).getInt();
	    int tvId = config.get("Bloco Tv + N64", "block", 200).getInt();
		int grassId = config.get("Fantasy Grass", "block", 210).getInt();
	    int stoneID = config.get("Fantasy Stone", "block", 211).getInt();
        int dirtID = config.get("Fantasy Dirt", "block", 212).getInt();		
	    int leafId = config.get("Fantasy Leaf", "block", 218).getInt();
        int logID = config.get("Fanatsy Log", "block",218).getInt();
	    int portalId = config.get("Fantasy Portal", "block", 216).getInt();
        int myststoneID = config.get("Mystical Stone", "block", 215).getInt();
        int sofaID = config.get("Sofa", "block", 255).getInt();
        int plankId = config.get("Fantasy Plank", "block", 2222).getInt();
        int cobbleId = config.get("Fantasy Cobblestone", "block", 2223).getInt();
        config.save();
        funmodtab = new CTabFun(CreativeTabs.getNextID(), "FunMod");
		LanguageRegistry.instance().addStringLocalization("itemGroup.FunMod", "FunMod CreativeTabs");
		System.out.println("[FunMod] Finished FunMod Pre Init Phase Without Any Errors");
	}	
	@Init
	 public void load(FMLInitializationEvent event) 
	 {
		System.out.println("[FunMod] Starting FunMod Init Phase");
		//registrando items e blocos
		UpMushroom = new ItemUpCog(500, 4, false).setPotionEffect(Potion.heal.id , 30, 0, 1.0F).setItemName("Up Mushroom"); 	 
		SuperMushroom = new ItemSuperCog(501, 4, false).setPotionEffect(Potion.resistance.id , 30, 0, 1.0F).setItemName("Super Mushroom"); 
		FireFlower = (new ItemFireFlower(5000).setItemName("Fire Flower"));
		Starman = (new ItemStarman(5001).setItemName("Starman"));
		LinkSword = (new LinkSword (5002, Link)).setCreativeTab(FunMod.funmodtab).setItemName("Link Sword"); 
		ThunderSword = (new ThunderSword (5003, Link)).setCreativeTab(FunMod.funmodtab).setItemName("Thunder Sword"); 
		ThunderBlade = (new ThunderBlade(5015).setItemName("Thunder Blade")); 
		MarioCoin = (new ItemMarioCoin(5004).setItemName("Mario Coin"));
	 	MegaManHelmet = (new MegaManHelm(5007,MegaMan, 3, 0)).setItemName("MegaMan Helmet");
	 	MegaManChest = (new MegaManChest(5008,MegaMan, 3, 1)).setItemName("MegaMan Chest");
	 	 MegaManPants = (new MegaManLeg (5009, MegaMan, 3,2)).setItemName("MegaMan Pants");
	 	MegaManBoots = (new MegaManBot (5010, MegaMan , 3,3)).setItemName("MegaMan Boots");
	 	SonicBoots = (new SonicBoots (5011, Sonic ,3,3)).setItemName("Sonic Boots");
	 	LinkBow = (new ItemLinkBow(5012).setItemName("Link Bow").setCreativeTab(FunMod.funmodtab).setItemName("Link Bow")); 
	 	throwItem = (new ItemThrowing(5013).setItemName("Throw Item").setIconIndex(16));
	 	PearlOfLink = (new ItemPearl(5016).setItemName("Pearl Of Link"));
	 	Battery = (new ItemBattery(5017).setItemName("Battery"));
	 	ThunderDust = (new ItemThunderDust(5018).setItemName("Thunder Dust"));
	 	ObsidianStick = (new ItemObsidianStick(5019).setItemName("Obsidian Stick"));
	 	Blade = (new ItemBlade(5020).setItemName("Blade"));
	 	QuestionBlock = new BlockQuestionBlock(225, 0).setHardness(2F).setResistance(200F).setCreativeTab(FunMod.funmodtab).setBlockName("Question Block"); 
	 	BrickBlock = new BlockBrickBlock(226,0, 0).setHardness(3F).setResistance(200F).setLightValue(0.2F).setCreativeTab(FunMod.funmodtab).setBlockName("Brick Block");
	 	tv = new BlockTv(200,0, EntidadeN64.class).setResistance(.5F).setBlockName("Test").setHardness(0.5f);
	 	sofa = new BlockSofa(255, 0, EntidadeN64.class).setResistance(.5F).setBlockName("Sofa").setHardness(0.5f);
	 	FantasyGrass = (new FantasyGrass(210,0).setStepSound(Block.soundGrassFootstep).setHardness(0.5F).setResistance(1F).setBlockName("FantasyGrass"));
	 	FantasyStone = (new FantasyStone(211, 0).setHardness((float) 5.0).setStepSound(Block.soundStoneFootstep).setResistance(1.0F).setBlockName("FantasyStone"));
	 	FantasyDirt = (new FantasyDirt(212,0).setHardness(0.5F).setStepSound(Block.soundGrassFootstep).setResistance(0.5F).setBlockName("FantasyDirt"));
	 	FantasyLeaf = (new FantasyLeaf(218, 0)).setHardness(1.0F).setRequiresSelfNotify().setStepSound(Block.soundGrassFootstep).setResistance(1.0F).setBlockName("FantasyLeaf");
	 	FantasyLog = (new FantasyLog (217).setResistance(1.0F).setHardness(1.0F).setBlockName("forbiddenLog").setStepSound(Block.soundWoodFootstep)); 
	 	FantasyBiome = (new BiomeGenFantasy(65));
	 	FantasyPortal = (new BlockFantasyPortal(216, 0).setStepSound(Block.soundWoodFootstep).setHardness(0.5F).setResistance(1F).setBlockName("FantasyPortal"));	
	 	MysticalStone = (new MysticalStone(215,0, 0).setHardness(5.0F).setStepSound(Block.soundStoneFootstep).setResistance(1000000.0F).setBlockName("MysticalStone"));
	 	tvcima = (new ItemTvCima(10001).setItemName("TvCima"));
	 	nes = (new Itemnes(10005).setItemName("Nes"));
	 	mesa = (new Itemmesa(10004).setItemName("mesa"));
	 	plank = new BlockPlank(2222, 0).setHardness(2F).setResistance(200F).setCreativeTab(FunMod.funmodtab).setBlockName("Plank"); 
	 	cobble = new BlocCobble(2223, 0).setHardness(2F).setResistance(200F).setCreativeTab(FunMod.funmodtab).setBlockName("Cobble"); 
	 	//Item em 3d	 	
	 	controle = (new ItemControle(3025).setItemName("Controle").setCreativeTab(FunMod.funmodtab));
	 	desativada = new FantasyFurnace(2831, false).setBlockName("FantasyFurnace").setHardness(6F).setStepSound(Block.soundMetalFootstep).setCreativeTab(this.funmodtab);
	 	ativa = new FantasyFurnace(2832, true).setBlockName("BrickFurnaceActive").setHardness(6F).setStepSound(Block.soundMetalFootstep);
	 	coal = (new ItemCoalF(3024).setItemName("CoaL").setCreativeTab(this.funmodtab));
	 	
	 	
	 	
	 	//geracao de ore
	 	 GameRegistry.registerWorldGenerator(new WorldGeneratorFantasy());
		 	//registrando blocos
	 	GameRegistry.registerBlock(plank);
	 	GameRegistry.registerBlock(cobble);
	 	GameRegistry.registerBlock(QuestionBlock);
	 	GameRegistry.registerBlock(BrickBlock);
	 	GameRegistry.registerBlock(FantasyGrass);
	 	GameRegistry.registerBlock(FantasyStone);
	 	GameRegistry.registerBlock(FantasyDirt);
	 	GameRegistry.registerBlock(FantasyLeaf);
	 	GameRegistry.registerBlock(FantasyLog);
	 	GameRegistry.registerBlock(FantasyPortal);
	 	GameRegistry.registerBlock(MysticalStone);
	 	GameRegistry.registerBlock(tv);
	 	GameRegistry.registerBlock(sofa);
	 	GameRegistry.registerBlock(desativada);
	 	 NetworkRegistry.instance().registerGuiHandler(instance, proxy);
	 	//nomes
	 	
	 	 
	 	LanguageRegistry.addName(plank,"Fantasy Plank");
	 	LanguageRegistry.addName(cobble,"Fantasy Cobblestone");
	 	LanguageRegistry.addName(controle,"Control");
	 	LanguageRegistry.addName(mesa,"Desk");
	 	LanguageRegistry.addName(nes, "Nintendo 64");
	 	LanguageRegistry.addName(tvcima, "A Little Tv");	
	 	LanguageRegistry.addName(coal, "Fantasy Coal");
	 	LanguageRegistry.addName(desativada, "Fantasy Furnace");
	 	LanguageRegistry.addName(FantasyGrass, "Fantasy Grass");
	 	LanguageRegistry.addName(FantasyStone, "Fantasy Stone");
	 	LanguageRegistry.addName(FantasyDirt, "Fantasy Dirt");
	 	LanguageRegistry.addName(FantasyLeaf, "Fantasy Leaf");
	 	LanguageRegistry.addName(FantasyLog, "Fantasy Log");
	 	LanguageRegistry.addName(FantasyPortal, "Fantasy Portal");
	 	LanguageRegistry.addName(MysticalStone, "Mystical Stone");
	 	LanguageRegistry.addName(UpMushroom, "Up Mushroom");
	 	LanguageRegistry.addName(SuperMushroom, "Super Mushroom");
	 	LanguageRegistry.addName(FireFlower, "Fire Flower");
	 	LanguageRegistry.addName(Starman, "Starman");
	 	LanguageRegistry.addName(LinkSword, "Link Sword");
	 	LanguageRegistry.addName(ThunderSword, "Thunder Sword");
	 	LanguageRegistry.addName(ThunderBlade, "Thunder Blade");
	 	LanguageRegistry.addName(MarioCoin, "Mario Coin");
	 	LanguageRegistry.addName(LinkBow, "Link Bow");
	 	LanguageRegistry.addName(MegaManHelmet, "MegaMan Helmet");
	 	LanguageRegistry.addName(MegaManChest, "MegaMan Chestplate");
	 	LanguageRegistry.addName(MegaManPants, "MegaMan Pants");
	 	LanguageRegistry.addName(MegaManBoots, "MegaMan Shoes");
	 	LanguageRegistry.addName(SonicBoots, "Sonic Shoes");
	 	LanguageRegistry.addName(PearlOfLink, "Pearl Of Link");
	 	LanguageRegistry.addName(Battery, "Battery");
	 	LanguageRegistry.addName(ThunderDust, "ThunderDust");
	 	LanguageRegistry.addName(ObsidianStick, "Obsidian Stick");
	 	LanguageRegistry.addName(Blade, "Blade");
	    LanguageRegistry.addName(BrickBlock,"BrickBlock");
	 	LanguageRegistry.addName(throwItem, "Throwing Item");
	    LanguageRegistry.addName(QuestionBlock, "Question Block");
	 	LanguageRegistry.addName(tv, "Tv with Nintendo 64");
	    LanguageRegistry.addName(sofa, "Sofa");
	 	//recipes
	    GameRegistry.addRecipe(new ItemStack(controle, 1), (new Object[] {" XY","XZX","HX ", Character.valueOf('X'), ObsidianStick,Character.valueOf('Y'), Item.redstone,Character.valueOf('Z'), Block.stoneButton,Character.valueOf('H'), Item.ingotIron }));  
	    GameRegistry.addSmelting(FantasyLog.blockID, new ItemStack(coal,1), 1f);
	    GameRegistry.addSmelting(cobble.blockID, new ItemStack(FantasyStone,1), 1f);
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
		EntityRegistry.addSpawn(EntityLink.class, 100, 2, 3, EnumCreatureType.creature,  new BiomeGenBase[] {BiomeGenBase.forest , FunMod.FantasyBiome , FunMod.FantasyBiome}); 
		
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
		EntityRegistry.addSpawn(EntityHomemAranha.class, 113, 1, 4, EnumCreatureType.creature,  new BiomeGenBase[] {BiomeGenBase.forest , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome});
		
		EntityRegistry.registerGlobalEntityID(EntityVenom.class,"Venom",114, 9090706, 152152);
		EntityRegistry.addSpawn(EntityVenom.class, 114, 3, 5, EnumCreatureType.monster,  new BiomeGenBase[] {BiomeGenBase.forest , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome});
		
		EntityRegistry.registerGlobalEntityID(EntityPikachu.class,"Pikachu",115, 80807060, 1515151 );
		EntityRegistry.addSpawn(EntityPikachu.class, 115, 1, 3, EnumCreatureType.creature,  new BiomeGenBase[] {BiomeGenBase.forest , FunMod.FantasyBiome , FunMod.FantasyBiome , FunMod.FantasyBiome});
		
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
	GameRegistry.registerTileEntity(EntidadeFantasyFurnace.class, "EntidadeFantasyFurnace");
	//nome dos mobs
	  LanguageRegistry.instance().addStringLocalization("entity.Link.name","pt_BR","Link"); 
      LanguageRegistry.instance().addStringLocalization("entity.Link.name","Link");
		
      LanguageRegistry.instance().addStringLocalization("entity.Ness.name","pt_BR","Ness"); 
      LanguageRegistry.instance().addStringLocalization("entity.Ness.name","Ness");
      
      LanguageRegistry.instance().addStringLocalization("entity.Mega Man.name","pt_BR","Mega Man"); 
      LanguageRegistry.instance().addStringLocalization("entity.Mega Man.name","Mega Man");
      
      LanguageRegistry.instance().addStringLocalization("entity.Woody.name","pt_BR","Woody"); 
      LanguageRegistry.instance().addStringLocalization("entity.Woody.name","Woody");
      
      LanguageRegistry.instance().addStringLocalization("entity.Ichigo.name","pt_BR","Ichigo"); 
      LanguageRegistry.instance().addStringLocalization("entity.Ichigo.name","Ichigo");
      
      LanguageRegistry.instance().addStringLocalization("entity.Clyde.name","pt_BR","Clyde"); 
      LanguageRegistry.instance().addStringLocalization("entity.Clyde.name","Clyde");
      
      LanguageRegistry.instance().addStringLocalization("entity.Goomba.name","pt_BR","Goomba"); 
      LanguageRegistry.instance().addStringLocalization("entity.Goomba.name","Goomba");
      
      LanguageRegistry.instance().addStringLocalization("entity.Naruto.name","pt_BR","Naruto"); 
      LanguageRegistry.instance().addStringLocalization("entity.Naruto.name","Naruto");
      
      LanguageRegistry.instance().addStringLocalization("entity.Blinky.name","pt_BR","Blinky"); 
      LanguageRegistry.instance().addStringLocalization("entity.Blinky.name","Blinky");
      
      LanguageRegistry.instance().addStringLocalization("entity.Inky.name","pt_BR","Inky"); 
      LanguageRegistry.instance().addStringLocalization("entity.Inky.name","Inky");
      
	  LanguageRegistry.instance().addStringLocalization("entity.Pinky.name","pt_BR","Pinky"); 
      LanguageRegistry.instance().addStringLocalization("entity.Pinky.name","Pinky");
      
      LanguageRegistry.instance().addStringLocalization("entity.Ash.name","pt_BR","Ash"); 
      LanguageRegistry.instance().addStringLocalization("entity.Ash.name","Ash");
      
      LanguageRegistry.instance().addStringLocalization("entity.Kirby.name","pt_BR","Kirby"); 
      LanguageRegistry.instance().addStringLocalization("entity.Kirby.name","Kirby");
	
      
      LanguageRegistry.instance().addStringLocalization("entity.Spider Man.name","pt_BR","Spider Man"); 
      LanguageRegistry.instance().addStringLocalization("entity.Spider Man.name","Spider Man");
      
      
      LanguageRegistry.instance().addStringLocalization("entity.Venom.name","pt_BR","Venom"); 
      LanguageRegistry.instance().addStringLocalization("entity.Venom.name","Venom"); 
	
      
      LanguageRegistry.instance().addStringLocalization("entity.Pikachu.name","pt_BR","Pikachu"); 
      LanguageRegistry.instance().addStringLocalization("entity.Pikachu.name","Pikachu"); 
	
      
      LanguageRegistry.instance().addStringLocalization("entity.Chaos.name","pt_BR","Chaos"); 
      LanguageRegistry.instance().addStringLocalization("entity.Chaos.name","Chaos"); 
	
      LanguageRegistry.instance().addStringLocalization("entity.Mage.name","pt_BR","Mage"); 
      LanguageRegistry.instance().addStringLocalization("entity.Mage.name","Mage"); 

      
      LanguageRegistry.instance().addStringLocalization("entity.Dark Link.name","pt_BR","Dark Link"); 
      LanguageRegistry.instance().addStringLocalization("entity.Dark Link.name","Dark Link"); 
      
      LanguageRegistry.instance().addStringLocalization("entity.Ganondorf.name","pt_BR","Ganondorf"); 
      LanguageRegistry.instance().addStringLocalization("entity.Ganondorf.name","Ganondorf"); 
      
      
      LanguageRegistry.instance().addStringLocalization("entity.Sephiroth.name","pt_BR","Sephiroth"); 
      LanguageRegistry.instance().addStringLocalization("entity.Sephiroth.name","Sephiroth"); 
	
      LanguageRegistry.instance().addStringLocalization("entity.Koopa Troopa.name","pt_BR","Koopa Troopa"); 
      LanguageRegistry.instance().addStringLocalization("entity.Koopa Troopa.name","Koopa Troopa"); 
	
      LanguageRegistry.instance().addStringLocalization("entity.Sonic.name","pt_BR","Sonic"); 
      LanguageRegistry.instance().addStringLocalization("entity.Sonic.name","Sonic"); 
	
      LanguageRegistry.instance().addStringLocalization("entity.Yoshi.name","pt_BR","Yoshi"); 
      LanguageRegistry.instance().addStringLocalization("entity.Yoshi.name","Yoshi"); 
	
      LanguageRegistry.instance().addStringLocalization("entity.Doctor Willy.name","pt_BR","Doctor Willy"); 
      LanguageRegistry.instance().addStringLocalization("entity.Doctor Willy.name","Doctor Willy"); 
	
      LanguageRegistry.instance().addStringLocalization("entity.Hamtaro.name","pt_BR","Hamtaro"); 
      LanguageRegistry.instance().addStringLocalization("entity.Hamtaro.name","Hamtaro"); 
	 //Dimensao
      DimensionManager.registerProviderType(10, WorldProviderFantasy.class, false);
      DimensionManager.registerDimension(10, 10);
	  
	
      System.out.println("[FunMod] Finished FunMod Init Phase Without Any Errors");
      new ThreadGetData();
	 
	 }
	@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{
		System.out.println("[FunMod] PostInit Phase started.");
		System.out.println("[FunMod] PostInit Phase completed sucefull.");
	}

	@SideOnly(Side.SERVER)
	public void registerServerCommands()
	{
		ServerCommandHandler.initialize();
	}	
	@ServerStarting
	public void serverStarting(FMLServerStartingEvent event) {
		CommandHandler commandManager = (CommandHandler)event.getServer().getCommandManager();
		commandManager.registerCommand(new CommandFun());
	}
	/**
	public static float getMoveStrafing(EntityPlayer var0)
	    {
	        return var0.worldObj.isRemote ? var0.moveStrafing : 0.0F;
	    }

	    public static float getMoveForward(EntityPlayer var0)
	    {
	        return var0.worldObj.isRemote ? var0.moveForward : 0.0F;
	    }
	  **/ 
	    // sistema relacionado a packets (Nao precisa implementar IPacketHandler pois ja existe um packet pra entidades)
	 public Entity spawnEntity(int var1, World var2, double var3, double var5, double var7)
	    {
	             if(var1 == 497)
	             {
	                     return new EntityThrowing( var2, var3, var5, var7 );
	             }
	             else
	             {
	                     return null;
	             }
	            
	    }

	 public Packet23VehicleSpawn getSpawnPacket(Entity var1, int var2)
	    {
	             if(var1 instanceof EntityThrowing)
	             {
	                     return new Packet23VehicleSpawn( var1, 497 );
	             }
	             else
	             {
	                     return null;
	             }
	    }
	 public static boolean isSpacebarPressed(EntityPlayer var0)
	    {
	        return var0.worldObj.isRemote ? Minecraft.getMinecraft().gameSettings.keyBindJump.pressed : (!playerStats.containsKey(var0) ? false : ((float[])playerStats.get(var0))[5] == 1.0F);
	    }

	    public static boolean isShiftbarPressed(EntityPlayer var0)
	    {
	        return var0.worldObj.isRemote ? Minecraft.getMinecraft().gameSettings.keyBindSneak.pressed : (!playerStats.containsKey(var0) ? false : ((float[])playerStats.get(var0))[6] == 1.0F);
	    }
		public static boolean isJumping(EntityPlayer rider) {
			
			return rider.worldObj.isRemote ? rider.isJumping : false;
		}

	 
	 }

	    
	    
	    
	    
	    
	    
	










