package FunMod.entidades;

import opssemnik.minecraft.funmod.fixes.StaticHelper;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import FunMod.FunMod;

public class EntityGoomba extends EntityMobFun
{
    public EntityGoomba(World par1World)
    {
        super(par1World);
        this.setSize(0.3F, 0.5F);
       // texture = "/FunMod/cliente/texturas/Mobs/GoombaTexture.png"; 
        //this.moveSpeed = 0.23F;
        this.attackStrength = 5;    
       // this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        
    }

    
  //  public int getMaxHealth()
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
 
    protected Item getDropItem()
    {
        return StaticHelper.FMItemLoader.MarioCoin;
    }
    
    protected void dropFewItems(boolean par1, int par2)
    {
        super.dropFewItems(par1, par2);

        if (par1 && (this.rand.nextInt(3) == 0 || this.rand.nextInt(1 + par2) > 0))
        {
            this.dropItem(StaticHelper.FMItemLoader.FireFlower, 1);
        }
    }
}