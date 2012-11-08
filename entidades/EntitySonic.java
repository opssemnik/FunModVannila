package FunMod.entidades;

import FunMod.FunMod;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAIPanic;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntitySonic extends EntityAnimal
{
    public EntitySonic(World par1World)
    {
        super(par1World);
        texture = "/FunMod/cliente/texturas/Mobs/Sonic.png"; 
        setSize(1F*1F, 0.8F*0.8F);       
        tasks.addTask(1, new EntityAIPanic(this, 0.15F));
        tasks.addTask(5, new EntityAIWander(this, 0.5F));
        tasks.addTask(6, new EntityAIWatchClosest(this, net.minecraft.src.EntityPlayer.class, 6F));
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

 
    protected void dropFewItems(boolean par1, int par2)
    {
        super.dropFewItems(par1, par2);

        if (par1 && (this.rand.nextInt(3) == 0 || this.rand.nextInt(1 + par2) > 0))
        {
            this.dropItem(FunMod.SonicBoots.shiftedIndex, 1);
        }
    }
    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
    


} 