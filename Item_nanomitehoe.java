package fr.mcnanotech.kevin_68.nanotech_mod;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;

public class Item_nanomitehoe extends ItemHoe
{
	public Item_nanomitehoe(int itemID, EnumToolMaterial toolMaterial)
	{
		super(itemID, toolMaterial);
	}
	
	public String getTextureFile()
	{
		return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/items.png";
	}
}