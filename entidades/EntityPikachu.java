package FunMod.entidades;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import FunMod.FunMod;

/** ticks until heightOffset is randomized */


public class EntityPikachu extends EntityMob
{
	private int heightOffsetUpdateTime;
	private int field_70846_g;
	
    public EntityPikachu(World par1World)
    {
        super(par1World);
        texture = "/FunMod/cliente/texturas/Mobs/ModelPikachuHD.png"; 
        this.setSize(0.4F, 0.8F);     
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIPanic(this, 0.15F));
        tasks.addTask(5, new EntityAIWander(this, 0.5F));
        tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6F));
        tasks.addTask(7, new EntityAILookIdle(this));
    }

    public boolean isAIEnabled()
    {
        return true; 
    }

    public int getMaxHealth()
    {
        return 30; 
    }

    protected void attackEntity(Entity par1Entity, float par2)
    {
        if (this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY)
        {
            this.attackTime = 20;
            this.attackEntityAsMob(par1Entity);
        }
        else if (par2 < 30.0F)
        {
            double var3 = par1Entity.posX - this.posX;
            double var5 = par1Entity.boundingBox.minY + (double)(par1Entity.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
            double var7 = par1Entity.posZ - this.posZ;

            if (this.attackTime == 0)
            {
                ++this.field_70846_g;

                if (this.field_70846_g == 1)
                {
                    this.attackTime = 60;
                    this.func_70844_e(true);
                }
                else if (this.field_70846_g <= 4)
                {
                    this.attackTime = 6;
                }
                else
                {
                    this.attackTime = 100;
                    this.field_70846_g = 0;
                    this.func_70844_e(false);
                }

                if (this.field_70846_g > 1)
                {
                    float var9 = MathHelper.sqrt_float(par2) * 0.5F;
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);

                    for (int var10 = 0; var10 < 1; ++var10)
                    {
                        EntityThunderBolt var11 = new EntityThunderBolt(this.worldObj, var3 + this.rand.nextGaussian() * (double)var9, var5, var7 + this.rand.nextGaussian() * (double)var9);
                        var11.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
                        this.worldObj.spawnEntityInWorld(var11);
                    }
                }
            }

            this.rotationYaw = (float)(Math.atan2(var7, var3) * 180.0D / Math.PI) - 90.0F;
            this.hasAttacked = true;
        }
    }

   

    
    public boolean func_70845_n()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void func_70844_e(boolean par1)
    {
        byte var2 = this.dataWatcher.getWatchableObjectByte(16);

        if (par1)
        {
            var2 = (byte)(var2 | 1);
        }
        else
        {
            var2 &= -2;
        }

        this.dataWatcher.updateObject(16, Byte.valueOf(var2));
    }
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound); 
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
    }

    protected String getLivingSound()
    {
        return "mob.silverfish.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.silverfish.hit";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.silverfish.kill";
    }
    protected float getSoundVolume()
    {
        return 0.4F;
    }

 
    protected int getDropItemId()
    {
        return FunMod.ThunderDust.itemID; 
    }

    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
    


} 