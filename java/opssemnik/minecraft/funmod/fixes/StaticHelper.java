package opssemnik.minecraft.funmod.fixes;

import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.util.EnumHelper;
import FunMod.FunMod;
import FunMod.blocks.BlockFantasyPortal;
import FunMod.blocks.BlockPlank;
import FunMod.blocks.BlockQuestionBlock;
import FunMod.blocks.BlockSofa;
import FunMod.blocks.BlockTv;
import FunMod.blocks.FantasyFurnace;
import FunMod.blocks.FantasyGrass;
import FunMod.blocks.FantasyLeaf;
import FunMod.blocks.FantasyLog;
import FunMod.blocks.FantasyStone;
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
import FunMod.tileentidades.EntidadeN64;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class StaticHelper {
 public static class FMItemLoader {
		static ToolMaterial Link = EnumHelper.addToolMaterial("Link", 1, 250, 1, 7,
				14);
		static ArmorMaterial MegaMan = EnumHelper.addArmorMaterial("MegaMan", 30,
				new int[] { 2, 7, 5, 3 }, 15);
		static ArmorMaterial Sonic = EnumHelper.addArmorMaterial("Sonic", 25,
				new int[] { 2, 7, 5, 3 }, 15);
		public static Item UpMushroom;
		public static Item SuperMushroom;
		public static Item FireFlower;
		public static Item Starman;
		public static Item LinkSword;
		public static Item ThunderSword;
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
		public static Item controle;
		public static Item coal;
		public static Item tvcima;
		public static Item nes;
		public static Item mesa;
	 public FMItemLoader(){
			UpMushroom = new FMItemHelper.FMItemFoodHelper(4).setPotionEffect(Potion.heal.id, 30, 0, 1.0F).setUnlocalizedName("UPM");
			SuperMushroom = new FMItemHelper.FMItemFoodHelper(4).setPotionEffect(Potion.resistance.id, 30, 0, 1.0F).setUnlocalizedName("SPM");
			FireFlower = (new FMItemHelper().setUnlocalizedName("fireFlower").setMaxDamage(20));
			Starman = (new FMItemHelper().setUnlocalizedName("Starman"));
			LinkSword = (new FMItemHelper.FMItemSwordHelper(Link)).setUnlocalizedName("LNK");
			ThunderSword = (new FMItemHelper.FMItemSwordHelper(Link)).setUnlocalizedName("TSW");
			ThunderBlade = (new FMItemHelper().setUnlocalizedName("ThunderBlade"));
			MarioCoin = (new FMItemHelper().setUnlocalizedName("MarioCoin"));
			MegaManHelmet = (new FMItemHelper.FMItemArmorHelper(MegaMan, 3, 0)).setUnlocalizedName("MegaManHelmet");
			MegaManChest = (new FMItemHelper.FMItemArmorHelper(MegaMan, 3, 1)).setUnlocalizedName("MegaManChest");
			MegaManPants = (new FMItemHelper.FMItemArmorHelper(MegaMan, 3, 2)).setUnlocalizedName("MegaManPants");
			MegaManBoots = (new FMItemHelper.FMItemArmorHelper(MegaMan, 3, 3)).setUnlocalizedName("MegaManBoots");
			SonicBoots = (new FMItemHelper.FMItemArmorHelper(Sonic, 3, 3)).setUnlocalizedName("SonicBoots");
			LinkBow = (new FMItemHelper.FMItemBowHelper().setUnlocalizedName("LinkBow"));
			PearlOfLink = (new FMItemHelper().setUnlocalizedName("PearlOfLink"));
			Battery = (new FMItemHelper().setUnlocalizedName("Battery"));
			ThunderDust = (new FMItemHelper().setUnlocalizedName("ThunderDust"));
			ObsidianStick = (new FMItemHelper().setUnlocalizedName("ObsidianStick"));
			Blade = (new FMItemHelper().setUnlocalizedName("Blade"));
			nes = new FMItemHelper().setUnlocalizedName("Nes");
			mesa = new FMItemHelper().setUnlocalizedName("mesa");
			controle = (new FMItemHelper().setUnlocalizedName("Controle").setFull3D());
			coal = (new FMItemHelper().setUnlocalizedName("CoaL"));
			tvcima = (new FMItemHelper().setUnlocalizedName("TvCima"));
	 }
	 public void loadRecipes() {
			GameRegistry.addRecipe(new ItemStack(controle, 1),(new Object[] { " XY", "XZX", "HX ", Character.valueOf('X'),
							ObsidianStick, Character.valueOf('Y'), Items.redstone,
							Character.valueOf('Z'), Blocks.stone_button,
							Character.valueOf('H'), Items.iron_ingot }));	
			GameRegistry.addRecipe(new ItemStack(UpMushroom, 1), (new Object[] {
					"&&&", "&A&", "&&&", Character.valueOf('&'),
					Blocks.brown_mushroom, Character.valueOf('A'), Starman }));
			GameRegistry.addRecipe(new ItemStack(SuperMushroom, 1), (new Object[] {
					"&&&", "&A&", "&&&", Character.valueOf('&'),
					Blocks.red_mushroom, Character.valueOf('A'), Starman }));
			GameRegistry.addRecipe(new ItemStack(Starman, 1),
					(new Object[] { " & ", "&&&", " & ", Character.valueOf('&'),
							Items.gold_ingot }));
			GameRegistry.addRecipe(new ItemStack(LinkSword, 1), (new Object[] {
					" & ", " & ", " A ", Character.valueOf('&'), PearlOfLink,
					Character.valueOf('A'), Items.stick }));
			GameRegistry.addRecipe(new ItemStack(ThunderSword, 1), (new Object[] {
					"   ", " & ", " A ", Character.valueOf('&'), ThunderBlade,
					Character.valueOf('A'), ObsidianStick }));
			GameRegistry.addRecipe(new ItemStack(ThunderBlade, 1), (new Object[] {
					"&&&", "&A&", "&&&", Character.valueOf('&'), ThunderDust,
					Character.valueOf('A'), Blade }));
			GameRegistry.addRecipe(new ItemStack(MegaManHelmet, 1), (new Object[] {
					"A&A", "O O", "   ", Character.valueOf('A'), Items.iron_ingot,
					Character.valueOf('&'), Battery, Character.valueOf('O'),
					Items.diamond }));
			GameRegistry.addRecipe(new ItemStack(MegaManChest, 1), (new Object[] {
					"A A", "OPO", "LOL", Character.valueOf('A'), Items.redstone,
					Character.valueOf('P'), Battery, Character.valueOf('O'),
					Items.iron_ingot, Character.valueOf('L'), Items.diamond }));
			GameRegistry.addRecipe(new ItemStack(MegaManPants, 1), (new Object[] {
					"IAI", "A A", "O O", Character.valueOf('A'), Items.iron_ingot,
					Character.valueOf('O'), Items.redstone, Character.valueOf('I'),
					Items.diamond }));
			GameRegistry.addRecipe(new ItemStack(MegaManBoots, 1), (new Object[] {
					"   ", "A A", "O O", Character.valueOf('A'), Items.iron_ingot,
					Character.valueOf('O'), Items.redstone }));
			GameRegistry.addRecipe(new ItemStack(LinkBow, 1), (new Object[] {
					" A&", "B &", " A&", Character.valueOf('&'), Items.string,
					Character.valueOf('A'), Items.stick, Character.valueOf('B'),
					PearlOfLink }));
			GameRegistry
					.addRecipe(new ItemStack(ObsidianStick, 2), (new Object[] {
							"   ", " & ", " & ", Character.valueOf('&'),
							Blocks.obsidian }));
			GameRegistry.addRecipe(new ItemStack(Blade, 1), (new Object[] { "   ",
					" & ", " & ", Character.valueOf('&'), Items.iron_ingot }));
			GameRegistry.addRecipe(new ItemStack(nes, 1), (new Object[] { "   ",
					"&X&", "&Y&", Character.valueOf('&'), Items.iron_ingot,
					Character.valueOf('X'), Items.diamond, Character.valueOf('Y'),
					Items.redstone }));
			GameRegistry.addRecipe(new ItemStack(tvcima, 1), (new Object[] { "&&&",
					"&X&", "&&&", Character.valueOf('&'), Items.iron_ingot, 'X',
					Blocks.glass_pane }));
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 4),
					new Object[] { FMBlockLoader.plank });
			GameRegistry.addRecipe(new ItemStack(mesa, 1), (new Object[] { "&&&",
					"X X", "&&&", Character.valueOf('&'), Blocks.wooden_slab, 'X',
					Items.stick }));
			GameRegistry.addRecipe(new ItemStack(FMBlockLoader.tv, 1), (new Object[] { " & ",
					" X ", " Z ", Character.valueOf('&'), tvcima, 'X', nes, 'Z',
					mesa }));
	 }
	 public void registerItems() {
		 Field[] items = this.getClass().getDeclaredFields();
		 for(Field item : items){
			 try {
				if(item.get(this).getClass().getSuperclass().getName().contains("Item")){
					 try {
						GameRegistry.registerItem((Item)item.get(this), String.format("FM_ITEM_%s",item.getName()));
					} catch (IllegalArgumentException e) {
					} catch (IllegalAccessException e) {
					}
				 }
			} catch (IllegalArgumentException e) {
			} catch (IllegalAccessException e) {

			}
		 }
	 }
 }
 public static class FMBlockLoader{
		public static Block QuestionBlock;
		public static Block BrickBlock;
		public static Block tv;
		public static Block FantasyGrass;
		public static Block FantasyStone;
		public static Block FantasyDirt;
		public static Block FantasyLeaf;
		public static Block FantasyLog;
		public static Block FantasyPortal;
		public static Block MysticalStone;
		public static Block sofa;
		public static Block ativa;
		public static Block desativada;
		public static Block plank;
		public static Block cobble;
	 public FMBlockLoader(){
		 QuestionBlock = new BlockQuestionBlock(225, 0).setHardness(2F).setResistance(200F).setBlockName("QuestionBlock");
		 BrickBlock = new FMBlockHelper(Material.rock).setHardness(3F).setResistance(200F).setBlockName("BrickBlock");
		 tv = new BlockTv(200, 0).setResistance(.5F).setBlockName("Test").setHardness(0.5f);
		 sofa = new BlockSofa(255, 0, EntidadeN64.class).setResistance(.5F).setBlockName("Sofa").setHardness(0.5f);
		 FantasyGrass = (new FantasyGrass(210, 0).setStepSound(Block.soundTypeGrass).setHardness(0.5F).setResistance(1F).setBlockName("FantasyGrass"));
		 FantasyStone = (new FantasyStone(211, 0).setHardness((float) 5.0).setStepSound(Block.soundTypeStone).setResistance(1.0F).setBlockName("FantasyStone"));
		 FantasyDirt = (new FMBlockHelper(Material.ground).setHardness(0.5F).setStepSound(Block.soundTypeGrass).setResistance(0.5F).setBlockName("FantasyDirt"));
		 FantasyLeaf = (new FantasyLeaf(218, 0)).setHardness(1.0F).setStepSound(Block.soundTypeGrass).setResistance(1.0F).setBlockName("FantasyLeaf");
		 FantasyLog = (new FantasyLog(217).setResistance(1.0F).setHardness(1.0F).setBlockName("forbiddenLog").setStepSound(Block.soundTypeWood));		 
		 FantasyPortal = (new BlockFantasyPortal(216, 0).setStepSound(Block.soundTypeWood).setHardness(0.5F).setResistance(1F).setBlockName("FantasyPortal"));
	     MysticalStone = (new FMBlockHelper(Material.rock).setHardness(5.0F).setStepSound(Block.soundTypeStone).setResistance(1000000.0F).setBlockName("MysticalStone"));
	     plank = new BlockPlank(2222, 0).setHardness(2F).setResistance(200F).setCreativeTab(FunMod.funmodtab).setBlockName("Plank");
	     cobble = new FMBlockHelper(Material.rock).setHardness(2F).setResistance(200F).setBlockName("Cobble");
	     desativada = new FantasyFurnace(2831, false).setBlockName("FantasyFurnace").setHardness(6F).setStepSound(Block.soundTypeMetal);
	     ativa = new FantasyFurnace(2832, true).setBlockName("BrickFurnaceActive").setHardness(6F).setStepSound(Block.soundTypeMetal);
	 }
	 public void registerBlockRecipes(){
			GameRegistry.addShapelessRecipe(new ItemStack(plank),
					new Object[] { FantasyLog });
			GameRegistry.addSmelting(FantasyLog, new ItemStack(StaticHelper.FMItemLoader.coal, 1), 1f);
			GameRegistry.addSmelting(cobble, new ItemStack(FantasyStone, 1), 1f);
			GameRegistry.addRecipe(new ItemStack(sofa, 1), (new Object[] { " X ","XXX", "XXX", Character.valueOf('X'), Blocks.wool }));
			GameRegistry.addRecipe(new ItemStack(desativada, 1), (new Object[] {"XXX", "X X", "XXX", Character.valueOf('X'), FantasyStone }));
	 }
	 public void registerBlocks() {
		 Field[] items = this.getClass().getDeclaredFields();
		 for(Field item : items){
			 try {
				if(item.get(this).getClass().getSuperclass().getName().contains("Block")){
					 try {
						GameRegistry.registerBlock((Block)item.get(this), String.format("FM_BLOCK_%s",item.getName()));
					} catch (IllegalArgumentException e) {
					} catch (IllegalAccessException e) {
					}
				 }
			} catch (IllegalArgumentException e) {
			} catch (IllegalAccessException e) {

			}
		 }
	 }
 }
 public static class FMEntityLoader{
	 public FMEntityLoader(){
		EntityRegistry.registerGlobalEntityID(EntityThrowing.class, "Throwing",EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityThrowing.class, "Throwing", EntityRegistry.findGlobalUniqueEntityId(),FunMod.instance, 64, 1, true);
		EntityRegistry.registerGlobalEntityID(EntityLink.class, "Link", EntityRegistry.findGlobalUniqueEntityId(),8510747, 2551400);
		EntityRegistry.addSpawn(EntityLink.class, 100, 2, 3,EnumCreatureType.creature, new BiomeGenBase[] {FunMod.FantasyBiome, });
		EntityRegistry.registerGlobalEntityID(EntityNess.class, "Ness", EntityRegistry.findGlobalUniqueEntityId(),25500, 30144255);
		EntityRegistry.addSpawn(EntityNess.class, 182, 1, 4,EnumCreatureType.creature,new BiomeGenBase[] { FunMod.FantasyBiome });
		EntityRegistry.registerGlobalEntityID(EntityMegaMan.class, "MegaMan",EntityRegistry.findGlobalUniqueEntityId(), 135206250, 245245245);
		EntityRegistry.addSpawn(EntityMegaMan.class, 102, 1, 2,EnumCreatureType.creature,	new BiomeGenBase[] { FunMod.FantasyBiome });
		EntityRegistry.registerGlobalEntityID(EntityWoody.class, "Woody", EntityRegistry.findGlobalUniqueEntityId(),812712861, 245245245);
		EntityRegistry.addSpawn(EntityWoody.class, EntityRegistry.findGlobalUniqueEntityId(), 1, 3,EnumCreatureType.creature,new BiomeGenBase[] { FunMod.FantasyBiome });
		EntityRegistry.registerGlobalEntityID(EntityIchigo.class, "Ichigo",	EntityRegistry.findGlobalUniqueEntityId(), 23344499, 212823623);
		EntityRegistry.addSpawn(EntityIchigo.class, 104, 3, 5,EnumCreatureType.creature,new BiomeGenBase[] { FunMod.FantasyBiome });
		EntityRegistry.registerGlobalEntityID(EntityClyde.class, "Clyde", EntityRegistry.findGlobalUniqueEntityId(),46467576, 212823623);
		EntityRegistry.addSpawn(EntityClyde.class, 105, 3, 7,EnumCreatureType.monster,new BiomeGenBase[] { FunMod.FantasyBiome });
		EntityRegistry.registerGlobalEntityID(EntityGoomba.class, "Goomba",EntityRegistry.findGlobalUniqueEntityId(), 18271293, 212823623);
		EntityRegistry.addSpawn(EntityGoomba.class, 106, 6, 8,EnumCreatureType.monster,new BiomeGenBase[] { FunMod.FantasyBiome });
		EntityRegistry.registerGlobalEntityID(EntityNaruto.class, "Naruto",	EntityRegistry.findGlobalUniqueEntityId(), 252520, 141415);
		EntityRegistry.addSpawn(EntityNaruto.class, 107, 2, 4,	EnumCreatureType.creature,new BiomeGenBase[] { FunMod.FantasyBiome });EntityRegistry.registerGlobalEntityID(EntityBlinky.class, "Blinky",		EntityRegistry.findGlobalUniqueEntityId(), 12872382, 141415);
		EntityRegistry.addSpawn(EntityBlinky.class, 108, 8, 12,	EnumCreatureType.monster, new BiomeGenBase[] {FunMod.FantasyBiome, });
		EntityRegistry.registerGlobalEntityID(EntityInky.class, "Inky", EntityRegistry.findGlobalUniqueEntityId(),12872382, 18191918);
		EntityRegistry.addSpawn(EntityInky.class, 109, 3, 5,EnumCreatureType.monster, new BiomeGenBase[] {FunMod.FantasyBiome });
		EntityRegistry.registerGlobalEntityID(EntityPinky.class, "Pinky", EntityRegistry.findGlobalUniqueEntityId(),1281272, 18191918);
		EntityRegistry.addSpawn(EntityPinky.class, 110, 8, 12,EnumCreatureType.monster, new BiomeGenBase[] {FunMod.FantasyBiome });
		EntityRegistry.registerGlobalEntityID(EntityAsh.class, "Ash", EntityRegistry.findGlobalUniqueEntityId(),19291201, 1821928);
		EntityRegistry.addSpawn(EntityAsh.class, 111, 2, 3,EnumCreatureType.creature, new BiomeGenBase[] {FunMod.FantasyBiome });
		EntityRegistry.registerGlobalEntityID(EntityKirby.class, "Kirby", EntityRegistry.findGlobalUniqueEntityId(),80807090, 8512712);
		EntityRegistry.addSpawn(EntityKirby.class, 112, 4, 8,EnumCreatureType.creature, new BiomeGenBase[] {	FunMod.FantasyBiome });
		EntityRegistry.registerGlobalEntityID(EntityHomemAranha.class,"Spider Man", EntityRegistry.findGlobalUniqueEntityId(), 60807090, 152152);
		EntityRegistry.addSpawn(EntityHomemAranha.class, 113, 1, 4,EnumCreatureType.creature, new BiomeGenBase[] {FunMod.FantasyBiome});
		EntityRegistry.registerGlobalEntityID(EntityVenom.class, "Venom", EntityRegistry.findGlobalUniqueEntityId(),9090706, 152152);
		EntityRegistry.addSpawn(EntityVenom.class, 114, 3, 5,EnumCreatureType.monster, new BiomeGenBase[] {	FunMod.FantasyBiome });
		EntityRegistry.registerGlobalEntityID(EntityPikachu.class, "Pikachu",	EntityRegistry.findGlobalUniqueEntityId(), 80807060, 1515151);
		EntityRegistry.addSpawn(EntityPikachu.class, 115, 1, 3,EnumCreatureType.creature, new BiomeGenBase[] {FunMod.FantasyBiome });
		EntityRegistry.registerGlobalEntityID(EntityChaos.class, "Chaos", EntityRegistry.findGlobalUniqueEntityId(),3636363, 1515151);
		EntityRegistry.addSpawn(EntityChaos.class, 116, 5, 5,EnumCreatureType.monster, new BiomeGenBase[] {FunMod.FantasyBiome});
		EntityRegistry.registerGlobalEntityID(EntityMage.class, "Mage", EntityRegistry.findGlobalUniqueEntityId(),3636363, 66666666);
		EntityRegistry.addSpawn(EntityMage.class, 117, 1, 2,EnumCreatureType.monster, new BiomeGenBase[] {	FunMod.FantasyBiome });
		EntityRegistry.registerGlobalEntityID(EntityDarkLink.class,"DarkLink", EntityRegistry.findGlobalUniqueEntityId(), 77777777, 88888888);
		EntityRegistry.addSpawn(EntityDarkLink.class, 119, 2, 4,EnumCreatureType.monster, new BiomeGenBase[] {FunMod.FantasyBiome});
		EntityRegistry.registerGlobalEntityID(EntityGanondorf.class,"Ganondorf", EntityRegistry.findGlobalUniqueEntityId(), 10277912, 16161616);
		EntityRegistry.addSpawn(EntityGanondorf.class, 120, 1, 3,EnumCreatureType.monster, new BiomeGenBase[] {FunMod.FantasyBiome});
		EntityRegistry.registerGlobalEntityID(EntitySephiroth.class,"Sephiroth", EntityRegistry.findGlobalUniqueEntityId(), 10277912, 67676767);
		EntityRegistry.addSpawn(EntitySephiroth.class, 121, 1, 3,EnumCreatureType.monster, new BiomeGenBase[] {FunMod.FantasyBiome });
		EntityRegistry.registerGlobalEntityID(EntityKoopaTroopa.class,"KoopaTroopa", EntityRegistry.findGlobalUniqueEntityId(), 89898090, 67676767);
		EntityRegistry.addSpawn(EntityKoopaTroopa.class, 122, 6, 7,EnumCreatureType.monster, new BiomeGenBase[] {FunMod.FantasyBiome });
		EntityRegistry.registerGlobalEntityID(EntitySonic.class, "Sonic", EntityRegistry.findGlobalUniqueEntityId(),89898090, 49484047);
		EntityRegistry.addSpawn(EntitySonic.class, 123, 2, 5,EnumCreatureType.creature, new BiomeGenBase[] {FunMod.FantasyBiome });
		EntityRegistry.registerGlobalEntityID(EntityDoctorWilly.class,"DoctorWilly", EntityRegistry.findGlobalUniqueEntityId(), 129128918, 88888888);
		EntityRegistry.addSpawn(EntityDoctorWilly.class, 125, 1, 3,EnumCreatureType.monster, new BiomeGenBase[] {FunMod.FantasyBiome });
		EntityRegistry.registerGlobalEntityID(EntityHamtaro.class, "Hamtaro",EntityRegistry.findGlobalUniqueEntityId(), 129128918, 81726162);
		EntityRegistry.addSpawn(EntityDoctorWilly.class, 125, 1, 3,EnumCreatureType.creature, new BiomeGenBase[] {FunMod.FantasyBiome});
	 }
 }
}
