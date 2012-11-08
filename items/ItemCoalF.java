package FunMod.items;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ModLoader;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
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