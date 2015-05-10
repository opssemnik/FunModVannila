package FunMod.entidades;

import opssemnik.minecraft.funmod.fixes.StaticHelper;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import FunMod.FunMod;

public class EntityDarkLink extends EntityMobFun
{
    public EntityDarkLink(World par1World)
    {
        super(par1World);
       // texture = "/FunMod/cliente/texturas/Mobs/DarkLink.png"; 
        setSize(0.9F, 1.3F);  
       // this.moveSpeed = 0.5F;
        this.attackStrength = 8;  
       // this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLink.class, 0, true));
    }

    public boolean isAIEnabled()
    {
        return true; 
    }

  //  public int getMaxHealth()
   // {
   //     return 28; 
   // }

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
        return StaticHelper.FMItemLoader.PearlOfLink; 
    }

    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
    


} 