package FunMod.biomas;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import FunMod.FunMod;
import FunMod.dimensao.WorldGenFantasy;
import FunMod.entidades.EntityClyde;
import FunMod.entidades.EntityGoomba;
import FunMod.entidades.EntityIchigo;
import FunMod.entidades.EntityMegaMan;
import FunMod.entidades.EntityNaruto;
import FunMod.entidades.EntityNess;

public class BiomeGenFantasy extends BiomeGenBase
{
    protected WorldGenerator bushGen;
	protected WorldGenerator sandGen;
    protected WorldGenerator hematiteGen;
    protected WorldGenerator meteoriteGen;
    protected WorldGenerator cobaltGen;
    protected WorldGenerator blazestoneGen;
   
    @SuppressWarnings("unchecked")
	public BiomeGenFantasy(int par1)
    {

        super(par1);
        this.spawnableCreatureList.add(new SpawnListEntry(EntityNess.class, 101, 1, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityMegaMan.class, 102, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityIchigo.class, 104, 3, 5));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityClyde.class, 105, 3, 7));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityGoomba.class, 106, 6, 8));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityNaruto.class, 107, 2, 4));
        topBlock = FunMod.FantasyGrass;
        fillerBlock = FunMod.FantasyDirt;
    }

    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return (WorldGenerator)(par1Random.nextInt(10) == 0 ? this.worldGeneratorBigTree : (par1Random.nextInt(2) == 0 ? new WorldGenShrub(3, 0) : (par1Random.nextInt(3) == 0 ? new WorldGenFantasy(false) : new WorldGenTrees(false, 4 + par1Random.nextInt(7), 3, 3, true))));
    }
    
    
    
    
}
