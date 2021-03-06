/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySoundBox;

public class ContainerSoundBox extends Container
{
    protected TileEntitySoundBox tileListerJukebox;
    private World worldObj;

    public ContainerSoundBox(TileEntitySoundBox tileEntity, InventoryPlayer inventoryPlayer, World world)
    {
        this.worldObj = world;
        this.tileListerJukebox = tileEntity;
        bindPlayerInventory(inventoryPlayer);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return tileListerJukebox.isUseableByPlayer(player);
    }

    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer)
    {

        for(int i = 0; i < 9; i++)
        {
            addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    public TileEntitySoundBox getFountain()
    {
        return tileListerJukebox;
    }
}