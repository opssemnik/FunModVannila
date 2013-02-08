package FunMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import FunMod.FunMod;

public class BlocCobble extends Block
{
        public BlocCobble(int i, int j)
        {
                super(i, j , Material.rock);
                this.blockIndexInTexture = 44;
                this.setCreativeTab(FunMod.funmodtab);
        }

        
public String getTextureFile(){       
return "/FunMod/cliente/texturas/texturas.png";}
}