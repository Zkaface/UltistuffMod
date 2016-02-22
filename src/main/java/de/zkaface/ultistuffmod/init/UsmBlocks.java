package de.zkaface.ultistuffmod.init;

import de.zkaface.ultistuffmod.UsmReference;
import de.zkaface.ultistuffmod.blocks.BlockTeleporter;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class UsmBlocks {
	
	public static BlockTeleporter testblock;	
	
	public static void init(){
		testblock = new BlockTeleporter(Material.ground, "testblock", 5.0F, 1.0F, 1.0F, "axe", 1);
	}
	
	public static void register(){
		GameRegistry.registerBlock(testblock, testblock.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders(){
		registerRender(testblock);
	}
	
	public static void registerRender(Block block){
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(UsmReference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
