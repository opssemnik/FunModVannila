package FunMod.cliente.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import FunMod.cliente.model.ModelNess;

public class RenderNess extends RenderLiving
{
    public RenderNess(ModelNess par1ModelNess, float par2) {
		super(par1ModelNess, par2);
	}

	protected void renderName(EntityPlayer par1EntityPlayer, double par2, double par4, double par6)
    {
        if (Minecraft.isGuiEnabled() && par1EntityPlayer != this.renderManager.livingPlayer)
        {
            float var8 = 1.6F;
            float var9 = 0.016666668F * var8;
            double var10 = par1EntityPlayer.getDistanceSqToEntity(this.renderManager.livingPlayer);
            float var12 = par1EntityPlayer.isSneaking() ? 32.0F : 64.0F;

            if (var10 < (double)(var12 * var12))
            {
                String var13 = Minecraft.getMinecraft().thePlayer.getDisplayName();

                if (par1EntityPlayer.isSneaking())
                {
                    FontRenderer var14 = this.getFontRendererFromRenderManager();
                    GL11.glPushMatrix();
                    GL11.glTranslatef((float)par2 + 0.0F, (float)par4 + 2.3F, (float)par6);
                    GL11.glNormal3f(0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
                    GL11.glScalef(-var9, -var9, var9);
                    GL11.glDisable(GL11.GL_LIGHTING);
                    GL11.glTranslatef(0.0F, 0.25F / var9, 0.0F);
                    GL11.glDepthMask(false);
                    GL11.glEnable(GL11.GL_BLEND);
                    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
                    Tessellator var15 = Tessellator.instance;
                    GL11.glDisable(GL11.GL_TEXTURE_2D);
                    var15.startDrawingQuads();
                    int var16 = var14.getStringWidth(var13) / 2;
                    var15.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.25F);
                    var15.addVertex((double)(-var16 - 1), -1.0D, 0.0D);
                    var15.addVertex((double)(-var16 - 1), 8.0D, 0.0D);
                    var15.addVertex((double)(var16 + 1), 8.0D, 0.0D);
                    var15.addVertex((double)(var16 + 1), -1.0D, 0.0D);
                    var15.draw();
                    GL11.glEnable(GL11.GL_TEXTURE_2D);
                    GL11.glDepthMask(true);
                    var14.drawString(var13, -var14.getStringWidth(var13) / 2, 0, 553648127);
                    GL11.glEnable(GL11.GL_LIGHTING);
                    GL11.glDisable(GL11.GL_BLEND);
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    GL11.glPopMatrix();
                }
                else if (par1EntityPlayer.isPlayerSleeping())
                {
                    this.doRender(par1EntityPlayer, var13, par2, par4 - 1.5D, par6, 64);
                }
                else
                {
                    this.doRender(par1EntityPlayer, var13, par2, par4, par6, 64);
                }
            }
        }
    }

	private void doRender(EntityPlayer par1EntityPlayer, String var13,
			double par2, double par6, double par62, int par9) {
		this.doRender(par1EntityPlayer, par2, par6, par62, par9, par9);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		// TODO Auto-generated method stub
		return null;
	}

}
