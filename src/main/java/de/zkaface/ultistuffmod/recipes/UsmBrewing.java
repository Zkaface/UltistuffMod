package de.zkaface.ultistuffmod.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import thaumcraft.api.items.ItemsTC;

public class UsmBrewing {

	
	
	public static void register() {
		
		BrewingRecipeRegistry.addRecipe(new ItemStack(Items.potionitem) , new ItemStack(ItemsTC.brain), new ItemStack(Items.potato));

		
	}

}
