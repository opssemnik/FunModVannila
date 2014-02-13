package FunMod.cliente.render;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import FunMod.cliente.model.ModelSofa;
import FunMod.tileentidades.EntidadeSofa;

public class RenderSofa extends TileEntitySpecialRenderer 
{
private ModelSofa modelsofa; 

public RenderSofa()
{
modelsofa = new  ModelSofa();
} 
public void renderAModelAt(EntidadeSofa tileentity1, double d, double d1, double d2, float f)
{  
	if(tileentity1.getWorldObj() != null) 
	{
	}
   // bindTextureByName("/FunMod/cliente/texturas/modelos/sofa.png");
    GL11.glPushMatrix();
    GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F); //size
    GL11.glRotatef(90, 0.0F, 1.0F, 0.0F); 
    GL11.glScalef(1.0F, -1F, -1F); 
    modelsofa.renderModel(0.0625F); 
    GL11.glPopMatrix(); 
                
}
public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f)
{
renderAModelAt((EntidadeSofa) tileentity, d, d1, d2, f); //where to render
}

}