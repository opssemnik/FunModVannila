package FunMod.items;

import cpw.mods.fml.common.registry.GameData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import FunMod.FunMod;
import FunMod.entidades.EntityThrowing;
	public class ItemFun extends Item
	{
	    public static int fireflowermustbeuse;    
		public ItemFun(int id, int textura, int maxStack)
	        {
	                super();
	                fireflowermustbeuse = id;
	                maxStackSize = maxStack;     
	                this.setCreativeTab(FunMod.funmodtab);
	        
	        }
	
@Override
public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
{
    System.out.println(fireflowermustbeuse);
	if(GameData.itemRegistry.getId(this) == 3024){
	par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
    if (!par2World.isRemote)
    {
        par2World.spawnEntityInWorld(new EntityThrowing(par2World));
    }
     par1ItemStack.damageItem(1, par3EntityPlayer);
     return par1ItemStack;
}
    else{
    return par1ItemStack;
}}
public EnumRarity getRarity(ItemStack par1ItemStack)

{
	if(GameData.itemRegistry.getId(this) == 3024){
	return EnumRarity.rare; 
    }
    else{
    	return EnumRarity.common;
    }
}
	
	
	
	
	
	}