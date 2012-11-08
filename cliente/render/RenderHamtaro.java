package FunMod.cliente.render;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;
import FunMod.entidades.EntityHamtaro;

public class RenderHamtaro extends RenderLiving
{
    public RenderHamtaro(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    public void renderHamtaro(EntityHamtaro par1EntityHamtaro, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityHamtaro, par2, par4, par6, par8, par9);
    }

    protected float getTailRotation(EntityHamtaro par1EntityHamtaro, float par2)
    {
        return par1EntityHamtaro.getTailRotation();
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityLiving par1EntityLiving, float par2)
    {
        return this.getTailRotation((EntityHamtaro)par1EntityLiving, par2);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderHamtaro((EntityHamtaro)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderHamtaro((EntityHamtaro)par1Entity, par2, par4, par6, par8, par9);
    }
}
