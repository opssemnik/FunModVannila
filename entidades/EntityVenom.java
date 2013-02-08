package FunMod.entidades;

import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityVenom extends EntityMobFun
{
    

	private int attackStrength;

	public EntityVenom(World par1World)
    {
        super(par1World);
        this.texture = "/FunMod/cliente/texturas/Mobs/Venom.png";
        this.moveSpeed = 0.23F;
        attackStrength = 40;
        tasks.addTask(2, new EntityAIWander(this, 0.4F));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityHomemAranha.class, this.moveSpeed, false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityHomemAranha.class, 16.0F, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
        this.attackStrength = 4;  
    }

    
    public int getMaxHealth()
    {
        return 25;
    }

    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
   

    /**
     * Returns true if the newer Entity AI code should be run
     */
    protected boolean isAIEnabled()
    {
        return true;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.spider";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.spider";
    }

    /**
     * Returns the sound this mob makes on death.
     */
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
        return 8.5F;
    }
    
    protected int getDropItemId()
    {
        return Item.silk.itemID;
    }
    
}

	 