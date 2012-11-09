package FunMod.loader;

import net.minecraft.src.Block;
import net.minecraft.src.BlockCloth;
import net.minecraft.src.EntityAgeable;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemDye;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;
import FunMod.FunMod;
import FunMod.enums.EnumFunMod;

public class CreaturaMontavelPacketHandlerForFunMod extends EntityAnimal
{
    public float flySpeed = 0.91F;
    public float walkSpeed = 0.2F;
    public float swimmingSpeed = 0.2F;
    public float defaultSpeed = 0.1F;
    public boolean canFly = false;
    public boolean canSwim = false;
    public boolean canLand = true;
    public boolean canColor = true;
    private double oldPosX;
    private double oldPosY;
    private double oldPosZ;
    private float oldRotationYaw;
    private int nextStepDistance = 1;
    public EntityPlayer rider = null;
    public boolean init = false;
    boolean prevJump;
    boolean prevSneak;
    private float[][] fleeceColorTable = new float[][] {{1.0F, 1.0F, 1.0F}, {0.95F, 0.7F, 0.2F}, {0.9F, 0.5F, 0.85F}, {0.6F, 0.7F, 0.95F}, {0.9F, 0.9F, 0.2F}, {0.5F, 0.8F, 0.1F}, {0.95F, 0.7F, 0.8F}, {0.3F, 0.3F, 0.3F}, {0.6F, 0.6F, 0.6F}, {0.3F, 0.6F, 0.7F}, {0.7F, 0.4F, 0.9F}, {0.2F, 0.4F, 0.8F}, {0.5F, 0.4F, 0.3F}, {0.4F, 0.5F, 0.2F}, {0.8F, 0.3F, 0.3F}, {0.1F, 0.1F, 0.1F}};

    public CreaturaMontavelPacketHandlerForFunMod(World var1)
    {
        super(var1);

        if (!this.worldObj.isRemote)
        {
            this.setFleeceColor(this.getRandomFleeceColor());
            this.setSpecial(this.rand.nextInt(5) == 1);
        }
    }
    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(15, "");
        this.dataWatcher.addObject(16, Integer.valueOf(0));
        this.dataWatcher.addObject(17, Byte.valueOf((byte)0));
        this.dataWatcher.addObject(18, Integer.valueOf(0));
        this.dataWatcher.addObject(19, Integer.valueOf(0));
        this.dataWatcher.addObject(20, Integer.valueOf(0));
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public void writeEntityToNBT(NBTTagCompound var1)
    {
        super.writeEntityToNBT(var1);
        var1.setString("Owner", this.getOwner());
        var1.setInteger("Color", this.getFleeceColor());
        var1.setBoolean("Special", this.getSpecial());
        var1.setInteger("18", this.getRCFlag(18));
        var1.setInteger("19", this.getRCFlag(19));
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readEntityFromNBT(NBTTagCompound var1)
    {
        super.readEntityFromNBT(var1);
        this.setOwner(var1.getString("Owner"));
        this.setFleeceColor(var1.getInteger("Color"));
        this.setSpecial(var1.getBoolean("Special"));
        this.setRCFlag(18, var1.getInteger("18"));
        this.setRCFlag(19, var1.getInteger("19"));
    }

    public void setOwner(String var1)
    {
        this.dataWatcher.updateObject(15, var1);
    }

    public String getOwner()
    {
        return this.dataWatcher.getWatchableObjectString(15);
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    public void fall(float var1)
    {
        if (!this.canFly)
        {
            if (this.rider != null && this.worldObj.isRemote)
            {
                FunModPacketHandlerForForge.sendServerData(EnumFunMod.Fall, new Object[] {Float.valueOf(var1)});
            }

            super.fall(var1);
        }
    }

    public boolean getSpecial()
    {
        return (this.dataWatcher.getWatchableObjectByte(17) & 1) == 1;
    }

    public void setSpecial(boolean var1)
    {
        this.dataWatcher.updateObject(17, Byte.valueOf((byte)(var1 ? 1 : 0)));
    }

    public int getFleeceColor()
    {
        return this.dataWatcher.getWatchableObjectInt(16);
    }

    public int getRCFlag(int var1)
    {
        try
        {
            return this.dataWatcher.getWatchableObjectInt(var1);
        }
        catch (Exception var3)
        {
            return 0;
        }
    }

    public void setRCFlag(int var1, int var2)
    {
        this.dataWatcher.updateObject(var1, Integer.valueOf(var2));
    }

    public void setFleeceColor(int var1)
    {
        this.dataWatcher.updateObject(16, Integer.valueOf(var1));
    }

    public int getRandomFleeceColor()
    {
        int var1 = this.rand.nextInt(this.fleeceColorTable.length);
        return var1;
    }

    /**
     * Tries to moves the entity by the passed in displacement. Args: x, y, z
     */
    public void moveEntity(double var1, double var3, double var5)
    {
        float var7 = this.width / 2.0F;
        float var8 = (float)this.getMountedYOffset() + 1.4F + this.yOffset;
        this.boundingBox.setBounds(this.posX - (double)var7, this.posY - (double)this.yOffset + (double)this.ySize, this.posZ - (double)var7, this.posX + (double)var7, this.posY - (double)this.yOffset + (double)this.ySize + (double)var8, this.posZ + (double)var7);
        super.moveEntity(var1, var3, var5);
        var8 = this.height;
        this.boundingBox.setBounds(this.posX - (double)var7, this.posY - (double)this.yOffset + (double)this.ySize, this.posZ - (double)var7, this.posX + (double)var7, this.posY - (double)this.yOffset + (double)this.ySize + (double)var8, this.posZ + (double)var7);
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    public boolean canTriggerWalking()
    {
        return this.rider == null;
    }

    public void updateEntityActionState()
    {
        if (this.rider == null)
        {
            super.updateEntityActionState();
        }
    }

    /**
     * Sets the x,y,z of the entity from the given parameters. Also seems to set up a bounding box.
     */
    public void setPosition(double var1, double var3, double var5)
    {
        if (this.onGround && !this.isSneaking() && !this.canTriggerWalking())
        {
            double var7 = this.posX - var1;
            double var9 = this.posZ - var5;
            this.distanceWalkedModified = (float)((double)this.distanceWalkedModified + (double)MathHelper.sqrt_double(var7 * var7 + var9 * var9) * 0.6D);
            int var11 = MathHelper.floor_double(var1);
            int var12 = MathHelper.floor_double(var3 - 0.20000000298023224D - (double)this.yOffset);
            int var13 = MathHelper.floor_double(var5);
            int var14 = this.worldObj.getBlockId(var11, var12, var13);

            if (var14 == 0 && this.worldObj.getBlockId(var11, var12 - 1, var13) == Block.fence.blockID)
            {
                var14 = this.worldObj.getBlockId(var11, var12 - 1, var13);
            }

            if (this.distanceWalkedModified > (float)this.nextStepDistance && var14 > 0)
            {
                this.nextStepDistance = (int)this.distanceWalkedModified + 1;
                this.playStepSound(var11, var12, var13, var14);
                Block.blocksList[var14].onEntityWalking(this.worldObj, var11, var12, var13, this);
            }
        }

        super.setPosition(var1, var3, var5);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (this.worldObj.isRemote && !this.init)
        {
            FunModPacketHandlerForForge.sendServerData(EnumFunMod.Data, new Object[] {Integer.valueOf(this.entityId)});
            this.init = true;
        }

        if (this.rider != null)
        {
            this.landMovementFactor = this.walkSpeed;
        }
        else
        {
            this.landMovementFactor = this.defaultSpeed;
        }

        if (this.isChild())
        {
            this.landMovementFactor = (float)((double)this.landMovementFactor * 0.7D);
        }

        this.jumpMovementFactor = this.landMovementFactor / 5.0F;

        if (this.rider != null)
        {
            if (this.worldObj.isRemote && this.riddenByEntity instanceof EntityClientPlayerMP)
            {
                this.rotationYawHead = this.rotationYaw = this.rider.rotationYaw;
                this.prevRotationPitch = this.rotationPitch = 0.0F;
                this.prevRotationYaw = this.rider.prevRotationYaw;
                /**
                this.setMoveForward(FunMod.getMoveForward(this.rider));
                this.moveStrafing = FunMod.getMoveStrafing(this.rider);
                **/
                this.isJumping = FunMod.isJumping(this.rider);
                this.setSneaking(this.rider.isSneaking());
                this.newPosRotationIncrements = 0;

                if (this.canSwim && this.isInWater())
                {
                    if (!this.isSneaking() && (this.moveForward != 0.0F || this.moveStrafing != 0.0F))
                    {
                        this.motionY += 0.02D;
                    }

                    this.motionX += this.rider.motionX * 5.0D;
                    this.motionZ += this.rider.motionZ * 5.0D;

                    if (this.motionX < (double)(-this.swimmingSpeed))
                    {
                        this.motionX = (double)(-this.swimmingSpeed);
                    }

                    if (this.motionX > (double)this.swimmingSpeed)
                    {
                        this.motionX = (double)this.swimmingSpeed;
                    }

                    if (this.motionZ < (double)(-this.swimmingSpeed))
                    {
                        this.motionZ = (double)(-this.swimmingSpeed);
                    }

                    if (this.motionZ > (double)this.swimmingSpeed)
                    {
                        this.motionZ = (double)this.swimmingSpeed;
                    }
                }
            }
            else
            {
                this.rider.rotationYawHead = this.prevRotationYawHead = this.rotationYawHead = this.rider.rotationYaw = this.rotationYaw;

                if (!this.worldObj.isRemote)
                {
                    return;
                }
            }
        }

        super.onLivingUpdate();
    }

    public void doAttack() {}

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer)
        {
            this.rider = (EntityPlayer)this.riddenByEntity;
        }
        else
        {
            this.rider = null;
        }

        super.onUpdate();
        this.onMotionUpdate();
    }

    private void onMotionUpdate()
    {
        if (this.worldObj.isRemote && this.rider != null && this.riddenByEntity instanceof EntityClientPlayerMP)
        {
            double var1 = this.posX - this.oldPosX;
            double var3 = this.boundingBox.minY - this.oldPosY;
            double var5 = this.posZ - this.oldPosZ;
            double var7 = (double)(this.rotationYaw - this.oldRotationYaw);
            boolean var9 = var1 * var1 + var3 * var3 + var5 * var5 > 9.0E-4D && (this.canFly || this.onGround);
            boolean var10 = var7 != 0.0D;
            boolean var11 = this.prevJump != FunMod.isJumping(this.rider) || this.prevSneak != this.rider.isSneaking();

            if (var9 && var10)
            {
                FunModPacketHandlerForForge.sendServerData(EnumFunMod.PositionView, new Object[] {Double.valueOf(this.posX), Double.valueOf(this.posY), Double.valueOf(this.posZ), Float.valueOf(this.rotationYaw), Float.valueOf(this.rider.rotationPitch)});
            }
            else if (var9)
            {
                FunModPacketHandlerForForge.sendServerData(EnumFunMod.Position, new Object[] {Double.valueOf(this.posX), Double.valueOf(this.posY), Double.valueOf(this.posZ)});
            }
            else if (var10)
            {
                FunModPacketHandlerForForge.sendServerData(EnumFunMod.View, new Object[] {Float.valueOf(this.rotationYaw), Float.valueOf(this.rider.rotationPitch)});
            }

            if (var11)
            {
                this.prevJump = FunMod.isJumping(this.rider);
                this.prevSneak = this.rider.isSneaking();
                FunModPacketHandlerForForge.sendServerData(EnumFunMod.Action, new Object[] {Boolean.valueOf(this.prevJump), Boolean.valueOf(this.prevSneak)});
            }

            this.oldPosX = this.posX;
            this.oldPosY = this.boundingBox.minY;
            this.oldPosZ = this.posZ;
            this.oldRotationYaw = this.rotationYaw;
        }
    }

    /**
     * Moves the entity based on the specified heading.  Args: strafe, forward
     */
    public void moveEntityWithHeading(float var1, float var2)
    {
       
            super.moveEntityWithHeading(var1, var2);
        }
    

    public void bikeFlying(float var1, float var2)
    {
        if (this.rider != null && FunMod.FlyingEnabled && this.canFly)
        {
            boolean var3 = !this.worldObj.isAirBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY) - 1, MathHelper.floor_double(this.posZ));
            boolean var4 = FunMod.isSpacebarPressed(this.rider);
            boolean var5 = FunMod.isShiftbarPressed(this.rider);

            if (var3 && !var4 && !var5 && this.canLand)
            {
                super.moveEntityWithHeading(var1, var2);
            }
            else
            {
                if (var4)
                {
                    this.motionY = (double)(0.5F * this.flySpeed);
                }

                if (var5)
                {
                    this.motionY = (double)(-0.5F * this.flySpeed);
                }

                float var6 = this.flySpeed;
                float var7 = 0.1627714F / (var6 * var6 * var6);
                this.moveFlying(var1, var2, this.onGround ? 0.1F * var7 : 0.085F);
                this.moveEntity(this.motionX, this.motionY, this.motionZ);
                this.motionX *= (double)var6;
                this.motionY *= (double)var6;
                this.motionZ *= (double)var6;
                this.prevLegYaw = this.legYaw;
                double var8 = this.posX - this.prevPosX;
                double var10 = this.posZ - this.prevPosZ;
                float var12 = MathHelper.sqrt_double(var8 * var8 + var10 * var10) * 4.0F;

                if (var12 > 1.0F)
                {
                    var12 = 1.0F;
                }

                this.legYaw += (var12 - this.legYaw) * 0.4F;
                this.legSwing += this.legYaw;
            }
        }
        else
        {
            super.moveEntityWithHeading(var1, var2);
        }
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }

    /**
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    public boolean canBePushed()
    {
        return false;
    }

    public float getShadowSize()
    {
        return 0.0F;
    }

    /**
     * Called when the entity is attacked.
     */
    

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer var1)
    {
        if (this.worldObj.isRemote)
        {
            return false;
        }
        else if (!this.getOwner().isEmpty() && !var1.username.equals(this.getOwner()))
        {
            var1.sendChatToPlayer("Owned by " + this.getOwner());
            return false;
        }
        else
        {
            ItemStack var2 = var1.getCurrentEquippedItem();

            if (var2 != null && this.rider == null)
            {
                if (var2.getItem() instanceof ItemDye && this.canColor)
                {
                    int var3 = BlockCloth.getBlockFromDye(var2.getItemDamage());

                    if (this.getFleeceColor() != var3)
                    {
                        this.setFleeceColor(var3);
                        var1.inventory.consumeInventoryItem(var2.itemID);
                        return true;
                    }
                }

               
            }

            if (this.rider != null && this.rider != var1)
            {
                return false;
            }
            else
            {
                var1.mountEntity(this);

                if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer)
                {
                    this.rider = (EntityPlayer)this.riddenByEntity;
                }
                else
                {
                    this.rider = null;
                }

                return true;
            }
        }
    }

    public float getRBGColor(int var1, int var2)
    {
        if (var1 >= this.fleeceColorTable.length)
        {
            var1 = 0;
        }

        return this.fleeceColorTable[var1][var2];
    }

    public int getMaxHealth()
    {
        return 15;
    }
	@Override
	public EntityAgeable func_90011_a(EntityAgeable var1) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
