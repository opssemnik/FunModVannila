package FunMod.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.util.ChatComponentText;
import FunMod.FunMod;
import FunMod.enums.EnumColor;
import cpw.mods.fml.server.FMLServerHandler;



public class FunModHooks
{
	
	public static void checkForUpdates(EntityPlayer entityplayer)
	{
		if(!(FunMod.latestVersionNumber.equals("Error retrieving data.")) && !(FunMod.latestVersionNumber.equals(FunMod.versionNumber.toString())))
		{
			entityplayer.addChatMessage(new ChatComponentText(EnumColor.GREY.code + "Your version of " + EnumColor.DARK_BLUE.code + "FunMod " + EnumColor.GREY.code + "(" + EnumColor.DARK_GREY.code + FunMod.versionNumber.toString() + EnumColor.GREY.code + ") is outdated. Please update to version " + EnumColor.RED.code + FunMod.latestVersionNumber + EnumColor.ORANGE.code + FunMod.recentNews));
		}
		else if(FunMod.latestVersionNumber.equals("Error retrieving data."))
		{
			System.out.println("[FunMod] Minecraft is in offline mode, could not check for updates.");
		}
	}
	
	public static String getLatestVersion()
	{
		String[] text = getHTML("https://dl.dropbox.com/u/77390445/vercao.txt").split(":");
		if(!text[0].contains("UTF-8") && !text[0].contains("HTML")) return text[0];
		return "Error retrieving data.";
	}

	
	public static String getRecentNews()
	{
		String[] text = getHTML("https://dl.dropbox.com/u/77390445/vercao.txt").split(":");
		if(text.length > 1 && !text[1].contains("UTF-8") && !text[1].contains("HTML")) return text[1];
		return "There is no news to show.";
	}

	public static String getHTML(String urlToRead) 
	{
		StringBuilder sb = new StringBuilder();
		URL url;
		HttpURLConnection conn;
		BufferedReader rd;
		String line;
		String result = "";
		try {
			url = new URL(urlToRead);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				result += line;
				sb.append(line);
			}
			rd.close();
		} catch (Exception e) {
			result = "Error retrieving data.";
			System.err.println("[FunMod] An error occured while connecting to URL '" + urlToRead + ".'");
		}
		return result;
	}
	public static void sendChatMessageToPlayer(String playerUsername, String msg)
	{
		EntityPlayer player = FMLServerHandler.instance().getServer().getConfigurationManager().getPlayerForUsername(playerUsername);
		C01PacketChatMessage chatPacket = new C01PacketChatMessage(msg);
		if(player != null)
		{
			((EntityPlayerMP)player).playerNetServerHandler.sendPacket(chatPacket);
		}
	}
	public static boolean isLatestVersion()
	{
		return FunMod.versionNumber.toString().equals(FunMod.latestVersionNumber);
	}

	
	public static boolean isOffline()
	{
		try {
			new URL("http://www.google.com").openConnection().connect();
			return true;
		} catch (IOException e)
		{
			return false;
		}
	}
}