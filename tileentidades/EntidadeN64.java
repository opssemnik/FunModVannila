package FunMod.tileentidades;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
 
public class EntidadeN64  extends TileEntity{
	 private ItemStack[] furnaceItemStacks = new ItemStack[3];
	 public int furnaceBurnTime = 0;
	 public int furnaceCookTime = 0;
	 public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	    {
	        super.readFromNBT(par1NBTTagCompound);
	        NBTTagList var2 = par1NBTTagCompound.getTagList("Items",15);
	      

	        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
	        {
	            NBTTagCompound var4 = (NBTTagCompound)var2.getCompoundTagAt(var3);
	            byte var5 = var4.getByte("Slot");

	           
	        }

	       
	    }

	    /**
	     * Writes a tile entity to NBT.
	     */
	 public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	    {
	        super.writeToNBT(par1NBTTagCompound);
	        par1NBTTagCompound.setShort("BurnTime", (short)this.furnaceBurnTime);
	        par1NBTTagCompound.setShort("CookTime", (short)this.furnaceCookTime);
	        NBTTagList var2 = new NBTTagList();

	        for (int var3 = 0; var3 < this.furnaceItemStacks.length; ++var3)
	        {
	            if (this.furnaceItemStacks[var3] != null)
	            {
	                NBTTagCompound var4 = new NBTTagCompound();
	                var4.setByte("Slot", (byte)var3);
	                this.furnaceItemStacks[var3].writeToNBT(var4);
	                var2.appendTag(var4);
	            }
	        }

	        par1NBTTagCompound.setTag("Items", var2);
	    }
 
}