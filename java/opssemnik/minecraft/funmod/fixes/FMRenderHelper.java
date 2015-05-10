package opssemnik.minecraft.funmod.fixes;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import FunMod.entidades.EntityGanondorf;
import FunMod.entidades.EntityHamtaro;
import FunMod.entidades.EntityPikachu;
import FunMod.entidades.EntitySephiroth;

public class FMRenderHelper extends RenderLiving
{
    public FMRenderHelper(ModelBase par1Model, float par2)
    {
        super(par1Model, par2);
    }

    public void renderEntity(EntityLiving par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender(par1Entity, par2, par4, par6, par8, par9);
    }

    public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderEntity(par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
    	renderEntity((EntityLiving)par1Entity, par2, par4, par6, par8, par9);
    }
    protected void preRenderCallback(EntityLivingBase entity, float p_77041_2_)
    {
    	if(entity instanceof EntitySephiroth){
    		GL11.glScalef(1.2f, 1.2f, 1.2f);
    	}
    	else if(entity instanceof EntityPikachu){
    		GL11.glScalef(1F,1F,1F);
    	}
    	else if(entity instanceof EntityGanondorf){
    		GL11.glScalef(2F,2F,2F);
    	}
    	
    }
    protected float handleRotationFloat(EntityLiving par1EntityLiving, float par2)
    {
    	if(par1EntityLiving instanceof EntityHamtaro){
    		return ((EntityHamtaro)par1EntityLiving).getTailRotation();
    	}
    	return 0F;
    }
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return new ResourceLocation(String.format("funmod:textures/mobs/%s.png",var1.getClass().getSimpleName().toLowerCase().replace("entity","")));
	}
} 