package net.crystic.colores.crafting;

import net.crystic.colores.Colores;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ExtractorRecipes {

	public static ItemStack extraction(Item item) {
		return getOutput(item);
	}

	public static ItemStack getOutput(Item item) {

		if (item == Colores.itm_BlackFossil) {
			return new ItemStack(Items.dye, 1, 0);
		} else if (item == Colores.itm_BrownFossil) {
			return new ItemStack(Items.dye, 1, 3);
		} else if (item == Colores.itm_GreenFossil) {
			return new ItemStack(Items.dye, 1, 2);
		} else if (item == Colores.itm_RedFossil) {
			return new ItemStack(Items.dye, 1, 1);
		} else if (item == Colores.itm_WhiteFossil) {
			return new ItemStack(Items.dye, 1, 15);
		} else if (item == Colores.itm_YellowFossil) {
			return new ItemStack(Items.dye, 1, 11);
		}

		return null;
	}
}