package opssemnik.minecraft.funmod.fixes;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import FunMod.FunMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FMItemHelper extends Item{
	private FMItemPropertyHelper hlp = new FMItemPropertyHelper();
  public FMItemHelper(){
	  super();
	  this.setCreativeTab(FunMod.funmodtab);
  }
  @SideOnly(Side.CLIENT)
  @Override
  public void registerIcons(IIconRegister iconRegister)
  {
      this.itemIcon = iconRegister.registerIcon(String.format("funmod:%s",this.getUnlocalizedName().toLowerCase().replace("item.","")));
  }

  public static class FMItemBowHelper extends ItemBow {
	  public FMItemBowHelper(){ super();this.setCreativeTab(FunMod.funmodtab); }
	  @SideOnly(Side.CLIENT)
	  @Override
	  public void registerIcons(IIconRegister iconRegister)
	  {
	      this.itemIcon = iconRegister.registerIcon(String.format("funmod:%s",this.getUnlocalizedName().toLowerCase().replace("item.","")));
	  }
  }
  public static class FMItemArmorHelper extends ItemArmor {

	public FMItemArmorHelper(ArmorMaterial material, int renderIndex,int armorType) {
		super(material, renderIndex, armorType);this.setCreativeTab(FunMod.funmodtab);
	}
	@SideOnly(Side.CLIENT)
	  @Override
	  public void registerIcons(IIconRegister iconRegister)
	  {
	      this.itemIcon = iconRegister.registerIcon(String.format("funmod:%s",this.getUnlocalizedName().toLowerCase().replace("item.","")));
	  }
	  
  }
  public static class FMItemSwordHelper extends ItemSword {
	  private FMItemPropertyHelper hlp = new FMItemPropertyHelper();
	  public FMItemSwordHelper(ToolMaterial mat){
		  super(mat);this.setCreativeTab(FunMod.funmodtab);
		  
	  }
	  @SideOnly(Side.CLIENT)
	  @Override
	  public void registerIcons(IIconRegister iconRegister)
	  {
	      this.itemIcon = iconRegister.registerIcon(String.format("funmod:%s",this.getUnlocalizedName().toLowerCase().replace("item.","")));
	  }
  }

public static class FMItemFoodHelper extends ItemFood{
	protected FMItemHelper hlp;
	protected FMItemPropertyHelper prophlp;
	
	public FMItemFoodHelper(int healAmount){
		super(healAmount, false);
		hlp = new FMItemHelper();
		prophlp = new FMItemPropertyHelper();
		this.setCreativeTab(FunMod.funmodtab);
	}
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack){
	return EnumRarity.common;
	}
	  @SideOnly(Side.CLIENT)
	  @Override
	  public void registerIcons(IIconRegister iconRegister)
	  {
	      this.itemIcon = iconRegister.registerIcon(String.format("funmod:%s",this.getUnlocalizedName().toLowerCase().replace("item.","")));
	  }

}
public static class FMItemPropertyHelper {
	
}

}