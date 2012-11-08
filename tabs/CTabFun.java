package FunMod.tabs;

import FunMod.FunMod;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.StringTranslate;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class CTabFun extends CreativeTabs {
	public CTabFun(int par1, String par2Str) {
super(par1, par2Str);

}
@SideOnly(Side.CLIENT)
@Override
public int getTabIconItemIndex() {
return FunMod.Starman.shiftedIndex;
}

}
