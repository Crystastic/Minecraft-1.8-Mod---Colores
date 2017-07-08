package net.crystic.colores.handlers;

import net.crystic.colores.Colores;
import net.crystic.colores.container.ContainerRainbowExtractor;
import net.crystic.colores.gui.GuiRainbowExtractor;
import net.crystic.colores.tileentity.TileEntityRainbowExtractor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if (entity != null) {
			switch (ID) {
			case Colores.guiIdRainbowExtractor:
				if (entity instanceof TileEntityRainbowExtractor) {
					return new ContainerRainbowExtractor(player.inventory,
							(TileEntityRainbowExtractor) entity);
				}
				return null;
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if (entity != null) {
			switch (ID) {
			case Colores.guiIdRainbowExtractor:
				if (entity instanceof TileEntityRainbowExtractor) {
					return new GuiRainbowExtractor(player.inventory,
							(TileEntityRainbowExtractor) entity);
				}
				return null;
			}
		}
		return null;
	}

}
