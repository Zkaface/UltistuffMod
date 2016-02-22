package de.zkaface.ultistuffmod.proxy;

import de.zkaface.ultistuffmod.init.UsmBlocks;
import de.zkaface.ultistuffmod.init.UsmItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void registerRenders(){
		UsmItems.registerRenders();
		UsmBlocks.registerRenders();
	}
	

	
}
