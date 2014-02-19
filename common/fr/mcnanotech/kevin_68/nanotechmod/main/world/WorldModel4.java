/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechModList;

public class WorldModel4 extends WorldGenerator
{
	protected Block[] getValidSpawnBlocks()
	{
		return new Block[] {Blocks.stone, Blocks.dirt, NanotechModList.nanoGrass, Blocks.snow};
	}

	public boolean LocationIsValidSpawn(World world, int x, int y, int z)
	{
		int distanceToAir = 0;
		Block check = world.getBlock(x, y, z);

		while(check != null)
		{
			distanceToAir++;
			check = world.getBlock(x, y + distanceToAir, z);
		}

		if(distanceToAir > 3)
		{
			return false;
		}
		y += distanceToAir - 1;

		Block block = world.getBlock(x, y, z);
		boolean isAirAbove = world.isAirBlock(x, y + 1, z);
		Block blockBelow = world.getBlock(x, y - 1, z);
		for(Block valideBlock : getValidSpawnBlocks())
		{
			if(!isAirAbove)
			{
				return false;
			}
			if(block == valideBlock)
			{
				return true;
			}
			else if(block == Blocks.snow && blockBelow == valideBlock)
			{
				return true;
			}
		}
		return false;
	}

	public WorldModel4()
	{}

	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		// checz that each corner is one of the valid spawn blocks
		if(!LocationIsValidSpawn(world, x, y, z) || !LocationIsValidSpawn(world, x + 8, y, z) || !LocationIsValidSpawn(world, x + 8, y, z + 11) || !LocationIsValidSpawn(world, x, y, z + 11))
		{
			return false;
		}

		world.setBlockToAir(x + 0, y + 0, z + 0);
		world.setBlockToAir(x + 0, y + 0, z + 1);
		world.setBlock(x + 0, y + 0, z + 2, Blocks.cobblestone);
		world.setBlock(x + 0, y + 0, z + 3, Blocks.cobblestone);
		world.setBlock(x + 0, y + 0, z + 4, Blocks.stone_slab);
		world.setBlockToAir(x + 0, y + 0, z + 5);
		world.setBlockToAir(x + 0, y + 0, z + 6);
		world.setBlockToAir(x + 0, y + 1, z + 0);
		world.setBlockToAir(x + 0, y + 1, z + 1);
		world.setBlock(x + 0, y + 1, z + 2, Blocks.stone_slab);
		world.setBlock(x + 0, y + 1, z + 3, Blocks.cobblestone);
		world.setBlockToAir(x + 0, y + 1, z + 4);
		world.setBlockToAir(x + 0, y + 1, z + 5);
		world.setBlockToAir(x + 0, y + 1, z + 6);
		world.setBlockToAir(x + 0, y + 2, z + 0);
		world.setBlockToAir(x + 0, y + 2, z + 1);
		world.setBlockToAir(x + 0, y + 2, z + 2);
		world.setBlock(x + 0, y + 2, z + 3, Blocks.stone_slab);
		world.setBlockToAir(x + 0, y + 2, z + 4);
		world.setBlockToAir(x + 0, y + 2, z + 5);
		world.setBlockToAir(x + 0, y + 2, z + 6);
		world.setBlockToAir(x + 0, y + 3, z + 0);
		world.setBlockToAir(x + 0, y + 3, z + 1);
		world.setBlockToAir(x + 0, y + 3, z + 2);
		world.setBlockToAir(x + 0, y + 3, z + 3);
		world.setBlockToAir(x + 0, y + 3, z + 4);
		world.setBlockToAir(x + 0, y + 3, z + 5);
		world.setBlockToAir(x + 0, y + 3, z + 6);
		world.setBlockToAir(x + 0, y + 4, z + 0);
		world.setBlockToAir(x + 0, y + 4, z + 1);
		world.setBlockToAir(x + 0, y + 4, z + 2);
		world.setBlockToAir(x + 0, y + 4, z + 3);
		world.setBlockToAir(x + 0, y + 4, z + 4);
		world.setBlockToAir(x + 0, y + 4, z + 5);
		world.setBlockToAir(x + 0, y + 4, z + 6);
		world.setBlockToAir(x + 0, y + 5, z + 0);
		world.setBlockToAir(x + 0, y + 5, z + 1);
		world.setBlockToAir(x + 0, y + 5, z + 2);
		world.setBlockToAir(x + 0, y + 5, z + 3);
		world.setBlockToAir(x + 0, y + 5, z + 4);
		world.setBlockToAir(x + 0, y + 5, z + 5);
		world.setBlockToAir(x + 0, y + 5, z + 6);
		world.setBlockToAir(x + 0, y + 6, z + 0);
		world.setBlockToAir(x + 0, y + 6, z + 1);
		world.setBlockToAir(x + 0, y + 6, z + 2);
		world.setBlockToAir(x + 0, y + 6, z + 3);
		world.setBlockToAir(x + 0, y + 6, z + 4);
		world.setBlockToAir(x + 0, y + 6, z + 5);
		world.setBlock(x + 1, y + 0, z + 0, Blocks.cobblestone);
		world.setBlock(x + 1, y + 0, z + 1, Blocks.cobblestone);
		world.setBlock(x + 1, y + 0, z + 2, Blocks.cobblestone);
		world.setBlock(x + 1, y + 0, z + 3, Blocks.cobblestone);
		world.setBlock(x + 1, y + 0, z + 4, Blocks.cobblestone);
		world.setBlock(x + 1, y + 0, z + 5, Blocks.cobblestone);
		world.setBlock(x + 1, y + 0, z + 6, Blocks.cobblestone);
		world.setBlock(x + 1, y + 1, z + 0, Blocks.log);
		world.setBlock(x + 1, y + 1, z + 1, Blocks.planks);
		world.setBlock(x + 1, y + 1, z + 2, Blocks.planks);
		world.setBlock(x + 1, y + 1, z + 4, Blocks.planks);
		world.setBlock(x + 1, y + 1, z + 5, Blocks.planks);
		world.setBlock(x + 1, y + 1, z + 6, Blocks.log);
		world.setBlock(x + 1, y + 2, z + 0, Blocks.log);
		world.setBlock(x + 1, y + 2, z + 1, Blocks.planks);
		world.setBlock(x + 1, y + 2, z + 2, Blocks.fence);
		world.setBlock(x + 1, y + 2, z + 3, Blocks.planks);
		world.setBlock(x + 1, y + 2, z + 4, Blocks.fence);
		world.setBlock(x + 1, y + 2, z + 5, Blocks.planks);
		world.setBlock(x + 1, y + 2, z + 6, Blocks.log);
		world.setBlock(x + 1, y + 3, z + 0, Blocks.log);
		world.setBlock(x + 1, y + 3, z + 1, Blocks.planks);
		world.setBlock(x + 1, y + 3, z + 2, Blocks.planks);
		world.setBlock(x + 1, y + 3, z + 3, Blocks.planks);
		world.setBlock(x + 1, y + 3, z + 4, Blocks.planks);
		world.setBlock(x + 1, y + 3, z + 5, Blocks.planks);
		world.setBlock(x + 1, y + 3, z + 6, Blocks.log);
		world.setBlock(x + 1, y + 4, z + 0, Blocks.log);
		world.setBlock(x + 1, y + 4, z + 1, Blocks.cobblestone);
		world.setBlockToAir(x + 1, y + 4, z + 2);
		world.setBlockToAir(x + 1, y + 4, z + 3);
		world.setBlockToAir(x + 1, y + 4, z + 4);
		world.setBlock(x + 1, y + 4, z + 5, Blocks.cobblestone);
		world.setBlock(x + 1, y + 4, z + 6, Blocks.log);
		world.setBlock(x + 1, y + 5, z + 0, Blocks.stone_slab);
		world.setBlock(x + 1, y + 5, z + 1, Blocks.stone_slab);
		world.setBlockToAir(x + 1, y + 5, z + 2);
		world.setBlockToAir(x + 1, y + 5, z + 3);
		world.setBlockToAir(x + 1, y + 5, z + 4);
		world.setBlock(x + 1, y + 5, z + 5, Blocks.stone_slab);
		world.setBlock(x + 1, y + 5, z + 6, Blocks.stone_slab);
		world.setBlockToAir(x + 1, y + 6, z + 0);
		world.setBlockToAir(x + 1, y + 6, z + 1);
		world.setBlockToAir(x + 1, y + 6, z + 2);
		world.setBlockToAir(x + 1, y + 6, z + 3);
		world.setBlockToAir(x + 1, y + 6, z + 4);
		world.setBlockToAir(x + 1, y + 6, z + 5);
		world.setBlockToAir(x + 1, y + 6, z + 6);
		world.setBlock(x + 2, y + 0, z + 0, Blocks.cobblestone);
		world.setBlock(x + 2, y + 0, z + 1, Blocks.cobblestone);
		world.setBlock(x + 2, y + 0, z + 2, Blocks.cobblestone);
		world.setBlock(x + 2, y + 0, z + 3, Blocks.cobblestone);
		world.setBlock(x + 2, y + 0, z + 4, Blocks.cobblestone);
		world.setBlock(x + 2, y + 0, z + 5, Blocks.cobblestone);
		world.setBlock(x + 2, y + 0, z + 6, Blocks.cobblestone);
		world.setBlock(x + 2, y + 1, z + 0, Blocks.planks);
		world.setBlockToAir(x + 2, y + 1, z + 1);
		world.setBlockToAir(x + 2, y + 1, z + 2);
		world.setBlock(x + 2, y + 1, z + 3, Blocks.tripwire, 4, 3);
		world.setBlockToAir(x + 2, y + 1, z + 4);
		world.setBlockToAir(x + 2, y + 1, z + 5);
		world.setBlock(x + 2, y + 1, z + 6, Blocks.planks);
		world.setBlock(x + 2, y + 2, z + 0, Blocks.planks);
		world.setBlockToAir(x + 2, y + 2, z + 1);
		world.setBlockToAir(x + 2, y + 2, z + 2);
		world.setBlockToAir(x + 2, y + 2, z + 3);
		world.setBlockToAir(x + 2, y + 2, z + 4);
		world.setBlockToAir(x + 2, y + 2, z + 5);
		world.setBlock(x + 2, y + 2, z + 6, Blocks.planks);
		world.setBlock(x + 2, y + 3, z + 0, Blocks.planks);
		world.setBlockToAir(x + 2, y + 3, z + 1);
		world.setBlockToAir(x + 2, y + 3, z + 2);
		world.setBlockToAir(x + 2, y + 3, z + 3);
		world.setBlockToAir(x + 2, y + 3, z + 4);
		world.setBlockToAir(x + 2, y + 3, z + 5);
		world.setBlock(x + 2, y + 3, z + 6, Blocks.planks);
		world.setBlock(x + 2, y + 4, z + 0, Blocks.cobblestone);
		world.setBlock(x + 2, y + 4, z + 1, Blocks.cobblestone);
		world.setBlock(x + 2, y + 4, z + 2, Blocks.cobblestone);
		world.setBlock(x + 2, y + 4, z + 3, Blocks.cobblestone);
		world.setBlock(x + 2, y + 4, z + 4, Blocks.cobblestone);
		world.setBlock(x + 2, y + 4, z + 5, Blocks.cobblestone);
		world.setBlock(x + 2, y + 4, z + 6, Blocks.cobblestone);
		world.setBlock(x + 2, y + 5, z + 0, Blocks.stone_slab);
		world.setBlockToAir(x + 2, y + 5, z + 1);
		world.setBlockToAir(x + 2, y + 5, z + 2);
		world.setBlockToAir(x + 2, y + 5, z + 3);
		world.setBlockToAir(x + 2, y + 5, z + 4);
		world.setBlockToAir(x + 2, y + 5, z + 5);
		world.setBlock(x + 2, y + 5, z + 6, Blocks.stone_slab);
		world.setBlockToAir(x + 2, y + 6, z + 0);
		world.setBlockToAir(x + 2, y + 6, z + 1);
		world.setBlockToAir(x + 2, y + 6, z + 2);
		world.setBlockToAir(x + 2, y + 6, z + 3);
		world.setBlockToAir(x + 2, y + 6, z + 4);
		world.setBlockToAir(x + 2, y + 6, z + 5);
		world.setBlockToAir(x + 2, y + 6, z + 6);
		world.setBlock(x + 3, y + 0, z + 0, Blocks.cobblestone);
		world.setBlock(x + 3, y + 0, z + 1, Blocks.cobblestone);
		world.setBlock(x + 3, y + 0, z + 2, Blocks.cobblestone);
		world.setBlock(x + 3, y + 0, z + 3, Blocks.cobblestone);
		world.setBlock(x + 3, y + 0, z + 4, Blocks.cobblestone);
		world.setBlock(x + 3, y + 0, z + 5, Blocks.cobblestone);
		world.setBlock(x + 3, y + 0, z + 6, Blocks.cobblestone);
		world.setBlock(x + 3, y + 1, z + 0, Blocks.planks);
		world.setBlockToAir(x + 3, y + 1, z + 1);
		world.setBlockToAir(x + 3, y + 1, z + 2);
		world.setBlock(x + 3, y + 1, z + 3, Blocks.tripwire, 4, 3);
		world.setBlockToAir(x + 3, y + 1, z + 4);
		world.setBlockToAir(x + 3, y + 1, z + 5);
		world.setBlock(x + 3, y + 1, z + 6, Blocks.planks);
		world.setBlock(x + 3, y + 2, z + 0, Blocks.planks);
		world.setBlockToAir(x + 3, y + 2, z + 1);
		world.setBlockToAir(x + 3, y + 2, z + 2);
		world.setBlockToAir(x + 3, y + 2, z + 3);
		world.setBlockToAir(x + 3, y + 2, z + 4);
		world.setBlockToAir(x + 3, y + 2, z + 5);
		world.setBlock(x + 3, y + 2, z + 6, Blocks.fence);
		world.setBlock(x + 3, y + 3, z + 0, Blocks.planks);
		world.setBlockToAir(x + 3, y + 3, z + 1);
		world.setBlockToAir(x + 3, y + 3, z + 2);
		world.setBlockToAir(x + 3, y + 3, z + 3);
		world.setBlockToAir(x + 3, y + 3, z + 4);
		world.setBlockToAir(x + 3, y + 3, z + 5);
		world.setBlock(x + 3, y + 3, z + 6, Blocks.planks);
		world.setBlock(x + 3, y + 4, z + 0, Blocks.cobblestone);
		world.setBlock(x + 3, y + 4, z + 1, Blocks.cobblestone);
		world.setBlock(x + 3, y + 4, z + 2, Blocks.cobblestone);
		world.setBlock(x + 3, y + 4, z + 3, Blocks.cobblestone);
		world.setBlock(x + 3, y + 4, z + 4, Blocks.cobblestone);
		world.setBlock(x + 3, y + 4, z + 5, Blocks.cobblestone);
		world.setBlock(x + 3, y + 4, z + 6, Blocks.cobblestone);
		world.setBlock(x + 3, y + 5, z + 0, Blocks.stone_slab);
		world.setBlockToAir(x + 3, y + 5, z + 1);
		world.setBlockToAir(x + 3, y + 5, z + 2);
		world.setBlockToAir(x + 3, y + 5, z + 3);
		world.setBlockToAir(x + 3, y + 5, z + 4);
		world.setBlockToAir(x + 3, y + 5, z + 5);
		world.setBlock(x + 3, y + 5, z + 6, Blocks.stone_slab);
		world.setBlockToAir(x + 3, y + 6, z + 0);
		world.setBlockToAir(x + 3, y + 6, z + 1);
		world.setBlockToAir(x + 3, y + 6, z + 2);
		world.setBlockToAir(x + 3, y + 6, z + 3);
		world.setBlockToAir(x + 3, y + 6, z + 4);
		world.setBlockToAir(x + 3, y + 6, z + 5);
		world.setBlockToAir(x + 3, y + 6, z + 6);
		world.setBlock(x + 4, y + 0, z + 0, Blocks.cobblestone);
		world.setBlock(x + 4, y + 0, z + 1, Blocks.cobblestone);
		world.setBlock(x + 4, y + 0, z + 2, Blocks.cobblestone);
		world.setBlock(x + 4, y + 0, z + 3, Blocks.cobblestone);
		world.setBlock(x + 4, y + 0, z + 4, NanotechModList.sodium);
		world.setBlock(x + 4, y + 0, z + 5, Blocks.cobblestone);
		world.setBlock(x + 4, y + 0, z + 6, Blocks.cobblestone);
		world.setBlock(x + 4, y + 1, z + 0, Blocks.log);
		world.setBlockToAir(x + 4, y + 1, z + 1);
		world.setBlock(x + 4, y + 1, z + 2, Blocks.planks);
		world.setBlock(x + 4, y + 1, z + 4, Blocks.cobblestone);
		world.setBlockToAir(x + 4, y + 1, z + 5);
		world.setBlock(x + 4, y + 1, z + 6, Blocks.planks);
		world.setBlock(x + 4, y + 2, z + 0, Blocks.log);
		world.setBlockToAir(x + 4, y + 2, z + 1);
		world.setBlock(x + 4, y + 2, z + 2, Blocks.planks);
		world.setBlockToAir(x + 4, y + 2, z + 3);
		world.setBlockToAir(x + 4, y + 2, z + 4);
		world.setBlockToAir(x + 4, y + 2, z + 5);
		world.setBlock(x + 4, y + 2, z + 6, Blocks.planks);
		world.setBlock(x + 4, y + 3, z + 0, Blocks.log);
		world.setBlock(x + 4, y + 3, z + 1, Blocks.planks);
		world.setBlock(x + 4, y + 3, z + 2, Blocks.planks);
		world.setBlockToAir(x + 4, y + 3, z + 3);
		world.setBlockToAir(x + 4, y + 3, z + 4);
		world.setBlockToAir(x + 4, y + 3, z + 5);
		world.setBlock(x + 4, y + 3, z + 6, Blocks.planks);
		world.setBlock(x + 4, y + 4, z + 0, Blocks.log);
		world.setBlock(x + 4, y + 4, z + 1, Blocks.cobblestone);
		world.setBlock(x + 4, y + 4, z + 2, Blocks.cobblestone);
		world.setBlock(x + 4, y + 4, z + 3, Blocks.cobblestone);
		world.setBlockToAir(x + 4, y + 4, z + 4);
		world.setBlock(x + 4, y + 4, z + 5, Blocks.cobblestone);
		world.setBlock(x + 4, y + 4, z + 6, Blocks.cobblestone);
		world.setBlock(x + 4, y + 5, z + 0, Blocks.stone_slab);
		world.setBlockToAir(x + 4, y + 5, z + 1);
		world.setBlockToAir(x + 4, y + 5, z + 2);
		world.setBlockToAir(x + 4, y + 5, z + 3);
		world.setBlockToAir(x + 4, y + 5, z + 4);
		world.setBlockToAir(x + 4, y + 5, z + 5);
		world.setBlock(x + 4, y + 5, z + 6, Blocks.stone_slab);
		world.setBlockToAir(x + 4, y + 6, z + 0);
		world.setBlockToAir(x + 4, y + 6, z + 1);
		world.setBlockToAir(x + 4, y + 6, z + 2);
		world.setBlockToAir(x + 4, y + 6, z + 3);
		world.setBlockToAir(x + 4, y + 6, z + 4);
		world.setBlockToAir(x + 4, y + 6, z + 5);
		world.setBlockToAir(x + 4, y + 6, z + 6);
		world.setBlock(x + 5, y + 0, z + 0, Blocks.cobblestone);
		world.setBlock(x + 5, y + 0, z + 1, Blocks.cobblestone);
		world.setBlock(x + 5, y + 0, z + 2, Blocks.cobblestone);
		world.setBlock(x + 5, y + 0, z + 3, Blocks.piston, 3, 3);
		world.setBlock(x + 5, y + 0, z + 4, Blocks.cobblestone);
		world.setBlock(x + 5, y + 0, z + 5, Blocks.cobblestone);
		world.setBlockToAir(x + 5, y + 0, z + 6);
		world.setBlockToAir(x + 5, y + 1, z + 0);
		world.setBlockToAir(x + 5, y + 1, z + 1);
		world.setBlockToAir(x + 5, y + 1, z + 2);
		world.setBlock(x + 5, y + 1, z + 3, Blocks.planks);
		world.setBlockToAir(x + 5, y + 1, z + 4);
		world.setBlockToAir(x + 5, y + 1, z + 5);
		world.setBlock(x + 5, y + 1, z + 6, Blocks.planks);
		world.setBlockToAir(x + 5, y + 2, z + 0);
		world.setBlockToAir(x + 5, y + 2, z + 1);
		world.setBlockToAir(x + 5, y + 2, z + 2);
		world.setBlock(x + 5, y + 2, z + 3, Blocks.planks);
		world.setBlockToAir(x + 5, y + 2, z + 4);
		world.setBlockToAir(x + 5, y + 2, z + 5);
		world.setBlock(x + 5, y + 2, z + 6, Blocks.fence);
		world.setBlockToAir(x + 5, y + 3, z + 0);
		world.setBlockToAir(x + 5, y + 3, z + 1);
		world.setBlockToAir(x + 5, y + 3, z + 2);
		world.setBlock(x + 5, y + 3, z + 3, Blocks.planks);
		world.setBlockToAir(x + 5, y + 3, z + 4);
		world.setBlockToAir(x + 5, y + 3, z + 5);
		world.setBlock(x + 5, y + 3, z + 6, Blocks.planks);
		world.setBlock(x + 5, y + 4, z + 0, Blocks.cobblestone);
		world.setBlock(x + 5, y + 4, z + 1, Blocks.cobblestone);
		world.setBlock(x + 5, y + 4, z + 2, Blocks.cobblestone);
		world.setBlock(x + 5, y + 4, z + 3, Blocks.cobblestone);
		world.setBlock(x + 5, y + 4, z + 4, Blocks.cobblestone);
		world.setBlock(x + 5, y + 4, z + 5, Blocks.cobblestone);
		world.setBlock(x + 5, y + 4, z + 6, Blocks.cobblestone);
		world.setBlock(x + 5, y + 5, z + 0, Blocks.stone_slab);
		world.setBlockToAir(x + 5, y + 5, z + 1);
		world.setBlockToAir(x + 5, y + 5, z + 2);
		world.setBlockToAir(x + 5, y + 5, z + 3);
		world.setBlockToAir(x + 5, y + 5, z + 4);
		world.setBlockToAir(x + 5, y + 5, z + 5);
		world.setBlock(x + 5, y + 5, z + 6, Blocks.stone_slab);
		world.setBlockToAir(x + 5, y + 6, z + 0);
		world.setBlockToAir(x + 5, y + 6, z + 1);
		world.setBlockToAir(x + 5, y + 6, z + 2);
		world.setBlockToAir(x + 5, y + 6, z + 3);
		world.setBlockToAir(x + 5, y + 6, z + 4);
		world.setBlockToAir(x + 5, y + 6, z + 5);
		world.setBlockToAir(x + 5, y + 6, z + 6);
		world.setBlock(x + 6, y + 0, z + 0, Blocks.cobblestone);
		world.setBlock(x + 6, y + 0, z + 1, Blocks.cobblestone);
		world.setBlock(x + 6, y + 0, z + 2, Blocks.cobblestone);
		world.setBlock(x + 6, y + 0, z + 3, Blocks.cobblestone);
		world.setBlock(x + 6, y + 0, z + 5, Blocks.cobblestone);
		world.setBlock(x + 6, y + 0, z + 6, Blocks.cobblestone);
		world.setBlock(x + 6, y + 1, z + 0, Blocks.fence);
		world.setBlockToAir(x + 6, y + 1, z + 1);
		world.setBlockToAir(x + 6, y + 1, z + 2);
		world.setBlock(x + 6, y + 1, z + 3, Blocks.planks);
		world.setBlockToAir(x + 6, y + 1, z + 4);
		world.setBlock(x + 6, y + 1, z + 5, Blocks.chest, 4, 3);
		world.setBlock(x + 6, y + 1, z + 6, Blocks.planks);
		world.setBlock(x + 6, y + 2, z + 0, Blocks.fence);
		world.setBlockToAir(x + 6, y + 2, z + 1);
		world.setBlockToAir(x + 6, y + 2, z + 2);
		world.setBlock(x + 6, y + 2, z + 3, Blocks.planks);
		world.setBlockToAir(x + 6, y + 2, z + 4);
		world.setBlockToAir(x + 6, y + 2, z + 5);
		world.setBlock(x + 6, y + 2, z + 6, Blocks.planks);
		world.setBlock(x + 6, y + 3, z + 0, Blocks.fence);
		world.setBlockToAir(x + 6, y + 3, z + 1);
		world.setBlockToAir(x + 6, y + 3, z + 2);
		world.setBlock(x + 6, y + 3, z + 3, Blocks.planks);
		world.setBlockToAir(x + 6, y + 3, z + 4);
		world.setBlockToAir(x + 6, y + 3, z + 5);
		world.setBlock(x + 6, y + 3, z + 6, Blocks.planks);
		world.setBlock(x + 6, y + 4, z + 0, Blocks.cobblestone);
		world.setBlock(x + 6, y + 4, z + 1, Blocks.cobblestone);
		world.setBlock(x + 6, y + 4, z + 2, Blocks.cobblestone);
		world.setBlock(x + 6, y + 4, z + 3, Blocks.cobblestone);
		world.setBlock(x + 6, y + 4, z + 4, Blocks.cobblestone);
		world.setBlock(x + 6, y + 4, z + 5, Blocks.cobblestone);
		world.setBlock(x + 6, y + 4, z + 6, Blocks.cobblestone);
		world.setBlock(x + 6, y + 5, z + 0, Blocks.stone_slab);
		world.setBlockToAir(x + 6, y + 5, z + 1);
		world.setBlockToAir(x + 6, y + 5, z + 2);
		world.setBlockToAir(x + 6, y + 5, z + 3);
		world.setBlockToAir(x + 6, y + 5, z + 4);
		world.setBlockToAir(x + 6, y + 5, z + 5);
		world.setBlock(x + 6, y + 5, z + 6, Blocks.stone_slab);
		world.setBlockToAir(x + 6, y + 6, z + 0);
		world.setBlockToAir(x + 6, y + 6, z + 1);
		world.setBlockToAir(x + 6, y + 6, z + 2);
		world.setBlockToAir(x + 6, y + 6, z + 3);
		world.setBlockToAir(x + 6, y + 6, z + 4);
		world.setBlockToAir(x + 6, y + 6, z + 5);
		world.setBlockToAir(x + 6, y + 6, z + 6);
		world.setBlock(x + 7, y + 0, z + 0, Blocks.cobblestone);
		world.setBlock(x + 7, y + 0, z + 1, Blocks.cobblestone);
		world.setBlock(x + 7, y + 0, z + 2, Blocks.cobblestone);
		world.setBlock(x + 7, y + 0, z + 3, Blocks.cobblestone);
		world.setBlock(x + 7, y + 0, z + 4, Blocks.cobblestone);
		world.setBlock(x + 7, y + 0, z + 5, Blocks.cobblestone);
		world.setBlock(x + 7, y + 0, z + 6, Blocks.cobblestone);
		world.setBlock(x + 7, y + 1, z + 0, Blocks.stone_slab);
		world.setBlockToAir(x + 7, y + 1, z + 1);
		world.setBlockToAir(x + 7, y + 1, z + 2);
		world.setBlock(x + 7, y + 1, z + 3, Blocks.cobblestone);
		world.setBlock(x + 7, y + 1, z + 4, Blocks.cobblestone);
		world.setBlock(x + 7, y + 1, z + 5, Blocks.cobblestone);
		world.setBlock(x + 7, y + 1, z + 6, Blocks.cobblestone);
		world.setBlockToAir(x + 7, y + 2, z + 0);
		world.setBlockToAir(x + 7, y + 2, z + 1);
		world.setBlockToAir(x + 7, y + 2, z + 2);
		world.setBlock(x + 7, y + 2, z + 3, Blocks.cobblestone);
		world.setBlock(x + 7, y + 2, z + 4, Blocks.cobblestone);
		world.setBlock(x + 7, y + 2, z + 5, Blocks.cobblestone);
		world.setBlock(x + 7, y + 2, z + 6, Blocks.cobblestone);
		world.setBlockToAir(x + 7, y + 3, z + 0);
		world.setBlockToAir(x + 7, y + 3, z + 1);
		world.setBlockToAir(x + 7, y + 3, z + 2);
		world.setBlock(x + 7, y + 3, z + 3, Blocks.cobblestone);
		world.setBlock(x + 7, y + 3, z + 4, Blocks.cobblestone);
		world.setBlock(x + 7, y + 3, z + 5, Blocks.cobblestone);
		world.setBlock(x + 7, y + 3, z + 6, Blocks.cobblestone);
		world.setBlockToAir(x + 7, y + 4, z + 0);
		world.setBlock(x + 7, y + 4, z + 1, Blocks.cobblestone);
		world.setBlock(x + 7, y + 4, z + 2, Blocks.cobblestone);
		world.setBlock(x + 7, y + 4, z + 3, Blocks.cobblestone);
		world.setBlock(x + 7, y + 4, z + 4, Blocks.cobblestone);
		world.setBlock(x + 7, y + 4, z + 5, Blocks.cobblestone);
		world.setBlock(x + 7, y + 4, z + 6, Blocks.cobblestone);
		world.setBlockToAir(x + 7, y + 5, z + 0);
		world.setBlockToAir(x + 7, y + 5, z + 1);
		world.setBlockToAir(x + 7, y + 5, z + 2);
		world.setBlockToAir(x + 7, y + 5, z + 3);
		world.setBlockToAir(x + 7, y + 5, z + 4);
		world.setBlockToAir(x + 7, y + 5, z + 5);
		world.setBlock(x + 7, y + 5, z + 6, Blocks.stone_slab);
		world.setBlockToAir(x + 7, y + 6, z + 0);
		world.setBlockToAir(x + 7, y + 6, z + 1);
		world.setBlockToAir(x + 7, y + 6, z + 2);
		world.setBlockToAir(x + 7, y + 6, z + 3);
		world.setBlockToAir(x + 7, y + 6, z + 4);
		world.setBlockToAir(x + 7, y + 6, z + 5);
		world.setBlockToAir(x + 7, y + 6, z + 6);
		world.setBlock(x + 8, y + 0, z + 0, Blocks.cobblestone);
		world.setBlock(x + 8, y + 0, z + 1, Blocks.cobblestone);
		world.setBlock(x + 8, y + 0, z + 3, Blocks.cobblestone);
		world.setBlock(x + 8, y + 0, z + 4, Blocks.cobblestone);
		world.setBlock(x + 8, y + 0, z + 5, Blocks.cobblestone);
		world.setBlock(x + 8, y + 0, z + 6, Blocks.cobblestone);
		world.setBlock(x + 8, y + 1, z + 0, Blocks.stone_slab, 3, 3);
		world.setBlock(x + 8, y + 1, z + 1, Blocks.cobblestone);
		world.setBlock(x + 8, y + 1, z + 6, Blocks.cobblestone);
		world.setBlockToAir(x + 8, y + 2, z + 0);
		world.setBlockToAir(x + 8, y + 2, z + 1);
		world.setBlockToAir(x + 8, y + 2, z + 2);
		world.setBlockToAir(x + 8, y + 2, z + 3);
		world.setBlockToAir(x + 8, y + 2, z + 4);
		world.setBlockToAir(x + 8, y + 2, z + 5);
		world.setBlock(x + 8, y + 2, z + 6, Blocks.cobblestone);
		world.setBlockToAir(x + 8, y + 3, z + 0);
		world.setBlockToAir(x + 8, y + 3, z + 1);
		world.setBlockToAir(x + 8, y + 3, z + 2);
		world.setBlockToAir(x + 8, y + 3, z + 3);
		world.setBlock(x + 8, y + 3, z + 4, Blocks.cobblestone);
		world.setBlock(x + 8, y + 3, z + 5, Blocks.cobblestone);
		world.setBlock(x + 8, y + 3, z + 6, Blocks.cobblestone);
		world.setBlockToAir(x + 8, y + 4, z + 0);
		world.setBlockToAir(x + 8, y + 4, z + 1);
		world.setBlock(x + 8, y + 4, z + 2, Blocks.cobblestone);
		world.setBlock(x + 8, y + 4, z + 3, Blocks.cobblestone);
		world.setBlock(x + 8, y + 4, z + 4, Blocks.cobblestone);
		world.setBlock(x + 8, y + 4, z + 5, Blocks.cobblestone);
		world.setBlock(x + 8, y + 4, z + 6, Blocks.cobblestone);
		world.setBlockToAir(x + 8, y + 5, z + 0);
		world.setBlockToAir(x + 8, y + 5, z + 1);
		world.setBlockToAir(x + 8, y + 5, z + 2);
		world.setBlockToAir(x + 8, y + 5, z + 3);
		world.setBlockToAir(x + 8, y + 5, z + 4);
		world.setBlockToAir(x + 8, y + 5, z + 5);
		world.setBlock(x + 8, y + 5, z + 6, Blocks.stone_slab);
		world.setBlockToAir(x + 8, y + 6, z + 0);
		world.setBlockToAir(x + 8, y + 6, z + 1);
		world.setBlockToAir(x + 8, y + 6, z + 2);
		world.setBlockToAir(x + 8, y + 6, z + 3);
		world.setBlockToAir(x + 8, y + 6, z + 4);
		world.setBlockToAir(x + 8, y + 6, z + 5);
		world.setBlockToAir(x + 8, y + 6, z + 6);
		world.setBlock(x + 9, y + 0, z + 0, Blocks.cobblestone);
		world.setBlock(x + 9, y + 0, z + 1, Blocks.cobblestone);
		world.setBlock(x + 9, y + 0, z + 2, Blocks.cobblestone);
		world.setBlock(x + 9, y + 0, z + 3, Blocks.cobblestone);
		world.setBlock(x + 9, y + 0, z + 4, Blocks.cobblestone);
		world.setBlock(x + 9, y + 0, z + 5, Blocks.cobblestone);
		world.setBlock(x + 9, y + 0, z + 6, Blocks.cobblestone);
		world.setBlock(x + 9, y + 1, z + 0, Blocks.stone_slab, 3, 3);
		world.setBlock(x + 9, y + 1, z + 1, Blocks.cobblestone);
		world.setBlock(x + 9, y + 1, z + 6, Blocks.cobblestone);
		world.setBlockToAir(x + 9, y + 2, z + 0);
		world.setBlockToAir(x + 9, y + 2, z + 1);
		world.setBlockToAir(x + 9, y + 2, z + 2);
		world.setBlockToAir(x + 9, y + 2, z + 3);
		world.setBlockToAir(x + 9, y + 2, z + 4);
		world.setBlockToAir(x + 9, y + 2, z + 5);
		world.setBlock(x + 9, y + 2, z + 6, Blocks.cobblestone);
		world.setBlockToAir(x + 9, y + 3, z + 0);
		world.setBlockToAir(x + 9, y + 3, z + 1);
		world.setBlockToAir(x + 9, y + 3, z + 2);
		world.setBlockToAir(x + 9, y + 3, z + 3);
		world.setBlock(x + 9, y + 3, z + 4, Blocks.cobblestone);
		world.setBlock(x + 9, y + 3, z + 5, Blocks.cobblestone);
		world.setBlock(x + 9, y + 3, z + 6, Blocks.cobblestone);
		world.setBlockToAir(x + 9, y + 4, z + 0);
		world.setBlockToAir(x + 9, y + 4, z + 1);
		world.setBlock(x + 9, y + 4, z + 2, Blocks.cobblestone);
		world.setBlock(x + 9, y + 4, z + 3, Blocks.cobblestone);
		world.setBlock(x + 9, y + 4, z + 4, Blocks.cobblestone);
		world.setBlock(x + 9, y + 4, z + 5, Blocks.cobblestone);
		world.setBlock(x + 9, y + 4, z + 6, Blocks.cobblestone);
		world.setBlockToAir(x + 9, y + 5, z + 0);
		world.setBlockToAir(x + 9, y + 5, z + 1);
		world.setBlockToAir(x + 9, y + 5, z + 2);
		world.setBlockToAir(x + 9, y + 5, z + 3);
		world.setBlockToAir(x + 9, y + 5, z + 4);
		world.setBlockToAir(x + 9, y + 5, z + 5);
		world.setBlock(x + 9, y + 5, z + 6, Blocks.stone_slab);
		world.setBlockToAir(x + 9, y + 6, z + 0);
		world.setBlockToAir(x + 9, y + 6, z + 1);
		world.setBlockToAir(x + 9, y + 6, z + 2);
		world.setBlockToAir(x + 9, y + 6, z + 3);
		world.setBlockToAir(x + 9, y + 6, z + 4);
		world.setBlockToAir(x + 9, y + 6, z + 5);
		world.setBlockToAir(x + 9, y + 6, z + 6);
		world.setBlock(x + 10, y + 0, z + 0, Blocks.cobblestone);
		world.setBlock(x + 10, y + 0, z + 1, Blocks.cobblestone);
		world.setBlock(x + 10, y + 0, z + 2, Blocks.cobblestone);
		world.setBlock(x + 10, y + 0, z + 3, Blocks.cobblestone);
		world.setBlock(x + 10, y + 0, z + 4, Blocks.cobblestone);
		world.setBlock(x + 10, y + 0, z + 5, Blocks.cobblestone);
		world.setBlock(x + 10, y + 0, z + 6, Blocks.cobblestone);
		world.setBlock(x + 10, y + 1, z + 0, Blocks.stone_slab);
		world.setBlock(x + 10, y + 1, z + 1, Blocks.stone_slab, 3, 3);
		world.setBlock(x + 10, y + 1, z + 2, Blocks.cobblestone);
		world.setBlock(x + 10, y + 1, z + 3, Blocks.cobblestone);
		world.setBlock(x + 10, y + 1, z + 4, Blocks.cobblestone);
		world.setBlock(x + 10, y + 1, z + 5, Blocks.cobblestone);
		world.setBlock(x + 10, y + 1, z + 6, Blocks.cobblestone);
		world.setBlockToAir(x + 10, y + 2, z + 0);
		world.setBlockToAir(x + 10, y + 2, z + 1);
		world.setBlockToAir(x + 10, y + 2, z + 2);
		world.setBlock(x + 10, y + 2, z + 3, Blocks.stone_slab);
		world.setBlock(x + 10, y + 2, z + 4, Blocks.iron_bars);
		world.setBlock(x + 10, y + 2, z + 5, Blocks.iron_bars);
		world.setBlock(x + 10, y + 2, z + 6, Blocks.cobblestone);
		world.setBlockToAir(x + 10, y + 3, z + 0);
		world.setBlockToAir(x + 10, y + 3, z + 1);
		world.setBlockToAir(x + 10, y + 3, z + 2);
		world.setBlockToAir(x + 10, y + 3, z + 3);
		world.setBlock(x + 10, y + 3, z + 4, Blocks.cobblestone);
		world.setBlock(x + 10, y + 3, z + 5, Blocks.cobblestone);
		world.setBlock(x + 10, y + 3, z + 6, Blocks.cobblestone);
		world.setBlockToAir(x + 10, y + 4, z + 0);
		world.setBlockToAir(x + 10, y + 4, z + 1);
		world.setBlockToAir(x + 10, y + 4, z + 2);
		world.setBlockToAir(x + 10, y + 4, z + 3);
		world.setBlock(x + 10, y + 4, z + 4, Blocks.cobblestone);
		world.setBlock(x + 10, y + 4, z + 5, Blocks.cobblestone);
		world.setBlock(x + 10, y + 4, z + 6, Blocks.cobblestone);
		world.setBlockToAir(x + 10, y + 5, z + 0);
		world.setBlockToAir(x + 10, y + 5, z + 1);
		world.setBlockToAir(x + 10, y + 5, z + 2);
		world.setBlockToAir(x + 10, y + 5, z + 3);
		world.setBlock(x + 10, y + 5, z + 4, Blocks.stone_slab);
		world.setBlock(x + 10, y + 5, z + 5, Blocks.stone_slab);
		world.setBlock(x + 10, y + 5, z + 6, Blocks.stone_slab);
		world.setBlockToAir(x + 10, y + 6, z + 0);
		world.setBlockToAir(x + 10, y + 6, z + 1);
		world.setBlockToAir(x + 10, y + 6, z + 2);
		world.setBlockToAir(x + 10, y + 6, z + 3);
		world.setBlockToAir(x + 10, y + 6, z + 4);
		world.setBlockToAir(x + 10, y + 6, z + 5);
		world.setBlockToAir(x + 10, y + 6, z + 6);
		world.setBlockToAir(x + 11, y + 0, z + 1);
		world.setBlockToAir(x + 11, y + 0, z + 2);
		world.setBlockToAir(x + 11, y + 0, z + 3);
		world.setBlockToAir(x + 11, y + 0, z + 4);
		world.setBlockToAir(x + 11, y + 0, z + 5);
		world.setBlockToAir(x + 11, y + 0, z + 6);
		world.setBlockToAir(x + 11, y + 1, z + 0);
		world.setBlockToAir(x + 11, y + 1, z + 1);
		world.setBlockToAir(x + 11, y + 1, z + 2);
		world.setBlockToAir(x + 11, y + 1, z + 3);
		world.setBlockToAir(x + 11, y + 1, z + 4);
		world.setBlockToAir(x + 11, y + 1, z + 5);
		world.setBlockToAir(x + 11, y + 1, z + 6);
		world.setBlockToAir(x + 11, y + 2, z + 0);
		world.setBlockToAir(x + 11, y + 2, z + 1);
		world.setBlockToAir(x + 11, y + 2, z + 2);
		world.setBlockToAir(x + 11, y + 2, z + 3);
		world.setBlockToAir(x + 11, y + 2, z + 4);
		world.setBlockToAir(x + 11, y + 2, z + 5);
		world.setBlockToAir(x + 11, y + 2, z + 6);
		world.setBlockToAir(x + 11, y + 3, z + 0);
		world.setBlockToAir(x + 11, y + 3, z + 1);
		world.setBlockToAir(x + 11, y + 3, z + 2);
		world.setBlockToAir(x + 11, y + 3, z + 3);
		world.setBlockToAir(x + 11, y + 3, z + 4);
		world.setBlockToAir(x + 11, y + 3, z + 5);
		world.setBlockToAir(x + 11, y + 3, z + 6);
		world.setBlockToAir(x + 11, y + 4, z + 0);
		world.setBlockToAir(x + 11, y + 4, z + 1);
		world.setBlockToAir(x + 11, y + 4, z + 2);
		world.setBlockToAir(x + 11, y + 4, z + 3);
		world.setBlockToAir(x + 11, y + 4, z + 4);
		world.setBlockToAir(x + 11, y + 4, z + 5);
		world.setBlockToAir(x + 11, y + 4, z + 6);
		world.setBlockToAir(x + 11, y + 5, z + 0);
		world.setBlockToAir(x + 11, y + 5, z + 1);
		world.setBlockToAir(x + 11, y + 5, z + 2);
		world.setBlockToAir(x + 11, y + 5, z + 3);
		world.setBlockToAir(x + 11, y + 5, z + 4);
		world.setBlockToAir(x + 11, y + 5, z + 5);
		world.setBlockToAir(x + 11, y + 5, z + 6);
		world.setBlockToAir(x + 11, y + 6, z + 0);
		world.setBlockToAir(x + 11, y + 6, z + 1);
		world.setBlockToAir(x + 11, y + 6, z + 2);
		world.setBlockToAir(x + 11, y + 6, z + 3);
		world.setBlockToAir(x + 11, y + 6, z + 4);
		world.setBlockToAir(x + 11, y + 6, z + 5);
		world.setBlockToAir(x + 11, y + 6, z + 6);
		world.setBlock(x + 6, y + 0, z + 4, Blocks.water);
		world.setBlock(x + 8, y + 0, z + 2, Blocks.lava, 14, 3);
		world.setBlock(x + 8, y + 1, z + 2, Blocks.lava, 6, 3);
		world.setBlock(x + 8, y + 1, z + 3, Blocks.lava, 4, 3);
		world.setBlock(x + 8, y + 1, z + 4, Blocks.lava, 2, 3);
		world.setBlock(x + 8, y + 1, z + 5, Blocks.lava);
		world.setBlock(x + 9, y + 1, z + 2, Blocks.lava, 6, 3);
		world.setBlock(x + 9, y + 1, z + 3, Blocks.lava, 4, 3);
		world.setBlock(x + 9, y + 1, z + 4, Blocks.lava, 2, 3);
		world.setBlock(x + 9, y + 1, z + 5, Blocks.lava);
		world.setBlock(x + 4, y + 1, z + 3, Blocks.tripwire_hook, 5, 3);
		world.setBlock(x + 1, y + 1, z + 3, Blocks.tripwire_hook, 7, 3);

		return true;
	}
}