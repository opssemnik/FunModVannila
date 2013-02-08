package FunMod.entidades;

import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntitySephiroth extends EntityMobFun
{
    public EntitySephiroth(World par1World)
    {
        super(par1World);
        texture = "/FunMod/cliente/texturas/Mobs/Sephiroth.png"; 
        setSize(1F*1F, 1.5F*1.5F); 
        this.moveSpeed = 0.4F;
        this.attackStrength = 6; 
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
    }

    public boolean isAIEnabled()
    {
        return true; 
    }

    public int getMaxHealth()
    {
        return 30; 
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
        return "mob.zombiepig.zpig";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.zombiepig.zpighurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.zombiepig.zpigdeath";
    }



    protected float getSoundVolume()
    {
        return 0.4F;
    }

 
   
    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
    


} 