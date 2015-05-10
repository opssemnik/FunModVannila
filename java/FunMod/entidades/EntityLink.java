package FunMod.entidades;

import opssemnik.minecraft.funmod.fixes.StaticHelper;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import FunMod.FunMod;
public class EntityLink extends EntityMobFun
{
    private boolean isPeacefulCreature;

    private static final ItemStack defaultHeldItem = new ItemStack(StaticHelper.FMItemLoader.LinkSword , 0);
    
	public EntityLink(World par1World)
    {
        super(par1World);
       // texture = "/FunMod/cliente/texturas/Mobs/LINK.png"; 
        setSize(0.9F, 1.3F); 
      //  moveSpeed = 0.23F;
        attackStrength = 3;
        tasks.addTask(1, new EntityAIPanic(this, 0.20F));
        tasks.addTask(2, new EntityAIWander(this, 0.4F));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        
    }

    public boolean isAIEnabled()
    {
        return true; 
    }

  //  public int getMaxHealth()
  //  {
   //     return 25; 
   // }
    protected String getLivingSound()
    {
        return "mob.villager.default";
    }

    
    protected String getHurtSound()
    {
        return "mob.villager.defaulthurt";
    }

    
    protected String getDeathSound()
    {
        return "mob.villager.defaultdeath";
    }


    protected float getSoundVolume()
    {
        return 0.6F;
    }

    public boolean getPeacefulCreature()
    {
        return this.isPeacefulCreature;
    }
    
    protected Item getDropItem()
    {
        return Items.stone_sword; 
    }
    
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        return null; 
    }
    
    public ItemStack getHeldItem()
    {
    return defaultHeldItem; 
    }
    
}

	 