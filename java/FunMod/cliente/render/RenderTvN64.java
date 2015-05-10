package FunMod.cliente.render;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import FunMod.cliente.model.ModelTvN64;
import FunMod.tileentidades.EntidadeN64;

public class RenderTvN64 extends TileEntitySpecialRenderer 
{
private ModelTvN64 model; 

public RenderTvN64()
{
model = new  ModelTvN64();
} 

public void renderAModelAt(EntidadeN64 tileentity1, double d, double d1, double d2, float f)
{  
   // bindTextureByName("/FunMod/cliente/texturas/modelos/tv.png");
    GL11.glPushMatrix(); 
    GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F); 
    GL11.glRotatef(0, 0.0F, 1.0F, 0.0F);
    GL11.glScalef(1.0F, -1F, -1F); 
    model.renderModel(0.0625F); 
    GL11.glPopMatrix(); 
                
}
public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f)
{
renderAModelAt((EntidadeN64) tileentity, d, d1, d2, f); //where to render
}

}