 package FunMod.items;
 
 import net.minecraft.item.ItemArmor;
import FunMod.FunMod;
 public class MegaManHelm extends ItemArmor
 {
   public MegaManHelm(int par1, ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
   {
    super(par2EnumArmorMaterial, par3, par4);
              this.setCreativeTab(FunMod.funmodtab);    
}
 /*
   public String getArmorTextureFile(ItemStack par1)
   {
   if ((par1.itemID == FunMod.MegaManHelmet.itemID) || (par1.itemID == FunMod.MegaManHelmet.itemID) || 
     (par1.itemID == FunMod.MegaManHelmet.itemID))
    return "/FunMod/cliente/texturas/armaduras/mega_1.png";
  if (par1.itemID == FunMod.MegaManHelmet.itemID)
      return "/FunMod/cliente/texturas/armaduras/mega_1.png";
    return "/FunMod/cliente/texturas/armaduras/mega_2.png";
   }
 */
 }