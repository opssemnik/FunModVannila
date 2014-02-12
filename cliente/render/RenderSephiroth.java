package FunMod.cliente.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

import org.lwjgl.opengl.GL11;

import FunMod.cliente.model.ModelSephiroth;
import FunMod.entidades.EntitySephiroth;

public class RenderSephiroth extends RenderLiving
{
    public RenderSephiroth(ModelSephiroth par1ModelSephiroth, float par2)
    {
        super(par1ModelSephiroth, par2);
    }

    public void renderSephiroth(EntitySephiroth par1EntitySephiroth, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender(par1EntitySephiroth, par2, par4, par6, par8, par9);
    }

    public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderSephiroth((EntitySephiroth)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderSephiroth((EntitySephiroth)par1Entity, par2, par4, par6, par8, par9);
    }
    protected void preRenderScale(EntitySephiroth par1EntitySephiroth, float par2)
    {
        float f = 1.2F; // troque esse valor pra o que desejar, coloquei 2.0F, o que vai duplicar seu tamanho.
        GL11.glScalef(f, f, f);
    }

    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        preRenderScale((EntitySephiroth)par1EntityLiving, par2);
    } 
    
} 