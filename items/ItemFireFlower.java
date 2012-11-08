package FunMod.items;

import java.util.Map;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumRarity;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.RenderSnowball;
import net.minecraft.src.World;
import FunMod.FunMod;
import FunMod.entidades.EntityThrowing;
 public class ItemFireFlower extends Item
 {
         public ItemFireFlower(int i)
         {
                 super(i);
                 maxStackSize = 1;     
                 this.setCreativeTab(FunMod.funmodtab);
                 setMaxDamage(20);
                 this.iconIndex = 5;
         }
        public String getTextureFile(){
			
			return "/FunMod/cliente/texturas/texturas.png";
		}
    	public void addRender(Map var1){
    		var1.put(EntityThrowing.class, new RenderSnowball(this.iconIndex));}
		public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
         {
            

             par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

             if (!par2World.isRemote)
             {
                 par2World.spawnEntityInWorld(new EntityThrowing(par2World, par3EntityPlayer));
             }
              
             par1ItemStack.damageItem(1, par3EntityPlayer);
             
             return par1ItemStack;
         }
         
         public EnumRarity getRarity(ItemStack par1ItemStack)

         {

                 return EnumRarity.rare; 

         }
         
     }