package FunMod.items;

import net.minecraft.item.Item;
import FunMod.FunMod;
	public class ItemCoalF extends Item
	{
	        public ItemCoalF(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.setCreativeTab(FunMod.funmodtab);
	                this.iconIndex = 46;
	        
	        }
public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
	
	}