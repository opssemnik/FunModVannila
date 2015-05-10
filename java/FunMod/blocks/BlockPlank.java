package FunMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import FunMod.FunMod;

public class BlockPlank extends Block
{
        public BlockPlank(int i, int j)
        {
                super(Material.rock);
                this.setCreativeTab(FunMod.funmodtab);
        }
}