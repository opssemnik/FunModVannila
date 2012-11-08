package FunMod.items;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ModLoader;
import FunMod.FunMod;
	public class ThunderBlade extends Item
	{
	        public ThunderBlade(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.setCreativeTab(FunMod.funmodtab);
	                this.iconIndex = 11;
	        }
	public String getTextureFile(){
	  return "/FunMod/cliente/texturas/texturas.png";}      
	}