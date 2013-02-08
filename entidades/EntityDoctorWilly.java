package FunMod.entidades;

import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityDoctorWilly extends EntityMobFun
{
	
	
    public EntityDoctorWilly(World par1World)
    {
        super(par1World);
        texture = "/FunMod/cliente/texturas/Mobs/willy.png"; 
        setSize(0.9F, 1.3F);  
        this.moveSpeed = 0.5F;
        this.attackStrength = 7;  
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityMegaMan.class, this.moveSpeed, false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityMegaMan.class, 16.0F, 0, true));
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
        return "mob.villager.default";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.villager.defaulthurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.villager.defaultdeath";
    }


    protected float getSoundVolume()
    {
        return 0.4F;
    }

    protected int getDropItemId()
    {
        return 2;
    }

    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
    


} 