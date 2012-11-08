/**
package FunMod;

import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;



public class EntityYoshi extends EntityAnimal
{

        public EntityYoshi(World world)
        {
                super(world);
                texture = "/FunMod/cliente/texturas/Mobs/ModelYoshi.png";
                setSize(0.9F*1.25F, 0.9F*1.25F);
                stationary = false;

        }

        public void writeEntityToNBT(NBTTagCompound nbttagcompound)
        {
                super.writeEntityToNBT(nbttagcompound);
  
        }

      


		public void readEntityFromNBT(NBTTagCompound nbttagcompound)
        {
                super.readEntityFromNBT(nbttagcompound);
                setSaddled(nbttagcompound.getBoolean("Saddle"));
        }

		 public void setSaddled(boolean par1)
		    {
		        if (par1)
		        {
		            this.dataWatcher.updateObject(16, Byte.valueOf((byte)1));
		        }
		        else
		        {
		            this.dataWatcher.updateObject(16, Byte.valueOf((byte)0));
		        }
		    }

		protected String getLivingSound()
        {
                return "mob.pig";
        }

        protected String getHurtSound()
        {
                return "mob.pig";
        }

        protected String getDeathSound()
        {
                return "mob.pigdeath";
        }

        public boolean interact(EntityPlayer par1EntityPlayer)
        {
            if (super.interact(par1EntityPlayer))
            {
                return true;
            }
            else if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == par1EntityPlayer))
            {
                par1EntityPlayer.mountEntity(this);
                return true;
            }
            else
            {
                return false;
            }
        }
        protected boolean isMovementCeased()
        {
                return stationary;
        }
        
 
        public void moveEntity(double d, double d1, double d2)
        {
                if(riddenByEntity != null)
                {
                	stationary = true;
                    this.moveForward = 0.0F;
                    this.moveStrafing = 0.0F;
                    this.isJumping = false;
                    this.riddenByEntity.fallDistance = 0.0F;
                    this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
                    this.prevRotationPitch = this.rotationPitch = this.riddenByEntity.rotationPitch;
                    EntityLiving var1 = (EntityLiving)this.riddenByEntity;
                    float var2 = (float)Math.PI;
                    float var3 = var2 / 180.0F;
                    float var4;

                        motionX += riddenByEntity.motionX*8;   // * 0.20000000000000001D;
                        motionZ += riddenByEntity.motionZ*8;   // * 0.20000000000000001D;
                        if(isCollidedHorizontally)
                        {
                                isJumping = false;
                        }
                        
                        if(var1.isJumping)
                        {
                                isJumping = true;
                        }
                        super.moveEntity(motionX, motionY, motionZ);
                }else
                {

                        super.moveEntity(d, d1, d2);
                }
        }

 
        public void onUpdate()
        {
                super.onUpdate();
                if(riddenByEntity != null)                                                      //check if there is a rider
                {
                        //currentTarget = this;
                        texture = "/FunMod/cliente/texturas/Mobs/ModelYoshi.png";                                    //test to show a different texture when mounted
                                      //try not to let the horse control where to look.

                }else
                {
                        if(texture != "/FunMod/cliente/texturas/Mobs/ModelYoshi.png")
                        {       
                                texture = "/FunMod/cliente/texturas/Mobs/ModelYoshi.png";                            //reset texture afte getting off.
                        }
                }
                
        }
        public boolean stationary;
		@Override
		public EntityAnimal spawnBabyAnimal(EntityAnimal var1) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public int getMaxHealth() {
			// TODO Auto-generated method stub
			return 10;
		}
}
**/
package FunMod.entidades;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;
import FunMod.loader.CreaturaMontavelPacketHandlerForFunMod;
public class EntityYoshi extends CreaturaMontavelPacketHandlerForFunMod 
{
    private float prevMoveforward;

    public EntityYoshi(World var1)
    {
        super(var1);
        this.texture = "/FunMod/cliente/texturas/Mobs/ModelYoshi.png";
        this.setSize(0.9F, 0.9F);
        this.walkSpeed = 0.4F;
    }

    /**
     * If Animal, checks if the age timer is negative
     */
    @Override
	public int getMaxHealth() {
		// TODO Auto-generated method stub
		return 10;
	}
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
        if (super.interact(par1EntityPlayer))
        {
            return true;
        }
        else if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == par1EntityPlayer))
        {
            par1EntityPlayer.mountEntity(this);
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean isChild()
    {
        return this.getSpecial();
    }

    public EntityYoshi(World var1, double var2, double var4, double var6)
    {
        this(var1);
        this.setPosition(var2, var4, var6);
    }

    /**
     * Returns the Y offset from the entity's position for any entity riding this one.
     */
    public double getMountedYOffset()
    {
        return this.getSpecial() ? 0.4D : 0.8D;
    }

    public void setMoveForward(float var1)
    {
        if ((double)var1 < 0.5D && (double)var1 > -0.5D)
        {
            if (this.prevMoveforward > 0.0F)
            {
                var1 = 0.5F;
            }

            if (this.prevMoveforward < 0.0F)
            {
                var1 = -0.5F;
            }
        }

        super.setMoveForward(var1);
        this.prevMoveforward = var1;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.pig";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.pig";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.pigdeath";
    }
}
