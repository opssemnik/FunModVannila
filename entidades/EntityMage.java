package FunMod.entidades;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import FunMod.FunMod;
public class EntityMage extends EntityMobFun
{
	
    public EntityMage(World par1World)
    {
        super(par1World);
     //   texture = "/FunMod/cliente/texturas/Mobs/firemage.png"; 
        setSize(0.9F, 1.0F);      
       // this.moveSpeed = 0.4F;
        this.attackStrength = 2;  
       // this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, , false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
    }

    public boolean isAIEnabled()
    {
        return true; 
    }

 //   public int getMaxHealth()
  //  {
  //      return 20; 
 //   }

    public boolean attackEntityAsMob(Entity par1Entity)
    {
        if (super.attackEntityAsMob(par1Entity))
        {
            if (par1Entity instanceof EntityLiving)
            {
                byte var2 = 0;

                if (this.worldObj.difficultySetting.getDifficultyId() > 1)
                {
                    if (this.worldObj.difficultySetting.getDifficultyId() == 2)
                    {
                        var2 = 7;
                    }
                    else if (this.worldObj.difficultySetting.getDifficultyId() == 3)
                    {
                        var2 = 15;
                    }
                }

                if (var2 > 0)
                {
                    ((EntityLiving)par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, var2 * 20, 0));
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    protected String getLivingSound()
    {
        return "mob.zombiepig.zpig";
    }
    protected String getHurtSound()
    {
        return "mob.zombiepig.zpighurt";
    }
    protected String getDeathSound()
    {
        return "mob.zombiepig.zpigdeath";
    }
    protected float getSoundVolume()
    {
        return 0.4F;
    }
    protected Item getDropItem()
    {
        return FunMod.MarioCoin; 
    }

    protected void dropFewItems(boolean par1, int par2)
    {
        super.dropFewItems(par1, par2);

        if (par1 && (this.rand.nextInt(3) == 0 || this.rand.nextInt(1 + par2) > 0))
        {
            this.dropItem(FunMod.ObsidianStick, 1);
        }
    }
    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
    
   

} 