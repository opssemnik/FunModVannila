/*    */ package FunMod.items;
/*    */ 
/*    */ import net.minecraft.src.EnumArmorMaterial;
/*    */ import net.minecraft.src.Item;
/*    */ import net.minecraft.src.ItemArmor;
/*    */ import net.minecraft.src.ItemStack;
/*    */ import net.minecraftforge.common.IArmorTextureProvider;
/*    */ import FunMod.FunMod;
/*    */ public class MegaManChest extends ItemArmor
/*    */   implements IArmorTextureProvider
/*    */ {
/*    */   public MegaManChest(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
/*    */   {
/* 12 */     super(par1, par2EnumArmorMaterial, par3, par4);
/*    */     this.setCreativeTab(FunMod.funmodtab);
/* 14 */     this.iconIndex = 22;
/*    */   }
/*    */ 
/*    */   public String getArmorTextureFile(ItemStack par1)
/*    */   {
/* 21 */     if ((par1.itemID == FunMod.MegaManChest.shiftedIndex) || (par1.itemID == FunMod.MegaManChest.shiftedIndex) || 
/* 22 */       (par1.itemID == FunMod.MegaManChest.shiftedIndex))
/* 23 */       return "/FunMod/cliente/texturas/armaduras/mega_1.png";
/* 24 */     if (par1.itemID == FunMod.MegaManChest.shiftedIndex)
/* 25 */       return "FunMod/cliente/texturas/armaduras/mega_leg.png";
/* 26 */     return "/FunMod/cliente/texturas/armaduras/mega_2.png";
/*    */   }
/*    */   public String getTextureFile() {
/* 29 */     return "/FunMod/cliente/texturas/texturas.png";
/*    */   }
/*    */ }

/* Location:           N:\a\
 * Qualified Name:     FunMod.ItemalexPlate
 * JD-Core Version:    0.6.1
 */