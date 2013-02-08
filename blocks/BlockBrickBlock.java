package FunMod.blocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBrickBlock extends Block
{

                public BlockBrickBlock(int i, int j, int k)
                {
                        super(i, j, Material.rock);
                        this.blockIndexInTexture = 0;
                }
public String getTextureFile(){
		return "/FunMod/cliente/texturas/texturas.png";}		
  
    }               