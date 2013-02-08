package FunMod.cliente.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelYoshi extends ModelBase
{
  //fields
    ModelRenderer nose;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer tail;
    ModelRenderer leg4;
    ModelRenderer head;
    ModelRenderer eyes;
	public Object bipedRightArm;
	
  

    public ModelYoshi()
    {
        this(0.0F);
    }

    public ModelYoshi(float par1)
    {
        this(par1, 0.0F);
    }
    
  
  public ModelYoshi(float par1, float par2)
  {  
  
  textureWidth = 128;
    textureHeight = 64;
    
      nose = new ModelRenderer(this, 29, 15);
      nose.addBox(-3F, -3.5F, -11F, 6, 6, 5, par1);
      nose.setRotationPoint(0F, 10F+ par2, -6F);
      nose.setTextureSize(128, 64);
      nose.mirror = true;
      setRotation(nose, 0F, 0F, 0F);
      body = new ModelRenderer(this, 28, 30);
      body.addBox(-4F, -10F, -7F, 8, 16, 8, par1);
      body.setRotationPoint(0F, 11F+ par2, 3F);
      body.setTextureSize(128, 64);
      body.mirror = true;
      setRotation(body, 1.347725F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 42);
      leg1.addBox(-2F, 0F, -2F, 4, 7, 4, par1);
      leg1.setRotationPoint(-3F, 17F+ par2, 5F);
      leg1.setTextureSize(128, 64);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 42);
      leg2.addBox(-2F, 0F, -2F, 4, 7, 4, par1);
      leg2.setRotationPoint(3F, 17F+ par2, 5F);
      leg2.setTextureSize(128, 64);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 0, 30);
      leg3.addBox(-2F, 0F, -2F, 3, 4, 4, par1);
      leg3.setRotationPoint(-3F, 15F+ par2, -5F);
      leg3.setTextureSize(128, 64);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      tail = new ModelRenderer(this, 18, 50);
      tail.addBox(-1F, -1F, 0F, 2, 2, 2, par1);
      tail.setRotationPoint(0F, 15F+ par2, 8F);
      tail.setTextureSize(128, 64);
      tail.mirror = true;
      setRotation(tail, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 0, 30);
      leg4.addBox(-2F, 0F, -2F, 3, 4, 4, par1);
      leg4.setRotationPoint(4F, 15F+ par2, -5F);
      leg4.setTextureSize(128, 64);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      head = new ModelRenderer(this, 0, 14);
      head.addBox(-4F, -3F, -7F, 8, 7, 6, par1);
      head.setRotationPoint(0F, 10F+ par2, -6F);
      head.setTextureSize(128, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      eyes = new ModelRenderer(this, 0, 0);
      eyes.addBox(-3F, -7F, -3F, 6, 5, 2, par1);
      eyes.setRotationPoint(0F, 10F+ par2, -6F);
      eyes.setTextureSize(128, 64);
      eyes.mirror = true;
      setRotation(eyes, 0F, 0F, 0F);
  }
  
  public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
    super.render(par1Entity, par2, par3, par4, par5, par6, par7);
    setRotationAngles(par2, par3, par4, par5, par6, par7);
    head.render(par7);
    body.render(par7);
    eyes.render(par7);
    tail.render(par7);    
    leg4.render(par7);
    leg3.render(par7);
    leg1.render(par7);
    leg2.render(par7);
    nose.render(par7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6)
  {
      head.rotateAngleY = par4 / (180F / (float)Math.PI);
      head.rotateAngleX = par5 / (180F / (float)Math.PI);
      eyes.rotateAngleY = par4 / (180F / (float)Math.PI);
      eyes.rotateAngleX = par5 / (180F / (float)Math.PI);
      nose.rotateAngleY = par4 / (180F / (float)Math.PI);
      nose.rotateAngleX = par5 / (180F / (float)Math.PI);

      leg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      leg2.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      leg1.rotateAngleY = 0.0F;
      leg2.rotateAngleY = 0.0F;
  


}
}
