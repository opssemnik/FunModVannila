package FunMod;

import java.util.EnumSet;

import FunMod.items.SonicBoots;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class TickHandlerForArmor implements ITickHandler {

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		
		        	EntityPlayer p = (EntityPlayer)tickData[0];		              
		        	
		        	   
		           if(p.inventory.armorItemInSlot(3) != null && p.inventory.armorItemInSlot(3).getItem() instanceof SonicBoots){
		    		   System.out.println(true);
		        	 p.setVelocity(10D, 1D, 10D);
		    	   
		        }
		         
			 
		 }
	
	
	
	   
	  

	


	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		
	}

	@Override
	public EnumSet<TickType> ticks() {
		
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel() {
		
		return "SonicBoots";
	}

}
