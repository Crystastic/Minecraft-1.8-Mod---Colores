package net.crystic.colores.worldgen;

import java.util.Random;

import net.crystic.colores.Colores;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class ColoresWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		switch (world.provider.dimensionId) {
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);

		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);

		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void addOreSpawn(Block block, World world, Random random,
			int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize,
			int chanceToSpawn, int minY, int maxY) {

		for (int i = 0; i < chanceToSpawn; i++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block, maxVeinSize)).generate(world, random,
					posX, posY, posZ);
		}
	}

	private void generateSurface(World world, Random random, int x, int z) {

		int o = 10;
		int j = 10;
		int d = 10;

		if (world.provider.getBiomeGenForCoords(x, z) == BiomeGenBase.ocean
				|| world.provider.getBiomeGenForCoords(x, z) == BiomeGenBase.river
				|| world.provider.getBiomeGenForCoords(x, z) == BiomeGenBase.deepOcean) {
			j = 20;
		} else if (world.provider.getBiomeGenForCoords(x, z) == BiomeGenBase.jungle
				|| world.provider.getBiomeGenForCoords(x, z) == BiomeGenBase.jungleHills
				|| world.provider.getBiomeGenForCoords(x, z) == BiomeGenBase.jungleEdge) {
			o = 20;
		} else if (world.provider.getBiomeGenForCoords(x, z) == BiomeGenBase.desert
				|| world.provider.getBiomeGenForCoords(x, z) == BiomeGenBase.desertHills) {
			d = 20;
		}

		this.addOreSpawn(Colores.ore_BlackFossil, world, random, x, z, 16, 16,
				1 + random.nextInt(6), o, 7, 64);
		this.addOreSpawn(Colores.ore_BrownFossil, world, random, x, z, 16, 16,
				1 + random.nextInt(5), j, 7, 64);
		this.addOreSpawn(Colores.ore_GreenFossil, world, random, x, z, 16, 16,
				2 + random.nextInt(7), d, 7, 64);
		this.addOreSpawn(Colores.ore_RedFossil, world, random, x, z, 16, 16,
				2 + random.nextInt(7), 15, 7, 64);
		this.addOreSpawn(Colores.ore_WhiteFossil, world, random, x, z, 16, 16,
				2 + random.nextInt(5), 15, 7, 64);
		this.addOreSpawn(Colores.ore_YellowFossil, world, random, x, z, 16, 16,
				2 + random.nextInt(2), 15, 7, 64);
	}

	private void generateNether(World world, Random random, int i, int j) {

		// Nether ores
	}

	private void generateEnd(World world, Random random, int i, int j) {

		// End ores
	}
}
