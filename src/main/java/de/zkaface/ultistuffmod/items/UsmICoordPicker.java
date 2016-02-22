package de.zkaface.ultistuffmod.items;

import java.util.List;
import java.util.Random;

import de.zkaface.ultistuffmod.UltistuffMod;
import de.zkaface.ultistuffmod.UsmReference;
import de.zkaface.ultistuffmod.easy.UsmEasy;
import de.zkaface.ultistuffmod.packages.TeleportPacket;
import de.zkaface.ultistuffmod.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.relauncher.Side;

import java.util.Random;

public class UsmICoordPicker extends Item{
	
	private static final String TAG_mytag = "tag_usm";
	private static final String TAG_player = "tag_player";
	private static final String TAG_posx = "tag_posx";
	private static final String TAG_posy = "tag_posy";
	private static final String TAG_posz = "tag_posz";
	private static final String TAG_dim = "tag_dim";
	private BlockPos pos;
	Random random = new Random();
	
	private String name;
	private int dimension;
	private int x, y, z;
	
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
		if(player.isSneaking()){
			if(!world.isRemote){
				
				if (stack.getTagCompound() == null){
					stack.setTagCompound(new NBTTagCompound());
					setNBTData(stack, player);
				}
				
			}
			return stack;
		}
		else
		if(!player.isSneaking()){
			if(!world.isRemote){
				
				if (stack.getTagCompound() == null){
					UsmEasy.chat("No Coords!", player);
				}
				else{ 
					NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag("coords");
						if(player.dimension == nbt.getInteger(TAG_dim)){
							int x = nbt.getInteger(TAG_posx);
							int y = nbt.getInteger(TAG_posy);
							int z = nbt.getInteger(TAG_posz);
					
							UsmEasy.chat("X: " + x + " Y: " + y + " Z: " +z, player);
							player.setPositionAndUpdate(x, y, z);
							--stack.stackSize;
						}
						else {
							int x = random.nextInt(16)*256 - random.nextInt(16)*256 + random.nextInt(16);
							int z = random.nextInt(16)*256 - random.nextInt(16)*256 + random.nextInt(16);
							int y = world.getTopSolidOrLiquidBlock(new BlockPos(x,0,z)).getY();
							UsmEasy.chat("ERROR!", player);
							
							player.setPositionAndUpdate(x, y, z);
							--stack.stackSize;
						}
				}		
			}
		}
		return stack;
    }
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("This item belongs to: " + getNBTTag(stack, TAG_player));
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		setNBTData(stack, playerIn);
		
	}
	
	
	private static void setNBTData(ItemStack stack, EntityPlayer player){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString(TAG_player, player.getDisplayNameString());
		nbt.setInteger(TAG_dim, player.dimension);
		nbt.setInteger(TAG_posx, player.getPosition().getX());
		nbt.setInteger(TAG_posy, player.getPosition().getY());
		nbt.setInteger(TAG_posz, player.getPosition().getZ());
		stack.getTagCompound().setTag("coords", nbt);
		stack.setTagInfo(TAG_mytag, nbt);
		stack.setStackDisplayName(EnumChatFormatting.AQUA + "Coordinate Cache");	
	}
	
	private static String getNBTTag(ItemStack stack, String tag){
		if (stack.getTagCompound() != null) {
			NBTTagCompound nbt = stack.getTagCompound().getCompoundTag(TAG_mytag);
			return nbt.getString(tag);
		} else
			return "-";
	}
	
}
