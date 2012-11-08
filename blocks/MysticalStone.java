package FunMod.blocks;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
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