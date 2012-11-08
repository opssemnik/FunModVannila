package FunMod.items;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumRarity;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import FunMod.FunMod;
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