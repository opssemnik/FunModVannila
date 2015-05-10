package opssemnik.minecraft.funmod.fixes;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.monster.IMob;
import net.minecraft.world.World;

public class FMEntityHelper extends EntityCreature implements IMob{

	public FMEntityHelper(World world) {
		super(world);
		
	}

}
