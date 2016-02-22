package de.zkaface.ultistuffmod;

import de.zkaface.ultistuffmod.init.UsmBlocks;
import de.zkaface.ultistuffmod.init.UsmItems;
import de.zkaface.ultistuffmod.init.UsmTeleportTileEntities;
import de.zkaface.ultistuffmod.packages.TeleportPacket;
import de.zkaface.ultistuffmod.packages.UsmPackedHandler;
import de.zkaface.ultistuffmod.proxy.CommonProxy;
import de.zkaface.ultistuffmod.recipes.UsmBrewing;
import de.zkaface.ultistuffmod.recipes.UsmTCRecipes;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

@Mod(modid = UsmReference.MODID, name = UsmReference.MODNAME, version = UsmReference.VERSION)
public class UltistuffMod {
	
	@Instance
	public static UltistuffMod instance = new UltistuffMod();

	public static SimpleNetworkWrapper network;
	
	@SidedProxy(clientSide = UsmReference.CLIENT_PROXY_CLASS, serverSide = UsmReference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		System.out.println("preInit of " + UsmReference.MODID);
		network = NetworkRegistry.INSTANCE.newSimpleChannel(UsmReference.MODID);
		network.registerMessage(new UsmPackedHandler(), TeleportPacket.class, 0, Side.SERVER);
		
		
		UsmBlocks.init();
		UsmBlocks.register();
		UsmItems.init();
		UsmItems.register();
		UsmTeleportTileEntities.register();
		
		ThaumcraftApi.registerObjectTag(new ItemStack(UsmBlocks.testblock), new AspectList().add(Aspect.ENERGY, 3).add(Aspect.EARTH, 1));
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
		proxy.registerRenders();
		System.out.println("Init of " + UsmReference.MODID);
		
		UsmBrewing.register();
		}

	

	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
		System.out.println("postInit of " + UsmReference.MODID);
		
		UsmTCRecipes.register();
		
		
	}
	
}
