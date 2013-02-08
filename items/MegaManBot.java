/*    */ package FunMod.items;
/*    */ 
/*    */ import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
import FunMod.FunMod;
/*    */ public class MegaManBot extends ItemArmor
/*    */   implements IArmorTextureProvider
/*    */ {
/*    */   public MegaManBot(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
/*    */   {
/* 12 */     super(par1, par2EnumArmorMaterial, par3, par4);
/*    */ 
/* 15 */     this.iconIndex = 21;
             this.setCreativeTab(FunMod.funmodtab)  ; 
}
/*    */ 
/*    */   public String getArmorTextureFile(ItemStack par1)
/*    */   {
/* 21 */     if ((par1.itemID == FunMod.MegaManBoots.itemID) || (par1.itemID == FunMod.MegaManBoots.itemID) || 
/* 22 */       (par1.itemID == FunMod.MegaManBoots.itemID))
/* 23 */       return "/FunMod/cliente/texturas/armaduras/mega_1.png";
/* 24 */     if (par1.itemID == FunMod.MegaManBoots.itemID)
/* 25 */       return "/FunMod/cliente/armaduras/enx_bo.png";
/* 26 */     return "/FunMod/cliente/texturas/armaduras/mega_2.png";
/*    */   }
/*    */   public String getTextureFile() {
/* 29 */     return "/FunMod/cliente/texturas/texturas.png";
/*    */   }
/*    */ }

/* Location:           N:\a\
 * Qualified Name:     FunMod.ItealexBoots
 * JD-Core Version:    0.6.1
 */