package de.zkaface.ultistuffmod.blocks;

import java.util.ArrayList;
import java.util.List;

import de.zkaface.ultistuffmod.UsmCoordEntry;
import de.zkaface.ultistuffmod.easy.UsmEasy;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTeleporter extends TileEntity{

	private List<UsmCoordEntry> teleports = new ArrayList<UsmCoordEntry>();
	private static final String TAG_posx = "tag_posx";
	private static final String TAG_posy = "tag_posy";
	private static final String TAG_posz = "tag_posz";
	private static final String TAG_dim = "tag_dim";
	
	public void addEntry(String name, ItemStack coordPicker){
		
		NBTTagCompound nbt = (NBTTagCompound) coordPicker.getTagCompound().getTag("coords");
		int dim = nbt.getInteger(TAG_dim);
		int x = nbt.getInteger(TAG_posx);
		int y = nbt.getInteger(TAG_posy);
		int z = nbt.getInteger(TAG_posz);
		teleports.add(new UsmCoordEntry(name, dim, x,y,z));
		
	}
	
	public UsmCoordEntry getEntry(int i){
		
		if(i < teleports.size())
		{
			return teleports.get(i);
		}
		return null;
		
	}
	
	
	public void deleteEntry(int i){
		if(i < teleports.size())
		{
			teleports.remove(i);
		}
	} 
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		
		teleports = new ArrayList<UsmCoordEntry>();
		
		NBTTagList entryList = (NBTTagList) compound.getTag("coords");
		for(int i = 0; i < entryList.tagCount(); i++){
			NBTTagCompound  entryCompound = entryList.getCompoundTagAt(i);
			UsmCoordEntry entry = UsmCoordEntry.readEntryFromNBT(entryCompound);
			teleports.add(entry);
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		
		NBTTagList entryList = new NBTTagList();
		for(UsmCoordEntry entry : teleports){
			NBTTagCompound entryCompound = new NBTTagCompound();
			entry.writeEntryToNBT(entryCompound);
			entryList.appendTag(entryCompound);
		}
		compound.setTag("coords", entryList);
	}
	
}
