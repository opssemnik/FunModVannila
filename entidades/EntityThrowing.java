package FunMod.entidades;

import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityThrowable;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.World;

public class EntityThrowing extends EntityThrowable
{
public EntityThrowing( World par1World )
{
super( par1World );
this.getTexture();
}
public EntityThrowing( World par1World, EntityLiving par2EntityLiving )
{
super( par1World, par2EntityLiving );
// TODO Auto-generated constructor stub
}
public EntityThrowing( World par1World, double par2, double par4,
double par6 )
{
super( par1World, par2, par4, par6 );
// TODO Auto-generated constructor stub
}
@Override
protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
{
    if (!this.worldObj.isRemote)
    {
        if (par1MovingObjectPosition.entityHit != null)
        {
        	par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.ridingEntity), 5);
        }

        this.worldObj.createExplosion((Entity)null, this.posX, this.posY, this.posZ, 1.0F, true);
        this.setDead();
    }
}
  public String getTexture(){
   return "/FunMod/cliente/texturas/texturas.png";}

    
}