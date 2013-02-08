package FunMod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import FunMod.FunMod;
import FunMod.entidades.EntityThrowing;
public class ItemThrowing extends Item
{

public ItemThrowing( int par1 )
{
super( par1 );
this.iconIndex = 16;
this.setCreativeTab(FunMod.funmodtab);
}
/**
* Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
*/
public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
{
if (!par3EntityPlayer.capabilities.isCreativeMode)
{
--par1ItemStack.stackSize;
}
par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
if (!par2World.isRemote)
{
par2World.spawnEntityInWorld(new EntityThrowing(par2World, par3EntityPlayer));
}
return par1ItemStack;
}
public String getTextureFile(){
	return "/FunMod/cliente/texturas/texturas.png";}


}