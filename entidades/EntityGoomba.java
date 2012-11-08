package FunMod.entidades;

import FunMod.FunMod;
import net.minecraft.src.EntityAIAttackOnCollide;
import net.minecraft.src.EntityAINearestAttackableTarget;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;

public class EntityGoomba extends EntityMobFun
{
    public EntityGoomba(World par1World)
    {
        super(par1World);
        this.setSize(0.3F, 0.5F);
        texture = "/FunMod/cliente/texturas/Mobs/GoombaTexture.png"; 
        this.moveSpeed = 0.23F;
        this.attackStrength = 5;    
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
        
    }

    
    public int getMaxHealth()
    {
        return 20;
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
    /**
     * Returns the item ID for the item the mob drops on death.
     */
    
    protected int getDropItemId()
    {
        return FunMod.MarioCoin.shiftedIndex ;
    }
    
    protected void dropFewItems(boolean par1, int par2)
    {
        super.dropFewItems(par1, par2);

        if (par1 && (this.rand.nextInt(3) == 0 || this.rand.nextInt(1 + par2) > 0))
        {
            this.dropItem(FunMod.FireFlower.shiftedIndex, 1);
        }
    }
}