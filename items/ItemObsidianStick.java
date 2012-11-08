
	package FunMod.items;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import FunMod.FunMod;
	public class ItemObsidianStick extends Item
	{
	        public ItemObsidianStick(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.setCreativeTab(FunMod.funmodtab);
	                this.iconIndex = 19;
	        }
	public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
	
	}