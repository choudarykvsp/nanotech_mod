package fr.mcnanotech.kevin_68.nanotech_mod.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySmoker extends TileEntity implements IInventory
{
	private ItemStack[] inventory;
	public static byte Smokepower;
           
	public TileEntitySmoker()
	{
		inventory = new ItemStack[1];
		if(Smokepower > 15)
		{
			Smokepower = 15;
		}
		if(Smokepower < 0)
		{
			Smokepower = 0;
		}
	}
	
	public byte getSmokePower()
	{
		return Smokepower;
	}
           
	@Override
	public String getInvName()
	{
		return "TileEntitySmoker";
	}
           
	@Override
	public int getSizeInventory()
	{
		return inventory.length;
	}
           
	@Override
	public ItemStack getStackInSlot(int slotIndex)
	{
		return inventory[slotIndex];
	}
           
	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}
           
	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}
           
	@Override
	public void setInventorySlotContents(int slot, ItemStack stack)
	{
		inventory[slot] = stack;
                   
		if(stack != null && stack.stackSize > getInventoryStackLimit())
		{
			stack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound)
	{
		super.readFromNBT(tagCompound);
		Smokepower = tagCompound.getByte("power");
		
		NBTTagList tagList = tagCompound.getTagList("Inventory");
		
		for(int i = 0; i < tagList.tagCount(); i++)
		{
			NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
			byte slot = tag.getByte("Slot");
           
			if(slot >= 0 && slot < inventory.length)
			{
				inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
	}
           
	@Override
	public void writeToNBT(NBTTagCompound tagCompound)
	{
		super.writeToNBT(tagCompound);
		tagCompound.setByte("Smokepower", Smokepower);
		
		NBTTagList itemList = new NBTTagList();
		
		for(int j = 0; j < inventory.length; j++)
		{
			ItemStack stack = inventory[j];
           
			if(stack != null)
			{
				NBTTagCompound tag = new NBTTagCompound();
           
				tag.setByte("Slot", (byte) j);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
           
		tagCompound.setTag("Inventory", itemList);
	}
	
	@Override
	public ItemStack decrStackSize(int slotIndex, int amount)
	{
		ItemStack stack = getStackInSlot(slotIndex);
		if(stack != null)
		{
			if(stack.stackSize <= amount)
			{
				setInventorySlotContents(slotIndex, null);
			}
			else
			{
				stack = stack.splitStack(amount);
				if(stack.stackSize == 0)
				{
					setInventorySlotContents(slotIndex, null);
				}
			}
		}
		
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slotIndex)
	{
		ItemStack stack = getStackInSlot(slotIndex);
		if(stack != null)
		{
			setInventorySlotContents(slotIndex, null);
		}

		return stack;
	}

	@Override
	public void openChest() 
	{
	}

	@Override
	public void closeChest()
	{
	}
}
