
	package FunMod.items;

import net.minecraft.item.Item;
import FunMod.FunMod;
	public class ItemBlade extends Item
	{
	        public ItemBlade(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.setCreativeTab(FunMod.funmodtab);
	                this.iconIndex = 20;
	        }
	public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
	
	}