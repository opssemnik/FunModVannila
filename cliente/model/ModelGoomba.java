package FunMod.cliente.model;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelGoomba extends ModelBase
{
  
    ModelRenderer Perna_direita;
    ModelRenderer Perna_esquerda;
    ModelRenderer Corpo;
    ModelRenderer Cabeca;
    ModelRenderer Topo_da_cabeca;
    ModelRenderer Sombrancelha_esquerda;
    ModelRenderer Sombrancelha_direita;
  
  public ModelGoomba()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Perna_direita = new ModelRenderer(this, 0, 13);
      Perna_direita.addBox(0F, 0F, 0F, 3, 2, 2);
      Perna_direita.setRotationPoint(-2F, 22F, 1F);
      Perna_direita.setTextureSize(64, 32);
      Perna_direita.mirror = true;
      setRotation(Perna_direita, 0F, 2.007129F, 0F);
      Perna_esquerda = new ModelRenderer(this, 0, 13);
      Perna_esquerda.addBox(0F, 0F, 0F, 3, 2, 2);
      Perna_esquerda.setRotationPoint(1F, 22F, 6.994405E-15F);
      Perna_esquerda.setTextureSize(64, 32);
      Perna_esquerda.mirror = true;
      setRotation(Perna_esquerda, 0F, 1.239184F, 0F);
      Corpo = new ModelRenderer(this, 10, 13);
      Corpo.addBox(0F, 0F, 0F, 4, 1, 4);
      Corpo.setRotationPoint(-2F, 21F, -2F);
      Corpo.setTextureSize(64, 32);
      Corpo.mirror = true;
      setRotation(Corpo, 0F, 0F, 0F);
      Cabeca = new ModelRenderer(this, 0, 0);
      Cabeca.addBox(0F, 0F, 0F, 8, 5, 8);
      Cabeca.setRotationPoint(-4F, 16F, -4F);
      Cabeca.setTextureSize(64, 32);
      Cabeca.mirror = true;
      setRotation(Cabeca, 0F, 0F, 0F);
      Topo_da_cabeca = new ModelRenderer(this, 32, 0);
      Topo_da_cabeca.addBox(0F, 0F, 0F, 6, 1, 6);
      Topo_da_cabeca.setRotationPoint(-3F, 15F, -3F);
      Topo_da_cabeca.setTextureSize(64, 32);
      Topo_da_cabeca.mirror = true;
      setRotation(Topo_da_cabeca, 0.0174533F, 0F, 0F);
      Sombrancelha_esquerda = new ModelRenderer(this, 0, 0);
      Sombrancelha_esquerda.addBox(0F, 0F, 0F, 4, 1, 1);
      Sombrancelha_esquerda.setRotationPoint(-4F, 16F, -5F);
      Sombrancelha_esquerda.setTextureSize(64, 32);
      Sombrancelha_esquerda.mirror = true;
      setRotation(Sombrancelha_esquerda, 0F, 0F, 0.1268273F);
      Sombrancelha_direita = new ModelRenderer(this, 0, 0);
      Sombrancelha_direita.addBox(0F, 0F, 0F, 4, 1, 1);
      Sombrancelha_direita.setRotationPoint(0F, 16.46667F, -5F);
      Sombrancelha_direita.setTextureSize(64, 32);
      Sombrancelha_direita.mirror = true;
      setRotation(Sombrancelha_direita, 0F, 0F, -0.1745329F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Perna_direita.render(f5);
    Perna_esquerda.render(f5);
    Corpo.render(f5);
    Cabeca.render(f5);
    Topo_da_cabeca.render(f5);
    Sombrancelha_esquerda.render(f5);
    Sombrancelha_direita.render(f5);
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

  public void setLivingAnimations(EntityLiving par1EntityLiving, float f1, float f2, float f3)
  {

	  Perna_esquerda.rotateAngleX = MathHelper.cos(f1 * 0.6662F) * 1.4F * f2;
	  Perna_direita.rotateAngleX = MathHelper.cos(f1 * 0.6662F + (float)Math.PI) * 1.4F * f2;
  } 
  
}
