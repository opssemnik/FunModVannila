package FunMod.tabs;

import opssemnik.minecraft.funmod.fixes.StaticHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import FunMod.FunMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CTabFun extends CreativeTabs {
	public CTabFun(int par1, String par2Str) {
		super(par1, par2Str);

	}

	@SideOnly(Side.CLIENT)
	@Override
	public Item getTabIconItem() {
		return StaticHelper.FMItemLoader.Starman;
	}

}
