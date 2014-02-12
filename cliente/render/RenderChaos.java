package FunMod.cliente.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import FunMod.cliente.model.ModelChaos;
import FunMod.entidades.EntityChaos;

public class RenderChaos extends RenderLiving
{
    public RenderChaos(ModelChaos par1ModelChaos, float par2)
    {
        super(par1ModelChaos, par2);
    }

    public void renderChaos(EntityChaos par1EntityChaos, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender(par1EntityChaos, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderChaos((EntityChaos)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderChaos((EntityChaos)par1Entity, par2, par4, par6, par8, par9);
    }
    protected void preRenderScale(EntityChaos par1EntityChaos, float par2)
    {
        float f = 2.0F; 
        GL11.glScalef(f, f, f);
    }

    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        preRenderScale((EntityChaos)par1EntityLiving, par2);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return null;
	} 
    
} 