
	package FunMod.items;

import net.minecraft.item.Item;
import FunMod.FunMod;
	public class ItemStarman extends Item
	{
	        public ItemStarman(int i)
	        {
	                super(i);
	                maxStackSize = 1;     
	                this.setCreativeTab(FunMod.funmodtab);
	                this.iconIndex = 8;
	        }
public String getTextureFile(){
			
				return "/FunMod/cliente/texturas/texturas.png";
			}
	}