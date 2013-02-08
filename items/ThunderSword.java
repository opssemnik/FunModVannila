
package FunMod.items;

import java.util.Random;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
public class ThunderSword extends ItemSword
{
	
   
    		
	
    public ThunderSword(int i, EnumToolMaterial toolmaterial)
    {
        super(i, toolmaterial);
        this.iconIndex = 18;
    }
    public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
        int l = world.getBlockMetadata(i, j, k);
        double d = (float)i + 0.5F;
        double d1 = (float)j + 0.7F;
        double d2 = (float)k + 0.5F;
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;
        if (l == 1)
        {
            world.spawnParticle("smoke", d - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", d - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
        }
        else if (l == 2)
        {
            world.spawnParticle("smoke", d + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", d + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
        }
        else if (l == 3)
        {
            world.spawnParticle("smoke", d, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", d, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
        }
        else if (l == 4)
        {
            world.spawnParticle("smoke", d, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", d, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
        }
        else
        {
            world.spawnParticle("smoke", d, d1, d2, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", d, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }
   
 
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        float f = 1.0F;
        float f1 = entityplayer.prevRotationPitch + (entityplayer.rotationPitch - entityplayer.prevRotationPitch) * f;
        float f2 = entityplayer.prevRotationYaw + (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f;
        double d = entityplayer.prevPosX + (entityplayer.posX - entityplayer.prevPosX) * (double)f;
        double d1 = (entityplayer.prevPosY + (entityplayer.posY - entityplayer.prevPosY) * (double)f + 1.6200000000000001D) - (double)entityplayer.yOffset;
        double d2 = entityplayer.prevPosZ + (entityplayer.posZ - entityplayer.prevPosZ) * (double)f;
        Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
        float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
        float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
        float f5 = -MathHelper.cos(-f1 * 0.01745329F);
        float f6 = MathHelper.sin(-f1 * 0.01745329F);
        float f7 = f4 * f5;
        float f8 = f6;
        float f9 = f3 * f5;
        double d3 = 5000D;
        Vec3 vec3d1 = vec3d.addVector((double)f7 * d3, (double)f8 * d3, (double)f9 * d3);
        MovingObjectPosition movingobjectposition = world.rayTraceBlocks_do_do(vec3d, vec3d1, false, true);
        if (movingobjectposition == null) 
        {
         return itemstack;
        }
        if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) 
        {
         int i = movingobjectposition.blockX;
            int j = movingobjectposition.blockY;
            int k = movingobjectposition.blockZ;
            world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
        }
        itemstack.damageItem(10, entityplayer);
        return itemstack;
    }
    public String getTextureFile(){
     return "/FunMod/cliente/texturas/texturas.png";}
    
    } 