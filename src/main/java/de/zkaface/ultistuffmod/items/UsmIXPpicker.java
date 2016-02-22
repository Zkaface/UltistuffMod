package de.zkaface.ultistuffmod.items;

import de.zkaface.ultistuffmod.proxy.ClientProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import thaumcraft.api.aura.AuraHelper;
import thaumcraft.api.research.ResearchCategories;

public class UsmIXPpicker extends Item{

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
		if(player.isSneaking()){
			player.removeExperienceLevel(1);
			
			player.addChatMessage(new ChatComponentText("" + player.experienceLevel));
			return new ItemStack(Items.paper);
		}
		else
		return stack;
        
    }
	
}
