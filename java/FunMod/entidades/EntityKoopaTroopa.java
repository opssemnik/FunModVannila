package FunMod.entidades;

import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameData;

public class EntityKoopaTroopa extends EntityMobFun 
{
    public EntityKoopaTroopa(World par1World)
    {
        super(par1World);
        this.setSize(0.3F, 0.7F);
      //  this.texture = "/FunMod/cliente/texturas/Mobs/Koopa.png";
       // this.moveSpeed = 0.23F;
        attackStrength = 5;
      //  this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        
    }

    
   // public int getMaxHealth()
   // {
   //     return 24;
  //  }

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
    
    protected Item getDropItem()
    {
        return GameData.itemRegistry.get(2);
    }
    
}