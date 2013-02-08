package FunMod.items;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import FunMod.FunMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public class ItemLinkBow extends ItemBow
{
    public ItemLinkBow(int par1)
    {
        super(par1);
        this.maxStackSize = 1;
        this.setMaxDamage(499);
        this.setCreativeTab(FunMod.funmodtab);
        this.iconIndex = 12;
    }

    /**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
    {
        boolean var5 = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

        if (var5 || par3EntityPlayer.inventory.hasItem(Item.arrow.itemID))
        {
            int var6 = this.getMaxItemUseDuration(par1ItemStack) - par4;
            float var7 = (float)var6 / 20.0F;
            var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;

            if ((double)var7 < 0.1D)
            {
                 
                
                 return ;
            }

            if (var7 > 1.0F)
            {
             iconIndex = 13;
                var7 = 1.0F;
            }

            EntityArrow var8 = new EntityArrow(par2World, par3EntityPlayer, var7 * 2.0F);

            if (var7 == 1.0F)
            {
                var8.setIsCritical(true);
            }

            int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

            if (var9 > 0)
            {
                var8.setDamage(var8.getDamage() + (double)var9 * 0.5D + 0.5D);
            }

            int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

            if (var10 > 0)
            {
                var8.setKnockbackStrength(var10);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
            {
                var8.setFire(100);
            }

            par1ItemStack.damageItem(1, par3EntityPlayer);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);

            if (var5)
            {
                var8.canBePickedUp = 2;
            }
            else
            {
             par3EntityPlayer.inventory.consumeInventoryItem(Item.arrow.itemID);
            }

            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(var8);
            }
        }
        iconIndex = 12;
    }

    

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(Item.arrow.itemID))
        {
         par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
         }

        return par1ItemStack; 
 
    }
      
    

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
   
    
@SideOnly(Side.CLIENT)
    public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag)
    {
            EntityPlayer entityplayer = (EntityPlayer)entity;
            ItemStack itemstack1 = entityplayer.inventory.getCurrentItem();
            if(entityplayer.isUsingItem() && itemstack1.itemID == FunMod.LinkBow.itemID)
            {
                    int k = itemstack1.getMaxItemUseDuration() - entityplayer.getItemInUseCount();
                    if (k >= 18) {
                    iconIndex = 13;} else if(k > 13) {
                    iconIndex = 14;} else if(k > 0) {
                    iconIndex = 15;}
            } else {
            iconIndex = 12;}
    }

    
   

public String getTextureFile(){
return "/FunMod/cliente/texturas/texturas.png";}

}
