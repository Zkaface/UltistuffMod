package de.zkaface.ultistuffmod.init;

import de.zkaface.ultistuffmod.UsmReference;
import de.zkaface.ultistuffmod.items.UsmICoordPicker;
import de.zkaface.ultistuffmod.items.UsmIXPpicker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class UsmItems{
	

	public static UsmIXPpicker xppicker;
	public static UsmICoordPicker coordpicker;
	
	
	public static void init(){
		xppicker = (UsmIXPpicker) new UsmIXPpicker().setUnlocalizedName("xppicker").setMaxStackSize(1);
		coordpicker = (UsmICoordPicker) new UsmICoordPicker().setUnlocalizedName("coordpicker").setMaxStackSize(1);
		
	}
	
	public static void register(){
		GameRegistry.registerItem(xppicker, xppicker.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(coordpicker, coordpicker.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders(){
		registerRender(xppicker);
		registerRender(coordpicker);
	}
	
	public static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(UsmReference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	

}
