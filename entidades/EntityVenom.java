package FunMod.entidades;

import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityVenom extends EntityMobFun {

	public EntityVenom(World par1World) {
		super(par1World);
		//this.texture = "/FunMod/cliente/texturas/Mobs/Venom.png";
		//this.moveSpeed = 0.23F;
		tasks.addTask(2, new EntityAIWander(this, 0.4F));
		//this.tasks.addTask(1, new EntityAIAttackOnCollide(this,
				//EntityHomemAranha.class, this.moveSpeed, false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this,
				EntityHomemAranha.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityPlayer.class, 0, true));
	}

	//public int getMaxHealth() {
	//	return 25;
	//}

	protected boolean isAIEnabled() {
		return true;
	}

	protected String getLivingSound() {
		return "mob.spider";
	}

	protected String getHurtSound() {
		return "mob.spider";
	}

	protected String getDeathSound() {
		return "mob.spiderdeath";
	}

	protected float getSoundVolume() {
		return 0.4F;
	}

	public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal) {
		return null;
	}

	public float spiderScaleAmount() {
		return 8.5F;
	}

	protected Item getDropItem() {
		return Items.string;
	}

}
