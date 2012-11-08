package FunMod.cliente.render;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.RenderLiving;
import FunMod.cliente.model.ModelBlinky;
import FunMod.entidades.EntityBlinky;

public class RenderBlinky extends RenderLiving
{
    public RenderBlinky(ModelBlinky par1ModelBlinky, float par2)
    {
        super(par1ModelBlinky, par2);
    }

    public void renderBlinky(EntityBlinky par1EntityBlinky, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityBlinky, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderBlinky((EntityBlinky)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderBlinky((EntityBlinky)par1Entity, par2, par4, par6, par8, par9);
    }
} 