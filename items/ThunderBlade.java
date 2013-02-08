package FunMod.items;

import net.minecraft.item.Item;
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