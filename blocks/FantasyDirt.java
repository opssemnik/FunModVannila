package FunMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import FunMod.FunMod;
public class FantasyDirt extends Block
{
    public FantasyDirt(int par1, int par2)
    {
        super(par1, par2, Material.ground);
        this.blockIndexInTexture = 28;
        this.setCreativeTab(FunMod.funmodtab);
    }
public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
}


