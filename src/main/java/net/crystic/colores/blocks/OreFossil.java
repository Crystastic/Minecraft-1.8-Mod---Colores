package net.crystic.colores.blocks;

import java.util.Random;

import net.crystic.colores.Colores;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OreFossil extends Block {

	public OreFossil(Material material) {
		super(material);

		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(Colores.coloresTab);
		this.setHarvestLevel("pickaxe", 1);
		this.canSilkHarvest();
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(Colores.modid + ":"
				+ this.getUnlocalizedName().substring(5));
	}

	public Item getItemDropped(int meta, Random random, int forune) {
		if (this == Colores.ore_BlackFossil) {
			return Colores.itm_BlackFossil;
		} else if (this == Colores.ore_BrownFossil) {
			return Colores.itm_BrownFossil;
		} else if (this == Colores.ore_GreenFossil) {
			return Colores.itm_GreenFossil;
		} else if (this == Colores.ore_RedFossil) {
			return Colores.itm_RedFossil;
		} else if (this == Colores.ore_WhiteFossil) {
			return Colores.itm_WhiteFossil;
		} else {
			return Colores.itm_YellowFossil;
		}
	}

	public int quantityDropped(Random random) {

		if (this == Colores.ore_BlackFossil) {
			return 1 + random.nextInt(4);
		} else if (this == Colores.ore_BrownFossil) {
			return 1 + random.nextInt(4);
		} else if (this == Colores.ore_GreenFossil) {
			return 1 + random.nextInt(4);
		} else if (this == Colores.ore_RedFossil) {
			return 1 + random.nextInt(4);
		} else if (this == Colores.ore_WhiteFossil) {
			return 1 + random.nextInt(4);
		} else {
			return 1 + random.nextInt(4);
		}
	}

}
