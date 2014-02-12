package FunMod.entidades;

import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityHomemAranha extends EntityMobFun
{
    public EntityHomemAranha(World par1World)
    {
        super(par1World);
       // texture = "/FunMod/cliente/texturas/Mobs/Spiderman.png"; 
        setSize(0.9F, 1.3F);    
        this.attackStrength = 4;  
        tasks.addTask(1, new EntityAIPanic(this, 0.10F));
        tasks.addTask(2, new EntityAIWander(this, 0.4F));
       // this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityVenom.class, this.moveSpeed, false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityVenom.class, 0, true));
    }

    public boolean isAIEnabled()
    {
        return true; 
    }

   // public int getMaxHealth()
   // {
   //     return 25; 
  //  }

    protected String getLivingSound()
    {
        return "mob.spider";
    }

    protected String getHurtSound()
    {
        return "mob.spider";
    }

    protected String getDeathSound()
    {
        return "mob.spiderdeath";
    }
    protected float getSoundVolume()
    {
        return 0.4F;
    }
 public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
    public float spiderScaleAmount()
    {
        return 6.5F;
    }
    
    protected Item getDropItem()
    {
        return Items.string;
    }
    
}

	 