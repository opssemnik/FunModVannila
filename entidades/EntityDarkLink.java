package FunMod.entidades;

import FunMod.FunMod;
import net.minecraft.src.EntityAIAttackOnCollide;
import net.minecraft.src.EntityAINearestAttackableTarget;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityDarkLink extends EntityMobFun
{
    public EntityDarkLink(World par1World)
    {
        super(par1World);
        texture = "/FunMod/cliente/texturas/Mobs/DarkLink.png"; 
        setSize(0.9F, 1.3F);  
        this.moveSpeed = 0.5F;
        this.attackStrength = 8;  
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLink.class, 16.0F, 0, true));
    }

    public boolean isAIEnabled()
    {
        return true; 
    }

    public int getMaxHealth()
    {
        return 28; 
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

   
    
    protected int getDropItemId()
    {
        return FunMod.PearlOfLink.shiftedIndex; 
    }

    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
    


} 