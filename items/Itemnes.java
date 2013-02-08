package FunMod.items;

import net.minecraft.item.Item;
import FunMod.FunMod;
	public class Itemnes extends Item
	{
	        public Itemnes(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.setCreativeTab(FunMod.funmodtab);
	                this.iconIndex = 36;
	        
	        }
public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
	
	}