package FunMod.comandos;
import java.util.Arrays;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import FunMod.FunMod;
import FunMod.enums.EnumColor;
import FunMod.ftp.ThreadFunModUpdater;
import FunMod.loader.FunModHooks;

public class CommandFun extends CommandBase
{
    public String getCommandName()
    {
        return "fun";
    }
    
    public String getCommandUsage(ICommandSender sender)
    {
    	return "/fun <parameters>";
    }
    public int getRequiredPermissionLevel()
    {
        return 2;
    }

	public List getCommandAliases()
	{
		return Arrays.asList(new String[] {"obsidian", "FunMod"});
	}
	/** Era isso que nao deixava eu usar o comando em single player *_*
    public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return !MinecraftServer.getServer().isSinglePlayer() && super.canCommandSenderUseCommand(sender);
    }
	**/
    public void processCommand(ICommandSender sender, String[] params)
    {
        if(params.length < 1)
        {
            sender.sendChatToPlayer(EnumColor.GREY.code + "-------- " + EnumColor.DARK_BLUE.code + "[FunMod]" + EnumColor.GREY.code + " --------");
            sender.sendChatToPlayer(EnumColor.GREY.code + " *Version: " + EnumColor.DARK_GREY.code + FunMod.versionNumber);
            sender.sendChatToPlayer(EnumColor.GREY.code + " *Latest Version: " + EnumColor.DARK_GREY.code + FunMod.latestVersionNumber);
            sender.sendChatToPlayer(EnumColor.GREY.code + " *Developed on Mac OS X 10.8 Mountain Lion, Eclipse Juno emulated with vmware (windows 7 workspace)");
            sender.sendChatToPlayer(EnumColor.GREY.code + " *This mod is made by Brazilian Cool Guys");
            sender.sendChatToPlayer(EnumColor.GREY.code + " *Recent News: " + EnumColor.INDIGO.code + FunMod.recentNews);
            sender.sendChatToPlayer(EnumColor.GREY.code + "-------- " + EnumColor.ORANGE.code + "Type /fun help For Help" + EnumColor.GREY.code + " --------");
            sender.sendChatToPlayer(EnumColor.GREY.code + "-------- " + EnumColor.DARK_BLUE.code + "[============]" + EnumColor.GREY.code + " --------");
        }
        else if(params.length == 1)
        {
	        if(params[0].equalsIgnoreCase("update"))
	        {
	        	if(FunModHooks.isLatestVersion())
	        	{
	        		sender.sendChatToPlayer(EnumColor.DARK_BLUE.code + "[FunMod] " + EnumColor.GREY.code + "FunMod is already up-to-date.");
	        	}
	        	else {
	        		sender.sendChatToPlayer(EnumColor.DARK_BLUE.code + "[FunMod] " + EnumColor.GREY.code + "Preparing to update...");
	        		new ThreadFunModUpdater("http://dl.dropbox.com/u/90411166/FunMod.jar", sender);
	        	}
	        }
	        
	        else if(params[0].equalsIgnoreCase("help"))
	        {
	            sender.sendChatToPlayer(EnumColor.GREY.code + "-------- " + EnumColor.DARK_BLUE.code + "[FunMod]" + EnumColor.GREY.code + " --------");
	            sender.sendChatToPlayer(EnumColor.INDIGO.code + " /fun" + EnumColor.GREY.code + " -- displays the main page.");
	            sender.sendChatToPlayer(EnumColor.INDIGO.code + " /fun help" + EnumColor.GREY.code + " -- displays this guide.");
	            sender.sendChatToPlayer(EnumColor.INDIGO.code + " /fun update" + EnumColor.GREY.code + " -- updates the Obsidian Ingots server.");
	            sender.sendChatToPlayer(EnumColor.INDIGO.code + " /fun version" + EnumColor.GREY.code + " -- displays the version number.");
	            sender.sendChatToPlayer(EnumColor.INDIGO.code + " /fun news" + EnumColor.GREY.code + " -- displays most recent recent news.");
	            sender.sendChatToPlayer(EnumColor.GREY.code + "-------- " + EnumColor.DARK_BLUE.code + "[============]" + EnumColor.GREY.code + " --------");
	        }
	        
	        else if(params[0].equalsIgnoreCase("version"))
	        {
	        	sender.sendChatToPlayer(EnumColor.DARK_BLUE.code + "[FunMod]" + EnumColor.GREY.code + " This server is running on version " + EnumColor.DARK_GREY.code + FunMod.versionNumber.toString() + EnumColor.GREY.code + ".");
	        }
	        
	        else if(params[0].equalsIgnoreCase("news"))
	        {
	        	sender.sendChatToPlayer(EnumColor.DARK_BLUE.code + "[FunMod]" + EnumColor.GREY.code + " Most recent news: " + EnumColor.INDIGO.code + FunMod.recentNews);
	        }
	        
	        else if(params[0].equalsIgnoreCase("latest"))
	        {
	        	sender.sendChatToPlayer(EnumColor.DARK_BLUE.code + "[FunMod]" + EnumColor.GREY.code + " The latest version for this mod is " + EnumColor.DARK_GREY.code + FunMod.latestVersionNumber + EnumColor.GREY.code + ".");
	        }
	        
	        else {
	        	sender.sendChatToPlayer(EnumColor.DARK_BLUE.code + "[FunMod]" + EnumColor.GREY.code + " Unknown command. Type '" + EnumColor.INDIGO.code + "/fun help" + EnumColor.GREY.code + "' for help.");
	        }
        }
    }
}