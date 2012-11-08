
	package FunMod.items;
	import FunMod.FunMod;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

	public class ItemThunderDust extends Item
	{
	        public ItemThunderDust(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                this.setCreativeTab(FunMod.funmodtab);
	                this.iconIndex = 17;
	        }
	public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
	
	}