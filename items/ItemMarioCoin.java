
	package FunMod.items;

import net.minecraft.item.Item;
import FunMod.FunMod;
	public class ItemMarioCoin extends Item
	{
	        public ItemMarioCoin(int i)
	        {
	                super(i);
	                maxStackSize = 16;     
	                this.setCreativeTab(FunMod.funmodtab);
	                this.iconIndex = 6;
	        }
public String getTextureFile(){
				
				return "/FunMod/cliente/texturas/texturas.png";
			}
	}