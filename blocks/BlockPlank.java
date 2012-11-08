package FunMod.blocks;

import FunMod.FunMod;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockPlank extends Block
{
        public BlockPlank(int i, int j)
        {
                super(i, j , Material.rock);
                this.blockIndexInTexture = 43;
                this.setCreativeTab(FunMod.funmodtab);
        }

        
public String getTextureFile(){       
return "/FunMod/cliente/texturas/texturas.png";}
}