package FunMod.entidades;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityWoody extends EntityAnimal 
{
    public EntityWoody(World par1World)
    {
        super(par1World);
        texture = "/FunMod/cliente/texturas/Mobs/WOODY.png"; 
        setSize(0.9F, 1.3F);      
        tasks.addTask(1, new EntityAIPanic(this, 0.25F));
        tasks.addTask(2, new EntityAIMate(this, 0.2F));
        tasks.addTask(4, new EntityAIFollowParent(this, 0.25F));
        tasks.addTask(5, new EntityAIWander(this, 0.2F));
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

 
    protected int getDropItemId()
    {
        return Item.appleRed.itemID; 
    }

    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
    
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

	@Override
	public EntityAgeable createChild(EntityAgeable var1) {
		// TODO Auto-generated method stub
		return null;
	}



} 