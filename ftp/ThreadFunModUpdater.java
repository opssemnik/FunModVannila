package FunMod.ftp;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import FunMod.FunMod;
import FunMod.enums.EnumColor;
public class ThreadFunModUpdater extends Thread
{
	private ICommandSender sender;
	private int bytesDownloaded;
	private int lastBytesDownloaded;
	private byte[] buffer = new byte[10240];
	private URL url;
	
	public ThreadFunModUpdater(String location, ICommandSender player)
	{
		sender = player;
		try {
			url = new URL(location);
			setDaemon(true);
			start();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public void run()
	{
	//	File download = new File(new StringBuilder().append(Minecraft.getMinecraft().getMinecraftDir()).append("/mods/FunMod.jar").toString());
		try {
			//prepareForDownload();
		//	download.createNewFile();
		//	FileOutputStream outputStream = new FileOutputStream(download.getAbsolutePath());
			InputStream stream = url.openStream();
			
			while((lastBytesDownloaded = stream.read(buffer)) > 0)
			{
				//outputStream.write(buffer, 0, lastBytesDownloaded);
				buffer = new byte[10240];
				bytesDownloaded += lastBytesDownloaded;
			}
			
			//outputStream.close();
			stream.close();
			sender.addChatMessage(new ChatComponentText(EnumColor.DARK_BLUE.code + "[FunMod] " + EnumColor.GREY.code + "Successfully updated to version " + EnumColor.DARK_GREY.code + FunMod.latestVersionNumber));
			System.out.println("[FunMod] Successfully updated to latest version (" + FunMod.latestVersionNumber + ").");
			finalize();
			
		} catch(Throwable e)
		{
			sender.addChatMessage(new ChatComponentText(EnumColor.DARK_BLUE.code + "[FunMod] " + EnumColor.GREY.code + "Unable to update to version " + EnumColor.DARK_GREY.code + FunMod.latestVersionNumber));
			System.err.println("[FunMod] Error while finishing update thread: " + e.getMessage());
			try {
				finalize();
			} catch (Throwable e1) {
				System.err.println("[FunMod] Error while finalizing update thread: " + e1.getMessage());
			}
		}
	}
	/*
	public void prepareForDownload()
	{
		File download = new File(new StringBuilder().append(Minecraft.getMinecraft().()).append("/mods/FunMod.jar").toString());
		File config = new File(new StringBuilder().append(Minecraft.getMinecraft().getMinecraftDir()).append("/config/FunMod.cfg").toString());
		
		if(download.exists())
		{
			download.delete();
		}
		if(config.exists())
		{
			config.delete();
		}
		System.out.println("[FunMod] Preparing to update...");
	}
	*/
}