package opssemnik.minecraft.funmod.fixes;

import FunMod.FunMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class FMBlockHelper extends Block{

	protected FMBlockHelper(Material material) {
		super(material);
		this.setCreativeTab(FunMod.funmodtab);
	}

}
