package FunMod.entidades;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import FunMod.FunMod;

public class EntitySonic extends EntityAnimal
{
    public EntitySonic(World par1World)
    {
        super(par1World);
      //  texture = "/FunMod/cliente/texturas/Mobs/Sonic.png"; 
        setSize(1F*1F, 0.8F*0.8F);       
        tasks.addTask(1, new EntityAIPanic(this, 0.15F));
        tasks.addTask(5, new EntityAIWander(this, 0.5F));
        tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6F));
        tasks.addTask(7, new EntityAILookIdle(this));
    }

    public boolean isAIEnabled()
    {
        return true; 
    }

 //   public int getMaxHealth()
  //  {
  //      return 30; 
   // }

    protected String getLivingSound()
    {
        return "mob.silverfish.say";
    }


    protected String getHurtSound()
    {
        return "mob.silverfish.hit";
    }


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
            this.dropItem(FunMod.SonicBoots, 1);
        }
    }
    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }

	@Override
	public EntityAgeable createChild(EntityAgeable var1) {
		return null;
	}

	
    
    


} 