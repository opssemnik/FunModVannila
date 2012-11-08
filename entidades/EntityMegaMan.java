package FunMod.entidades;

import net.minecraft.src.EntityAINearestAttackableTarget;
import net.minecraft.src.EntityAIPanic;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntitySpider;
import net.minecraft.src.EnumCreatureAttribute;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityMegaMan extends EntityMobFun
{
	
	private boolean isPeacefulCreature;
	
    public EntityMegaMan(World par1World)
    {
        super(par1World);
        texture = "/FunMod/cliente/texturas/Mobs/MEGAMAN.png"; 
        setSize(0.9F, 1.3F);      
        this.attackStrength = 3;
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntitySpider.class, 16.0F, 0, true));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityDoctorWilly.class, 16.0F, 0, true));
        tasks.addTask(1, new EntityAIPanic(this, 0.20F));
        tasks.addTask(2, new EntityAIWander(this, 0.4F));
    }

    public boolean isAIEnabled()
    {
        return true; 
    }

    public int getMaxHealth()
    {
        return 25; 
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

    
    protected String getHurtSound()
    {
        return "mob.villager.defaulthurt";
    }

    
    protected String getDeathSound()
    {
        return "mob.villager.defaultdeath";
    }


    protected float getSoundVolume()
    {
        return 0.6F;
    }

    public boolean getPeacefulCreature()
    {
        return this.isPeacefulCreature;
    }
   

    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }


} 