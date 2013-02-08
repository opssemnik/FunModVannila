package FunMod.items;

import net.minecraft.item.Item;
	public class ItemControle extends Item
	{
	        public ItemControle(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                
	                this.iconIndex = 35;
	        
	        }
     public String getTextureFile(){
    	 return "/FunMod/cliente/texturas/texturas.png";
     }
	
	}