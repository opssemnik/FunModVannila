/*    */ package FunMod.items;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.IArmorTextureProvider;
import FunMod.FunMod;
/*    */ public class SonicBoots extends ItemArmor
/*    */   implements IArmorTextureProvider
/*    */ {
/*    */   public SonicBoots(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
/*    */   {
/* 12 */     super(par1, par2EnumArmorMaterial, par3, par4);
/*    */ 
/* 15 */     this.iconIndex = 25;
/*    */     this.setCreativeTab(FunMod.funmodtab);
}

       public String getTextureFile() {
     return "/FunMod/cliente/texturas/texturas.png";
       }     

@Override
public String getArmorTextureFile(ItemStack par1) {
	 if (par1.itemID == FunMod.SonicBoots.itemID)
		        return "/FunMod/cliente/texturas/armaduras/sonic_2.png";
	 return "/FunMod/cliente/texturas/armaduras/sonic_2.png";
}

public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack2)

{
 if(itemStack2.getItem().itemID == this.itemID){
	 player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10));
 }

 }
}

