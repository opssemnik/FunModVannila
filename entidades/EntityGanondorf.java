package FunMod.entidades;

import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import FunMod.FunMod;

public class EntityGanondorf extends EntityMobFun
{
    public EntityGanondorf(World par1World)
    {
        super(par1World);
      //  texture = "/FunMod/cliente/texturas/Mobs/Ganondorf.png"; 
        setSize(1F*1F, 2F*2F); 
       // this.moveSpeed = 0.5F;
        this.attackStrength = 7;
       // this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
    }

    public boolean isAIEnabled()
    {
        return true; 
    }

   // public int getMaxHealth()
   // {
   //     return 30; 
    //}

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
            this.dropItem(FunMod.Blade, 1);
        }
    }
    
    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
    


} 