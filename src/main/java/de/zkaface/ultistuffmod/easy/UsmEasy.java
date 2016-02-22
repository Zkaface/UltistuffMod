package de.zkaface.ultistuffmod.easy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class UsmEasy {
	
	


	public static void chat (String text, EntityPlayer player){
		player.addChatMessage(new ChatComponentText(text));
	}

}
