package de.zkaface.ultistuffmod;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;

public class UsmCoordEntry {

	private String name;
	private int dim, x, y, z;
	
	public UsmCoordEntry(String name, int dim, int x, int y, int z) {
		
		this.name = name;
		this.dim = dim;
		this.x = x;
		this.y = y;
		this.z = z;
	
	}

	public String getName() {
		return name;
	}

	public int getDim() {
		return dim;
	}
	
	public BlockPos getPos()
	{
		return new BlockPos(x,y,z);
	}
	
	public void writeEntryToNBT(NBTTagCompound nbt){
		nbt.setString("name", name);
		nbt.setInteger("dimension", dim);
		nbt.setInteger("posx", x);
		nbt.setInteger("posy", y);
		nbt.setInteger("posz", z);
	}
	
	public static UsmCoordEntry readEntryFromNBT(NBTTagCompound nbt){
		return new UsmCoordEntry(nbt.getString("name"), nbt.getInteger("dimension"), nbt.getInteger("posx"), nbt.getInteger("posy"), nbt.getInteger("posz"));
	}
	
}
