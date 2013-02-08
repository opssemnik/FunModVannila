package FunMod.items;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import FunMod.FunMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
	public class ItemSuperCog extends ItemFood
	{
	        public ItemSuperCog(int i, int j, boolean b)
	        {
	                super(i, i, b);
	                maxStackSize = 64;     
	                this.setCreativeTab(FunMod.funmodtab);
	                this.iconIndex = 4;
	        }
	public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}
		
		@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack){
	return EnumRarity.epic;
	
	
	
	}
	}