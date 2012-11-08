package FunMod.blocks;

import FunMod.FunMod;
import net.minecraft.src.Block;
import net.minecraft.src.Material;

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