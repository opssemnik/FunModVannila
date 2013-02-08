package FunMod.items;

import net.minecraft.item.Item;
import FunMod.FunMod;
	public class ItemPearl extends Item
	{
	        public ItemPearl(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.setCreativeTab(FunMod.funmodtab);
	                this.iconIndex = 10;
	        
	        }
public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
	
	}