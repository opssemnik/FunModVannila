package FunMod.items;

import net.minecraft.item.Item;
import FunMod.FunMod;
	public class ItemTvCima extends Item
	{
	        public ItemTvCima(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.setCreativeTab(FunMod.funmodtab);
	                this.iconIndex = 34;
	        
	        }
public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
	
	}