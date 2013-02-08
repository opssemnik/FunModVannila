package FunMod.cliente.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import FunMod.cliente.model.ModelGoomba;
import FunMod.entidades.EntityGoomba;

public class RenderGoomba extends RenderLiving
{
    public RenderGoomba(ModelGoomba par1ModelGoomba, float par2)
    {
        super(par1ModelGoomba, par2);
    }

    public void renderGoomba(EntityGoomba par1EntityGoomba, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityGoomba, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderGoomba((EntityGoomba)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderGoomba((EntityGoomba)par1Entity, par2, par4, par6, par8, par9);
    }
} 