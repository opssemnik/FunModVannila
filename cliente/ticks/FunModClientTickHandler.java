package FunMod.cliente.ticks;

import net.minecraft.client.Minecraft;
import FunMod.FunMod;
import FunMod.loader.FunModHooks;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
public class FunModClientTickHandler extends TickEvent
{
	public FunModClientTickHandler(Type type, Side side, Phase phase) {
		super(type, side, phase);
		if(FunMod.ticksPassed == 0 && Minecraft.getMinecraft().theWorld != null && Minecraft.getMinecraft().thePlayer != null)
		{
			FunModHooks.checkForUpdates(Minecraft.getMinecraft().thePlayer);
			FunMod.ticksPassed++;
		}
	}

}