package FunMod.cliente.render;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.RenderLiving;
import FunMod.cliente.model.ModelKoopa;
import FunMod.entidades.EntityKoopaTroopa;

public class RenderKoopaTroopa extends RenderLiving
{
    public RenderKoopaTroopa(ModelKoopa par1ModelKoopa, float par2)
    {
        super(par1ModelKoopa, par2);
    }

    public void renderKoopaTroopa(EntityKoopaTroopa par1EntityKoopaTroopa, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityKoopaTroopa, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderKoopaTroopa((EntityKoopaTroopa)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderKoopaTroopa((EntityKoopaTroopa)par1Entity, par2, par4, par6, par8, par9);
    }
} 