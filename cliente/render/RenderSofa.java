package FunMod.cliente.render;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySpecialRenderer;

import org.lwjgl.opengl.GL11;

import FunMod.cliente.model.ModelSofa;
import FunMod.tileentidades.EntidadeSofa;

public class RenderSofa extends TileEntitySpecialRenderer // because your block is, and you are too.
{
private ModelSofa modelsofa; // yup, this refers to the last file. so you'll get an error for now. it says what model it has to take. you could also make it a boat, or a cow. nice for statues or something. have it render the model of a cow.

public RenderSofa()
{
modelsofa = new  ModelSofa();
} // where and what to render

public void renderAModelAt(EntidadeSofa tileentity1, double d, double d1, double d2, float f)
{  
	int i =0; // a regular int, with a zero. more on this below

	if(tileentity1.worldObj != null) // to tell the world that your object is placed.
	{
	i =(tileentity1.worldObj.getBlockMetadata(tileentity1.xCoord, tileentity1.yCoord, tileentity1.zCoord)); // to tell the game it needs to pick up metadata from your block
	}

	
    bindTextureByName("/FunMod/cliente/texturas/modelos/sofa.png");
    GL11.glPushMatrix(); //start
    GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F); //size
    GL11.glRotatef(90, 0.0F, 1.0F, 0.0F); //change the first 0 in like 90 to make it rotate 90 degrees.
    GL11.glScalef(1.0F, -1F, -1F); // to make your block have a normal positioning. comment out to see what happens
    modelsofa.renderModel(0.0625F); //renders and 0.0625F is exactly 1/16. every block has 16 entitys/pixels. if you make the number 1, every pixel will be as big as a block. make it 0.03125 and your block will be half as big as a normal one.
    GL11.glPopMatrix(); //end
                
}



public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f)
{
renderAModelAt((EntidadeSofa) tileentity, d, d1, d2, f); //where to render
}

}