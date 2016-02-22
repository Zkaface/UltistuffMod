package de.zkaface.ultistuffmod.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class UsmTCRecipes {

	public static void register() {
		
		ResearchCategories.registerCategory("Banana", null, new ResourceLocation("thaumcraft", "textures/items/brain.png"), new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_1.jpg"));
		
		CrucibleRecipe diadupeCru = ThaumcraftApi.addCrucibleRecipe("Diadupe", new ItemStack(Items.diamond, 2), new ItemStack(Items.emerald), new AspectList().add(Aspect.CRYSTAL, 2).add(Aspect.FIRE, 2));
		CrucibleRecipe emerdupeCru = ThaumcraftApi.addCrucibleRecipe("Emerdupe", new ItemStack(Items.emerald, 2), new ItemStack(Items.diamond), new AspectList().add(Aspect.CRYSTAL, 2).add(Aspect.EARTH, 2));
		
		ResearchItem Diadupe = new ResearchItem("Diadupe", "Banana", new AspectList().add(Aspect.CRYSTAL, 2).add(Aspect.FIRE, 2),0 , 0, 1, new ItemStack(Items.diamond)).registerResearchItem();
		ResearchItem Emerdupe = new ResearchItem("Emerdupe", "Banana", new AspectList().add(Aspect.CRYSTAL, 2).add(Aspect.EARTH, 2),0 , 2, 1, new ItemStack(Items.emerald)).setParents("Diadupe").registerResearchItem();
		
		Diadupe.setPages(new ResearchPage[]{new ResearchPage(diadupeCru)});
		Emerdupe.setPages(new ResearchPage[]{new ResearchPage(emerdupeCru)});
		
	}

}
