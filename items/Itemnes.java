package FunMod.items;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ModLoader;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import FunMod.FunMod;
	public class Itemnes extends Item
	{
	        public Itemnes(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.setCreativeTab(FunMod.funmodtab);
	                this.iconIndex = 36;
	        
	        }
public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
	
	}