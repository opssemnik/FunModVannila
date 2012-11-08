package FunMod.blocks;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

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