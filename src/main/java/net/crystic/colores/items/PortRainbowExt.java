package net.crystic.colores.items;

import net.crystic.colores.Colores;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PortRainbowExt extends Item {

	public PortRainbowExt() {
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(32);
		this.setNoRepair();
		this.setCreativeTab(Colores.coloresTab);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {

		this.itemIcon = iconRegister.registerIcon(Colores.modid + ":"
				+ this.getUnlocalizedName().substring(5));

	}
}
