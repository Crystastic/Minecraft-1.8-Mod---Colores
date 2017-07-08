package net.crystic.colores;

import net.crystic.colores.blocks.OreFossil;
import net.crystic.colores.blocks.RainbowExtractor;
import net.crystic.colores.handlers.CraftingHandler;
import net.crystic.colores.handlers.GuiHandler;
import net.crystic.colores.items.FossilItem;
import net.crystic.colores.items.PortRainbowExt;
import net.crystic.colores.items.RainbowExtKit;
import net.crystic.colores.tileentity.TileEntityRainbowExtractor;
import net.crystic.colores.worldgen.ColoresWorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = Colores.modid, version = Colores.version)
public class Colores {

	public static final String modid = "Colores";
	public static final String version = "R0.9";
	public static CreativeTabs coloresTab;
	ColoresWorldGen eventWorldGen = new ColoresWorldGen();

	@Instance(modid)
	public static Colores instance;

	// Blocks
	public static Block ore_BlackFossil;
	public static Block ore_BrownFossil;
	public static Block ore_GreenFossil;
	public static Block ore_RedFossil;
	public static Block ore_WhiteFossil;
	public static Block ore_YellowFossil;

	public static Block blockRainbowExtractorIdle;
	public static Block blockRainbowExtractorActive;
	public static final int guiIdRainbowExtractor = 0;

	// Items
	public static Item itm_BlackFossil;
	public static Item itm_BrownFossil;
	public static Item itm_GreenFossil;
	public static Item itm_RedFossil;
	public static Item itm_WhiteFossil;
	public static Item itm_YellowFossil;

	public static Item itm_PortRainbowExt;

	public static Item itm_RainbowExtKit;

	// Pre Init
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent) {

		coloresTab = new CreativeTabs("Colores") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return Item.getItemFromBlock(Colores.ore_WhiteFossil);
			}
		};

		// Block Initializations
		ore_BlackFossil = new OreFossil(Material.rock)
				.setBlockName("ore_BlackFossil");
		ore_BrownFossil = new OreFossil(Material.rock)
				.setBlockName("ore_BrownFossil");
		ore_GreenFossil = new OreFossil(Material.rock)
				.setBlockName("ore_GreenFossil");
		ore_RedFossil = new OreFossil(Material.rock)
				.setBlockName("ore_RedFossil");
		ore_WhiteFossil = new OreFossil(Material.rock)
				.setBlockName("ore_WhiteFossil");
		ore_YellowFossil = new OreFossil(Material.rock)
				.setBlockName("ore_YellowFossil");

		blockRainbowExtractorIdle = new RainbowExtractor(false)
				.setBlockName("RainbowExtractorIdle")
				.setCreativeTab(Colores.coloresTab).setHardness(3.5F);
		blockRainbowExtractorActive = new RainbowExtractor(true)
				.setBlockName("RainbowExtractorActive").setHardness(3.5F)
				.setLightLevel(0.625F);

		// Item Initializations
		itm_BlackFossil = new FossilItem()
				.setUnlocalizedName("itm_BlackFossil");
		itm_BrownFossil = new FossilItem()
				.setUnlocalizedName("itm_BrownFossil");
		itm_GreenFossil = new FossilItem()
				.setUnlocalizedName("itm_GreenFossil");
		itm_RedFossil = new FossilItem().setUnlocalizedName("itm_RedFossil");
		itm_WhiteFossil = new FossilItem()
				.setUnlocalizedName("itm_WhiteFossil");
		itm_YellowFossil = new FossilItem()
				.setUnlocalizedName("itm_YellowFossil");

		itm_PortRainbowExt = new PortRainbowExt()
				.setUnlocalizedName("itm_PortRainbowExt");

		itm_RainbowExtKit = new RainbowExtKit()
				.setUnlocalizedName("itm_RainbowExtKit");

		// Block Registrations
		GameRegistry.registerBlock(ore_BlackFossil, "ore_BlackFossil");
		GameRegistry.registerBlock(ore_BrownFossil, "ore_BrownFossil");
		GameRegistry.registerBlock(ore_GreenFossil, "ore_GreenFossil");
		GameRegistry.registerBlock(ore_RedFossil, "ore_RedFossil");
		GameRegistry.registerBlock(ore_WhiteFossil, "ore_WhiteFossil");
		GameRegistry.registerBlock(ore_YellowFossil, "ore_YellowFossil");

		GameRegistry.registerBlock(blockRainbowExtractorIdle,
				"blockRainbowExtractorIdle");
		GameRegistry.registerBlock(blockRainbowExtractorActive,
				"blockRainbowExtractorActive");

		// Item Registrations
		GameRegistry.registerItem(itm_BlackFossil, "itm_BlackFossil");
		GameRegistry.registerItem(itm_BrownFossil, "itm_BrownFossil");
		GameRegistry.registerItem(itm_GreenFossil, "itm_GreenFossil");
		GameRegistry.registerItem(itm_RedFossil, "itm_RedFossil");
		GameRegistry.registerItem(itm_WhiteFossil, "itm_WhiteFossil");
		GameRegistry.registerItem(itm_YellowFossil, "itm_YellowFossil");

		GameRegistry.registerItem(itm_PortRainbowExt, "itm_PortRainbowExt");

		GameRegistry.registerItem(itm_RainbowExtKit, "itm_RainbowExtKit");

		// WorldGen Registration
		GameRegistry.registerWorldGenerator(eventWorldGen, 0);
	}

	// Init
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(new CraftingHandler());

		GameRegistry.registerTileEntity(TileEntityRainbowExtractor.class,
				"RainbowExtractor");
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

		// PortRainbowExt Crafting Recipes
		GameRegistry
				.addRecipe(new ItemStack(itm_PortRainbowExt), new Object[] {
						" G ", "G G", "B  ", 'G', Blocks.glass, 'B',
						Items.potionitem });
		GameRegistry
				.addRecipe(new ItemStack(itm_RainbowExtKit), new Object[] {
						" G ", "GBG", " G ", 'G', Blocks.glass, 'B',
						Items.potionitem });
		GameRegistry.addRecipe(new ItemStack(blockRainbowExtractorIdle),
				new Object[] { "CGC", "CPC", "SSS", 'C', Blocks.cobblestone,
						'P', itm_RainbowExtKit, 'S', Blocks.stone_slab, 'G',
						Blocks.glass });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 0),
				new Object[] {
						itm_BlackFossil,
						Items.potionitem,
						new ItemStack(itm_PortRainbowExt, 1,
								OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 3),
				new Object[] {
						itm_BrownFossil,
						Items.potionitem,
						new ItemStack(itm_PortRainbowExt, 1,
								OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 2),
				new Object[] {
						itm_GreenFossil,
						Items.potionitem,
						new ItemStack(itm_PortRainbowExt, 1,
								OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 1),
				new Object[] {
						itm_RedFossil,
						Items.potionitem,
						new ItemStack(itm_PortRainbowExt, 1,
								OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 15),
				new Object[] {
						itm_WhiteFossil,
						Items.potionitem,
						new ItemStack(itm_PortRainbowExt, 1,
								OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 11),
				new Object[] {
						itm_YellowFossil,
						Items.potionitem,
						new ItemStack(itm_PortRainbowExt, 1,
								OreDictionary.WILDCARD_VALUE) });

	}

	// Post Init
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent) {

	}

}