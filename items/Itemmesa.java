package FunMod.items;

import net.minecraft.item.Item;
import FunMod.FunMod;
	public class Itemmesa extends Item
	{
	        public Itemmesa(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.setCreativeTab(FunMod.funmodtab);
	                this.iconIndex = 37;
	        
	        }
public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
	
	}