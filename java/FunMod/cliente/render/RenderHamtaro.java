package FunMod.cliente.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import FunMod.entidades.EntityHamtaro;

public class RenderHamtaro extends RenderLiving
{
    public RenderHamtaro(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    public void renderHamtaro(EntityHamtaro par1EntityHamtaro, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender(par1EntityHamtaro, par2, par4, par6, par8, par9);
    }

    protected float getTailRotation(EntityHamtaro par1EntityHamtaro, float par2)
    {
        return par1EntityHamtaro.getTailRotation();
    }
    protected float handleRotationFloat(EntityLiving par1EntityLiving, float par2)
    {
        return this.getTailRotation((EntityHamtaro)par1EntityLiving, par2);
    }

    public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderHamtaro((EntityHamtaro)par1EntityLiving, par2, par4, par6, par8, par9);
    }
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderHamtaro((EntityHamtaro)par1Entity, par2, par4, par6, par8, par9);
    }
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return null;
	}
}
