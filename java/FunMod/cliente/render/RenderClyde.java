package FunMod.cliente.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import FunMod.cliente.model.ModelClyde;
import FunMod.entidades.EntityClyde;

public class RenderClyde extends RenderLiving
{
    public RenderClyde(ModelClyde par1ModelClyde, float par2)
    {
        super(par1ModelClyde, par2);
    }

    public void renderClyde(EntityClyde par1EntityClyde, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender(par1EntityClyde, par2, par4, par6, par8, par9);
    }

    public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderClyde((EntityClyde)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderClyde((EntityClyde)par1Entity, par2, par4, par6, par8, par9);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		// TODO Auto-generated method stub
		return null;
	}
} 