
package FunMod.cliente.model;

import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelPikachu extends ModelBase
{
  //fields
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer ear1;
    ModelRenderer ear2;
    ModelRenderer leg4;
  
    public ModelPikachu(int par1, float par2)
    {
    textureWidth = 64;
    textureHeight = 64;
    
      tail1 = new ModelRenderer(this, 37, 9);
      tail1.addBox(-1F, -2F, 0F, 1, 2, 0, par2);
      tail1.setRotationPoint(0F, 15F- par1, 5F);
      tail1.setTextureSize(64, 64);
      tail1.mirror = true;
      setRotation(tail1, 0F, 0F, 0.7853982F);
      tail2 = new ModelRenderer(this, 37, 5);
      tail2.addBox(1F, -4F, 0F, 1, 3, 0, par2);
      tail2.setRotationPoint(0F, 15F- par1, 5F);
      tail2.setTextureSize(64, 64);
      tail2.mirror = true;
      setRotation(tail2, 0F, 0F, -0.7853982F);
      tail3 = new ModelRenderer(this, 36, 0);
      tail3.addBox(-5F, -5F, 0F, 2, 4, 0, par2);
      tail3.setRotationPoint(0F, 15F- par1, 5F);
      tail3.setTextureSize(64, 64);
      tail3.mirror = true;
      setRotation(tail3, 0F, 0F, 0.7853982F);
      head = new ModelRenderer(this, 0, 9);
      head.addBox(-4F, -4F, -8F, 8, 8, 8, par2);
      head.setRotationPoint(0F, 14F- par1, -5F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 28, 30);
      body.addBox(-4F, -10F, -7F, 8, 12, 6, par2);
      body.setRotationPoint(0F, 13F- par1, 3F);
      body.setTextureSize(64, 64);
      body.mirror = true;
      setRotation(body, 1.570796F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 40);
      leg1.addBox(-1.333333F, 0F, -2F, 3, 5, 3, par2);
      leg1.setRotationPoint(-3F, 19F, 4F);
      leg1.setTextureSize(64, 64);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 40);
      leg2.addBox(-1.7F, 0F, -2F, 3, 5, 3, par2);
      leg2.setRotationPoint(3F, 19F, 4F);
      leg2.setTextureSize(64, 64);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 0, 40);
      leg3.addBox(-1.3F, 0F, -2F, 3, 5, 3, par2);
      leg3.setRotationPoint(-3F, 19F- par1, -5F);
      leg3.setTextureSize(64, 64);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      ear1 = new ModelRenderer(this, 0, 0);
      ear1.addBox(1F, -11F, -2F, 3, 7, 1, par2);
      ear1.setRotationPoint(0F, 14F- par1, -5F);
      ear1.setTextureSize(64, 64);
      ear1.mirror = true;
      setRotation(ear1, 0F, 0F, 0F);
      ear2 = new ModelRenderer(this, 0, 0);
      ear2.addBox(-4F, -11F, -2F, 3, 7, 1, par2);
      ear2.setRotationPoint(0F, 14F- par1, -5F);
      ear2.setTextureSize(64, 64);
      ear2.mirror = true;
      setRotation(ear2, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 0, 40);
      leg4.addBox(-1.7F, 0F, -2F, 3, 5, 3, par2);
      leg4.setRotationPoint(3F, 19F- par1, -5F);
      leg4.setTextureSize(64, 64);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
  }
  
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        setRotationAngles(par2, par3, par4, par5, par6, par7);
    tail1.render(par7);
    tail2.render(par7);
    tail3.render(par7);
    head.render(par7);
    body.render(par7);
    leg1.render(par7);
    leg2.render(par7);
    leg3.render(par7);
    ear1.render(par7);
    ear2.render(par7);
    leg4.render(par7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6)
  {
      head.rotateAngleX = par5 / (180F / (float)Math.PI);
      head.rotateAngleY = par4 / (180F / (float)Math.PI);
      ear1.rotateAngleX = par5 / (180F / (float)Math.PI);
      ear1.rotateAngleY = par4 / (180F / (float)Math.PI);
      ear2.rotateAngleX = par5 / (180F / (float)Math.PI);
      ear2.rotateAngleY = par4 / (180F / (float)Math.PI);
      
      
      body.rotateAngleX = ((float)Math.PI / 2F);

      
      
      leg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      leg2.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      leg3.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      leg4.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
  }

}
