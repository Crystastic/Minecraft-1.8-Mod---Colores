package net.crystic.colores.gui;

import net.crystic.colores.Colores;
import net.crystic.colores.container.ContainerRainbowExtractor;
import net.crystic.colores.tileentity.TileEntityRainbowExtractor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiRainbowExtractor extends GuiContainer {

	public static final ResourceLocation bground = new ResourceLocation(
			Colores.modid + ":" + "textures/gui/guirainbowextractor.png");

	public TileEntityRainbowExtractor rainbowExtractor;

	public GuiRainbowExtractor(InventoryPlayer inventoryPlayer,
			TileEntityRainbowExtractor entity) {
		super(new ContainerRainbowExtractor(inventoryPlayer, entity));

		this.rainbowExtractor = entity;

		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int par1, int par2) {

		String name = "Dye Extractor";
		this.fontRendererObj.drawString(name, this.xSize / 2
				- this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(
				I18n.format("container.inventory", new Object[0]), 8,
				this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);

		Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		if (this.rainbowExtractor.isBurning()) {
			int k = this.rainbowExtractor.getBurnTimeRemainingScaled(40); // Width
																			// of
																			// fuel
																			// meter
			int j = 40 - k;
			drawTexturedModalRect(guiLeft + 86, guiTop + 63, 176, 0, 40 - j, 10); // Pos
																					// of
																					// fuel
																					// meter,
																					// onGuiX,
																					// onGuiY,
																					// fuelMeterOffGuiX,
																					// fuelMeterOffGuiY,
																					// 40
																					// -
																					// j,
																					// heightOfFuelMeter
		}

		int k = this.rainbowExtractor.getCookProgressScaled(24);// Width of
																// progress
		drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 10, k + 1, 16); // Pos
																				// of
																				// progress
																				// meter,
																				// onGuiX,
																				// onGuiY,
																				// progressMeterOffGuiX,
																				// progresslMeterOffGuiY,
																				// k
																				// +
																				// 1,
																				// heightOfProgressBar
	}

}
