package FunMod.blocks;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;
import FunMod.FunMod;
public class FantasyStone extends Block
{
    public FantasyStone(int par1, int par2)
    {
        super(par1, par2, Material.rock);
        this.blockIndexInTexture = 32;
        this.setCreativeTab(FunMod.funmodtab);
    }
 public String getTextureFile(){
	 return "/FunMod/cliente/texturas/texturas.png";
 }
 @Override
 public int idDropped(int par1, Random par2Random, int par3)
 {
     return FunMod.cobble.idDropped(0, par2Random, par3);
 }
}