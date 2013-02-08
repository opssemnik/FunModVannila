package FunMod.blocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import FunMod.FunMod;
public class MysticalStone extends Block
{

                public MysticalStone(int i, int j, int k)
                {
                        super(i, j, Material.rock);
                        this.blockIndexInTexture = 42;
                        this.setCreativeTab(FunMod.funmodtab);
                }
public String getTextureFile(){
		return "/FunMod/cliente/texturas/texturas.png";}		
  
    }               