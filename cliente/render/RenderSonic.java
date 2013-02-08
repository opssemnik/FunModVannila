package FunMod.cliente.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import FunMod.cliente.model.ModelSonic;
import FunMod.entidades.EntitySonic;

public class RenderSonic extends RenderLiving
{
    public RenderSonic(ModelSonic par1ModelSonic, float par2)
    {
        super(par1ModelSonic, par2);
    }

    public void renderSonic(EntitySonic par1EntitySonic, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntitySonic, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderSonic((EntitySonic)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderSonic((EntitySonic)par1Entity, par2, par4, par6, par8, par9);
    }
} 