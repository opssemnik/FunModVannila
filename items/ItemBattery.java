package FunMod.items;

import net.minecraft.item.Item;
import FunMod.FunMod;
	public class ItemBattery extends Item
	{
	        public ItemBattery(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.setCreativeTab(FunMod.funmodtab);
	                this.iconIndex = 7;
	        
	        }
public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
	
	}