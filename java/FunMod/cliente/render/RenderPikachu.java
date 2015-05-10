package FunMod.cliente.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import FunMod.cliente.model.ModelPikachu;
import FunMod.entidades.EntityPikachu;

public class RenderPikachu extends RenderLiving
{
    public RenderPikachu(ModelPikachu par1ModelPikachu, float par2)
    {
        super(par1ModelPikachu, par2);
    }

    public void renderPikachu(EntityPikachu par1EntityPikachu, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender(par1EntityPikachu, par2, par4, par6, par8, par9);
    }

    public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderPikachu((EntityPikachu)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderPikachu((EntityPikachu)par1Entity, par2, par4, par6, par8, par9);
    }
    
    protected void preRenderScale(EntityPikachu par1EntityPikachu, float par2)
    {
        float f = 1.0F;
        GL11.glScalef(f, f, f);
    }

    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        preRenderScale((EntityPikachu)par1EntityLiving, par2);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		// TODO Auto-generated method stub
		return null;
	} 
    
} 