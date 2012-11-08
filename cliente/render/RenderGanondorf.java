package FunMod.cliente.render;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.RenderLiving;

import org.lwjgl.opengl.GL11;

import FunMod.cliente.model.ModelGanondorf;
import FunMod.entidades.EntityGanondorf;

public class RenderGanondorf extends RenderLiving
{
    public RenderGanondorf(ModelGanondorf par1ModelGanondorf, float par2)
    {
        super(par1ModelGanondorf, par2);
    }

    public void renderGanondorf(EntityGanondorf par1EntityGanondorf, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityGanondorf, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderGanondorf((EntityGanondorf)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderGanondorf((EntityGanondorf)par1Entity, par2, par4, par6, par8, par9);
    }
    protected void preRenderScale(EntityGanondorf par1EntityGanondorf, float par2)
    {
        float f = 2.0F;
        GL11.glScalef(f, f, f);
    }

    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        preRenderScale((EntityGanondorf)par1EntityLiving, par2);
    } 
    
} 