package FunMod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import FunMod.FunMod;
public class SonicBoots extends ItemArmor
{
  public SonicBoots(int par1, ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
  {
    super(par2EnumArmorMaterial, par3, par4);
    this.setCreativeTab(FunMod.funmodtab);
}
/*
@Override
public String getArmorTextureFile(ItemStack par1) {
	 if (par1.itemID == FunMod.SonicBoots.itemID)
		        return "/FunMod/cliente/texturas/armaduras/sonic_2.png";
	 return "/FunMod/cliente/texturas/armaduras/sonic_2.png";
}
*/
public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack2)

{
 if(itemStack2.getItem() == this){
	 player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10));
 }

 }
}

