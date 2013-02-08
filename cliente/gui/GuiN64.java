package FunMod.cliente.gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.opengl.GL11;
public class GuiN64 extends GuiScreen
{
	public final int xSizeOfTexture = 176;
	public final int ySizeOfTexture = 88;
	public GuiN64(EntityPlayer player)
{

}
	 public void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	    {
	        int var4 = this.mc.renderEngine.getTexture("/gui/furnace.png");
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        this.mc.renderEngine.bindTexture(var4);
	        int var5 = (this.width - this.xSizeOfTexture) / 2;
	        int var6 = (this.height - this.ySizeOfTexture) / 2;
	        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSizeOfTexture, this.ySizeOfTexture);
	        int var7;

	       

	        
	    }
	

	public void initGui()
	{
	this.controlList.clear();

	         int posX = (this.width - xSizeOfTexture) / 2;
	         int posY = (this.height - ySizeOfTexture) / 2;

	this.controlList.add(new GuiButton(250, posX+ 40, posY + 40, 100, 20, "Teste"));
	}
	public void actionPerformed(GuiButton button, Entity par5Entity)
	{
		String var3 = "Lol";
		if (button.id == 250)
        {
         
	        mc.getMinecraft().thePlayer.addChatMessage("Haha Troll");
        
        
        }
		this.mc.ingameGUI.getChatGUI().printChatMessage(var3);
		
		
	}	
	
	}
