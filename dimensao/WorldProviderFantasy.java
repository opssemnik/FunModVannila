package FunMod.dimensao;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import FunMod.FunMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public class WorldProviderFantasy extends WorldProvider
{
	 
//The WorldProvider covers all the basics of the dimension. Look in WorldProviderBase.java and
//WorldProvider.java for all the potential qualities you can assign to your dimension.

public WorldProviderFantasy()
{
}

//The save file will be called DIM65 (DIM + id number).
protected void generateLightBrightnessTable()
{
    float var1 = 0.0F;

    for (int var2 = 0; var2 <= 15; ++var2)
    {
        float var3 = 1.0F - (float)var2 / 15.0F;
        this.lightBrightnessTable[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
    }
}
public float calculateCelestialAngle(long par1, float par3)
{
    int var4 = (int)(par1 % 24000L);
    float var5 = ((float)var4 + par3) / 24000.0F - 0.25F;

    if (var5 < 0.0F)
    {
        ++var5;
    }

    if (var5 > 1.0F)
    {
        --var5;
    }

    float var6 = var5;
    var5 = 1.0F - (float)((Math.cos((double)var5 * Math.PI) + 1.0D) / 2.0D);
    var5 = var6 + (var5 - var6) / 3.0F;
    return var5;
}

@SideOnly(Side.CLIENT)
public int getMoonPhase(long par1, float par3)
{
    return (int)(par1 / 24000L) % 8;
}

public int getDimensionID()
	{
		
		return 10;
	
	}

public boolean renderClouds()
	{

		return true;

	}
public boolean renderEndSky()
{
    return false;
}
public boolean renderVoidFog()
{

	return true;
	
}



public float setMoonSize()
{
	return 1.0F;
}

public float setSunSize()
{
	
	return 1.0F;

}



public String getSunTexture()
{
    return "/terrain/sun.png";
}


public String getMoonTexture()
{
    return "/terrain/moon_phases.png";
}

public float getStarBrightness(World var1, float var2)
{
    return var1.getStarBrightness(var2);
}

public Vec3 getSkyColor(World var1, Entity var2, float var3)
{
    return var1.getSkyColor(var2, var3);
}
public boolean canCoordinateBeSpawn(int par1, int par2)
{
    int var3 = this.worldObj.getFirstUncoveredBlock(par1, par2);
    return var3 == FunMod.FantasyGrass.blockID;
}
public boolean renderStars()
{

	return true;

}

public String getRespawnMessage()
{
    return "Respawning";
}

public int respawnInDimension()
{
    return 0;
}

public boolean darkenSkyDuringRain()
{

	return true;

}


//You can use an existing WorldChunkManager, or create your own. You must create your own to
//add multiple unique biomes to a dimension.
public void registerWorldChunkManager()
{

	worldChunkMgr = new WorldChunkManagerHell(FunMod.FantasyBiome, 1.0F, 0.0F);

}

//This is where you define your terrain generator.
public IChunkProvider getChunkProvider()
{

	return new ChunkProviderFantasy(worldObj, worldObj.getSeed(), false);

}

//Note that, if you respawn in the dimension, you will end up at the coordinates of your
//overworld spawn point, not at the location of your first entrance to the dimension or
//something like that. Note also that beds don't work if you cannot respawn in the dimension.
public boolean canRespawnHere()
{

	return true;

}


public void beforeRespawnTeleportation(MinecraftServer var1, EntityPlayerMP var2) {}

public void afterRespawnTeleportation(MinecraftServer var1, EntityPlayerMP var2) {}

public EntityPlayerMP overrideRespawn(MinecraftServer var1, ServerConfigurationManager var2, EntityPlayerMP var3, int var4, boolean var5)
{
    return null;
}

@SideOnly(Side.CLIENT)

/**
 * Returns array with sunrise/sunset colors
 */
public boolean isDaytime()
{
    return worldObj.skylightSubtracted < 4;
}

@Override
public String getDimensionName() {
	
	return "Fantasy Dimension";
}

}


