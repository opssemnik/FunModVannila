package FunMod.entidades;

import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
public class EntityPinky extends EntityMobFun
{
    public EntityPinky(World par1World)
    {
        super(par1World);
        this.setSize(0.3F, 0.7F);
       // this.texture = "/FunMod/cliente/texturas/Mobs/Pinky.png";
       // this.moveSpeed = 0.40F;
        this.attackStrength = 3;  
       // this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        
    }

    
   // public int getMaxHealth()
   // {
   //     return 20;
   // }

    protected boolean isAIEnabled()
    {
        return true;
    }

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
    
}