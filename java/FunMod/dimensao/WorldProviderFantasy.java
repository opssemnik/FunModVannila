package FunMod.dimensao;

import opssemnik.minecraft.funmod.fixes.StaticHelper;
import net.minecraft.block.Block;
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

public class WorldProviderFantasy extends WorldProvider {

	public WorldProviderFantasy() {
	}

	protected void generateLightBrightnessTable() {
		float var1 = 0.0F;

		for (int var2 = 0; var2 <= 15; ++var2) {
			float var3 = 1.0F - (float) var2 / 15.0F;
			this.lightBrightnessTable[var2] = (1.0F - var3)
					/ (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
		}
	}

	public float calculateCelestialAngle(long par1, float par3) {
		int var4 = (int) (par1 % 24000L);
		float var5 = ((float) var4 + par3) / 24000.0F - 0.25F;

		if (var5 < 0.0F) {
			++var5;
		}

		if (var5 > 1.0F) {
			--var5;
		}

		float var6 = var5;
		var5 = 1.0F - (float) ((Math.cos((double) var5 * Math.PI) + 1.0D) / 2.0D);
		var5 = var6 + (var5 - var6) / 3.0F;
		return var5;
	}

	@SideOnly(Side.CLIENT)
	public int getMoonPhase(long par1, float par3) {
		return (int) (par1 / 24000L) % 8;
	}

	public int getDimensionID() {

		return 10;

	}

	public boolean renderClouds() {

		return true;

	}

	public boolean renderEndSky() {
		return false;
	}

	public boolean renderVoidFog() {

		return true;

	}

	public float setMoonSize() {
		return 1.0F;
	}

	public float setSunSize() {

		return 1.0F;

	}

	public String getSunTexture() {
		return "/terrain/sun.png";
	}

	public String getMoonTexture() {
		return "/terrain/moon_phases.png";
	}

	public float getStarBrightness(World var1, float var2) {
		return var1.getStarBrightness(var2);
	}

	public Vec3 getSkyColor(World var1, Entity var2, float var3) {
		return var1.getSkyColor(var2, var3);
	}

	public boolean canCoordinateBeSpawn(int par1, int par2) {
		Block var3 = this.worldObj.getTopBlock(par1, par2);
		return var3 == StaticHelper.FMBlockLoader.FantasyGrass;
	}

	public boolean renderStars() {
		return true;

	}

	public int respawnInDimension() {
		return 10;
	}

	public boolean darkenSkyDuringRain() {
		return true;
	}

	public void registerWorldChunkManager() {

		worldChunkMgr = new WorldChunkManagerHell(FunMod.FantasyBiome, 1.0F);

	}

	public IChunkProvider getChunkProvider() {
		return new ChunkProviderFantasy(worldObj, worldObj.getSeed(), false);
	}

	public boolean canRespawnHere() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public boolean isDaytime() {
		return worldObj.skylightSubtracted < 4;
	}

	@Override
	public String getDimensionName() {
		return "Fantasy Dimension";
	}

}
