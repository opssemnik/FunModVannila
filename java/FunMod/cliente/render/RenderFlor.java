package FunMod.cliente.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import opssemnik.minecraft.funmod.fixes.StaticHelper;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.registry.GameData;
import FunMod.FunMod;

public class RenderFlor extends Render {

	public RenderFlor() {

	}

	public void doRender(Entity entity, double d, double d1, double d2,
			float f, float f1) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d, (float) d1, (float) d2);
		GL11.glEnable(32826);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		// loadTexture("/FunMod/cliente/texturas/modelos/fogo.png");
		Tessellator tessellator = Tessellator.instance;
		int i = GameData.itemRegistry.getId(StaticHelper.FMItemLoader.FireFlower);
		float f2 = (float) ((i % 16) * 16 + 0) / 256F;
		float f3 = (float) ((i % 16) * 16 + 16) / 256F;
		float f4 = (float) ((i / 16) * 16 + 0) / 256F;
		float f5 = (float) ((i / 16) * 16 + 16) / 256F;
		float f6 = 1.0F;
		float f7 = 0.5F;
		float f8 = 0.25F;
		GL11.glRotatef(180F - renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		tessellator.addVertexWithUV(0.0F - f7, 0.0F - f8, 0.0D, f2, f5);
		tessellator.addVertexWithUV(f6 - f7, 0.0F - f8, 0.0D, f3, f5);
		tessellator.addVertexWithUV(f6 - f7, 1.0F - f8, 0.0D, f3, f4);
		tessellator.addVertexWithUV(0.0F - f7, 1.0F - f8, 0.0D, f2, f4);
		tessellator.draw();
		GL11.glDisable(32826 /* GL_RESCALE_NORMAL_EXT */);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		// TODO Auto-generated method stub
		return null;
	}
}