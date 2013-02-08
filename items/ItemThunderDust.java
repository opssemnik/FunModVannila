
	package FunMod.items;
	import net.minecraft.item.Item;
import FunMod.FunMod;

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