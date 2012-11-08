package FunMod.cliente.render;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.RenderLiving;
import FunMod.cliente.model.ModelPinky;
import FunMod.entidades.EntityPinky;

public class RenderPinky extends RenderLiving
{
    public RenderPinky(ModelPinky par1ModelPinky, float par2)
    {
        super(par1ModelPinky, par2);
    }

    public void renderPinky(EntityPinky par1EntityPinky, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityPinky, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderPinky((EntityPinky)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderPinky((EntityPinky)par1Entity, par2, par4, par6, par8, par9);
    }
} 