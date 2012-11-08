package FunMod.cliente.model;

import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelHamtaro extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer ear1;
    ModelRenderer ear2;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer tail;
    
    public int heldItemRight;
    
    public ModelHamtaro()
    {
        this(0.0F);
    }

    public ModelHamtaro(float par1)
    {
        this(par1, 0.0F);
    }
    
  
  public ModelHamtaro(float par1, float par2)
  
  {
    textureWidth = 32;
    textureHeight = 32;
    
    head = new ModelRenderer(this, 0, 5);
    head.addBox(-2F, -4F, -2F, 4, 4, 4);
    head.setRotationPoint(0F, 18F, 1F);
    head.setTextureSize(32, 32);
    head.mirror = true;
    setRotation(head, 0F, 0F, 0F);
    
    ear1 = new ModelRenderer(this, 0, 0);
    ear1.addBox(-3F, -5F, -2F, 2, 2, 2);
    ear1.setRotationPoint(0F, 18F, 1F);
    ear1.setTextureSize(32, 32);
    ear1.mirror = true;
    setRotation(ear1, 0F, 0F, 0F);
    
    ear2 = new ModelRenderer(this, 10, 0);
    ear2.addBox(1F, -5F, -2F, 2, 2, 2);
    ear2.setRotationPoint(0F, 18F, 1F);
    ear2.setTextureSize(32, 32);
    ear2.mirror = true;
    setRotation(ear2, 0F, 0F, 0F);    
    
    body = new ModelRenderer(this, 0, 15);
    body.addBox(-2F, 0F, -1F, 4, 4, 2);
    body.setRotationPoint(0F, 18F, 1F);
    body.setTextureSize(32, 32);
    body.mirror = true;
    setRotation(body, 0F, 0F, 0F);
    rightarm = new ModelRenderer(this, 13, 15);
    rightarm.addBox(-2F, -1F, -2F, 2, 2, 2);
    rightarm.setRotationPoint(-1F, 19F, 1F);
    rightarm.setTextureSize(32, 32);
    rightarm.mirror = true;
    setRotation(rightarm, 0F, 0F, 0F);
    leftarm = new ModelRenderer(this, 13, 15);
    leftarm.addBox(0F, -1F, -3F, 2, 2, 2);
    leftarm.setRotationPoint(1F, 19F, 2F);
    leftarm.setTextureSize(32, 32);
    leftarm.mirror = true;
    setRotation(leftarm, 0F, 0F, 0F);
    rightleg = new ModelRenderer(this, 0, 25);
    rightleg.addBox(-1F, 0F, -1F, 2, 2, 2);
    rightleg.setRotationPoint(-1F, 22F, 1F);
    rightleg.setTextureSize(32, 32);
    rightleg.mirror = true;
    setRotation(rightleg, 0F, 0F, 0F);
    leftleg = new ModelRenderer(this, 0, 25);
    leftleg.addBox(-1F, 0F, -1F, 2, 2, 2);
    leftleg.setRotationPoint(1F, 22F, 1F);
    leftleg.setTextureSize(32, 32);
    leftleg.mirror = true;
    setRotation(leftleg, 0F, 0F, 0F);
    tail = new ModelRenderer(this, 0, 13);
    tail.addBox(-1F, -1F, 0F, 2, 1, 1);
    tail.setRotationPoint(0F, 22F, 2F);
    tail.setTextureSize(32, 32);
    tail.mirror = true;
    
  }
  
  public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
    super.render(par1Entity, par2, par3, par4, par5, par6, par7);
    setRotationAngles(par2, par3, par4, par5, par6, par7);
    head.render(par7);
    body.render(par7);
    rightarm.render(par7);
    leftarm.render(par7);
    rightleg.render(par7);
    leftleg.render(par7);
    ear1.render(par7);
    ear2.render(par7);
    tail.render(par7);
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
      ear1.rotateAngleY = par4 / (180F / (float)Math.PI);
      ear1.rotateAngleX = par5 / (180F / (float)Math.PI);
      ear2.rotateAngleY = par4 / (180F / (float)Math.PI);
      ear2.rotateAngleX = par5 / (180F / (float)Math.PI);
      
      rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
      leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
      rightarm.rotateAngleZ = 0.0F;
      leftarm.rotateAngleZ = 0.0F;
      rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      rightleg.rotateAngleY = 0.0F;
      leftleg.rotateAngleY = 0.0F;
  

  if (heldItemRight != 0)
  {
      rightarm.rotateAngleX = rightarm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)heldItemRight;
  }

}
}
