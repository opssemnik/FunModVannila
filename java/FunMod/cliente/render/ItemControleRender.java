
package FunMod.cliente.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import FunMod.cliente.model.ModelControle;

public class ItemControleRender implements IItemRenderer
{
 private static ModelControle staffModel = new ModelControle();

 public boolean handleRenderType(ItemStack item, ItemRenderType type) 
 {
  if (type == ItemRenderType.EQUIPPED) { return true; }
  return false;
 }

 public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) 
 {
  return false;
 }

 public void renderItem(ItemRenderType type, ItemStack item, Object... data) 
 {
	 if (type == ItemRenderType.EQUIPPED) {
		   if ((data[1] != null) && ((data[1] instanceof EntityPlayer)))
		      {
		        if (((EntityPlayer)data[1] != Minecraft.getMinecraft().renderViewEntity) || (Minecraft.getMinecraft().gameSettings.thirdPersonView != 0) || (((Minecraft.getMinecraft().currentScreen instanceof GuiInventory)) && (RenderManager.instance.playerViewY == 140.0F)))
		        {
		          GL11.glTranslatef(0.65F, 0.75F, 0.0F);
		        }
		        else
		        {
		          GL11.glTranslatef(0.45F, 0.75F, 0.0F);
		        }
		       
		      }
		      else
		      {
		        GL11.glTranslatef(0.65F, 0.75F, 0.0F);
		        
		      }
		     // ForgeHooksClient.bindTexture("/FunMod/cliente/texturas/modelos/controle.png", 0);
		      GL11.glScalef(1.8F, 1.8F, 1.8F);
		      GL11.glRotatef(-110.0F, 0.0F, 1.0F, 0.0F);
		      GL11.glRotatef(55.0F, 1.0F, -0.0F, 0.0F);
		      GL11.glRotatef(201.0F, 0.0F, 0.0F, 1.0F);

		      ItemControleRender.staffModel.render((Entity)data[1], 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.0625F);
		     // ForgeHooksClient.unbindTexture();
	 }   
	 switch (type)
  {
  case ENTITY: renderItem(type, item, data);
  case EQUIPPED: renderEquippedItem(null, null, item); break;
  case INVENTORY: renderItem(type, item, data);
  default: break;
  }
 }

 public void renderEquippedItem(RenderBlocks var1, EntityLiving var2, ItemStack var3)
 {
     
	 GL11.glPushMatrix();
     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
     GL11.glPopMatrix();
 }
}
