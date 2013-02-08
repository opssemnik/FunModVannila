package FunMod.comandos;

import net.minecraft.command.ServerCommandManager;
import cpw.mods.fml.common.FMLCommonHandler;



public class ServerCommandHandler 
{
	public static boolean initialized = true;

	public static void initialize()
	{
		

			ServerCommandManager manager = (ServerCommandManager)FMLCommonHandler.instance().getMinecraftServerInstance().getCommandManager();
			manager.registerCommand(new CommandFun());
		}
	}
