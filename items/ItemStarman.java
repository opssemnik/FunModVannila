
	package FunMod.items;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ModLoader;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
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