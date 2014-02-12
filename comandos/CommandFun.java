package FunMod.comandos;
import java.util.Arrays;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import FunMod.FunMod;
import FunMod.enums.EnumColor;
import FunMod.ftp.ThreadFunModUpdater;
import FunMod.loader.FunModHooks;

public class CommandFun extends CommandBase
{
	private ICommandSender senderr;//Meio q um hack pra n te q subistuir td
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
public void mesage(String oq){
	senderr.addChatMessage(new ChatComponentText(oq));
}
	public List<String> getCommandAliases()
	{
		return Arrays.asList(new String[] {"obsidian", "FunMod"});
	}
    public void processCommand(ICommandSender sender, String[] params)
    {
        if(params.length < 1)
        {
            this.mesage(EnumColor.GREY.code + "-------- " + EnumColor.DARK_BLUE.code + "[FunMod]" + EnumColor.GREY.code + " --------");
            this.mesage(EnumColor.GREY.code + " *Version: " + EnumColor.DARK_GREY.code + FunMod.versionNumber);
            this.mesage(EnumColor.GREY.code + " *Latest Version: " + EnumColor.DARK_GREY.code + FunMod.latestVersionNumber);
            this.mesage(EnumColor.GREY.code + " *Developed on Mac OS X 10.8 Mountain Lion, Eclipse Juno emulated with vmware (windows 7 workspace)");
            this.mesage(EnumColor.GREY.code + " *This mod is made by Brazilian Cool Guys");
            this.mesage(EnumColor.GREY.code + " *Recent News: " + EnumColor.INDIGO.code + FunMod.recentNews);
            this.mesage(EnumColor.GREY.code + "-------- " + EnumColor.ORANGE.code + "Type /fun help For Help" + EnumColor.GREY.code + " --------");
            this.mesage(EnumColor.GREY.code + "-------- " + EnumColor.DARK_BLUE.code + "[============]" + EnumColor.GREY.code + " --------");
        }
        else if(params.length == 1)
        {
	        if(params[0].equalsIgnoreCase("update"))
	        {
	        	if(FunModHooks.isLatestVersion())
	        	{
	        		this.mesage(EnumColor.DARK_BLUE.code + "[FunMod] " + EnumColor.GREY.code + "FunMod is already up-to-date.");
	        	}
	        	else {
	        		this.mesage(EnumColor.DARK_BLUE.code + "[FunMod] " + EnumColor.GREY.code + "Preparing to update...");
	        		new ThreadFunModUpdater("http://dl.dropbox.com/u/90411166/FunMod.jar", sender);
	        	}
	        }
	        
	        else if(params[0].equalsIgnoreCase("help"))
	        {
	            this.mesage(EnumColor.GREY.code + "-------- " + EnumColor.DARK_BLUE.code + "[FunMod]" + EnumColor.GREY.code + " --------");
	            this.mesage(EnumColor.INDIGO.code + " /fun" + EnumColor.GREY.code + " -- displays the main page.");
	            this.mesage(EnumColor.INDIGO.code + " /fun help" + EnumColor.GREY.code + " -- displays this guide.");
	            this.mesage(EnumColor.INDIGO.code + " /fun update" + EnumColor.GREY.code + " -- updates the Obsidian Ingots server.");
	            this.mesage(EnumColor.INDIGO.code + " /fun version" + EnumColor.GREY.code + " -- displays the version number.");
	            this.mesage(EnumColor.INDIGO.code + " /fun news" + EnumColor.GREY.code + " -- displays most recent recent news.");
	            this.mesage(EnumColor.GREY.code + "-------- " + EnumColor.DARK_BLUE.code + "[============]" + EnumColor.GREY.code + " --------");
	        }
	        
	        else if(params[0].equalsIgnoreCase("version"))
	        {
	        	this.mesage(EnumColor.DARK_BLUE.code + "[FunMod]" + EnumColor.GREY.code + " This server is running on version " + EnumColor.DARK_GREY.code + FunMod.versionNumber.toString() + EnumColor.GREY.code + ".");
	        }
	        
	        else if(params[0].equalsIgnoreCase("news"))
	        {
	        	this.mesage(EnumColor.DARK_BLUE.code + "[FunMod]" + EnumColor.GREY.code + " Most recent news: " + EnumColor.INDIGO.code + FunMod.recentNews);
	        }
	        
	        else if(params[0].equalsIgnoreCase("latest"))
	        {
	        	this.mesage(EnumColor.DARK_BLUE.code + "[FunMod]" + EnumColor.GREY.code + " The latest version for this mod is " + EnumColor.DARK_GREY.code + FunMod.latestVersionNumber + EnumColor.GREY.code + ".");
	        }
	        
	        else {
	        	this.mesage(EnumColor.DARK_BLUE.code + "[FunMod]" + EnumColor.GREY.code + " Unknown command. Type '" + EnumColor.INDIGO.code + "/fun help" + EnumColor.GREY.code + "' for help.");
	        }
        }
    }
}