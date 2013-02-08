package FunMod.cliente.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKirby extends ModelBase
{
  
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape4;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
  
  public ModelKirby()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 42, 28);
      Shape1.addBox(0F, 0F, 0F, 4, 2, 2);
      Shape1.setRotationPoint(-3F, 22F, 2F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 2.007129F, 0F);
      Shape2 = new ModelRenderer(this, 24, 28);
      Shape2.addBox(0F, 0F, 0F, 4, 2, 2);
      Shape2.setRotationPoint(1F, 22F, 1F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 1.047198F, 0F);
      Shape4 = new ModelRenderer(this, 0, 0);
      Shape4.addBox(0F, 0F, 0F, 8, 6, 7);
      Shape4.setRotationPoint(-4F, 16F, -3F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 37, 0);
      Shape6.addBox(0F, 0F, 0F, 3, 2, 2);
      Shape6.setRotationPoint(-6.866667F, 19F, -1F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, -0.3665191F);
      Shape7 = new ModelRenderer(this, 51, 0);
      Shape7.addBox(0F, 0F, 0F, 3, 2, 2);
      Shape7.setRotationPoint(4F, 17.53333F, -1F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0.5235988F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape4.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ll)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, ll);
  }
  
 
}
