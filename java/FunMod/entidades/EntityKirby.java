package FunMod.entidades;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.Chunk;

public class EntityKirby extends EntityLiving implements IMob {
	public float field_70813_a;
	public float field_70811_b;
	public float field_70812_c;
	private int slimeJumpDelay = 0;

	public EntityKirby(World par1World) {
		super(par1World);
		this.setSize(0.3F, 0.6F);
	//	texture = "/FunMod/cliente/texturas/Mobs/KirbyTexture.png";
		int var2 = 1 << this.rand.nextInt(3);
		this.yOffset = 0.0F;
		this.slimeJumpDelay = this.rand.nextInt(20) + 10;
		this.setSlimeSize(var2);
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte) 1));
	}

	public void setSlimeSize(int par1) {
		this.dataWatcher.updateObject(16, new Byte((byte) par1));
		this.setSize(0.6F * (float) par1, 0.6F * (float) par1);
		this.setPosition(this.posX, this.posY, this.posZ);
	//	this.setEntityHealth(this.getMaxHealth());
		this.experienceValue = par1;
	}

	//public int getMaxHealth() {
	//	int var1 = this.getSlimeSize();
	//	return var1 * var1;
	//}
	public int getSlimeSize() {
		return this.dataWatcher.getWatchableObjectByte(16);
	}
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("Size", this.getSlimeSize() - 1);
	}
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		this.setSlimeSize(par1NBTTagCompound.getInteger("Size") + 1);
	}
	protected String getSlimeParticle() {
		return "smoke";
	}
	protected String getJumpSound() {
		return "mob.villager.defaulthurt";
	}
	public void onUpdate() {
		if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL
				&& this.getSlimeSize() > 0) {
			this.isDead = true;
		}

		this.field_70811_b += (this.field_70813_a - this.field_70811_b) * 0.5F;
		this.field_70812_c = this.field_70811_b;
		boolean var1 = this.onGround;
		super.onUpdate();

		if (this.onGround && !var1) {
			int var2 = this.getSlimeSize();

			for (int var3 = 0; var3 < var2 * 8; ++var3) {
				float var4 = this.rand.nextFloat() * (float) Math.PI * 2.0F;
				float var5 = this.rand.nextFloat() * 0.5F + 0.5F;
				float var6 = MathHelper.sin(var4) * (float) var2 * 0.5F * var5;
				float var7 = MathHelper.cos(var4) * (float) var2 * 0.5F * var5;
				this.worldObj.spawnParticle(this.getSlimeParticle(), this.posX
						+ (double) var6, this.boundingBox.minY, this.posZ
						+ (double) var7, 0.0D, 0.0D, 0.0D);
			}

			if (this.makesSoundOnLand()) {
				this.worldObj
						.playSoundAtEntity(
								this,
								this.getJumpSound(),
								this.getSoundVolume(),
								((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
			}

			this.field_70813_a = -0.5F;
		} else if (!this.onGround && var1) {
			this.field_70813_a = 1.0F;
		}

		this.func_70808_l();
	}

	protected void updateEntityActionState() {
		this.despawnEntity();
		EntityPlayer var1 = this.worldObj.getClosestVulnerablePlayerToEntity(
				this, 16.0D);

		if (var1 != null) {
			this.faceEntity(var1, 10.0F, 20.0F);
		}

		if (this.onGround && this.slimeJumpDelay-- <= 0) {
			this.slimeJumpDelay = this.getJumpDelay();

			if (var1 != null) {
				this.slimeJumpDelay /= 3;
			}

			this.isJumping = true;

			if (this.makesSoundOnJump()) {
				this.worldObj
						.playSoundAtEntity(
								this,
								this.getJumpSound(),
								this.getSoundVolume(),
								((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 0.8F);
			}

			this.moveStrafing = 1.0F - this.rand.nextFloat() * 2.0F;
			this.moveForward = (float) (1 * this.getSlimeSize());
		} else {
			this.isJumping = false;

			if (this.onGround) {
				this.moveStrafing = this.moveForward = 0.0F;
			}
		}
	}

	protected void func_70808_l() {
		this.field_70813_a *= 0.6F;
	}

	/**
	 * Gets the amount of time the slime needs to wait between jumps.
	 */
	protected int getJumpDelay() {
		return this.rand.nextInt(20) + 10;
	}

	protected EntityKirby createInstance() {
		return new EntityKirby(this.worldObj);
	}

	/**
	 * Will get destroyed next tick.
	 */

	/**
	 * Called by a player entity when they collide with an entity
	 */
	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer) {
		if (this.canDamagePlayer()) {
			int var2 = this.getSlimeSize();

			if (this.canEntityBeSeen(par1EntityPlayer)
					&& this.getDistanceSqToEntity(par1EntityPlayer) < 0.6D
							* (double) var2 * 0.6D * (double) var2
					&& par1EntityPlayer.attackEntityFrom(
							DamageSource.causeMobDamage(this),
							this.getAttackStrength())) {
				this.worldObj
						.playSoundAtEntity(
								this,
								"mob.slimeattack",
								1.0F,
								(this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			}
		}
	}

	/**
	 * Indicates weather the slime is able to damage the player (based upon the
	 * slime's size)
	 */
	protected boolean canDamagePlayer() {
		return this.getSlimeSize() > 1;
	}

	/**
	 * Gets the amount of damage dealt to the player when "attacked" by the
	 * slime.
	 */
	protected int getAttackStrength() {
		return this.getSlimeSize();
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound() {
		return "mob.villager.defaulthurt";
	}

	protected String getDeathSound() {
		return "mob.villager.defaultdeath";
	}

	/**
	 * Returns the item ID for the item the mob drops on death.
	 */

	/**
	 * Checks if the entity's current position is a valid location to spawn this
	 * entity.
	 */
	public boolean getCanSpawnHere() {
		Chunk var1 = this.worldObj.getChunkFromBlockCoords(
				MathHelper.floor_double(this.posX),
				MathHelper.floor_double(this.posZ));
		return this.worldObj.getWorldInfo().getTerrainType() == WorldType.FLAT
				&& this.rand.nextInt(4) != 1 ? false
				: ((this.getSlimeSize() == 1 || this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL)
						&& this.rand.nextInt(10) == 0
						&& var1.getRandomWithSeed(987234911L).nextInt(10) == 0
						&& this.posY < 40.0D ? super.getCanSpawnHere() : false);
	}
	protected float getSoundVolume() {
		return 0.4F * (float) this.getSlimeSize();
	}
	public int getVerticalFaceSpeed() {
		return 0;
	}
	protected boolean makesSoundOnJump() {
		return this.getSlimeSize() > 1;
	}
	protected boolean makesSoundOnLand() {
		return this.getSlimeSize() > 2;
	}
}
