package FunMod.cliente.render;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.RenderLiving;
import FunMod.cliente.model.ModelKirby;
import FunMod.entidades.EntityKirby;

public class RenderKirby extends RenderLiving
{
    public RenderKirby(ModelKirby par1ModelKirby, float par2)
    {
        super(par1ModelKirby, par2);
    }

    public void renderKirby(EntityKirby par1EntityKirby, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityKirby, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderKirby((EntityKirby)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderKirby((EntityKirby)par1Entity, par2, par4, par6, par8, par9);
    }
} 