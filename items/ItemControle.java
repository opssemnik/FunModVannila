package FunMod.items;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import FunMod.FunMod;
	public class ItemControle extends Item
	{
	        public ItemControle(int i)
	        {
	                super(i);
	                maxStackSize = 64;     
	                
	                this.iconIndex = 35;
	        
	        }
     public String getTextureFile(){
    	 return "/FunMod/cliente/texturas/texturas.png";
     }
	
	}