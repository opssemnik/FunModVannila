package FunMod.tabs;

import net.minecraft.creativetab.CreativeTabs;
import FunMod.FunMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CTabFun extends CreativeTabs {
	public CTabFun(int par1, String par2Str) {
super(par1, par2Str);

}
@SideOnly(Side.CLIENT)
@Override
public int getTabIconItemIndex() {
return FunMod.Starman.itemID;
}

}
