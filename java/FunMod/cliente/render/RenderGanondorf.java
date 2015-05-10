package FunMod.cliente.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import FunMod.cliente.model.ModelGanondorf;
import FunMod.entidades.EntityGanondorf;

public class RenderGanondorf extends RenderLiving
{
    public RenderGanondorf(ModelGanondorf par1ModelGanondorf, float par2)
    {
        super(par1ModelGanondorf, par2);
    }

    public void renderGanondorf(EntityGanondorf par1EntityGanondorf, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender(par1EntityGanondorf, par2, par4, par6, par8, par9);
    }

    public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderGanondorf((EntityGanondorf)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderGanondorf((EntityGanondorf)par1Entity, par2, par4, par6, par8, par9);
    }
    protected void preRenderScale(EntityGanondorf par1EntityGanondorf, float par2)
    {
        float f = 2.0F;
        GL11.glScalef(f, f, f);
    }

    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        preRenderScale((EntityGanondorf)par1EntityLiving, par2);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		// TODO Auto-generated method stub
		return null;
	} 
    
} 