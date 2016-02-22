package de.zkaface.ultistuffmod.blocks;

import de.zkaface.ultistuffmod.UsmCoordEntry;
import de.zkaface.ultistuffmod.easy.UsmEasy;
import de.zkaface.ultistuffmod.items.UsmICoordPicker;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockTeleporter extends Block implements ITileEntityProvider{

	private static final String TAG_posx = "tag_posx";
	private static final String TAG_posy = "tag_posy";
	private static final String TAG_posz = "tag_posz";
	private static final String TAG_dim = "tag_dim";
	
	public BlockTeleporter(Material material, String unlocalizedName, float hardness,
		float resistance, float lightlevel, String tool, Integer harvestlevel) {
		super(Material.iron);
		this.setUnlocalizedName(unlocalizedName);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setLightLevel(lightlevel);
		this.setHarvestLevel(tool, harvestlevel);
		
	} 
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		
		
		ItemStack stack = player.getCurrentEquippedItem();
		if(stack != null)
		{
			if(stack.getItem() instanceof UsmICoordPicker)
			{
				if (stack.getTagCompound() == null){
					UsmEasy.chat("No Coords!", player);
				}
				else
				{
					UsmEasy.chat("Hat welche!", player);					
					TileEntityTeleporter tect = (TileEntityTeleporter) worldIn.getTileEntity(pos);
					tect.addEntry("", stack);
				}
			}
		
			if(stack.getItem().equals(Items.bone)){
				TileEntityTeleporter tect = (TileEntityTeleporter) worldIn.getTileEntity(pos);
				if (tect != null){
					int x = 1;
					int y = 1;
					int z = 1;
					if(!worldIn.isRemote){
						UsmEasy.chat("Hallo x y z sind: " + x + " " + y + " " + z, player);
					}
				}
			}
		}
		return true;
		
		
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityTeleporter();
	}

}
