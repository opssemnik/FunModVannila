package FunMod.cliente.render;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.RenderLiving;
import FunMod.cliente.model.ModelInky;
import FunMod.entidades.EntityInky;

public class RenderInky extends RenderLiving
{
    public RenderInky(ModelInky par1ModelInky, float par2)
    {
        super(par1ModelInky, par2);
    }

    public void renderInky(EntityInky par1EntityInky, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityInky, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderInky((EntityInky)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderInky((EntityInky)par1Entity, par2, par4, par6, par8, par9);
    }
} 