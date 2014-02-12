package FunMod.cliente.ticks;

import java.util.EnumSet;

import FunMod.FunMod;
import FunMod.loader.FunModHooks;
/**
 * Client-side tick handler for Obsidian Ingots. Used mainly for the update check upon startup.
 * @author AidanBrady
 *
 */
public class FunModClientTickHandler implements ITickHandler
{
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		if(FunMod.ticksPassed == 0 && ModLoader.getMinecraftInstance().theWorld != null && ModLoader.getMinecraftInstance().thePlayer != null)
		{
			FunModHooks.checkForUpdates(ModLoader.getMinecraftInstance().thePlayer);
			FunMod.ticksPassed++;
		}
	}
	
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		
	}

	public EnumSet<TickType> ticks() 
	{
		return EnumSet.of(TickType.CLIENT);
	}

	public String getLabel()
	{
		return "FunMod";
	}
}