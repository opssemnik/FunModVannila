package FunMod.cliente.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSonic extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer spikehead1;
    ModelRenderer spikehead2;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer leftfoot;
    ModelRenderer rightfoot;
    ModelRenderer spikebody;
  
    public ModelSonic()
    {
        this(0.0F);
    }

    public ModelSonic(float par1)
    {
        this(par1, 0.0F);
    }
    
  
  public ModelSonic(float par1, float par2)
  {
    textureWidth = 64;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-3F, -7F, -3F, 6, 6, 6, par1);
      head.setRotationPoint(0F, 13F+ par2, 0F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 0, 12);
      body.addBox(-2F, -1F, -2F, 4, 6, 4, par1);
      body.setRotationPoint(0F, 12F+ par2, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      spikehead1 = new ModelRenderer(this, 25, 0);
      spikehead1.addBox(-1F, -7F, 2F, 2, 2, 5, par1);
      spikehead1.setRotationPoint(0F, 13F+ par2, 0F);
      spikehead1.setTextureSize(64, 32);
      spikehead1.mirror = true;
      setRotation(spikehead1, 0F, 0F, 0F);
      spikehead2 = new ModelRenderer(this, 25, 0);
      spikehead2.addBox(-1F, -4F, 1F, 2, 2, 5, par1);
      spikehead2.setRotationPoint(0F, 13F+ par2, 0F);
      spikehead2.setTextureSize(64, 32);
      spikehead2.mirror = true;
      setRotation(spikehead2, 0F, 0F, 0F);
      setRotation(spikehead2, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 28, 24);
      rightarm.addBox(-1F, -1F, -1F, 2, 6, 2, par1);
      rightarm.setRotationPoint(-3F, 13F+ par2, 0F);
      rightarm.setTextureSize(64, 32);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 28, 24);
      leftarm.addBox(-1F, -1F, -1F, 2, 6, 2, par1);
      leftarm.setRotationPoint(3F, 13F+ par2, 0F);
      leftarm.setTextureSize(64, 32);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 22);
      rightleg.addBox(-2F, 0F, -1F, 2, 5, 2, par1);
      rightleg.setRotationPoint(0F, 17F+ par2, 0F);
      rightleg.setTextureSize(64, 32);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 22);
      leftleg.addBox(0F, 0F, 0F, 2, 5, 2, par1);
      leftleg.setRotationPoint(0F, 17F+ par2, -1F);
      leftleg.setTextureSize(64, 32);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      leftfoot = new ModelRenderer(this, 9, 27);
      leftfoot.addBox(0F, 5F, -2F, 2, 2, 3, par1);
      leftfoot.setRotationPoint(0F, 17F+ par2, 0F);
      leftfoot.setTextureSize(64, 32);
      leftfoot.mirror = true;
      setRotation(leftfoot, 0F, 0F, 0F);
      rightfoot = new ModelRenderer(this, 9, 27);
      rightfoot.addBox(-2F, 5F, -2F, 2, 2, 3, par1);
      rightfoot.setRotationPoint(0F, 17F+ par2, 0F);
      rightfoot.setTextureSize(64, 32);
      rightfoot.mirror = true;
      setRotation(rightfoot, 0F, 0F, 0F);
      spikebody = new ModelRenderer(this, 25, 5);
      spikebody.addBox(0F, -1F, -1F, 4, 2, 2, par1);
      spikebody.setRotationPoint(0F, 13F+ par2, 0F);
      spikebody.setTextureSize(64, 32);
      spikebody.mirror = true;
      setRotation(spikebody, 0F, -1.570796F, 0F);
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
    spikehead1.render(par7);
    spikehead2.render(par7);
    spikebody.render(par7);
    leftfoot.render(par7);
    rightfoot.render(par7);
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
      
      spikehead1.rotateAngleY = par4 / (180F / (float)Math.PI);
      spikehead1.rotateAngleX = par5 / (180F / (float)Math.PI);
      
      spikehead2.rotateAngleY = par4 / (180F / (float)Math.PI);
      spikehead2.rotateAngleX = par5 / (180F / (float)Math.PI);
      
      rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
      leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
      rightarm.rotateAngleZ = 0.0F;
      leftarm.rotateAngleZ = 0.0F;
      
      rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      rightleg.rotateAngleY = 0.0F;
      leftleg.rotateAngleY = 0.0F;
  
      rightfoot.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      leftfoot.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      rightfoot.rotateAngleY = 0.0F;
      leftfoot.rotateAngleY = 0.0F;

  
}
}