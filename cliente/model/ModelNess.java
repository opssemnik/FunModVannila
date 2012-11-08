package FunMod.cliente.model;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelNess extends ModelBase
{
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer Shape1;
    ModelRenderer Shape4;
  
  public ModelNess()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape2 = new ModelRenderer(this, 24, 0);
      Shape2.addBox(0F, 0F, 0F, 6, 1, 6);
      Shape2.setRotationPoint(-3F, 0F, -3F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, -111, 0);
      Shape3.addBox(0F, 0F, 0F, 0, 0, 0);
      Shape3.setRotationPoint(-8F, -7F, -15F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 6, 6, 6);
      head.setRotationPoint(1F, 9F, 1F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 6, 9, 4);
      body.setRotationPoint(1F, 7F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 16);
      rightarm.addBox(-3F, -2F, -2F, 3, 8, 4);
      rightarm.setRotationPoint(-3F, 9F, 0F);
      rightarm.setTextureSize(64, 32);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 40, 16);
      leftarm.addBox(-1F, -2F, -2F, 3, 8, 4);
      leftarm.setRotationPoint(4F, 9F, 0F);
      leftarm.setTextureSize(64, 32);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-2F, 0F, -2F, 3, 8, 4);
      rightleg.setRotationPoint(-1F, 16F, 0F);
      rightleg.setTextureSize(64, 32);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-2F, 0F, -2F, 3, 8, 4);
      leftleg.setRotationPoint(2F, 16F, 0F);
      leftleg.setTextureSize(64, 32);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 49, 8);
      Shape1.addBox(0F, 0F, 0F, 4, 0, 1);
      Shape1.setRotationPoint(-4F, 1F, -4F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 49, 0);
      Shape4.addBox(0F, 0F, 0F, 1, 0, 3);
      Shape4.setRotationPoint(-4F, 1F, -3F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape2.render(f5);
    Shape3.render(f5);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
    Shape1.render(f5);
    Shape4.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

  public void setLivingAnimations(EntityLiving par1EntityLiving, float f1, float f2, float f3)
  {

      leftleg.rotateAngleX = MathHelper.cos(f1 * 0.6662F) * 1.4F * f2;
      rightleg.rotateAngleX = MathHelper.cos(f1 * 0.6662F + (float)Math.PI) * 1.4F * f2;
  } 
  
}
