package FunMod.cliente.animacoes;

import java.io.IOException;

import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.src.ModTextureAnimation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.TextureFXManager;

public class TextureFunFX extends ModTextureAnimation
{
	public TextureFunFX(String texture, int index) throws IOException
	{
		super(index, 1, texture, TextureFXManager.instance().loadImageFromTexturePack(FMLClientHandler.instance().getClient().renderEngine, texture), 5);
	}

    public void bindImage(RenderEngine renderengine)
    {
        GL11.glBindTexture(3553,renderengine.getTexture("/FunMod/cliente/texturas/texturas.png"));
    }
}